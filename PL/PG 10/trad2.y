/* Jorge Rodríguez Fraile Carlos Rubio Olivares Grupo 3*/
/* 100405951@alumnos.uc3m.es 100405834@alumnos.uc3m.es */
%{                          // SECCION 1 Declaraciones de C-Yacc
#include <stdio.h>
#include <ctype.h>            // declaraciones para tolower
#include <string.h>           // declaraciones para cadenas
#include <stdlib.h>           // declaraciones para exit ()

#define FF fflush(stdout);    // para forzar la impresion inmediata
char temp [2048] ;
char *genera_cadena (char *nombre);

%}

%union {                      // El tipo de la pila tiene caracter dual
      int valor ;             // - valor numerico de un NUMERO
      char *cadena ;          // - para pasar los nombres de IDENTIFES
}

%token <valor> NUMERO         // Todos los token tienen un tipo para la pila
%token <cadena> IDENTIF       // Identificador=variable
%token <cadena> INTEGER       // identifica la definicion de un entero
%token <cadena> STRING
%token <cadena> MAIN          // identifica el comienzo del proc. main
%token <cadena> WHILE         // identifica el bucle main

%type   <cadena>  expresion termino operando impr decl def cuerpo

%right '='                    // es la ultima operacion que se debe realizar
%left '+' '-'                 // menor orden de precedencia
%left '*' '/'                 // orden de precedencia intermedio
%left SIGNO_UNARIO            // mayor orden de precedencia

%%
                                          // Seccion 3 Gramatica - Semantico
axioma:     decl                                  { ; }
            def                                   { ; }
            ;

decl:       INTEGER IDENTIF ';'                   { strcpy(temp, "");
                                                      strcat(temp, "( setq ");
                                                      strcat(temp, $2);
                                                      strcat(temp, " 0 ");
                                                      strcat(temp, ")");
                                                      printf("%s\n", genera_cadena(temp)); }
              decl				                        { ; }
            |   INTEGER IDENTIF '=' NUMERO ';'	    { strcpy(temp, "");
                                                      strcat(temp, "( setq ");
                                                      strcat(temp, $2);
                                                      strcat(temp, " ");
                                                      char num[4];
                                                      sprintf(num,"%d", $4);
                                                      strcat(temp, num);
                                                      strcat(temp, " )");
                                                      printf("%s\n", genera_cadena(temp)); }
              decl				                          { ; }
            |   IDENTIF '=' expresion ';'	          { strcpy(temp, "");
                                                      strcat(temp, "(");
                                                      strcat(temp, " setq ");
                                                      strcat(temp, $1);
                                                      strcat(temp, " ");
                                                      strcat(temp, $3);
                                                      strcat(temp, ")");
                                                      printf("%s\n", genera_cadena(temp)); }
                decl			                          { ; }
            | /* lambda */	                        { ; }
            ;

def:        mainfun                                 { ; }
            | /* lambda */	                        { ; }
            ;

mainfun:    MAIN '(' ')' '{'                       { strcpy(temp, "");
                                                     strcat(temp, "( defun ");
                                                     strcat(temp, $1);
                                                     strcat(temp, " ()");
                                                     printf("%s\n", genera_cadena(temp));}
            cuerpo                                  { ; }
            '}'                                     { strcpy(temp, "");
                                                      strcat(temp, ")");
                                                      printf("%s\n", genera_cadena(temp)); }
            ;

cuerpo:         expresion ';'                         { printf("\t");
                                                        printf("%s\n", $1); }
                cuerpo				                        { ; }
            |   '$' '(' impr ')' ';'	                { printf("\t");
                                                        printf("%s\n", genera_cadena(temp)); }
                cuerpo				                        { ; }
            |   setq                                  { ; }
            |   /* lambda */	                        { ; }

            ;

setq:        INTEGER IDENTIF ';'                      { printf("\t");
                                                        strcpy(temp, "");
                                                        strcat(temp, "( setq ");
                                                        strcat(temp, $2);
                                                        strcat(temp, " 0 ");
                                                        strcat(temp, ")");
                                                        printf("%s\n", genera_cadena(temp)); }
                cuerpo				                        { ; }
            |   INTEGER IDENTIF '=' NUMERO ';'	      { printf("\t");
                                                        strcpy(temp, "");
                                                        strcat(temp, "( setq ");
                                                        strcat(temp, $2);
                                                        strcat(temp, " ");
                                                        char num[4];
                                                        sprintf(num,"%d", $4);
                                                        strcat(temp, num);
                                                        strcat(temp, " )");
                                                        printf("%s\n", genera_cadena(temp)); }
                cuerpo				                        { ; }
            |   IDENTIF '=' expresion ';'	            { printf("\t");
                                                        strcpy(temp, "");
                                                        strcat(temp, "(");
                                                        strcat(temp, " setq ");
                                                        strcat(temp, $1);
                                                        strcat(temp, " ");
                                                        strcat(temp, $3);
                                                        strcat(temp, ")");
                                                        printf("%s\n", genera_cadena(temp)); }
            ;

