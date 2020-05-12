-- ----------------------------------------------------
-- ----------------------------------------------------
-- -- TABLES CREATION SCRIPT -- ASSIGNMENT SOLUTION ---
-- ----------------------------------------------------
-- ----------------------------------------------------
-- -- Course: File Structures and DataBases -----------
-- ----------------------------------------------------
-- -- (c) 2020 Javier Calle ---------------------------
-- ------ Carlos III University of Madrid -------------
-- ----------------------------------------------------
-- ----------------------------------------------------
-- -- Part I: Destroy (in case) existent tables -------
-- ----------------------------------------------------

DROP TABLE casts CASCADE CONSTRAINTS;
DROP TABLE genres_movies CASCADE CONSTRAINTS;
DROP TABLE keywords CASCADE CONSTRAINTS;
DROP TABLE viewings CASCADE CONSTRAINTS;
DROP TABLE movies CASCADE CONSTRAINTS;
DROP TABLE stars CASCADE CONSTRAINTS;
DROP TABLE genres CASCADE CONSTRAINTS;
DROP TABLE contracts CASCADE CONSTRAINTS;
DROP TABLE products CASCADE CONSTRAINTS;
DROP TABLE profiles CASCADE CONSTRAINTS;
DROP TABLE comments CASCADE CONSTRAINTS;
DROP TABLE proposals CASCADE CONSTRAINTS;
DROP TABLE candidates CASCADE CONSTRAINTS;
DROP TABLE membership CASCADE CONSTRAINTS;
DROP TABLE clubs CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;



-- ----------------------------------------------------
-- -- Part II: Create all tables ----------------------
-- ----------------------------------------------------
CREATE TABLE genres (
genre	VARCHAR2(70),
CONSTRAINT PK_GENRES PRIMARY KEY (genre)
);

CREATE TABLE stars (
name	VARCHAR2(50),
CONSTRAINT PK_STARS PRIMARY KEY (name)
);

CREATE TABLE movies(
title             VARCHAR2(100),
director          VARCHAR2(50),
duration          NUMBER(3),
year              NUMBER(4),
country           VARCHAR2(25),
language          VARCHAR2(20),
color             VARCHAR2(1),
aspect_ratio      NUMBER(4,2) ,
gross             NUMBER(10),
budget            NUMBER(12),
content_rating    VARCHAR2(9),
faces_poster      NUMBER(6),
imdb_score        NUMBER(2,1),
imdb_link         VARCHAR2(60),
num_critic        NUMBER(6),
voted_users       NUMBER(7),
user_reviews      NUMBER(6),
movie_likes       NUMBER(6),
director_likes    NUMBER(6),
cast_likes        NUMBER(6),
CONSTRAINT MOVIES_PK PRIMARY KEY (title,director),
CONSTRAINT FK_movies_stars FOREIGN KEY (director) REFERENCES stars,
CONSTRAINT CK_MOVIES CHECK (COLOR IN ('B','C', null))
);

CREATE TABLE genres_movies (
title	 VARCHAR2(100),
director VARCHAR2(50),
genre	 VARCHAR2(70),
CONSTRAINT PK_GENRES_MOVIES PRIMARY KEY (title,director,genre),
CONSTRAINT FK_GENRES_MOVIES FOREIGN KEY (title,director) REFERENCES movies ON DELETE CASCADE,
CONSTRAINT FK_GENRES FOREIGN KEY (genre) REFERENCES genres
);

CREATE TABLE keywords (
title	  VARCHAR2(100),
director  VARCHAR2(50),
keyword	  VARCHAR2(150),
CONSTRAINT PK_KEYWORDS PRIMARY KEY (title,director,keyword),
CONSTRAINT FK_KEYWORDS_MOVIES FOREIGN KEY (title,director) REFERENCES movies ON DELETE CASCADE
);

CREATE TABLE casts (
actor     VARCHAR2(50),
title     VARCHAR2(100),
director  VARCHAR2(50),
likes     NUMBER(6),
CONSTRAINT PK_CASTS PRIMARY KEY (actor, title, director),
CONSTRAINT FK1_CASTS_STARS  FOREIGN KEY (actor) REFERENCES stars ON DELETE CASCADE,
CONSTRAINT FK2_CASTS_MOVIES FOREIGN KEY (title,director) REFERENCES MOVIES ON DELETE CASCADE
);


