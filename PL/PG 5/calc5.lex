/* Jorge Rodríguez Fraile Carlos Rubio Olivares Grupo 3*/
/* 100405951@alumnos.uc3m.es 100405834@alumnos.uc3m.es */
%{                            /* Primera Seccion */
#include "calc5.tab.h"        /* Cabecera con decl. de token etc. */
extern int n_linea;
%}
%%                            /* Segunda Seccion */
[ \t]                    { ; } /* ignorar espacios y tabuladores */
[0-9]+\.?|[0-9]*\.[0-9]+ { sscanf (yytext, "%lf", &yylval.valor); return NUMERO; }
[A-Z]                    { int caracter = 0; sscanf (yytext, "%c", &caracter); yylval.indice = caracter - 'A'; return VARIABLE; }
[a-z]                    { int caracter2 = 0; sscanf (yytext, "%c", &caracter2); yylval.indice = caracter2 + 32 - 'a'; return VARIABLE; }
\n                       { n_linea++; return ('\n'); }
.                        { return (yytext [0]); }   /* literales */
%%                            /* Tercera Seccion */
int yywrap ()     /* se incluye para evitar un error de compilacion */
{
    return (0) ; /* para el control de fin de fichero */
}
