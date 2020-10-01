#include <stdio.h>

int main(void) {

  /* Programa que crea un archivo llamado entradas.txt que en este ejemplo
  escribe matrices 3x3, escribe 3 y salta de linea 3 veces, de los primeros numeros*/

  FILE *escribir = NULL;
  escribir = fopen("entradas.txt", "w");

  if (escribir == NULL)
    return -1;

  int x = 0;
  while (x < 90) { // Escribe 10 matrices 3x3
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        fprintf(escribir, "%d\t\t", x);
        x++;
      }
      fprintf(escribir, "\n");
    }
    fprintf(escribir, "\n");
  }

  fclose(escribir);
  return 0;
}
