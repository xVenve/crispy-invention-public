768,37902832
____________________________________________________

ORGANIZACION 0:
RESULTS AT 01/05/20
TIME CONSUMPTION: 67773,7 milliseconds.
CONSISTENT GETS: 71693 blocks

Procedimiento PL/SQL terminado correctamente.

Transcurrido: 00:21:54.57
__________________________________________________________

--utilizamos esta indización ya que la peliculas es lo que más se busca y creemos que es lo más optimo--
CREATE INDEX director_index_movies ON movies(director) TABLESPACE TAB_8K;
___________________________________________________________
Transcurrido: 00:00:11.80

Plan de Ejecucion
----------------------------------------------------------
Plan hash value: 1020340360

--------------------------------------------------------------------------------
--

| Id  | Operation            | Name      | Rows  | Bytes | Cost (%CPU)| Time
 |

--------------------------------------------------------------------------------
--

|   0 | SELECT STATEMENT     |           | 13854 |   365K|    22   (0)| 00:00:01
 |

|   1 |  INDEX FAST FULL SCAN| MOVIES_PK | 13854 |   365K|    22   (0)| 00:00:01
 |

--------------------------------------------------------------------------------
--


Note
-----
   - dynamic statistics used: dynamic sampling (level=2)


Estadisticas
----------------------------------------------------------
          6  recursive calls
          0  db block gets
        813  consistent gets
          0  physical reads
          0  redo size
     246898  bytes sent via SQL*Net to client
       7756  bytes received via SQL*Net from client
        675  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
      10110  rows processed

Estadisticas
----------------------------------------------------------
          6  recursive calls
          0  db block gets
        716  consistent gets
         31  physical reads
          0  redo size
     246898  bytes sent via SQL*Net to client
       7760  bytes received via SQL*Net from client
        675  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
      10110  rows processed
__________________________________________________________________________________________

CREATE INDEX director_index_movies ON movies(director) TABLESPACE TAB_8K;

Acceso a un director especifico con indice: select /*+ INDEX(movies director_index_movies) */ title from movies where director='Zack Snyder';
__________________________________________________________________________________________
Transcurrido: 00:00:00.00

Plan de Ejecucion
----------------------------------------------------------
Plan hash value: 3795561416

--------------------------------------------------------------------------------
-----------------------------

| Id  | Operation                           | Name                  | Rows  | By
tes | Cost (%CPU)| Time     |

--------------------------------------------------------------------------------
-----------------------------

|   0 | SELECT STATEMENT                    |                       |     7 |
553 |     4   (0)| 00:00:01 |

|   1 |  TABLE ACCESS BY INDEX ROWID BATCHED| MOVIES                |     7 |
553 |     4   (0)| 00:00:01 |

|*  2 |   INDEX RANGE SCAN                  | DIRECTOR_INDEX_MOVIES |     7 |
    |     1   (0)| 00:00:01 |

--------------------------------------------------------------------------------
-----------------------------


Predicate Information (identified by operation id):
---------------------------------------------------

   2 - access("DIRECTOR"='Zack Snyder')

Note
-----
   - dynamic statistics used: dynamic sampling (level=2)


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         10  consistent gets
          0  physical reads
          0  redo size
        768  bytes sent via SQL*Net to client
        422  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
          7  rows processed
__________________________________________________________________________________________
Acceso normal a un director especifico: select /*+ no_INDEX(movies director_index_movies) */ title from movies where director='Zack Snyder';
__________________________________________________________________________________________
Transcurrido: 00:00:00.00

Plan de Ejecucion
----------------------------------------------------------
Plan hash value: 1020340360

--------------------------------------------------------------------------------
--

| Id  | Operation            | Name      | Rows  | Bytes | Cost (%CPU)| Time
 |

--------------------------------------------------------------------------------
--

|   0 | SELECT STATEMENT     |           |    23 |  1817 |    22   (0)| 00:00:01
 |

|*  1 |  INDEX FAST FULL SCAN| MOVIES_PK |    23 |  1817 |    22   (0)| 00:00:01
 |

--------------------------------------------------------------------------------
--


Predicate Information (identified by operation id):
---------------------------------------------------

   1 - filter("DIRECTOR"='Zack Snyder')

