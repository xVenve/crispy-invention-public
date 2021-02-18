/* Jorge Rodríguez Fraile Carlos Rubio Olivares */
/* 100405951@alumnos.uc3m.es 100405834@alumnos.uc3m.es */
/*
PREGUNTA 1:
El error reside en que el axioma no es iterativo, por tanto, solo lee la primera sentencia que escribe, y las siguientes
no las reconoce.

PREGUNTA 2:
Para arreglar el error hemos añadido a las reglas de produccioón del axioma una nueva regla, la regla añadida es
recursiva haciendo que se puedan encadenar operaciones, la regla es recursiva a derechas(axioma::=expresion '\n' axioma).
El efecto que produce es que se puedan hacer varias operaciones mostrando el resultado después de cada una de ella.
*/
%{                              /* Seccion 1  Declaraciones de C y BISON */
#include <stdio.h>
#define YYSTYPE  double
%}
                                /* Seccion 2  Declaraciones de BISON   */
%%
                                /* Seccion 3  Sint - Semantico   */

axioma:     expresion  '\n'          { printf ("Expresion=%lf\n", $1); } axioma
           | expresion               { printf ("Expresion=%lf\n", $1); }
           ;

expresion:   operando                { $$ = $1; }
           | operando '+' expresion  { $$ = $1 + $3; }
           | operando '-' expresion  { $$ = $1 - $3; }
           | operando '*' expresion  { $$ = $1 * $3; }
           | operando '/' expresion  { $$ = $1 / $3; }
           ;

operando:    numero                  { $$ = $1; }
           ;

numero:      '0'                     { $$ = 0 ; }
           | '1'                     { $$ = 1 ; }
           | '2'                     { $$ = 2 ; }
           | '3'                     { $$ = 3 ; }
           | '4'                     { $$ = 4 ; }
           | '5'                     { $$ = 5 ; }
           | '6'                     { $$ = 6 ; }
           | '7'                     { $$ = 7 ; }
           | '8'                     { $$ = 8 ; }
           | '9'                     { $$ = 9 ; }
           ;

%%
                                        /* Seccion 4  Codigo en C   */
int yyerror (char *mensaje)
{
    fprintf (stderr, "%s\n", mensaje) ;
}

int yylex ()
{
    unsigned char c ;

    do {
         c = getchar () ;
    } while (c == ' ') ;

    return c ;
}

int main ()
{
    yyparse () ;
}
