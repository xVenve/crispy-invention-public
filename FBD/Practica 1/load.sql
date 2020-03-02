INSERT INTO USUARIOS(nombre_usuario, password, email)
	SELECT nickname, passw, eMail
	FROM old_users
	WHERE (LENGTH(passw)>8);

INSERT INTO PERFILES(dni, nombre_pila, apellido1, apellido2, f_nacimiento, telf, edad, usuario)
	SELECT citizenID, name, surname, sec_surname, TO_DATE(birthdate, 'YYYY-MM-DD') , phoneN, (SYSDATE-(TO_DATE(birthdate, 'YYYY-MM-DD')))/365.2422, nickname
	FROM old_users
	WHERE (citizenID IS NOT NULL AND LENGTH(passw)>8);

INSERT INTO TIPOS_CONTRATOS(tipo)
	SELECT DISTINCT contract_type
	FROM old_users
	WHERE (contractId IS NOT NULL);

INSERT INTO CONTRATOS(id, tipo_contrato, perfil, cod_postal,direccion, ciudad, pais, f_inicio, f_fin)
	SELECT contractId, contract_type, citizenID, TO_NUMBER(ZIPcode,'9999999'), address,town, country, TO_DATE(startdate, 'YYYY-MM-DD'), TO_DATE(enddate, 'YYYY-MM-DD')
	FROM old_users
	WHERE (contractId IS NOT NULL AND citizenID IS NOT NULL AND LENGTH(passw)>8 AND phoneN IS NOT NULL AND (TO_DATE(enddate, 'YYYY-MM-DD') > TO_DATE(startdate, 'YYYY-MM-DD')));

INSERT INTO RATIOS(tipo)
	SELECT DISTINCT aspect_ratio
	FROM old_movies
	WHERE (aspect_ratio IS NOT NULL);

INSERT INTO IDIOMAS(nombre)
	SELECT DISTINCT language
	FROM old_movies
	WHERE (language IS NOT NULL);

INSERT INTO CALIFICACIONES(tipo)
	SELECT DISTINCT content_rating
	FROM old_movies
	WHERE (content_rating IS NOT NULL);

INSERT INTO GENEROS(tipo)
	SELECT DISTINCT genre1
	FROM old_movies
	WHERE (genre1 IS NOT NULL)
	UNION
	SELECT DISTINCT genre2
	FROM old_movies
	WHERE (genre2 IS NOT NULL AND genre2 NOT IN (SELECT tipo FROM GENEROS))
	UNION
	SELECT DISTINCT genre3
	FROM old_movies
	WHERE (genre3 IS NOT NULL AND genre3 NOT IN (SELECT tipo FROM GENEROS))
	UNION
	SELECT DISTINCT genre4
	FROM old_movies
	WHERE (genre4 IS NOT NULL AND genre4 NOT IN (SELECT tipo FROM GENEROS))
	UNION
	SELECT DISTINCT genre5
	FROM old_movies
	WHERE (genre5 IS NOT NULL AND genre5 NOT IN (SELECT tipo FROM GENEROS));

INSERT INTO IMDBS(link, puntuacion, cantidad_users, cantidad_criticos)
	SELECT DISTINCT movie_imdb_link, TO_NUMBER(imdb_score,'99.9'), TO_NUMBER(num_user_for_reviews, '99999'), TO_NUMBER(num_critic_for_reviews, '99999')
	FROM old_movies
	WHERE (movie_imdb_link IS NOT NULL AND num_critic_for_reviews IS NOT NULL AND num_user_for_reviews IS NOT NULL);

INSERT INTO PELICULAS(titulo, director, duracion,color,ratio,estreno,calif_edad,pais,idioma, presupuesto,ingresos,imdb, n_rostros, l_dir,l_rep,l_peli )
	SELECT DISTINCT movie_title, director_name,TO_NUMBER(duration,'9999'),color,aspect_ratio,TO_NUMBER(title_year,'999999'),content_rating,country, language, TO_NUMBER(budget,'9999999999999'),TO_NUMBER(gross,'9999999999999'),movie_imdb_link,TO_NUMBER(facenumber_in_poster,'9999999999'),TO_NUMBER(director_facebook_likes,'9999999999999'),TO_NUMBER(cast_total_facebook_likes,'9999999999999'),TO_NUMBER(movie_facebook_likes,'9999999999999')
	FROM old_movies
	WHERE (movie_title IS NOT NULL AND director_name IS NOT NULL AND content_rating IS NOT NULL AND aspect_ratio IS NOT NULL AND budget IS NOT NULL AND gross IS NOT NULL AND facenumber_in_poster IS NOT NULL AND director_facebook_likes IS NOT NULL AND movie_facebook_likes IS NOT NULL AND language IS NOT NULL AND color IS NOT NULL AND movie_imdb_link IN (SELECT link FROM IMDBS));