CREATE TABLE users (
nick	    VARCHAR2(35),
password  VARCHAR2(20) NOT NULL,
email 	  VARCHAR2(60) NOT NULL,
reg_date  DATE NOT NULL,
CONSTRAINT PK_USERS PRIMARY KEY (nick),
CONSTRAINT UK_USERS UNIQUE (email)
);


CREATE TABLE profiles (
nick	      VARCHAR2(35),
name        VARCHAR2(35),
surname     VARCHAR2(35),
secsurname  VARCHAR2(35),
citizenID 	VARCHAR2(10) NOT NULL,
mobile   	  NUMBER(12),
birthdate   DATE,
CONSTRAINT PK_PROFILES PRIMARY KEY (nick),
CONSTRAINT UK_PROFILES UNIQUE (citizenID),
CONSTRAINT FK_PROFILES_USERS FOREIGN KEY (nick) REFERENCES users ON DELETE CASCADE
);

CREATE TABLE products (
name	VARCHAR2(50),
CONSTRAINT PK_PRODUCTS PRIMARY KEY (name)
);

CREATE TABLE contracts (
idcontract    VARCHAR2(20),
citizenID 	  VARCHAR2(10) NOT NULL,
contract_type VARCHAR2(50) NOT NULL,
startdate     DATE NOT NULL,
enddate       DATE,
address       VARCHAR2(100) NOT NULL,
town          VARCHAR2(100) NOT NULL,
ZIPcode       VARCHAR2(8) NOT NULL,
country       VARCHAR2(100) NOT NULL,
CONSTRAINT PK_CONTRACTS PRIMARY KEY (idcontract),
CONSTRAINT FK_CONTRACTS_PRODUCTS FOREIGN KEY (contract_type) REFERENCES products,
CONSTRAINT FK_CONTRACTS_PROFILES FOREIGN KEY (citizenID) REFERENCES profiles(citizenID),
CONSTRAINT CK_CONTRACTS CHECK (enddate IS NULL OR enddate>startdate)
);

CREATE TABLE viewings (
title	   VARCHAR2(100),
director VARCHAR2(50),
client	 VARCHAR2(20),
vdate    DATE NOT NULL,
CONSTRAINT PK_VIEWINGS PRIMARY KEY (title,director,client),
CONSTRAINT FK_VIEWINGS_MOVIES  FOREIGN KEY (title,director) REFERENCES movies,
CONSTRAINT FK_VIEWINGS_CLIENTS FOREIGN KEY (client) REFERENCES contracts
);

CREATE TABLE clubs (
name	   VARCHAR2(60),
founder  VARCHAR2(35),
cre_date DATE NOT NULL,
end_date DATE,
slogan	 VARCHAR2(100),
open     CHAR(1) DEFAULT 'O' NOT NULL,
CONSTRAINT PK_CLUBS PRIMARY KEY (name),
CONSTRAINT FK_CLUBS_USER  FOREIGN KEY (founder) REFERENCES users ON DELETE SET NULL,
CONSTRAINT CK_CLUBS CHECK (open IN ('O','C'))
);

CREATE TABLE membership (
nick     VARCHAR2(35),
club     VARCHAR2(60),
mentor   VARCHAR2(35),
type     CHAR(1) NOT NULL,
req_date DATE NOT NULL,
inc_date DATE NOT NULL,
end_date DATE,
req_msg  VARCHAR2(100),
acc_msg VARCHAR2(1500),
CONSTRAINT PK_MEMBERSHIP PRIMARY KEY (nick,club),
CONSTRAINT FK_MEMBERSHIP_USERS FOREIGN KEY (nick) REFERENCES users ON DELETE CASCADE,
CONSTRAINT FK_MEMBERSHIP_CLUB FOREIGN KEY (club) REFERENCES clubs,
CONSTRAINT FK_MEMBERSHIP_MENTOR FOREIGN KEY (mentor,club) REFERENCES membership,
CONSTRAINT CK_MEMBERSHIP_TYPE CHECK (type IN ('A','I','F')),
CONSTRAINT CK_MEMBERSHIP_DATES CHECK (req_date<inc_date AND (end_date is null or inc_date<end_date))
);

