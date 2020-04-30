-- ----------------------------------------------------
-- ----------------------------------------------------
-- -- TESTS & STATISTICS SCRIPT -----------------------
-- --- (assignment 2 spoiler) -------------------------
-- ----------------------------------------------------
-- -- Course: File Structures and DataBases -----------
-- ----------------------------------------------------
-- -- (c) 2020 Javier Calle ---------------------------
-- ------ Carlos III University of Madrid -------------
-- ----------------------------------------------------
-- ----------------------------------------------------
-- -- Part I: Auxiliary structures (views) & data -----
-- ----------------------------------------------------


INSERT INTO movies(title,director) 
   SELECT DISTINCT 'workload_'||nick,'Common' FROM membership; 
-- 5297 rows inserted.
commit;

CREATE OR REPLACE VIEW CP_aragna AS (
SELECT nick, 100*sum(nuls)/count('c') pct_aragna 
  FROM (SELECT nick,club,title,director,
               NVL2(msg_date,0,1) nuls 
           FROM (SELECT member nick, club, title, director 
                    FROM proposals) 
                LEFT OUTER JOIN comments 
                USING(nick,club,title,director) 
       )
   GROUP BY nick
   HAVING sum(nuls)>0
) order by pct_aragna desc WITH READ ONLY;
/

CREATE OR REPLACE VIEW leader AS(
SELECT * FROM ( 
  SELECT * FROM ( 
    SELECT member nick,club, sum(nvl(coms,0))/count('c') total
       FROM proposals LEFT OUTER JOIN 
            (SELECT club,title,director,count('c') coms
                FROM comments GROUP BY club,title,director) A
            USING(club,title,director)
       GROUP BY club,member         
  ) ORDER BY total DESC
) WHERE rownum<=10
) WITH READ ONLY;
/


-- ----------------------------------------------------
-- -- Part II: Package Definition ---------------------
-- ----------------------------------------------------

CREATE OR REPLACE PACKAGE PKG_COSTES AS

-- auxiliary function converting an interval into a number (milliseconds)
	FUNCTION interval_to_milliseconds(x INTERVAL DAY TO SECOND) RETURN NUMBER;
-- WORKLOAD definition
	PROCEDURE PR_WORKLOAD(N NUMBER);
-- RE-STABLISH DB STATE
	PROCEDURE PR_RESET(N NUMBER);
-- Execution of workload (10 times) displaying some measurements 
	PROCEDURE RUN_TEST(ite NUMBER);

END PKG_COSTES;
/

-- ----------------------------------------------------
-- -- Part II: Package BODY ---------------------------
-- ----------------------------------------------------

CREATE OR REPLACE PACKAGE BODY PKG_COSTES AS 

FUNCTION interval_to_milliseconds(x INTERVAL DAY TO SECOND ) RETURN NUMBER IS
  BEGIN 
    return (((extract( day from x)*24 + extract( hour from x))*60 + extract( minute from x))*60 + extract( second from x))*1000;
  END interval_to_milliseconds;
  
  
PROCEDURE PR_WORKLOAD(N NUMBER) IS
-- this WL restablishes state between iterations, so N is not taken into account
BEGIN

  INSERT INTO proposals(title, director, club, member, prop_date, slogan, message) 
    SELECT 'workload_'||nick,'Common',club,nick,sysdate,
           DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(20,96))),
           DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(200,1496)))
    FROM (SELECT name club FROM clubs WHERE end_date is null)  
         JOIN membership USING(club); 
COMMIT;
 
  INSERT INTO comments(club, nick, msg_date, title, director, subject, message, valoration) 
    SELECT club,nick,sysdate+sec/43200,title,'Common',
           DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(20,96))),
           DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(200,1496))),
           TRUNC(DBMS_RANDOM.value(0,11))
    FROM (SELECT title,club, rownum sec FROM proposals WHERE title LIKE 'workload_%') JOIN membership USING(club);
COMMIT;

-- QUERY 1

FOR fila in (
   SELECT title,director 
      FROM GENRES_MOVIES WHERE UPPER(genre)='COMEDY'
   INTERSECT
   SELECT title,director 
      FROM GENRES_MOVIES WHERE UPPER(genre)='DRAMA'
) LOOP null; END LOOP;


-- QUERY 2