impr:       expresion	               	{ strcpy(temp, "");
                                        strcat(temp, "( print ");
                                        strcat(temp, $1);
                                        strcat(temp, ")");
                                        $$ = genera_cadena(temp); }
            | expresion ',' impr      { strcpy(temp, "");
                                        strcat(temp, "( print ");
                                        strcat(temp, $1);
                                        strcat(temp, ")");
                                        strcat(temp, " ");
                                        strcat(temp, $3);
                                        $$ = genera_cadena(temp); }
            ;

expresion:      termino					              { $$ = $1; }
            |   expresion '+' expresion   		{ strcpy(temp, "");
                                                strcat(temp, "(");
                                                strcat(temp, " + ");
                                                strcat(temp, $1);
                                                strcat(temp, $3);
                                                strcat(temp, ")");
                                                $$ = genera_cadena(temp); }
            |   expresion '-' expresion   		{ strcpy(temp, "");
                                                strcat(temp, "(");
                                                strcat(temp, " - ");
                                                strcat(temp, $1);
                                                strcat(temp, $3);
                                                strcat(temp, ")");
                                                $$ = genera_cadena(temp); }
            |   expresion '*' expresion   		{ strcpy(temp, "");
                                                strcat(temp, "(");
                                                strcat(temp, " * ");
                                                strcat(temp, $1);
                                                strcat(temp, $3);
                                                strcat(temp, ")");
                                                $$ = genera_cadena(temp); }
            |   expresion '/' expresion   		{ strcpy(temp, "");
                                                strcat(temp, "(");
                                                strcat(temp, " / ");
                                                strcat(temp, $1);
                                                strcat(temp, $3);
                                                strcat(temp, ")");
                                                $$ = genera_cadena(temp); }
            ;

termino:        operando				                { $$ = $1; }
            |   '+' termino %prec SIGNO_UNARIO	{ strcpy(temp, "");
                                                  strcat(temp, "(");
                                                  strcat(temp, "+");
                                                  strcat(temp, $2);
                                                  strcat(temp, ")");
                                                  $$ = genera_cadena(temp); }
            |   '-' termino %prec SIGNO_UNARIO	{ strcpy(temp, "");
                                                  strcat(temp, "(");
                                                  strcat(temp, "-");
                                                  strcat(temp, $2);
                                                  strcat(temp, ")");
                                                  $$ = genera_cadena(temp); }
            ;

operando:       IDENTIF	       		  { sprintf(temp,"%s ", $1);
                                      $$ = genera_cadena(temp); }
            |   NUMERO              { sprintf(temp,"%d ", $1);
                                      $$ = genera_cadena(temp);}
            |   '(' expresion ')'		{ strcpy(temp, "");
                                      strcat(temp, "(");
                                      strcat(temp, $2);
                                      strcat(temp, ")");
                                      $$ = genera_cadena(temp); }
            ;

%%
                            // SECCION 4    Codigo en C
int n_linea = 1 ;

int yyerror (mensaje)
char *mensaje ;
{
    fprintf (stderr, "%s en la linea %d\n", mensaje, n_linea) ;
    printf ( "\n") ;	// bye
}

char *mi_malloc (int nbytes)       // reserva n bytes de memoria dinamica
{
    char *p ;
    static long int nb = 0;        // sirven para contabilizar la memoria
    static int nv = 0 ;            // solicitada en total

    p = malloc (nbytes) ;
    if (p == NULL) {
         fprintf (stderr, "No queda memoria para %d bytes mas\n", nbytes) ;
         fprintf (stderr, "Reservados %ld bytes en %d llamadas\n", nb, nv) ;
         exit (0) ;
    }
    nb += (long) nbytes ;
    nv++ ;

    return p ;
}


/***************************************************************************/
/********************** Seccion de Palabras Reservadas *********************/
/***************************************************************************/

typedef struct s_pal_reservadas { // para las palabras reservadas de C
    char *nombre ;
    int token ;
} t_reservada ;

t_reservada pal_reservadas [] = { // define las palabras reservadas y los
    "main",        MAIN,           // y los token asociados
    "int",         INTEGER,
    NULL,          0               // para marcar el fin de la tabla
} ;

