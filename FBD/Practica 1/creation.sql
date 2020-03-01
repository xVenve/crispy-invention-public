DROP TABLE CREACIONES_CLUB;
DROP TABLE SOLICITUDES;
DROP TABLE INVITACIONES;
DROP TABLE OPINIONES_HISTORICAS;
DROP TABLE OPINIONES;
DROP TABLE PROPUESTAS_HISTORICAS;
DROP TABLE VISUALIZACIONES_HISTORICAS;
DROP TABLE MEMBRESIA_HISTORICAS;
DROP TABLE CLUBES_HISTORICOS;
DROP TABLE PROPUESTAS;
DROP TABLE VISUALIZACIONES;
DROP TABLE MEMBRESIA;
DROP TABLE CLUBES;
DROP TABLE PROTAGONISTAS;
DROP TABLE GENEROS_PELICULA;
DROP TABLE PALABRAS_PELICULA;
DROP TABLE PELICULAS;
DROP TABLE IMDBS;
DROP TABLE GENEROS;
DROP TABLE CALIFICACIONES;
DROP TABLE IDIOMAS;
DROP TABLE RATIOS;
DROP TABLE CONTRATOS;
DROP TABLE TIPOS_CONTRATOS;
DROP TABLE PERFILES;
DROP TABLE USUARIOS;

CREATE TABLE USUARIOS(
	nombre_usuario VARCHAR2(100) NOT NULL,
	password VARCHAR2(100) NOT NULL,
	email VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_USUARIOS PRIMARY KEY(nombre_usuario),
	CONSTRAINT FK_USUARIOS_email UNIQUE(email),
	CONSTRAINT PASSWORD_VALID CHECK (LENGTH(password) >8)
	);

CREATE TABLE PERFILES(
	dni VARCHAR2(9) NOT NULL,
	nombre_pila VARCHAR2(100),
	apellido1 VARCHAR2(100),
	apellido2 VARCHAR(100),
	f_nacimiento DATE,
	telf VARCHAR2(14),
	edad NUMBER(3),
	usuario VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_PERFILES PRIMARY KEY(dni),
	CONSTRAINT FK_PERFILES_usuario UNIQUE(usuario),
	CONSTRAINT FK_PERFILES_perfil_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(nombre_usuario)
	ON DELETE CASCADE
);

CREATE TABLE TIPOS_CONTRATOS(
	tipo VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_TIPOSCONTRATOS PRIMARY KEY(tipo)
);

CREATE TABLE CONTRATOS(
	id VARCHAR2(100) NOT NULL,
	tipo_contrato VARCHAR2(100) NOT NULL,
	perfil VARCHAR2(9) NOT NULL,
	cod_postal VARCHAR2(10) NOT NULL,
	direccion VARCHAR2(100) NOT NULL,
	ciudad VARCHAR2(100) NOT NULL,
	pais VARCHAR2(100) NOT NULL,
	f_inicio DATE NOT NULL,
	f_fin DATE,
	CONSTRAINT PK_CONTRATOS_id PRIMARY KEY(id),
	CONSTRAINT FK_CONTRATOS_contrato_perfil FOREIGN KEY(perfil) REFERENCES PERFILES(DNI),
	CONSTRAINT FK_CONTRATOS_contrato_tipo FOREIGN KEY(tipo_contrato) REFERENCES TIPOS_CONTRATOS(tipo)
);

CREATE TABLE RATIOS(
	tipo VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_RATIOS PRIMARY KEY(tipo)
);

CREATE TABLE IDIOMAS(
	nombre VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_IDIOMAS PRIMARY KEY(nombre)
);

CREATE TABLE CALIFICACIONES(
	tipo VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_CALIFICACIONES PRIMARY KEY(tipo)
);

CREATE TABLE GENEROS(
	tipo VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_GENEROS PRIMARY KEY(tipo)
);

CREATE TABLE IMDBS(
	link VARCHAR2(200) NOT NULL,
	puntuacion NUMBER(2,1) NOT NULL,
	cantidad_users NUMBER(4) NOT NULL,
	cantidad_criticos NUMBER(4) NOT NULL,
	CONSTRAINT PK_IMDBS_link PRIMARY KEY(link)
);