CREATE TABLE candidates (
nick     VARCHAR2(35),
club     VARCHAR2(60),
member   VARCHAR2(35),
type     CHAR(1) NOT NULL,
req_date DATE NOT NULL,
req_msg  VARCHAR2(1500) NOT NULL,
rej_date DATE,
rej_msg  VARCHAR2(1500),
CONSTRAINT PK_DISMISSALS PRIMARY KEY (nick,club,req_date),
CONSTRAINT FK_DISMISSALS_USERS FOREIGN KEY (nick) REFERENCES users ON DELETE CASCADE,
CONSTRAINT FK_DISMISSALS_CLUB FOREIGN KEY (club) REFERENCES clubs,
CONSTRAINT FK_DISMISSALS_MENTOR FOREIGN KEY (member,club) REFERENCES membership,
CONSTRAINT CK_DISMISSALS_TYPE CHECK (type IN ('A','I')),
CONSTRAINT CK_DISMISSALS_DATES CHECK (rej_date is null or req_date<rej_date),
CONSTRAINT CK_DISMISSALS_PENDING CHECK (rej_date is not null or rej_msg is null)
);

CREATE TABLE proposals (
title	    VARCHAR2(100),
director  VARCHAR2(50),
club      VARCHAR2(60),
member	  VARCHAR2(35) NOT NULL,
prop_date DATE NOT NULL,
slogan    VARCHAR2(100),
message   VARCHAR2(1500),
CONSTRAINT PK_PROPOSALS PRIMARY KEY (title,director,club),
CONSTRAINT UK_PROPOSALS UNIQUE (club,member,prop_date),
CONSTRAINT FK_PROPOSALS_MOVIES  FOREIGN KEY (title,director) REFERENCES movies,
CONSTRAINT FK_PROPOSALS_MEMBER FOREIGN KEY (member,club) REFERENCES membership ON DELETE CASCADE
);

CREATE TABLE comments (
club       VARCHAR2(60) NOT NULL,
nick	     VARCHAR2(35),
msg_date   DATE,
title	     VARCHAR2(100) NOT NULL,
director   VARCHAR2(50) NOT NULL,
subject    VARCHAR2(100),
message    VARCHAR2(1500),
valoration NUMBER(2),
CONSTRAINT PK_COMMENTS PRIMARY KEY (nick,msg_date),
CONSTRAINT FK_COMMENTS_MEMBER FOREIGN KEY (nick,club) REFERENCES membership ON DELETE CASCADE,
CONSTRAINT FK_COMMENTS_MOVIES  FOREIGN KEY (title,director) REFERENCES movies,
CONSTRAINT CK_COMMENTS_VAL CHECK (valoration<11)
);





drop index MEMBER_INDEX_PROPOSALS;
drop index NICK_INDEX_COMMENTS;
drop index NICK_MEMBERSHIP_INDEX;
drop index DIRECTORTITLE_INDEX_COMMENTS;
drop index DIRECTOR_INDEX_movies;
drop index end_clubs_index;


create index end_clubs_index on clubs(name,end_date) tablespace tab_8k;
CREATE INDEX MEMBER_INDEX_PROPOSALS ON PROPOSALS(MEMBER) TABLESPACE TAB_8K;
CREATE INDEX NICK_INDEX_COMMENTS ON COMMENTS(NICK) TABLESPACE TAB_2K;
create index nick_membership_index on membership(nick) tablespace tab_8k;
CREATE INDEX DirectorTitle_INDEX_COMMENTS ON COMMENTS(title, director) TABLESPACE TAB_8K;
CREATE INDEX director_index_movies ON movies(director) TABLESPACE TAB_8K;







-- ----------------------------------------------------
-- -- Annex: list of "mistakes" introduced         ----
-- ----------------------------------------------------
--
-- film "The Sting" appears twice, with different actors
--
--

-- ----------------------------------------------------
-- -- Part III: Populate tables by querying old ones --
-- ----------------------------------------------------

INSERT INTO stars (
SELECT DISTINCT actor_1_name FROM fsdb.old_movies WHERE actor_1_name IS NOT NULL
UNION SELECT DISTINCT actor_2_name FROM fsdb.old_movies WHERE actor_2_name IS NOT NULL
UNION SELECT DISTINCT actor_3_name FROM fsdb.old_movies WHERE actor_3_name IS NOT NULL
UNION SELECT DISTINCT director_name FROM fsdb.old_movies );
-- 8354 rows

