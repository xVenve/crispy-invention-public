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
%token <cadena> PUTS
%token <cadena> LEQ
%token <cadena> GEQ
%token <cadena> EQ
%token <cadena> NEQ
%token <cadena> AND
%token <cadena> OR
%token <cadena> IF
%token <cadena> ELSE
%token <cadena> PRINT
%token <cadena> MAIN          // identifica el comienzo del proc. main
%token <cadena> WHILE         // identifica el bucle while
%token <cadena> FOR
%token <cadena> RETURN


%type  <cadena> expresion expresioncond termino operando impr decl def cuerpo cond iter decliter vec callfun inipar resinipar par respar ressetq setq sent els mainfun fun resdecl progn

%right '='                    // es la ultima operacion que se debe realizar
%left OR
%left AND
%left EQ NEQ
%left '<' LEQ GEQ '>'
%left '+' '-'                 // menor orden de precedencia
%left '*' '/'                 // orden de precedencia intermedio
%left SIGNO_UNARIO            // mayor orden de precedencia

%%
                                          // Seccion 3 Gramatica - Semantico
axioma:       decl def 	      { sprintf(temp, "%s%s", $1, $2);
                                printf("%s", genera_cadena(temp)); }
            ;

decl:        INTEGER IDENTIF resdecl ';' decl                    { sprintf(temp, "(setq %s 0)\n%s%s", $2, $3, $5);
                                                                    $$ = genera_cadena(temp); }
            | INTEGER IDENTIF '=' NUMERO resdecl ';' decl 	      { sprintf(temp, "(setq %s %d)\n%s%s", $2, $4, $5, $7);
                                                                    $$ = genera_cadena(temp); }
            | INTEGER IDENTIF '[' NUMERO ']' ';' decl	            { sprintf(temp, "(setq %s (make-array %d))\n%s", $2, $4, $7);
                                                                    $$ = genera_cadena(temp); }
            /*| IDENTIF '=' NUMERO ';' decl	                    { sprintf(temp, "(setq %s %d)\n%s", $1, $3, $5);
                                                                    $$ = genera_cadena(temp); }
            | vec '=' NUMERO ';' decl	                            { sprintf(temp, "(setf %s %d)\n%s", $1, $3, $5);
                                                                    $$ = genera_cadena(temp); } */
            | /* lambda */	                                      { $$ = genera_cadena(""); }
            ;

resdecl:      ',' IDENTIF '=' NUMERO resdecl 	      { sprintf(temp, "(setq %s %d)\n%s", $2, $4, $5);
                                                      $$ = genera_cadena(temp); }
            | ',' IDENTIF resdecl                   { sprintf(temp, "(setq %s 0)\n%s", $2, $3);
                                                      $$ = genera_cadena(temp); }
            | /* lambda */	                        { $$ = genera_cadena(""); }
            ;

def:          mainfun             { $$ = genera_cadena($1); }
            | fun def	            { sprintf(temp, "%s%s", $1, $2);
                                    $$ = genera_cadena(temp); }
            | /* lambda */ 	      { $$ = genera_cadena(""); }
            ;

fun:          IDENTIF '(' inipar ')' '{' cuerpo '}' 	      { sprintf(temp, "(defun %s (%s)\n%s)\n", $1, $3, $6);
                                                              $$ = genera_cadena(temp); }
            ;


inipar:       INTEGER IDENTIF resinipar 	      { sprintf(temp, "%s%s", $2, $3);
                                                  $$ = genera_cadena(temp); }
            | /* lambda */                      { $$ = genera_cadena(""); }
            ;

resinipar:   ',' INTEGER IDENTIF resinipar 	      { sprintf(temp, " %s%s", $3, $4);
                                                    $$ = genera_cadena(temp); }
            | /* lambda */                        { $$ = genera_cadena(""); }
            ;


mainfun:      MAIN '(' ')' '{' 	cuerpo '}' 	      { sprintf(temp, "(defun %s ()\n%s)\n", $1, $5);
                                                      $$ = genera_cadena(temp); }
            ;

