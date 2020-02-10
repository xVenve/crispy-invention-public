#include <stdio.h>

void div(int *resultado, int a, int b)
{
	*resultado=a/b;
	printf("%d\n",*resultado);
}

int main(void)
{
	int x=450;
	int y=40;
	int r=0;
	div(&r,x,y);
	printf("%d\n",r);
	return 0;
}