CREATE TABLE PELICULAS(
	titulo VARCHAR2(100) NOT NULL,
	director VARCHAR2(100) NOT NULL,
	duracion NUMBER(4) NOT NULL,
	color VARCHAR2(100) NOT NULL,
	ratio VARCHAR2(100) NOT NULL,
	estreno NUMBER(6) NOT NULL,
	calif_edad VARCHAR2(100) NOT NULL,
	pais VARCHAR2(100) NOT NULL,
	idioma VARCHAR2(100) NOT NULL,
	presupuesto NUMBER(13) NOT NULL,
	ingresos NUMBER(13) NOT NULL,
	imdb VARCHAR2(100) NOT NULL,
	n_rostros NUMBER(10) NOT NULL,
	l_dir NUMBER(10) NOT NULL,
	l_rep NUMBER(10) NOT NULL,
	l_peli NUMBER(10) NOT NULL,
	CONSTRAINT PK_PELICULAS PRIMARY KEY(titulo, director),
	CONSTRAINT CHECK_PELICULAS_COLOR CHECK (color IN ('Color','Black and White')),
	CONSTRAINT FK_PELICULAS_RATIO FOREIGN KEY(ratio) REFERENCES RATIOS(tipo),
	CONSTRAINT FK_PELICULAS_CALIFICACION FOREIGN KEY(calif_edad) REFERENCES CALIFICACIONES(TIPO),
	CONSTRAINT FK_PELICULAS_IDIOMA FOREIGN KEY(idioma) REFERENCES IDIOMAS(NOMBRE),
	CONSTRAINT FK_PELICULAS_IMDB FOREIGN KEY(imdb) REFERENCES IMDBS(link)
);

CREATE TABLE PALABRAS_PELICULA(
	pelicula_titulo VARCHAR2(100) NOT NULL,
	pelicula_director VARCHAR2(100) NOT NULL,
	palabra VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_PALABRASPELICULA PRIMARY KEY(pelicula_titulo, pelicula_director, palabra),
	CONSTRAINT FK_PALABRASPELICULA_pelicula FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
	 ON DELETE CASCADE
);

CREATE TABLE GENEROS_PELICULA(
	pelicula_titulo VARCHAR2(100) NOT NULL,
	pelicula_director VARCHAR(100) NOT NULL,
	genero VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_GENEROSPELICULA PRIMARY KEY(pelicula_titulo, pelicula_director, genero),
	CONSTRAINT FK_GENEROSPELICULA_pelicula FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
	 ON DELETE CASCADE,
	CONSTRAINT FK_GENEROSPELICULA_genero FOREIGN KEY(genero) REFERENCES GENEROS(tipo)
);

CREATE TABLE PROTAGONISTAS(
	pelicula_titulo VARCHAR2(100) NOT NULL,
	pelicula_director VARCHAR2(100) NOT NULL,
	nombre VARCHAR2(100) NOT NULL,
	likes NUMBER(25) NOT NULL,
	CONSTRAINT PK_PROTAGONISTAS PRIMARY KEY(pelicula_titulo, pelicula_director, nombre),
	CONSTRAINT FK_PROTAGONISTAS_pelicula FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
);

CREATE TABLE CLUBES(
	nombre VARCHAR2(100) NOT NULL,
	abierto VARCHAR2(100) NOT NULL,
	slogan VARCHAR2(100),
	f_creacion DATE NOT NULL,
	CONSTRAINT PK_CLUBES PRIMARY KEY(nombre)
);

CREATE TABLE MEMBRESIA(
	club VARCHAR2(100) NOT NULL,
	usuario VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_MEMBRESIA PRIMARY KEY(club, usuario),
	CONSTRAINT FK_MEMBRESIA_club FOREIGN KEY(club) REFERENCES CLUBES(nombre),
	CONSTRAINT FK_MEMBRESIA_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(nombre_usuario)
);