cuerpo:       sent cuerpo                                                         { sprintf(temp, "%s%s", $1, $2);
                                                                                    $$ = genera_cadena(temp); }
            | WHILE '(' cond ')' '{' cuerpo '}' cuerpo                            { sprintf(temp, "\t(loop %s %s do\n%s\t)\n%s", $1, $3, $6, $8);
                                                                                    $$ = genera_cadena(temp); }
            | IF '(' cond ')' '{' progn els cuerpo                                 { sprintf(temp, "\t(if %s\n\t%s%s%s", $3, $6, $7, $8);
                                                                                    $$ = genera_cadena(temp); }
            | FOR '(' decliter ';' cond ';' iter ')' '{' cuerpo	'}' cuerpo 	      { sprintf(temp, "%s\t(loop while %s do\n%s%s\t)\n%s", $3, $5, $10, $7, $12);
                                                                                    $$ = genera_cadena(temp); }
            | callfun ';' cuerpo                                                  { sprintf(temp, "\t%s\n%s", $1, $3);
                                                                                    $$ = genera_cadena(temp); }
            | RETURN expresioncond ';' 	                                          { sprintf(temp, "\t%s\n", $2);
                                                                                    $$ = genera_cadena(temp); }
            | /* lambda */ 	                                                      { $$ = genera_cadena(""); }
            ;

decliter:     INTEGER IDENTIF '=' expresion 	      { sprintf(temp, "\t(setq %s %s)\n", $2, $4);
                                                      $$ = genera_cadena(temp); }
            ;

iter:         IDENTIF '=' expresion 	      { sprintf(temp, "\t(setq %s %s)\n", $1, $3);
                                              $$ = genera_cadena(temp); }
            ;

progn:        cuerpo                 { sprintf(temp, "(progn\n%s\t)\n", $1);
                                       $$ = genera_cadena(temp); }
            ;

els:         '}' ELSE '{' progn '}' 	      { sprintf(temp, "\t%s\t)\n", $4);
                                              $$ = genera_cadena(temp); }
            | '}'                           { sprintf(temp, "\t)\n");
                                              $$ = genera_cadena(temp); }
            ;

sent:         PRINT '(' STRING ',' impr ')' ';' 	      { if(strcmp(temp, " ") != 0) sprintf(temp, "\t%s\n", genera_cadena(temp));
                                                          $$ = genera_cadena(temp); }
            | setq                                      { $$ = genera_cadena(temp); }
            | PUTS '(' STRING ')' ';' 	                { sprintf(temp, "\t(print \"%s\")\n", $3);
                                                          $$ = genera_cadena(temp); }
            ;

setq:         INTEGER IDENTIF ressetq ';'                       { sprintf(temp, "\t(setq %s 0)\n%s", $2, $3);
                                                                  $$ = genera_cadena(temp); }
            | INTEGER IDENTIF '=' expresion ressetq ';' 	      { sprintf(temp, "\t(setq %s %s)\n%s", $2, $4, $5);
                                                                  $$ = genera_cadena(temp); }
            | IDENTIF '=' expresioncond ';'	                    { sprintf(temp, "\t(setq %s %s)\n", $1, $3);
                                                                  $$ = genera_cadena(temp); }
            | INTEGER IDENTIF '[' expresion ']' ';' 	          { sprintf(temp, "\t(setq %s (make-array %s))\n", $2, $4);
                                                                  $$ = genera_cadena(temp); }
            | vec '=' expresion ';' 	                          { sprintf(temp, "\t(setf %s %s)\n", $1, $3);
                                                                  $$ = genera_cadena(temp); }
            ;

ressetq:      ',' IDENTIF '=' expresioncond ressetq 	      { sprintf(temp, "\t(setq %s %s)\n%s", $2, $4, $5);
                                                              $$ = genera_cadena(temp); }
            | ',' IDENTIF ressetq                           { sprintf(temp, "\t(setq %s 0)\n%s", $2, $3);
                                                              $$ = genera_cadena(temp); }
            | /* lambda */	                                { $$ = genera_cadena(""); }
            ;