INSERT INTO PALABRAS_PELICULA(pelicula_titulo, pelicula_director, palabra)
	SELECT DISTINCT movie_title, director_name, keyword1
 	FROM old_movies
 	WHERE (keyword1 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
 	SELECT DISTINCT movie_title, director_name, keyword2
 	FROM old_movies
 	WHERE (keyword2 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
 	SELECT DISTINCT movie_title, director_name, keyword3
 	FROM old_movies
 	WHERE (keyword3 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
 	SELECT DISTINCT movie_title, director_name, keyword4
 	FROM old_movies
 	WHERE (keyword4 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
 	SELECT DISTINCT movie_title, director_name, keyword5
 	FROM old_movies
 	WHERE (keyword5 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS));

INSERT INTO GENEROS_PELICULA(pelicula_titulo,pelicula_director,genero)
	SELECT DISTINCT movie_title, director_name, genre1
	FROM old_movies
	WHERE(genre1 IS NOT NULL  AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT DISTINCT movie_title, director_name, genre2
	FROM old_movies
	WHERE(genre2 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT  DISTINCT movie_title, director_name, genre3
	FROM old_movies
	WHERE(genre3 IS NOT NULL  AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT DISTINCT movie_title, director_name, genre4
	FROM old_movies
	WHERE(genre4 IS NOT NULL  AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT DISTINCT movie_title, director_name, genre5
	FROM old_movies
	WHERE(genre5 IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS));

INSERT INTO PROTAGONISTAS(pelicula_titulo, pelicula_director, nombre, likes)
	SELECT DISTINCT movie_title, director_name, actor_1_name, actor_1_facebook_likes
	FROM old_movies
	WHERE(actor_1_name IS NOT NULL AND actor_1_facebook_likes IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
  UNION
	SELECT DISTINCT movie_title, director_name, actor_3_name, actor_3_facebook_likes
	FROM old_movies
	WHERE(actor_3_name IS NOT NULL AND actor_3_facebook_likes IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT DISTINCT movie_title, director_name, actor_2_name, actor_2_facebook_likes
	FROM old_movies
	WHERE(actor_2_name IS NOT NULL AND actor_2_facebook_likes IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS))
	UNION
	SELECT  DISTINCT movie_title, director_name, actor_3_name, actor_3_facebook_likes
	FROM old_movies
	WHERE(actor_3_name IS NOT NULL AND actor_3_facebook_likes IS NOT NULL AND movie_title  IN (SELECT titulo FROM PELICULAS) AND director_name IN (SELECT director FROM PELICULAS) AND actor_3_name NOT IN (SELECT nombre FROM PROTAGONISTAS));

INSERT INTO CLUBES_HISTORICOS(nombre, abierto, slogan, f_creacion, f_cierre)
	SELECT DISTINCT b.club, 'Closed', b.subject, TO_DATE(b.ev_date,'YYYY-MM-DD'), TO_DATE(a.ev_date,'YYYY-MM-DD')
  FROM old_events a JOIN old_events b ON a.club=b.club
	WHERE (a.Etype = 'ceasing' AND b.Etype='foundation' AND a.club IS NOT NULL AND TO_DATE(b.ev_date,'YYYY-MM-DD') < TO_DATE(a.ev_date, 'YYYY-MM-DD'));

INSERT INTO MEMBRESIA_HISTORICAS(club,usuario)
	SELECT DISTINCT club, client
  FROM old_events
	WHERE (club IS NOT NULL AND client IS NOT NULL AND client IN (SELECT nombre_usuario FROM USUARIOS) AND club IN (SELECT nombre FROM CLUBES_HISTORICOS));

INSERT INTO CLUBES(nombre, abierto, slogan, f_creacion)
	SELECT DISTINCT club, details1, subject, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI')
	FROM old_events
	WHERE (Etype='foundation' AND club IS NOT NULL AND client IN (SELECT nombre_usuario FROM USUARIOS) AND club NOT IN (SELECT nombre FROM CLUBES_HISTORICOS));

INSERT INTO MEMBRESIA(club, usuario)
	SELECT DISTINCT club, client
	FROM old_events
	WHERE (club IS NOT NULL AND client IS NOT NULL AND client IN (SELECT nombre_usuario FROM USUARIOS) AND club IN (SELECT nombre FROM CLUBES));

INSERT INTO VISUALIZACIONES(usuario_club, usuario_nombre, anio, media_actividad)
  SELECT Distinct b.club, a.CLIENT,  EXTRACT(YEAR FROM SYSDATE), count('x')
  FROM old_EVENTS a JOIN membresia b ON (a.client=b.usuario)
  WHERE (Etype='viewing' AND EXTRACT(YEAR FROM TO_DATE(ev_date, 'YYYY-MM-DD')) = EXTRACT(YEAR FROM SYSDATE) AND a.client in (SELECT usuario FROM MEMBRESIA))
  GROUP BY a.CLIENT, b.club;

INSERT INTO VISUALIZACIONES_HISTORICAS(usuario_club, usuario_nombre, anio, media_actividad)
  SELECT Distinct b.club, a.CLIENT,  EXTRACT(YEAR FROM SYSDATE), count('x')
  FROM old_EVENTS a JOIN MEMBRESIA_HISTORICAS b ON (a.client=b.usuario)
  WHERE (Etype='viewing' AND EXTRACT(YEAR FROM TO_DATE(ev_date, 'YYYY-MM-DD')) = EXTRACT(YEAR FROM SYSDATE) AND a.client in (SELECT usuario FROM MEMBRESIA_HISTORICAS))
  GROUP BY a.CLIENT, b.club;

INSERT INTO PROPUESTAS(miembro_club, miembro_usuario, pelicula_titulo, pelicula_director, f_completa, asunto, mensaje)
	SELECT DISTINCT club, client, details1, details2, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI'), subject, message
	FROM old_events
	WHERE(Etype='proposal' AND club IS NOT NULL AND client IS NOT NULL AND details1 IN (SELECT titulo FROM PELICULAS) AND client IN (SELECT usuario FROM MEMBRESIA));

INSERT INTO PROPUESTAS_HISTORICAS(miembro_club, miembro_usuario, pelicula_titulo, pelicula_director, f_completa, asunto, mensaje)
	SELECT DISTINCT club, client, details1, details2, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI'), subject, message
	FROM old_events
	WHERE(Etype='proposal' AND club IS NOT NULL AND client IS NOT NULL AND details1 IN (SELECT titulo FROM PELICULAS) AND client IN (SELECT usuario FROM MEMBRESIA_HISTORICAS));

INSERT INTO OPINIONES(miembro_club, miembro_usuario, pelicula_titulo, pelicula_director, f_completa, asunto, valoracion)
	SELECT DISTINCT club, client, details1,details2, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI'), subject, TO_NUMBER(ltrim(Etype,'opinion:'),'99')
	FROM old_events
	WHERE ((SUBSTR(Etype,0,9)='opinion' OR ltrim(Etype,'opinion:') BETWEEN '0' AND '9') AND (details1, details2) IN (SELECT titulo, director FROM PELICULAS) AND client IN (SELECT usuario FROM MEMBRESIA));

INSERT INTO OPINIONES_HISTORICAS(miembro_club, miembro_usuario, pelicula_titulo, pelicula_director, f_completa, asunto, valoracion)
	SELECT DISTINCT club, client, details1,details2, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI'), subject, TO_NUMBER(ltrim(Etype,'opinion:'),'99')
	FROM old_events
	WHERE ((SUBSTR(Etype,0,9)='opinion' OR ltrim(Etype,'opinion:') BETWEEN '0' AND '9') AND (details1, details2) IN (SELECT titulo, director FROM PELICULAS) AND client IN (SELECT usuario FROM MEMBRESIA_HISTORICAS));

INSERT INTO INVITACIONES(miembro_usuario, miembro_club,invitado,f_completa)
 	SELECT DISTINCT client, club, subject, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI')
 	FROM old_events a JOIN clubes b ON (a.club = b.nombre)
 	WHERE (Etype = 'invitation' AND client IS NOT NULL AND club IS NOT NULL AND subject IS NOT NULL AND (client,club) IN (SELECT usuario,club FROM MEMBRESIA) AND club IN (SELECT nombre FROM CLUBES) AND subject IN (SELECT nombre_usuario FROM USUARIOS) AND (TO_DATE(a.ev_date, 'YYYY-MM-DD')> b.f_creacion));

INSERT INTO SOLICITUDES(usuario, club,frase_aceptacion, f_completa)
	SELECT DISTINCT a.client,a.club,a.subject, TO_DATE(a.ev_date||a.ev_hour,'YYYY-MM-DD HH24:MI')
	FROM old_events a JOIN clubes B ON (b.nombre = a.club)
	WHERE (Etype = 'application' AND b.abierto = 'Open' AND client IS NOT NULL AND club IS NOT NULL AND client IN (SELECT nombre_usuario FROM USUARIOS) AND (TO_DATE(a.ev_date, 'YYYY-MM-DD')> b.f_creacion));

INSERT INTO CREACIONES_CLUB(usuario, club, f_completa)
	SELECT DISTINCT client, club, TO_DATE(ev_date||ev_hour,'YYYY-MM-DD HH24:MI')
	FROM old_events
	WHERE (Etype='foundation' AND client IS NOT NULL AND club IS NOT NULL AND subject IS NOT NULL AND client IN (SELECT usuario FROM MEMBRESIA) AND club IN (SELECT nombre FROM CLUBES));
