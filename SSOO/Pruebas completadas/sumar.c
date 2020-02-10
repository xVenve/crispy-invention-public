#include <stdio.h>

void suma(int resultado, int a, int b)
{
	resultado=a+b;
	printf("%d\n",resultado);
}

int main(void)
{
	int p=100;
	int s=350;
	int r;
	suma(r,p,s);
	printf("%d\n", r); //El valor de r no se actualiza, por lo que no contiene el resultado.
	return 0;
}