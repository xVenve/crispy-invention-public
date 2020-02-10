#include <stdio.h>
int main  (void) {
	int i, v[10];

	for (i=0; i<10; i++) {
  		printf ("Dar valor: ");
  		scanf ("%d", &v[i]);
}
	for (i=0; i<10; i++) 
 		printf ("Valor de la posicion %d es: %d\n",i, v[i]);

}
