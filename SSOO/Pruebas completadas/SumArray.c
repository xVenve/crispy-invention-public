#include <stdio.h>

int Sum5(int c);
int Sum10(int c);

int main(void) {
  int a[] = {1, 2, 3};
  int b[] = {3, 2, 1};
  int c[3];
  int j = 3;
  int i = 0;

  for (i = 0; i < j; i++) {
    c[i] = a[i] + b[i];
  }

  for (i = 0; i < j; i++) {
    printf(" %d ", c[i]);
  }
  printf("\n");

  return 0;
}

int Sum5(int c) { return c + 5; }

int Sum10(int c) { return c + 10; }