FOR fila in (
   SELECT nick FROM users WHERE (sysdate-reg_date)>182
   MINUS
   SELECT nick FROM membership 
   MINUS 
   SELECT nick FROM contracts JOIN profiles USING(citizenID)
) LOOP null; END LOOP;
 

-- QUERY 3

FOR fila in (
   SELECT * FROM (
     SELECT * FROM (
       SELECT director, avg(coms) meancomm
          FROM (SELECT title,director,count('c') coms
                  FROM comments
                  GROUP BY title,director)
          GROUP BY director
     ) ORDER BY meancomm DESC
   ) WHERE rownum=1
) LOOP null; END LOOP;
 

-- VIEW 1
FOR fila in (SELECT * FROM CP_aragna
) LOOP null; END LOOP;


-- VIEW 2
FOR fila in (SELECT * FROM leader
) LOOP null; END LOOP;

END PR_WORKLOAD;

  
PROCEDURE PR_RESET(N NUMBER) IS
-- Realize that your design could be degenerating
-- To test only initial state's performance, you can restablish initial state
  BEGIN
    delete from proposals where title LIKE 'workload_%';
    delete from comments where title LIKE 'workload_%';  
    COMMIT;

-- NOTE 1: procedures are intended for DML; for altering, we use dynamic SQL as trapdoor
    execute immediate 'alter table proposals deallocate unused';
    execute immediate 'alter table comments deallocate unused';
    execute immediate 'alter index PK_PROPOSALS rebuild';
    execute immediate 'alter index UK_PROPOSALS rebuild';
    execute immediate 'alter index PK_COMMENTS rebuild';
-- NOTE 2: for resetting indexes we rebuild them; it it takes too long replace with 'deallocate unused'
-- that won't completely restore previous state, but at least will release empty buckets (faster)

-- NOTE 3: purge any other index, materialized view or cluster involving tables proposals and/or comments
-- alter index name_of_the_index rebuild;
-- alter cluster name_of_the_cluster deallocate unused;
-- alter materialized view name_of_the_view deallocate unused;

END PR_RESET;


PROCEDURE RUN_TEST(ite NUMBER) IS
	t1 TIMESTAMP;
	t2 TIMESTAMP;
	auxt NUMBER := 0;
	g1 NUMBER;
	g2 NUMBER;
	auxg NUMBER := 0;
	localsid NUMBER;
    BEGIN
      PKG_COSTES.PR_WORKLOAD(0);  -- idle run for preparing db_buffers
      PKG_COSTES.PR_RESET(0);
      select distinct sid into localsid from v$mystat; 
--- LOOP WORKLOAD ITERATIONS (ite times) --------------------------------
      FOR i IN 1..ite LOOP
--- GET PREVIOUS MEASURES -----------------------------------
        SELECT SYSTIMESTAMP INTO t1 FROM DUAL;
        select S.value into g1 from (select * from v$sesstat where sid=localsid) S join (select * from v$statname where name='consistent gets') using(STATISTIC#);
--- EXECUTION OF THE WORKLOAD -----------------------------------
        PKG_COSTES.PR_WORKLOAD (i);
--- GET AFTER-RUN MEASURES -----------------------------------
        SELECT SYSTIMESTAMP INTO t2 FROM DUAL;
        select S.value into g2 from (select * from v$sesstat where sid=localsid) S join (select * from v$statname where name='consistent gets') using(STATISTIC#);
        auxt:= auxt + interval_to_milliseconds(t2-t1);
        auxg:= auxg + g2-g1;
--- RESTABLISH STATE-----------------------------------
        PKG_COSTES.PR_RESET (i);
--- END TESTS ---------------------------------------------------
      END LOOP;
      auxt:= auxt / ite;
      auxg:= auxg / ite;
--- DISPLAY RESULTS -----------------------------------
    DBMS_OUTPUT.PUT_LINE('RESULTS AT '||SYSDATE); 
    DBMS_OUTPUT.PUT_LINE('TIME CONSUMPTION: '|| auxt ||' milliseconds.'); 
    DBMS_OUTPUT.PUT_LINE('CONSISTENT GETS: '|| auxg ||' blocks'); 

END RUN_TEST;
  

BEGIN
   DBMS_OUTPUT.ENABLE (buffer_size => NULL);
END PKG_COSTES;

/

   