-- PROBLEM 1: film 'The Sting' appears twice, but with different stars
-- SOLUTION: while uploading movies (without stars), SELECT DISTINCT; while uploading 'casts', insert all six
INSERT INTO movies (title, director, duration, year, country, language,color, aspect_ratio,
            gross, budget, content_rating, faces_poster, imdb_score, imdb_link, num_critic,
            voted_users, user_reviews, movie_likes, director_likes, cast_likes)
SELECT DISTINCT movie_title,director_name,duration,TO_NUMBER(title_year),country, language,
       CASE WHEN color='Black and White' THEN 'B' WHEN color='Color' THEN 'C' ELSE null END,
       TO_NUMBER(aspect_ratio,'99.99'),gross,budget,content_rating,facenumber_in_poster,
       TO_NUMBER(imdb_score,'9.9'),movie_imdb_link,num_critic_for_reviews,num_voted_users,
       num_user_for_reviews,movie_facebook_likes,director_facebook_likes,cast_total_facebook_likes
FROM fsdb.old_movies;
-- 4814 rows

INSERT INTO casts (
SELECT DISTINCT actor_1_name,movie_title,director_name,actor_1_facebook_likes
       FROM fsdb.old_movies WHERE actor_1_name IS NOT NULL
UNION SELECT DISTINCT actor_2_name,movie_title,director_name,actor_2_facebook_likes
      FROM fsdb.old_movies WHERE actor_2_name IS NOT NULL
UNION SELECT DISTINCT actor_3_name,movie_title,director_name,actor_3_facebook_likes
      FROM fsdb.old_movies WHERE actor_3_name IS NOT NULL);
-- 14409 rows

INSERT INTO genres (
SELECT DISTINCT genre1 FROM fsdb.old_movies WHERE genre1 IS NOT NULL
UNION SELECT DISTINCT genre2 FROM fsdb.old_movies WHERE genre2 IS NOT NULL
UNION SELECT DISTINCT genre3 FROM fsdb.old_movies WHERE genre3 IS NOT NULL
UNION SELECT DISTINCT genre4 FROM fsdb.old_movies WHERE genre4 IS NOT NULL
UNION SELECT DISTINCT genre5 FROM fsdb.old_movies WHERE genre5 IS NOT NULL);
-- 24 rows

INSERT INTO genres_movies (
SELECT DISTINCT movie_title,director_name,genre1 FROM fsdb.old_movies WHERE genre1 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,genre2 FROM fsdb.old_movies WHERE genre2 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,genre3 FROM fsdb.old_movies WHERE genre3 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,genre4 FROM fsdb.old_movies WHERE genre4 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,genre5 FROM fsdb.old_movies WHERE genre5 IS NOT NULL);
-- 13698 rows

INSERT INTO keywords (
SELECT DISTINCT movie_title,director_name,keyword1 FROM fsdb.old_movies WHERE keyword1 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,keyword2 FROM fsdb.old_movies WHERE keyword2 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,keyword3 FROM fsdb.old_movies WHERE keyword3 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,keyword4 FROM fsdb.old_movies WHERE keyword4 IS NOT NULL
UNION SELECT DISTINCT movie_title,director_name,keyword5 FROM fsdb.old_movies WHERE keyword5 IS NOT NULL);
-- 23035 rows


INSERT INTO users (nick, password, email, reg_date)
   SELECT nickname,passw,email,TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI')
      FROM old_users JOIN (SELECT client nickname,ev_date,ev_hour FROM old_events WHERE etype='registration') USING(nickname);
-- 12345 rows


-- PROBLEM 2: user 'esperanza7' lacks of citizenID, while she has a profile
-- SOLUTION:  skip it
-- PROBLEM 3: users 'carhuamaca3' and 'alfredo40' share the same citizenID ('82768894J')
-- SOLUTION:  skip them
INSERT INTO profiles (nick, name, surname, secsurname, citizenID, mobile, birthdate)
   SELECT nickname,name,surname,sec_surname,citizenID,TO_NUMBER(phoneN),TO_DATE(birthdate,'YYYY-MM-DD')
      FROM old_users
      WHERE citizenID!='82768894J';
