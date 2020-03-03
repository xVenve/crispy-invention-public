#include <stdio.h>

void leerint(int *a);
int sumar(int a, int b);
void dividir(int a, int b, int *coc, int *resto);

int main() {
  int x, y;
  printf("Introduce el primer numero: \n");
  leerint(&x);
  printf("Introduce el segundo numero: \n");
  leerint(&y);
  int s = sumar(x, y);
  printf("x: %d  y: %d \n La suma es: %d\n", x, y, s);
  int c, r;
  dividir(x, y, &c, &r);
  printf("Cociente: %d y Resto: %d\n", c, r);
  return 0;
}

void leerint(int *a) { scanf("%d", a); }

int sumar(int a, int b) { return a + b; }

void dividir(int a, int b, int *coc, int *resto) {
  *coc = a / b;
  *resto = a % b;
}
