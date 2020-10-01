
#include <stdio.h>

struct quebrado {
  int num;
  int den;
};

void Leer_numero(struct quebrado *q) {
  printf("Introduce el numerador\n");
  scanf("%d", &q->num);
  printf("Introduce el denominador\n");
  scanf("%d", &q->den);
}

struct quebrado suma(struct quebrado q, struct quebrado p) {
  struct quebrado r;
  q.num = q.num * p.den;
  p.num = p.num * q.den;
  r.num = q.num + p.num;
  r.den = q.den * p.den;
  return r;
}

void reducir(struct quebrado q) {
  int x;
  if (q.num < q.den) {
    x = q.num;
  } else {
    x = q.den;
  }

  while (x > 0 && q.num != 1 && q.den != 1) {
    if (q.num % x == 0 && q.den % x == 0) {
      q.num /= x;
      q.den /= x;
    }
    x--;
  }

  printf("Resultado reducido de la suma: %d\\%d\n", q.num, q.den);
}

int main() {
  FILE *archivo = NULL;
  archivo = fopen("resultados.txt", "w");
  if (archivo == NULL)
    return -1;

  struct quebrado x;
  struct quebrado y;
  struct quebrado resul;
  int op = 1;

bcl:;
  Leer_numero(&x);
  Leer_numero(&y);
  resul = suma(x, y);
  reducir(resul);
  fprintf(archivo, "%d/%d + %d/%d = %d/%d\n", x.num, x.den, y.num, y.den, resul.num, resul.den);
  printf("Desea introducir mas pares?(1/0)\n");

  scanf("%d", &op);
  if (op == 1)
    goto bcl;

  return 0;
}