impr:         expresioncond	                { sprintf(temp, "(print %s)", $1);
                                              $$ = genera_cadena(temp); }
            | STRING	                      { sprintf(temp, " ");
                                              $$ = genera_cadena(temp); }
            | expresioncond ',' impr 	      { sprintf(temp, "(print %s) %s", $1, $3);
                                              $$ = genera_cadena(temp); }
            | STRING ',' impr               { sprintf(temp, "%s", $3);
                                              $$ = genera_cadena(temp); }
            ;

callfun:    IDENTIF '(' par ')' 	      { sprintf(temp, "(%s%s)", $1, $3);
                                          $$ = genera_cadena(temp); }
            ;

par:          expresion respar 	      { sprintf(temp, " %s%s", $1, $2);
                                        $$ = genera_cadena(temp); }
            | /* lambda */	          { $$ = genera_cadena(""); }
            ;

respar:       ',' expresion respar 	      { sprintf(temp, " %s%s", $2, $3);
                                            $$ = genera_cadena(temp); }
            | /* lambda */	              { $$ = genera_cadena(""); }
            ;

expresion:    termino					                { $$ = $1; }
            | expresion '+' expresion 	      { sprintf(temp, "(+ %s %s)", $1, $3);
                                                $$ = genera_cadena(temp); }
            | expresion '-' expresion 	      { sprintf(temp, "(- %s %s)", $1, $3);
                                                $$ = genera_cadena(temp); }
            | expresion '*' expresion 	      { sprintf(temp, "(* %s %s)", $1, $3);
                                                $$ = genera_cadena(temp); }
            | expresion '/' expresion   	   	{ sprintf(temp, "(/ %s %s)", $1, $3);
                                                $$ = genera_cadena(temp); }
            ;

expresioncond:  expresion           { $$ = genera_cadena(temp); }
              | cond                { $$ = genera_cadena(temp); }
              | '(' cond ')' 	      { sprintf(temp, "(%s)", $2);
                                      $$ = genera_cadena(temp); }
              ;

cond:         expresioncond GEQ expresioncond 	     { sprintf(temp, "(>= %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond LEQ expresioncond 	      { sprintf(temp, "(<= %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond '>' expresioncond       	{ sprintf(temp, "(> %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond '<' expresioncond 	      { sprintf(temp, "(< %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond AND expresioncond        	{ sprintf(temp, "(and %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond OR expresioncond 	        { sprintf(temp, "(or %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond EQ expresioncond 	        { sprintf(temp, "(= %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            | expresioncond NEQ expresioncond 	      { sprintf(temp, "(/= %s %s)", $1, $3);
                                                        $$ = genera_cadena(temp); }
            ;

termino:      operando				                      { $$ = $1; }
            | '+' termino %prec SIGNO_UNARIO 	      { sprintf(temp, "(+ %s)", $2);
                                                      $$ = genera_cadena(temp); }
            | '-' termino %prec SIGNO_UNARIO       	{ sprintf(temp, "(- %s)", $2);
                                                      $$ = genera_cadena(temp); }
            | vec                                   { $$ = $1; }
            | callfun                               { $$ = $1; }
            ;



vec:          IDENTIF '[' expresion ']' 	      { sprintf(temp, "(aref %s %s)", $1, $3);
                                                  $$ = genera_cadena(temp); }
            ;

operando:     IDENTIF	       		        { sprintf(temp,"%s", $1);
                                          $$ = genera_cadena(temp); }
            | NUMERO                    { sprintf(temp,"%d", $1);
                                          $$ = genera_cadena(temp); }
            | '(' expresion ')' 	      { sprintf(temp, "(%s)", $2);
                                          $$ = genera_cadena(temp); }
            ;

%%
                            // SECCION 4    Codigo en C
int n_linea = 1 ;

int yyerror (mensaje)
char *mensaje ;
{
    fprintf (stderr, "%s en la linea %d\n", mensaje, n_linea) ;
    printf ("\n") ;	// bye
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
    "while",       WHILE,
    "puts",        PUTS,
    "if",          IF,
    "else",        ELSE,
    "printf",      PRINT,
    ">=",          GEQ,
    "<=",          LEQ,
    "&&",          AND,
    "||",          OR,
    "==",          EQ,
    "!=",          NEQ,
    "for",         FOR,
    "return",      RETURN,
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