Note
-----
   - dynamic statistics used: dynamic sampling (level=2)


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         79  consistent gets
          0  physical reads
          0  redo size
        768  bytes sent via SQL*Net to client
        425  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
          7  rows processed
__________________________________________________________________________________________


CREATE INDEX MEMBER_INDEX_PROPOSALS ON PROPOSALS(MEMBER) TABLESPACE TAB_8K;

Usando indice: Acceso a la totalidad
________________________________________________________________________________________________
Transcurrido: 00:00:01.07

Plan de Ejecucion
----------------------------------------------------------
Plan hash value: 3296588120

--------------------------------------------------------------------------------
----------------

| Id  | Operation             | Name                   | Rows  | Bytes | Cost (%
CPU)| Time     |

--------------------------------------------------------------------------------
----------------

|   0 | SELECT STATEMENT      |                        | 12738 |   236K|    15
 (7)| 00:00:01 |

|   1 |  HASH UNIQUE          |                        | 12738 |   236K|    15
 (7)| 00:00:01 |

|   2 |   INDEX FAST FULL SCAN| MEMBER_INDEX_PROPOSALS | 12738 |   236K|    14
 (0)| 00:00:01 |

--------------------------------------------------------------------------------
----------------


Note
-----
   - dynamic statistics used: dynamic sampling (level=2)


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         45  consistent gets
          0  physical reads
          0  redo size
      96090  bytes sent via SQL*Net to client
       3674  bytes received via SQL*Net from client
        303  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4525  rows processed


Sin usar indice: Acceso a la totalidad.
________________________________________________________________________________________________
Transcurrido: 00:00:01.04

Plan de Ejecucion
----------------------------------------------------------
Plan hash value: 3601422770

--------------------------------------------------------------------------------
------

| Id  | Operation             | Name         | Rows  | Bytes | Cost (%CPU)| Time
     |

--------------------------------------------------------------------------------
------

|   0 | SELECT STATEMENT      |              | 12738 |   236K|    34   (6)| 00:0
0:01 |

|   1 |  HASH UNIQUE          |              | 12738 |   236K|    34   (6)| 00:0
0:01 |

|   2 |   INDEX FAST FULL SCAN| UK_PROPOSALS | 12738 |   236K|    32   (0)| 00:0
0:01 |

--------------------------------------------------------------------------------
------


Note
-----
   - dynamic statistics used: dynamic sampling (level=2)


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        110  consistent gets
          0  physical reads
          0  redo size
      96090  bytes sent via SQL*Net to client
       3674  bytes received via SQL*Net from client
        303  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4525  rows processed

CP_Aragna sin indice, a un miembro especifico:
________________________________________________________________________________________________
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        143  consistent gets
          0  physical reads
          0  redo size
        634  bytes sent via SQL*Net to client
        367  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed




CP_Aragna con indice, a un miembro especifico:
___________________________________________________________________________________________

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         43  consistent gets
          0  physical reads
          0  redo size
        634  bytes sent via SQL*Net to client
        367  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed
















CREATE INDEX NICK_INDEX_COMMENTS ON COMMENTS(NICK) TABLESPACE TAB_8K;

CP_Aragna con indice, a un miembro especifico:
___________________________________________________________________________________________


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         40  consistent gets
          0  physical reads
          0  redo size
        634  bytes sent via SQL*Net to client
        367  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed


CP_Aragna sin indice, a un miembro especifico:
________________________________________________________________________________________________
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        143  consistent gets
          0  physical reads
          0  redo size
        634  bytes sent via SQL*Net to client
        367  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed


Leader no se ha podido optimizar con indice, revisar si se puede con Clusteres.

EJECUCION DE RUNTEST SOBRE LOS INDICES CREADOS EN LA PARTE SUPERIOR:

RESULTS AT 01/05/20
TIME CONSUMPTION: 66777,1 milliseconds.
CONSISTENT GETS: 67586,6 blocks



LAS PRUEBAS ANTES DE CREAR EL PRIMER CLUSTER SON CON LOS DATOS AÑADIDOS POR LA PRUEBA

Precluster Leader:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21307  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        696  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed


Precluster cp_aragna:

Estadisticas
----------------------------------------------------------
          7  recursive calls
          0  db block gets
      21327  consistent gets
          0  physical reads
          0  redo size
       7135  bytes sent via SQL*Net to client
        838  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed

create cluster CLUSTER_PC (NICK VARCHAR2(35), CLUB VARCHAR2(60));
CREATE INDEX INDEX_CLUTER_PC ON CLUSTER CLUSTER_PC TABLESPACE TAB_8K;

Postcluster cp_aragna:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      66732  consistent gets
          0  physical reads
          0  redo size
       7135  bytes sent via SQL*Net to client
        904  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed

Postcluter leader:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      14094  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        696  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed


create cluster CLUSTER_PC (NICK VARCHAR2(35));
Postcluster cp_aragna:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      68209  consistent gets
          0  physical reads
          0  redo size
       7132  bytes sent via SQL*Net to client
        837  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed
Postcluter leader:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      14347  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        696  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

create cluster CLUSTER_PC (club VARCHAR2(60));


Aragna solo club:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
     566429  consistent gets
          0  physical reads
          0  redo size
       7132  bytes sent via SQL*Net to client
        837  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed

Leader solo con club:
Estadisticas
----------------------------------------------------------
         38  recursive calls
          0  db block gets
      11855  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        697  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed



Mejora de:
 SELECT title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='COMEDY'
   INTERSECT
   SELECT title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='DRAMA';

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        184  consistent gets
          0  physical reads
          0  redo size
      29275  bytes sent via SQL*Net to client
        953  bytes received via SQL*Net from client
         44  SQL*Net roundtrips to/from client
          2  sorts (memory)
          0  sorts (disk)
        645  rows processed

drop index genre_movies_index;
create index genre_movies_index on genres_movies(genre) tablespace tab_8k;

 SELECT /*+ index(genres_movies genre_movies_index) */ title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='COMEDY'
   INTERSECT
   SELECT /*+ index(genres_movies genre_movies_index) */ title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='DRAMA';

Estadisticas
----------------------------------------------------------
          1  recursive calls
          0  db block gets
        238  consistent gets
          0  physical reads
          0  redo size
      29275  bytes sent via SQL*Net to client
       1054  bytes received via SQL*Net from client
         44  SQL*Net roundtrips to/from client
          2  sorts (memory)
          0  sorts (disk)
        645  rows processed

Mejora de:

SELECT nick FROM users WHERE (sysdate-reg_date)>182
   MINUS
   SELECT nick FROM membership
   MINUS
   SELECT nick FROM contracts JOIN profiles USING(citizenID);

Concluster:
create cluster CLUSTER_NICK (NICK VARCHAR2(35));
CREATE INDEX INDEX_CLUTER_NICK ON CLUSTER CLUSTER_NICK TABLESPACE TAB_8K;

Precluster:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        460  consistent gets
          0  physical reads
          0  redo size
      52602  bytes sent via SQL*Net to client
       2247  bytes received via SQL*Net from client
        162  SQL*Net roundtrips to/from client
          3  sorts (memory)
          0  sorts (disk)
       2408  rows processed

Postcluster:

Estadisticas
----------------------------------------------------------
          4  recursive calls
          0  db block gets
      12748  consistent gets
          0  physical reads
          0  redo size
      52602  bytes sent via SQL*Net to client
       2247  bytes received via SQL*Net from client
        162  SQL*Net roundtrips to/from client
          3  sorts (memory)
          0  sorts (disk)
       2408  rows processed

Con indices, los otros dos ya existen:
Se han probado los otros tablespaces y el mejor es 8k 460 2k y 425 16k.

create index nick_membership_index on membership(nick) tablespace tab_8k;

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        318  consistent gets
          0  physical reads
          0  redo size
      41355  bytes sent via SQL*Net to client
       1834  bytes received via SQL*Net from client
        130  SQL*Net roundtrips to/from client
          2  sorts (memory)
          0  sorts (disk)
       1934  rows processed

Mejorar:
SELECT * FROM (
     SELECT * FROM (
       SELECT director, avg(coms) meancomm
          FROM (SELECT title,director,count('c') coms
                  FROM comments
                  GROUP BY title,director)
          GROUP BY director
     ) ORDER BY meancomm DESC
   ) WHERE rownum=1;


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      10873  consistent gets
          0  physical reads
          0  redo size
        652  bytes sent via SQL*Net to client
        620  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed



CREATE INDEX DirectorTitle_INDEX_COMMENTS ON COMMENTS(title, director) TABLESPACE TAB_8K;

Estadisticas
----------------------------------------------------------
                    0  recursive calls
                    0  db block gets
                  724  consistent gets
                    0  physical reads
                    0  redo size
                  652  bytes sent via SQL*Net to client
                  620  bytes received via SQL*Net from client
                    2  SQL*Net roundtrips to/from client
                    1  sorts (memory)
                    0  sorts (disk)
                    1  rows processed


CREATE INDEX MEMBER_INDEX_PROPOSALS ON PROPOSALS(MEMBER) TABLESPACE TAB_8K;
CREATE INDEX NICK_INDEX_COMMENTS ON COMMENTS(NICK) TABLESPACE TAB_8K;
create index nick_membership_index on membership(nick) tablespace tab_8k;
CREATE INDEX DirectorTitle_INDEX_COMMENTS ON COMMENTS(title, director) TABLESPACE TAB_8K;
CREATE INDEX director_index_movies ON movies(director) TABLESPACE TAB_8K;



drop index MEMBER_INDEX_PROPOSALS;
drop index NICK_INDEX_COMMENTS;
drop index NICK_MEMBERSHIP_INDEX;
drop index DIRECTORTITLE_INDEX_COMMENTS;
drop index DIRECTOR_INDEX_movies;




Leader con los 5 indices creados:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      11131  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        696  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

Aragna con los 5 indices creados:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      11133  consistent gets
          0  physical reads
          0  redo size
       7135  bytes sent via SQL*Net to client
        837  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed

Leader sin ningun indice nuestro:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      11877  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        696  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

Aragna sin indices nuestros:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      11878  consistent gets
          0  physical reads
          0  redo size
       7135  bytes sent via SQL*Net to client
        837  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
        207  rows processed

RESULTADO DE RUNTEST CON LOS 5 INDICES QUE ESTAN DEFINIDOS ARRIBA, CON LA TABLA RECIEN CREADA:
RESULTS AT 02/05/20
TIME CONSUMPTION: 68606,8 milliseconds.
CONSISTENT GETS: 48501,6 blocks

Procedimiento PL/SQL terminado correctamente.

Transcurrido: 00:13:00.20

HEMOS MEJORADO CON LA ORIGINAL, SOLO CON INDICES: 23192 ACCESOS A BLOQUES

drop index MEMBER_INDEX_PROPOSALS;
drop index NICK_INDEX_COMMENTS;
drop index NICK_MEMBERSHIP_INDEX;
drop index DIRECTORTITLE_INDEX_COMMENTS;
drop index DIRECTOR_INDEX_movies;

CREATE INDEX MEMBER_INDEX_PROPOSALS ON PROPOSALS(MEMBER) TABLESPACE TAB_8K;
CREATE INDEX NICK_INDEX_COMMENTS ON COMMENTS(NICK) TABLESPACE TAB_2K;
create index nick_membership_index on membership(nick) tablespace tab_8k;
CREATE INDEX DirectorTitle_INDEX_COMMENTS ON COMMENTS(title, director) TABLESPACE TAB_16K;
CREATE INDEX director_index_movies ON movies(director) TABLESPACE TAB_8K;

Query 1:
SELECT title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='COMEDY'
   INTERSECT
   SELECT title,director
      FROM GENRES_MOVIES WHERE UPPER(genre)='DRAMA';

No optimizada con indices.

QUERY 2:
   SELECT nick FROM users WHERE (sysdate-reg_date)>182
   MINUS
   SELECT nick FROM membership
   MINUS
   SELECT nick FROM contracts JOIN profiles USING(citizenID);

Tab_8k: Lo mantenemos por la poca diferencia con el de16k
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        432  consistent gets
          0  physical reads
          0  redo size
      52602  bytes sent via SQL*Net to client
       2250  bytes received via SQL*Net from client
        162  SQL*Net roundtrips to/from client
          3  sorts (memory)
          0  sorts (disk)
       2408  rows processed