-- this condition checks citizenID is comparable (not null) and different from '82768894J'
-- 12064 rows (3 ill rows skipped)


INSERT INTO products
   (SELECT DISTINCT contract_type
       FROM old_users WHERE contract_type is not null);
-- 8 rows

INSERT INTO contracts (idcontract,citizenID,contract_type,startdate,enddate,address,town,ZIPcode,country)
   SELECT contractid,citizenID,contract_type,TO_DATE(startdate,'YYYY-MM-DD'),TO_DATE(enddate,'YYYY-MM-DD'),
          address,town,ZIPcode,country
      FROM old_users WHERE contractID is not null;
-- 8002 rows

INSERT INTO viewings (title,director,client,vdate)
   WITH watching AS (SELECT details1 title, details2 dir, client nick,
                            TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI') vdate
                        FROM old_events WHERE etype='viewing')
   SELECT A.title,A.dir,C.IDcontract,A.vdate
      FROM watching A JOIN (SELECT nick,citizenID FROM profiles) B USING(nick) JOIN contracts C
           ON(B.citizenID=C.citizenID AND A.vdate>=C.startdate AND (C.enddate IS NULL OR C.enddate>=A.vdate));
-- 30867 rows

INSERT INTO clubs (name,founder,cre_date,end_date,slogan,open)
   SELECT club,A.client,TO_DATE(A.ev_date||A.ev_hour,'YYYY-MM-DDHH24:MI'),
          TO_DATE(B.ev_date||B.ev_hour,'YYYY-MM-DDHH24:MI'),A.subject,
          CASE WHEN details1='Open' THEN 'O' ELSE 'C' END
       FROM (SELECT * FROM old_events WHERE etype='foundation') A
           LEFT OUTER JOIN
           (SELECT club,ev_date,ev_hour FROM old_events WHERE etype='ceasing') B
           USING(club);
-- 399 rows

INSERT INTO membership (nick,club,mentor,type,req_date,inc_date,end_date,req_msg,acc_msg)
   SELECT client,club,null,'F',TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI'),
          TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI')+1/86400,null,details1,subject
       FROM old_events WHERE etype='foundation';
-- 399 rows


INSERT INTO membership (nick,club,mentor,type,req_date,inc_date,end_date,req_msg,acc_msg)
   WITH
     -- members from application: first mentor's answer (in case several mentors accept)
        applies AS ( SELECT A.client nick,A.club club,B.client member,
                            TO_DATE(A.ev_date||A.ev_hour,'YYYY-MM-DDHH24:MI') adate,
                            TO_DATE(B.ev_date||B.ev_hour,'YYYY-MM-DDHH24:MI') rdate,
                            A.message amsg,B.message rmsg
                        FROM (SELECT * FROM old_events WHERE etype='application') A
                             JOIN (SELECT * FROM old_events WHERE etype='acceptance') B
                             ON (A.club=B.club AND A.client=B.subject) ),
     -- latest application of candidate (in case has issued several applications)
        welcm AS ( SELECT nick,club,rdate,max(adate) adate
                   FROM (Select nick,club,min(rdate) rdate FROM applies GROUP BY nick,club) C
                        JOIN applies D USING (nick,club,rdate)
                   GROUP BY (nick,club,rdate) ),
     -- members coming from application
        cand_A AS (SELECT nick, club,F.member mentor,'A' type, adate req_date,
                          rdate inc_date, null end_date, F.amsg req_msg, F.rmsg acc_msg
                      FROM welcm E JOIN applies F USING (nick,club,rdate,adate) ),
     -- members coming from invitation
        cand_I AS (SELECT B.client nick,A.club club,A.client mentor,'I' type,
                         TO_DATE(A.ev_date||A.ev_hour,'YYYY-MM-DDHH24:MI') req_date,
                         TO_DATE(B.ev_date||B.ev_hour,'YYYY-MM-DDHH24:MI') inc_date,
                         null end_date,A.message req_msg,B.message acc_msg
                     FROM (SELECT * FROM old_events WHERE etype='invitation') A
                          JOIN (SELECT * FROM old_events WHERE etype='acceptance') B
                          ON (A.club=B.club AND (A.client=B.subject OR A.club=B.subject) AND A.subject=B.client)),
        cand_ALL AS (SELECT * FROM cand_A UNION SELECT * FROM cand_I)
   SELECT nick,club,mentor,type,req_date,inc_date,end_date,req_msg,acc_msg
      FROM cand_ALL ORDER BY inc_date;
