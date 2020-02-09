#include <stdio.h>

int main()
{
	char nom[5]; //Para que quepa Juan pero no si es mas largo no cabe
	printf("Introduce nombre: ");
	scanf("%s", nom);
	printf("Hola %s. \n", nom);
	return 0;
}