Tab_2k:
Estadisticas
----------------------------------------------------------
          2  recursive calls
          0  db block gets
        463  consistent gets
          0  physical reads
          0  redo size
      52602  bytes sent via SQL*Net to client
       2250  bytes received via SQL*Net from client
        162  SQL*Net roundtrips to/from client
          3  sorts (memory)
          0  sorts (disk)
       2408  rows processed
Tab_16k:


Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        425  consistent gets
          0  physical reads
          0  redo size
      52602  bytes sent via SQL*Net to client
       2250  bytes received via SQL*Net from client
        162  SQL*Net roundtrips to/from client
          3  sorts (memory)
          0  sorts (disk)
       2408  rows processed

QUERY 3:
SELECT * FROM (
     SELECT * FROM (
       SELECT director, avg(coms) meancomm
          FROM (SELECT title,director,count('c') coms
                  FROM comments
                  GROUP BY title,director)
          GROUP BY director
     ) ORDER BY meancomm DESC
   ) WHERE rownum=1;

Tab_8k:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
       1209  consistent gets
          0  physical reads
          0  redo size
        652  bytes sent via SQL*Net to client
        620  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed

Tab_2k:

Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
       3198  consistent gets
          0  physical reads
          0  redo size
        652  bytes sent via SQL*Net to client
        620  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed

Tab_16k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
        358  consistent gets
          0  physical reads
          0  redo size
        652  bytes sent via SQL*Net to client
        620  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
          1  rows processed

SELECT * FROM leader;

Tab_8k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21309  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        346  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

Tab_2k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21324  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        346  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

Tab_16k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21240  consistent gets
          0  physical reads
          0  redo size
        976  bytes sent via SQL*Net to client
        346  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
         10  rows processed

drop index MEMBER_INDEX_PROPOSALS;
CREATE INDEX MEMBER_INDEX_PROPOSALS ON PROPOSALS(MEMBER) TABLESPACE TAB_8K;

SELECT * FROM CP_aragna;

Tab_8k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21261  consistent gets
          0  physical reads
          0  redo size
       5911  bytes sent via SQL*Net to client
        492  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
        207  rows processed
Tab_2k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21326  consistent gets
          0  physical reads
          0  redo size
       5911  bytes sent via SQL*Net to client
        492  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
        207  rows processed

Tab_16k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
      21242  consistent gets
          0  physical reads
          0  redo size
       5911  bytes sent via SQL*Net to client
        492  bytes received via SQL*Net from client
         15  SQL*Net roundtrips to/from client
          1  sorts (memory)
          0  sorts (disk)
        207  rows processed

select * from movies where director='Zack Snyder';

Tab_2k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         12  consistent gets
          0  physical reads
          0  redo size
       3072  bytes sent via SQL*Net to client
        375  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
          7  rows processed

Tab_8k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         10  consistent gets
          0  physical reads
          0  redo size
       3072  bytes sent via SQL*Net to client
        375  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
          7  rows processed
Tab_16k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         10  consistent gets
          0  physical reads
          0  redo size
       3072  bytes sent via SQL*Net to client
        375  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
          7  rows processed

drop index NICK_INDEX_COMMENTS;
CREATE INDEX NICK_INDEX_COMMENTS ON COMMENTS(NICK) TABLESPACE TAB_2K;

select * from comments where nick='ruiz';
Tab_8k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         72  consistent gets
          0  physical reads
          0  redo size
      44045  bytes sent via SQL*Net to client
        410  bytes received via SQL*Net from client
          6  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
         71  rows processed

Tab_2k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         73  consistent gets
          0  physical reads
          0  redo size
      44045  bytes sent via SQL*Net to client
        410  bytes received via SQL*Net from client
          6  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
         71  rows processed

Tab_16k:
Estadisticas
----------------------------------------------------------
          0  recursive calls
          0  db block gets
         72  consistent gets
          0  physical reads
          0  redo size
      44045  bytes sent via SQL*Net to client
        410  bytes received via SQL*Net from client
          6  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
         71  rows processed

No modificado el pctused y pctfree.


delete from proposals where title LIKE 'workload_%';
delete from comments where title LIKE 'workload_%';