-- 4897 rows

INSERT INTO candidates (nick,club,member,type,req_date,req_msg,rej_date,rej_msg)
   SELECT B.client,A.club,A.client,'I',TO_DATE(A.ev_date||A.ev_hour,'YYYY-MM-DDHH24:MI'),
          A.message,TO_DATE(B.ev_date||B.ev_hour,'YYYY-MM-DDHH24:MI'),B.message
      FROM (SELECT * FROM old_events WHERE etype='invitation') A
           JOIN (SELECT * FROM old_events WHERE etype='rejection') B
           ON (A.club=B.club AND (A.client=B.subject OR A.club=B.subject) AND A.subject=B.client);
-- 505 rows

INSERT INTO candidates (nick,club,member,type,req_date,req_msg,rej_date,rej_msg)
   SELECT subject,club,client,'I',TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI'),message,null,null
      FROM old_events
      WHERE etype='invitation'
           AND (subject,club) NOT IN (SELECT client,club from old_events where etype='rejection' or etype='acceptance');
-- 335 rows

-- PROBLEM 4: user 'maria59' is not a member of 'Club of the Harvest potato' and rejects an application for it
-- SOLUTION: skip it
INSERT INTO candidates (nick,club,member,type,req_date,req_msg,rej_date,rej_msg)
   SELECT A.client,A.club,B.client,'A',TO_DATE(A.ev_date||A.ev_hour,'YYYY-MM-DDHH24:MI'),
          A.subject,TO_DATE(B.ev_date||B.ev_hour,'YYYY-MM-DDHH24:MI'),B.message
      FROM (SELECT * FROM old_events WHERE etype='application') A
           JOIN (SELECT * FROM old_events WHERE etype='rejection' and client!='maria59') B
           ON (A.club=B.club AND A.client=B.subject);
-- 46 rows (1 ill row skipped)

INSERT INTO candidates (nick,club,member,type,req_date,req_msg,rej_date,rej_msg)
   SELECT client,club,null,'A',TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI'),subject,null,null
      FROM old_events
      WHERE etype='application'
           AND (client,club) NOT IN (SELECT subject,club from old_events where etype='rejection' or etype='acceptance');
-- 11 rows

-- PROBLEM 5: there is a non existing movie, titled 'Toi Story'
-- SOLUTION: skip it
INSERT INTO proposals (title,director,club,member,prop_date,slogan,message)
   SELECT details1,details2,club,client,TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI'),subject,message
      FROM old_events WHERE etype='proposal' and details1!='Toi Story';
-- 15208 rows (1 ill row skipped)


-- PROBLEM 6: user 'bullon' from club "Eden's Guild" comments two films exactly at the same date+time
-- SOLUTION: skip those comments, then insert them adding "rownum-1" seconds
INSERT INTO comments (club,nick,msg_date,title,director,subject,message,valoration)
   SELECT club,client,TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI'),
          details1,details2,subject,message,TO_NUMBER(substr(etype,9))
      FROM (SELECT client,ev_date,ev_hour
               FROM old_events WHERE etype LIKE 'opinion%'
               GROUP BY client,ev_date,ev_hour having count('s')=1)
           JOIN old_events USING (client,ev_date,ev_hour)
       WHERE etype LIKE 'opinion%';
-- 121714 rows (skipped 2 ill rows)


INSERT INTO comments (club,nick,msg_date,title,director,subject,message,valoration)
   SELECT club,client,TO_DATE(ev_date||ev_hour,'YYYY-MM-DDHH24:MI')+((rownum-1)/86400),
          details1,details2,subject,message,TO_NUMBER(substr(etype,9))
      FROM (SELECT client,ev_date,ev_hour
               FROM old_events WHERE etype LIKE 'opinion%'
               GROUP BY client,ev_date,ev_hour having count('s')>1)
           JOIN old_events USING (client,ev_date,ev_hour)
       WHERE etype LIKE 'opinion%';
-- 2 rows (2 ill rows healed)



COMMIT;


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
