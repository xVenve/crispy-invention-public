Dar formato weno para word: http://qbnz.com/highlighter/php_highlighter.php

SELECT
    a.nick,
    a.reg_date,
    b.citizenid
FROM
    users a
    LEFT JOIN profiles b ON (a.nick = b.nick)
WHERE (months_between (sysdate, a.reg_date) >= 6
    AND a.nick NOT IN (
        SELECT
            nick
        FROM
            membership)
        AND (b.citizenID IS NULL
            OR b.citizenID NOT IN (
                SELECT
                    citizenID
                FROM
                    contracts)));

SELECT
    dic,
    avg(c)
FROM (
    SELECT
        a.director dic,
        a.title,
        COUNT('x') c
    FROM
        movies a
        JOIN comments b ON (a.director = b.director)
    GROUP BY
        a.director,
        a.title)
GROUP BY
    dic
ORDER BY
    avg(c)
    DESC fetch FIRST ROW ONLY;

--AÑADIR AL DOCUMENTO, ES LA VISTA DE LEADER
CREATE VIEW LEADER (nickname,club, media_comentarios) AS
    SELECT D.member, club, Z/M media_comentarios FROM (
    SELECT A.member, B.club, COUNT ('x') Z FROM PROPOSALS A JOIN COMMENTS B ON (A.title = B.title AND A.director = B.director) GROUP BY (A.member, B.club)) C JOIN
    (SELECT member, COUNT('x') M FROM PROPOSALS GROUP BY (member)) D ON (C.member = D.member)
    ORDER BY (media_comentarios) DESC
    FETCH FIRST 10 ROWS ONLY;

--AÑADIR AL DOCUMENTO, SON VISTAS Y DISPARADORES DE HISTORICOS
CREATE VIEW clubs_vigentes AS SELECT * FROM clubs WHERE (end_date IS NULL);
/
CREATE VIEW clubs_historicos AS SELECT * FROM clubs WHERE (end_date IS NOT NULL);
/
CREATE TRIGGER TG_not_insert_historicos instead OF INSERT ON clubs_historicos
  DECLARE
    notInsert Exception;
  BEGIN
    raise notInsert;
  EXCEPTION
    WHEN notInsert
      THEN raise_application_error(-20001, 'No se puede insertar en historicos');
    END TG_not_insert_historicos;
/
CREATE TRIGGER TG_delete_historicos instead OF DELETE ON clubs_historicos
  BEGIN
    DELETE FROM clubs WHERE(name=:OLD.name);
  END TG_delete_historicos;
/
CREATE TRIGGER TG_delete_vigentes
  instead OF DELETE ON clubs_vigentes
  BEGIN
    UPDATE clubs SET end_date=sysdate WHERE (name =:OLD.name);
  END TG_delete_vigentes;

--VIEW OPENPUB
CREATE VIEW OPENPUB AS
    select name,NUM_USERS, FLOOR(MONTHS_BETWEEN(sysdate,cre_date)) MONTHS, PROPO/FLOOR(MONTHS_BETWEEN(sysdate,cre_date)) AVG_PROP, NUM_COMMENT/PROPO COMMENT_PER_PROP
    FROM ((CLUBS_VIGENTES JOIN (SELECT CLUB NAME ,COUNT('X') NUM_USERS FROM MEMBERSHIP WHERE (CLUB IN (SELECT NAME FROM CLUBS_VIGENTES)) GROUP BY CLUB) USING (NAME))
     JOIN (select CLUB NAME, COUNT('X') PROPO FROM PROPOSALS GROUP BY (CLUB))USING (NAME))
     JOIN (SELECT CLUB NAME, COUNT('X') NUM_COMMENT FROM COMMENTS GROUP BY (CLUB)) USING (NAME);


--VIEW ANYONE_GOES
CREATE VIEW ANYONE_GOES AS
select club name, count('x') NUM_SOLICITUDES from candidates where (TYPE = 'I' AND REJ_DATE IS NULL) Group by club
ORDER BY COUNT('X') DESC
FETCH FIRST 5 ROWS ONLY;

--VIEW REPORT
CREATE  VIEW REPORT AS
select distinct name, founder, cre_date, end_date, slogan, open
from clubs
    Join
    (select DISTINCT nick, club name
    from
        (select nick, club from membership where (nick = user))
        Union
        (select nick, club from candidates where (nick = user))

    ) Using (name);

--CREACION Y GRANT DE usuarios_registrados
CREATE ROLE usuarios_registrados NOT IDENTIFIED;
GRANT select ON openpub TO usuarios_registrados;
GRANT select ON any_goes TO usuarios_registrados;
GRANT select ON REPORT TO usuarios_registrados;

--DISPARADOR APPLICATION

CREATE OR REPLACE TRIGGER APPLICATION BEFORE INSERT ON candidates FOR EACH ROW
DECLARE
    notInsert Exception;
    l_exist varchar2(1);
    BEGIN
    select max('Y') into l_exist
            from CLUBS
            where (name = :new.club AND open = 'C');

    IF :new.type = 'A' THEN
        IF (l_exist is not null) THEN
            raise notInsert;
        END IF;
        END  IF;
    EXCEPTION
    WHEN notInsert
      THEN raise_application_error(-20002, 'No se puede solicitar acceso a un club cerrado sin invitacion');
    END;
/

--PRUEBAS APPLICATION
    --salta el disparador
  insert into candidates (nick, club, type, req_date, req_msg, rej_date, rej_msg) values ('cmp', 'Guild of the Heart geraniums', 'A', to_date('10/01/19', 'DD/MM/YY'), 'dkhwizxcgqrjrfbf mudevgkdkj chwuka.',to_date('13/02/19', 'DD/MM/YY'),'dkhwizxcgqrjrfbf mudevgkdkj chwuka.');
    --no salta el disparador
insert into candidates (nick, club, type, req_date, req_msg, rej_date, rej_msg) values ('cmp', 'Guild of the Heart geraniums', 'I', to_date('10/01/19', 'DD/MM/YY'), 'dkhwizxcgqrjrfbf mudevgkdkj chwuka.',to_date('13/02/19', 'DD/MM/YY'),'dkhwizxcgqrjrfbf mudevgkdkj chwuka.');
    --borrar la fila de la prueba
delete from candidates where (nick = 'cmp' AND club = 'Guild of the Heart geraniums');

--DISPARADOR OVERWRITE

CREATE OR REPLACE TRIGGER OVERWRITE BEFORE INSERT ON comments FOR EACH ROW
DECLARE
    l_exist varchar2(1);
    BEGIN
    select max('Y') into l_exist
            from COMMENTS
            where (nick = :new.nick AND title = :new.title AND director = :new.director);

    IF (l_exist is not null) THEN
    delete from comments where (nick = :new.nick AND title = :new.title AND director = :new.director);
    end if;

    END overwrite;
/

--PRUEBAS OVERWRITE
delete from comments where (message = 'Hola, esto es una prueba');
insert into comments values ('The Sorority of Hamlet or all','ana',to_date('02/10/20','DD/MM/YY'),'Fantastic Mr. Fox','Wes Anderson','Luck','Hola, esto es una prueba','4');
