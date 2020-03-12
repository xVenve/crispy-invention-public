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
    UPDATE clubs SET end_date=sysdate WHERE (name=:OLD.name);
  END TG_delete_vigentes;
