#include <ctype.h>
#include <stdio.h>
#include <string.h>

void Upper(char a[]) {
  int i = 0;
  while (a[i]) {
    printf("%c", toupper(a[i]));
    i++;
  }
}

void Lower(char a[]) {
  int i = 0;
  while (a[i]) {
    printf("%c", tolower(a[i]));
    i++;
  }
}

void Palin(char *a) {
  int i = 0;
  while (a[i]) {
    i++;
  }
  while (i >= 0) {
    printf("%c", a[i]);
    i--;
  }
  printf("\n");
}

void Salta(char *a) {
  char *b;
  b = strtok(a, " ");
  if (b != NULL) {
    while (b != NULL) {
      printf("%s\n", b);
      b = strtok(NULL, " ");
    }
  }
  /*printf( "%s\n", b);
  while( (b = strtok( NULL, " " )) != NULL ){
  printf( "%s\n", b );
  }*/
}

int main() {
  char cad[100];
  printf("Introduce tu frase: ");
  fgets(cad, 100, stdin);
  Upper(cad);
  Lower(cad);
  Palin(cad);
  Salta(cad);
  return 0;
}