CREATE TABLE VISUALIZACIONES(
	usuario_club VARCHAR2(100) NOT NULL,
	usuario_nombre VARCHAR2(100) NOT NULL,
	anio VARCHAR2(100) NOT NULL,
	media_actividad NUMBER(4,2) NOT NULL,
	CONSTRAINT PK_VISUALIZACIONES PRIMARY KEY(usuario_club, usuario_nombre, anio),
	CONSTRAINT FK_VISUALIZACIONES FOREIGN KEY(usuario_club, usuario_nombre) REFERENCES MEMBRESIA(club, usuario)
);

CREATE TABLE PROPUESTAS(
	miembro_club VARCHAR(100) NOT NULL,
	miembro_usuario VARCHAR(100) NOT NULL,
	pelicula_titulo VARCHAR(100) NOT NULL,
	pelicula_director VARCHAR(100) NOT NULL,
	f_completa DATE NOT NULL,
	asunto VARCHAR(100) NOT NULL,
	mensaje VARCHAR (1500) NOT NULL,
	CONSTRAINT PK_PROPUESTAS PRIMARY KEY(miembro_club, miembro_usuario, f_completa),
	CONSTRAINT FK_PROPUESTAS_miembro FOREIGN KEY(miembro_club, miembro_usuario) REFERENCES MEMBRESIA(club, usuario)
	 ON DELETE CASCADE,
	CONSTRAINT FK_PROPUESTAS_peliculas FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
);

CREATE TABLE CLUBES_HISTORICOS(
	nombre VARCHAR2(100) NOT NULL,
	abierto VARCHAR2(100) NOT NULL,
	slogan VARCHAR2(100),
	f_creacion DATE NOT NULL,
	f_cierre DATE NOT NULL,
	CONSTRAINT PK_CLUBES_HISTORICOS PRIMARY KEY(nombre)
);

CREATE TABLE MEMBRESIA_HISTORICAS(
	club VARCHAR2(100) NOT NULL,
	usuario VARCHAR2(100),
	CONSTRAINT PK_MEMBRESIA_HISTORICAS PRIMARY KEY(club, usuario),
	CONSTRAINT FK_MEMBRESIA_HISTORICAS_club FOREIGN KEY(club) REFERENCES CLUBES_HISTORICOS(nombre)
	 ON DELETE CASCADE,
	CONSTRAINT FK_MEMBRESIA_HISTORICAS_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(nombre_usuario)
	 ON DELETE CASCADE
);

CREATE TABLE VISUALIZACIONES_HISTORICAS(
	usuario_club VARCHAR2(100) NOT NULL,
	usuario_nombre VARCHAR2(100) NOT NULL,
	anio VARCHAR2(100) NOT NULL,
	media_actividad NUMBER(4,2) NOT NULL,
	CONSTRAINT PK_VISUALIZACIONES_HISTORICAS PRIMARY KEY(usuario_club, usuario_nombre, anio),
	CONSTRAINT FK_VISUALIZACIONES_HISTORICAS FOREIGN KEY(usuario_club, usuario_nombre) REFERENCES MEMBRESIA_HISTORICAS(club, usuario)
);

CREATE TABLE PROPUESTAS_HISTORICAS(
	miembro_club VARCHAR(100) NOT NULL,
	miembro_usuario VARCHAR(100) NOT NULL,
	pelicula_titulo VARCHAR(100) NOT NULL,
	pelicula_director VARCHAR(100) NOT NULL,
	f_completa DATE NOT NULL,
	asunto VARCHAR(100) NOT NULL,
	mensaje VARCHAR (1500) NOT NULL,
	CONSTRAINT PK_PROPUESTAS_HISTORICAS PRIMARY KEY(miembro_club, miembro_usuario, f_completa),
	CONSTRAINT FK_PROPUESTAS_HISTORICAS_miembro FOREIGN KEY(miembro_club, miembro_usuario) REFERENCES MEMBRESIA_HISTORICAS(club, usuario)
	 ON DELETE CASCADE,
	CONSTRAINT FK_PROPUESTAS_HISTORICAS_peliculas FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
);