t_reservada *busca_pal_reservada (char *nombre_simbolo)
{                                  // Busca n_s en la tabla de pal. res.
                                   // y devuelve puntero a registro (simbolo)
    int i ;
    t_reservada *sim ;

    i = 0 ;
    sim = pal_reservadas ;
    while (sim [i].nombre != NULL) {
           if (strcmp (sim [i].nombre, nombre_simbolo) == 0) {
                                         // strcmp(a, b) devuelve == 0 si a==b
                 return &(sim [i]) ;
             }
           i++ ;
    }

    return NULL ;
}


/***************************************************************************/
/******************* Seccion del Analizador Lexicografico ******************/
/***************************************************************************/

char *genera_cadena (char *nombre)     // copia el argumento a un
{                                      // string en memoria dinamica
      char *p ;
      int l ;

      l = strlen (nombre)+1 ;
      p = (char *) mi_malloc (l) ;
      strcpy (p, nombre) ;

      return p ;
}


int yylex ()
{
    int i ;
    unsigned char c ;
    unsigned char cc ;
    char ops_expandibles [] = "!<=>|%&+-/*" ;
    char cadena [256] ;
    t_reservada *simbolo ;

    do {
    	c = getchar () ;

		if (c == '#') {	// Ignora las lineas que empiezan por #  (#define, #include)
			do {		//	OJO que puede funcionar mal si una linea contiene #
			 c = getchar () ;
			} while (c != '\n') ;
		}

		if (c == '/') {	// Si la linea contiene un / puede ser inicio de comentario
			cc = getchar () ;
			if (cc != '/') {   // Si el siguiente char es /  es un comentario, pero...
				ungetc (cc, stdin) ;
		 } else {
		     c = getchar () ;	// ...
		     if (c == '@') {	// Si es la secuencia //@  ==> transcribimos la linea
		          do {		// Se trata de codigo inline (Codigo embebido en C)
		              c = getchar () ;
		              putchar (c) ;
		          } while (c != '\n') ;
		     } else {		// ==> comentario, ignorar la linea
		          while (c != '\n') {
		              c = getchar () ;
		          }
		     }
		 }
		}

		if (c == '\n')
		 n_linea++ ;

    } while (c == ' ' || c == '\n' || c == 10 || c == 13 || c == '\t') ;

    if (c == '\"') {
         i = 0 ;
         do {
             c = getchar () ;
             cadena [i++] = c ;
         } while (c != '\"' && i < 255) ;
         if (i == 256) {
              printf ("AVISO: string con mas de 255 caracteres en linea %d\n", n_linea) ;
         }		 	// habria que leer hasta el siguiente " , pero, y si falta?
         cadena [--i] = '\0' ;
         yylval.cadena = genera_cadena (cadena) ;
         return (STRING) ;
    }

    if (c == '.' || (c >= '0' && c <= '9')) {
         ungetc (c, stdin) ;
         scanf ("%d", &yylval.valor) ;
//         printf ("\nDEV: NUMERO %d\n", yylval.valor) ;        // PARA DEPURAR
         return NUMERO ;
    }

    if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
         i = 0 ;
         while (((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                 (c >= '0' && c <= '9') || c == '_') && i < 255) {
             cadena [i++] = tolower (c) ;
             c = getchar () ;
         }
         cadena [i] = '\0' ;
         ungetc (c, stdin) ;

         yylval.cadena = genera_cadena (cadena) ;
         simbolo = busca_pal_reservada (yylval.cadena) ;
         if (simbolo == NULL) {    // no es palabra reservada -> identificador
//               printf ("\nDEV: IDENTIF %s\n", yylval.cadena) ;    // PARA DEPURAR
               return (IDENTIF) ;
         } else {
//               printf ("\nDEV: OTRO %s\n", yylval.cadena) ;       // PARA DEPURAR
               return (simbolo->token) ;
         }
    }

    if (strchr (ops_expandibles, c) != NULL) { // busca c en ops_expandibles
         cc = getchar () ;
         sprintf (cadena, "%c%c", (char) c, (char) cc) ;
         simbolo = busca_pal_reservada (cadena) ;
         if (simbolo == NULL) {
              ungetc (cc, stdin) ;
              yylval.cadena = NULL ;
              return (c) ;
         } else {
              yylval.cadena = genera_cadena (cadena) ; // aunque no se use
              return (simbolo->token) ;
         }
    }

//    printf ("\nDEV: LITERAL %d #%c#\n", (int) c, c) ;      // PARA DEPURAR
    if (c == EOF || c == 255 || c == 26) {
//         printf ("tEOF ") ;                                // PARA DEPURAR
         return (0) ;
    }

    return c ;
}


int main ()
{
    yyparse () ;
}
