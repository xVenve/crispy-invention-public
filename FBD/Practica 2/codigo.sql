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