Con indice NICK_MEMBERSHIP_INDEX: Media 886
Estadisticas
----------------------------------------------------------
         31  recursive calls
       2314  db block gets
        886  consistent gets
         22  physical reads
    1834852  redo size
        494  bytes sent via SQL*Net to client
        910  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         31  recursive calls
       2299  db block gets
        884  consistent gets
         16  physical reads
    1816708  redo size
        494  bytes sent via SQL*Net to client
        910  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         28  recursive calls
       2313  db block gets
        885  consistent gets
         16  physical reads
    1834860  redo size
        494  bytes sent via SQL*Net to client
        910  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         31  recursive calls
       2297  db block gets
        889  consistent gets
         16  physical reads
    1816668  redo size
        494  bytes sent via SQL*Net to client
        910  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed

Sin indice NICK_MEMBERSHIP_INDEX: Media 890
Estadisticas
----------------------------------------------------------
         32  recursive calls
       2631  db block gets
        880  consistent gets
          4  physical reads
    1795152  redo size
        494  bytes sent via SQL*Net to client
        910  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         29  recursive calls
       2641  db block gets
        887  consistent gets
          2  physical reads
    1813492  redo size
        494  bytes sent via SQL*Net to client
        907  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         32  recursive calls
       2624  db block gets
        895  consistent gets
          4  physical reads
    1795128  redo size
        494  bytes sent via SQL*Net to client
        907  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed
Estadisticas
----------------------------------------------------------
         32  recursive calls
       2627  db block gets
        895  consistent gets
          3  physical reads
    1795204  redo size
        494  bytes sent via SQL*Net to client
        907  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       5296  rows processed

select director from movies where director='Common';

@C:\Temp\NEWcreation.sql

INSERT INTO movies(title,director) SELECT DISTINCT 'workload_'||nick,'Common' FROM membership;

drop index index end_clubs_index;
create index end_clubs_index on clubs(name,end_date) tablespace tab_8k;

INSERT INTO proposals(title, director, club, member, prop_date, slogan, message) SELECT 'workload_'||nick,'Common',club,nick,sysdate,DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(20,96))), DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(200,1496)))FROM (SELECT name club FROM clubs WHERE end_date is null)  JOIN membership USING(club);

Sin indice: Media 2108
Estadisticas
----------------------------------------------------------
         88  recursive calls
      40064  db block gets
       1597  consistent gets
         47  physical reads
   10088828  redo size
        494  bytes sent via SQL*Net to client
       1152  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed
Estadisticas
----------------------------------------------------------
         45  recursive calls
      40208  db block gets
       2618  consistent gets
         42  physical reads
   10087452  redo size
        494  bytes sent via SQL*Net to client
       1156  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed

Con indice: name y end_date Media 1549
Estadisticas
----------------------------------------------------------
         29  recursive calls
      40047  db block gets
       1527  consistent gets
         42  physical reads
   10034284  redo size
        494  bytes sent via SQL*Net to client
       1156  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed
Estadisticas
----------------------------------------------------------
         29  recursive calls
      40107  db block gets
       1551  consistent gets
         42  physical reads
   10099108  redo size
        494  bytes sent via SQL*Net to client
       1192  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed
Estadisticas
----------------------------------------------------------
         30  recursive calls
      40005  db block gets
       1550  consistent gets
         41  physical reads
   10033640  redo size
        494  bytes sent via SQL*Net to client
       1192  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed
Estadisticas
----------------------------------------------------------
         29  recursive calls
      40062  db block gets
       1567  consistent gets
         41  physical reads
   10091000  redo size
        494  bytes sent via SQL*Net to client
       1192  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed

Con indice: end_date   Media 1558
Estadisticas
----------------------------------------------------------
         31  recursive calls
      40023  db block gets
       1559  consistent gets
         41  physical reads
   10052088  redo size
        494  bytes sent via SQL*Net to client
       1156  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed
Estadisticas
----------------------------------------------------------
         31  recursive calls
      40033  db block gets
       1557  consistent gets
         41  physical reads
   10082776  redo size
        494  bytes sent via SQL*Net to client
       1156  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
       4802  rows processed


select director from movies where director='Common';

@C:\Temp\NEWcreation.sql
@C:\Temp\script_statistics_2020.sql
INSERT INTO movies(title,director) SELECT DISTINCT 'workload_'||nick,'Common' FROM membership;

drop index end_clubs_index;
drop index title_proposals_index;

