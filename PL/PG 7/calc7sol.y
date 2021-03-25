%{                      // SECCION 1 
#include <stdio.h>
%}
%union {                // El tipo de la pila (del AP) tiene caracter dual 
      int valor ;       //  - valor numerico entero 
      int indice ;      //  - indice para identificar una variable
}                       // SECCION 2 

%token  <valor>  NUMERO    // Todos los token tienen un tipo para la pila. 
%token  <indice> VARIABLE

%right  '='             //  es la ultima operacion que se debe realizar
%left   '+' '-'         //  menor orden de precedencia 
%left   '*' '/'         //  orden de precedencia intermedio 
%left   SIGNO_UNARIO    //  mayor orden de precedencia 
%%
                        // SECCION 3: Gramatica - Semantico


axioma:         expresion '\n'      		{ printf("\n"); }
                r_expr				{ ; }
            |   VARIABLE            		{ printf("%c=", $1 + 'a'); } 
                '=' expresion '\n'  		{ printf("\n"); }
                r_expr				{ ; }
            ;


r_expr:         /* lambda */			{ ; }
            |   axioma				{ ; }
            ;

expresion:      termino				{ ; }
            |   expresion '+' 			{ printf(" + "); }  
				expresion   	{ ; }       
            |   expresion '-' 			{ printf(" - "); }  
				expresion   	{ ; }   
            |   expresion '*' 			{ printf(" * "); }  
				expresion   	{ ; }
            |   expresion '/' 			{ printf(" / "); }  
				expresion   	{ ; }      
            ;

termino:        operando			{ ; }                          
            |   '+' 				{ printf (" +") ; } 
		   operando %prec SIGNO_UNARIO	{ ; }
            |   '-' 				{ printf (" -") ; } 
                   operando %prec SIGNO_UNARIO	{ ; }    
            ;

operando:       VARIABLE			{ printf(" %c ", $1 + 'a'); }
            |   NUMERO				{ printf(" %d ", $1); }
            |   '('				{ printf(" ( "); }
	                expresion ')'		{ printf(" ) "); } 
            ;

%%

                        /* SECCION 4  Codigo en C */
int n_linea = 1 ;

int yyerror (mensaje)
char *mensaje ;
{
    fprintf (stderr, "%s en la linea %d\n", mensaje, n_linea) ;
}



int yylex ()
{
    unsigned char c ;

    do {
         c = getchar () ;
    } while (c == ' ') ;

    if (c == '.' || (c >= '0' && c <= '9')) {
         ungetc (c, stdin) ;
         scanf ("%d", &yylval.valor) ;
         return NUMERO ;
    }

    if (c >= 'A' && c <= 'Z') {
         yylval.indice = c - 'A' ;  // resta a c el valor ascii de A
         return VARIABLE ;
    }

    if (c >= 'a' && c <= 'z') {
         yylval.indice = c - 'a' ;  // resta a c el valor ascii de a 
         return VARIABLE ;
    }

    if (c == '\n')
          n_linea++ ;
    return c ;
}

int main ()
{
    yyparse () ;
}