CREATE TABLE OPINIONES(
	miembro_club VARCHAR2(100) NOT NULL,
	miembro_usuario VARCHAR2(100) NOT NULL,
	pelicula_titulo VARCHAR2(100) NOT NULL,
	pelicula_director VARCHAR2(100) NOT NULL,
	f_completa DATE NOT NULL,
	asunto VARCHAR2(1500) NOT NULL,
	valoracion NUMBER(3),
	CONSTRAINT PK_OPINIONES PRIMARY KEY(miembro_club, miembro_usuario,pelicula_titulo,pelicula_director,f_completa),
	CONSTRAINT FK_OPINIONES_pelicula FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
	ON DELETE CASCADE,
	CONSTRAINT FK_OPINIONES_miembro FOREIGN KEY(miembro_usuario, miembro_club) REFERENCES MEMBRESIA(usuario, club)
	ON DELETE CASCADE
);

CREATE TABLE OPINIONES_HISTORICAS(
	miembro_club VARCHAR2(100) NOT NULL,
	miembro_usuario VARCHAR2(100) NOT NULL,
	pelicula_titulo VARCHAR2(100) NOT NULL,
	pelicula_director VARCHAR2(100) NOT NULL,
	f_completa DATE NOT NULL,
	asunto VARCHAR2(1500) NOT NULL,
	valoracion NUMBER(3),
	CONSTRAINT PK_OPINIONES_HISTORICAS PRIMARY KEY(miembro_club, miembro_usuario,pelicula_titulo,pelicula_director,f_completa),
	CONSTRAINT FK_OPINIONES_HISTORICAS_pelicula FOREIGN KEY(pelicula_titulo, pelicula_director) REFERENCES PELICULAS(titulo, director)
	ON DELETE CASCADE,
	CONSTRAINT FK_OPINIONES_HISTORICAS_miembro FOREIGN KEY(miembro_usuario, miembro_club) REFERENCES MEMBRESIA_HISTORICAS(usuario, club)
	ON DELETE CASCADE
);

CREATE TABLE INVITACIONES(
	miembro_usuario VARCHAR2(100) NOT NULL,
	miembro_club VARCHAR2(100) NOT NULL,
	invitado VARCHAR(100) NOT NULL,
	f_completa DATE NOT NULL,
	CONSTRAINT PK_INVITACIONES PRIMARY KEY (miembro_club, miembro_usuario, invitado),
	CONSTRAINT FK_INVITACIONES_miembro FOREIGN KEY(miembro_usuario, miembro_club) REFERENCES MEMBRESIA(usuario, club)
	ON DELETE CASCADE,
	CONSTRAINT FK_INVITACIONES_invitado FOREIGN KEY(invitado) REFERENCES USUARIOS(nombre_usuario)
	ON DELETE CASCADE
);

CREATE TABLE SOLICITUDES(
	usuario VARCHAR2(100) NOT NULL,
	club varchar2(100) NOT NULL,
	f_completa DATE NOT NULL,
	frase_aceptacion VARCHAR2(100) NOT NULL,
	CONSTRAINT PK_SOLICITUDES PRIMARY KEY(usuario, club),
	CONSTRAINT FK_SOLICITUDES_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(nombre_usuario)
	 ON DELETE CASCADE,
	CONSTRAINT FK_SOLICITUDES_club FOREIGN KEY(club) REFERENCES CLUBES(nombre)
	 ON DELETE CASCADE
 );

CREATE TABLE CREACIONES_CLUB(
	usuario VARCHAR2(100) NOT NULL,
	club VARCHAR2(100) NOT NULL,
	f_completa DATE NOT NULL,
	CONSTRAINT PK_CREACIONESCLUB PRIMARY KEY(usuario, club),
	CONSTRAINT FK_CREACIONESCLUB_usuario FOREIGN KEY(usuario) REFERENCES USUARIOS(nombre_usuario)
	ON DELETE CASCADE,
	CONSTRAINT FK_CREACIONESCLUB_club FOREIGN KEY(club) REFERENCES CLUBES(nombre)
	ON DELETE CASCADE
);