create index title_proposals_index on proposals(title) tablespace tab_8k;
create index end_clubs_index on clubs(name,end_date) tablespace tab_8k;

INSERT INTO proposals(title, director, club, member, prop_date, slogan, message) SELECT 'workload_'||nick,'Common',club,nick,sysdate,DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(20,96))), DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(200,1496)))FROM (SELECT /*+ index(clubs end_clubs_index) */ name club FROM clubs WHERE end_date is null)  JOIN membership USING(club);

INSERT INTO comments(club, nick, msg_date, title, director, subject, message, valoration) SELECT club,nick,sysdate+sec/43200,title,'Common', DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(20,96))), DBMS_RANDOM.string('P',TRUNC(DBMS_RANDOM.value(200,1496))), TRUNC(DBMS_RANDOM.value(0,11)) FROM (SELECT title,club, rownum sec FROM proposals WHERE title LIKE 'workload_%') JOIN membership USING(club);

Sin indice: 79.752

Estadisticas
----------------------------------------------------------
       7787  recursive calls
     828141  db block gets
      87268  consistent gets
       1462  physical reads
  140588816  redo size
        494  bytes sent via SQL*Net to client
       1216  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        133  sorts (memory)
          0  sorts (disk)
      69584  rows processed

Estadisticas
----------------------------------------------------------
      11246  recursive calls
     834205  db block gets
     101260  consistent gets
       1540  physical reads
  141316660  redo size
        494  bytes sent via SQL*Net to client
       1216  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        184  sorts (memory)
          0  sorts (disk)
      69584  rows processed
Estadisticas
----------------------------------------------------------
        983  recursive calls
     825727  db block gets
      25696  consistent gets
       1378  physical reads
  140194896  redo size
        494  bytes sent via SQL*Net to client
       1216  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
         14  sorts (memory)
          0  sorts (disk)
      69584  rows processed
Estadisticas
----------------------------------------------------------
       5303  recursive calls
     826241  db block gets
      82542  consistent gets
       1432  physical reads
  140439008  redo size
        494  bytes sent via SQL*Net to client
       1216  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
         95  sorts (memory)
          0  sorts (disk)
      69584  rows processed
Estadisticas
----------------------------------------------------------
       9472  recursive calls
     827947  db block gets
     101992  consistent gets
       1464  physical reads
  140536160  redo size
        494  bytes sent via SQL*Net to client
       1216  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        159  sorts (memory)
          0  sorts (disk)
      69584  rows processed


Usando indice: 83.450

Estadisticas
----------------------------------------------------------
        133  recursive calls
     822637  db block gets
      19168  consistent gets
       1363  physical reads
  139894132  redo size
        494  bytes sent via SQL*Net to client
       1262  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
          0  sorts (memory)
          0  sorts (disk)
      69584  rows processed
Estadisticas
----------------------------------------------------------
       7325  recursive calls
     837263  db block gets
      85263  consistent gets
       1430  physical reads
  140598828  redo size
        494  bytes sent via SQL*Net to client
       1262  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        122  sorts (memory)
          0  sorts (disk)
      69584  rows processed

Estadisticas
----------------------------------------------------------
      11279  recursive calls
     840434  db block gets
     113408  consistent gets
       1471  physical reads
  140621196  redo size
        494  bytes sent via SQL*Net to client
       1262  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        186  sorts (memory)
          0  sorts (disk)
      69584  rows processed
Estadisticas
----------------------------------------------------------
      12034  recursive calls
     642397  db block gets
     115958  consistent gets
       1487  physical reads
  126327452  redo size
        494  bytes sent via SQL*Net to client
       1262  bytes received via SQL*Net from client
          2  SQL*Net roundtrips to/from client
        198  sorts (memory)
          0  sorts (disk)
      69584  rows processed

@C:\Temp\NEWcreation.sql
exec pkg_costes.run_test(10);

Runtest precambios de hoy:

RESULTS AT 02/05/20
TIME CONSUMPTION: 68606,8 milliseconds.
CONSISTENT GETS: 48501,6 blocks

RUNtest de todas las mejoras, incluido el indice end_clubs_index:

RESULTS AT 03/05/20
TIME CONSUMPTION: 69357,1 milliseconds.
CONSISTENT GETS: 59469,7 blocks

RUNtest de todas las mejoras, excepto el indice que no sabiasmos si mejoraba o no:

RESULTS AT 03/05/20
TIME CON52130S.30UMPTION: 68859,3 milliseconds.
CONSISTENT GETS: 63092,8 blocks

RESULTS AT 03/05/20
TIME CONSUMPTION: 68663,1 milliseconds.
CONSISTENT GETS: 78957 blocks

RESULTS AT 03/05/20
TIME CONSUMPTION: 68662,8 milliseconds.
CONSISTENT GETS: 133977,7 blocks

RESULTS AT 03/05/20
TIME CONSUMPTION: 68223,4 milliseconds.
CONSISTENT GETS: 59664,8 blocks

Runtest de todas las mejoras, excepto el indice y TODOS LOS INDICES A 8K EXCEPTO 1 A 2K: CREATE INDEX DirectorTitle_INDEX_COMMENTS ON COMMENTS(title, director) TABLESPACE TAB_8K;

RESULTS AT 03/05/20
TIME CONSUMPTION: 69681,1 milliseconds.
CONSISTENT GETS: 61033,1 blocks

Runtest de todas las mejoras, excepto el indice y TODOS LOS INDICES A 8K: 2 iguales consecutivas

RESULTS AT 03/05/20
TIME CONSUMPTION: 68972,5 milliseconds.
CONSISTENT GETS: 117680,4 blocks

RESULTS AT 03/05/20
TIME CONSUMPTION: 69146,5 milliseconds.
CONSISTENT GETS: 61816,5 blocks


Prueba de ejecucion de run_test con los indices que se han comprobado seguros:

RESULTS AT 05/05/20
TIME CONSUMPTION: 72177 milliseconds.
CONSISTENT GETS: 137774,3 blocks

Prueba de lo anterior cambiando TableSpaces de tablas:  genres TAB_2K; products TAB_2K; clubs TAB_2K; proposals TAB_16K; comments TAB_16K;

RESULTS AT 05/05/20
TIME CONSUMPTION: 79249 milliseconds.
CONSISTENT GETS: 198225,6 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 79639 milliseconds.
CONSISTENT GETS: 189212,2 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 82108,2 milliseconds.
CONSISTENT GETS: 189140,8 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 82250 milliseconds.
CONSISTENT GETS: 187912 blocks

Prueba de lo anterior cambiando TableSpaces de tablas, incluyendo end_clubs_index:  genres TAB_2K; products TAB_2K; clubs TAB_2K; proposals TAB_16K; comments TAB_16K;

RESULTS AT 05/05/20
TIME CONSUMPTION: 71570,2 milliseconds.
CONSISTENT GETS: 24522,9 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 78157,2 milliseconds.
CONSISTENT GETS: 193114,6 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 83012,5 milliseconds.
CONSISTENT GETS: 196313 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 79657,6 milliseconds.
CONSISTENT GETS: 192025,3 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 80377,8 milliseconds.
CONSISTENT GETS: 194329 blocks


Calculo de nuevo de la base sin ninguna modificacion:

RESULTS AT 05/05/20
TIME CONSUMPTION: 68265,7 milliseconds.
CONSISTENT GETS: 72122,7 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 67619 milliseconds.
CONSISTENT GETS: 71141,9 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 69304,5 milliseconds.
CONSISTENT GETS: 71133 blocks

Calculo de nuevo de los 5 indices con su correspondiente cambio de TABLESPACE y tamben el indice end_clubs_index:

RESULTS AT 05/05/20
TIME CONSUMPTION: 69363,8 milliseconds.
CONSISTENT GETS: 226950,2 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 69977,6 milliseconds.
CONSISTENT GETS: 227752,2 blocks

RESULTS AT 05/05/20
TIME CONSUMPTION: 69575,6 milliseconds.
CONSISTENT GETS: 222726,4 blocks


Ejecutando todos los indices, pero solo cambiando el tablespace de 2k:

RESULTS AT 12/05/20
TIME CONSUMPTION: 69252,8 milliseconds.
CONSISTENT GETS: 231494,5 blocks

RESULTS AT 12/05/20
TIME CONSUMPTION: 73008,3 milliseconds.
CONSISTENT GETS: 232552,2 blocks
