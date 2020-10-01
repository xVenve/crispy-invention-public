#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
  /*
  char *cadena=malloc(100);
  char texti[]= "Intento 1: ";
  strcat(cadena, texti);

  strcat(cadena, argv[1]);
  strcat(cadena, argv[2]);
  printf("%s", cadena);
  free(cadena);
  */
  int tamReser = 0;
  for (int i = 1; i < argc; i++) {
    tamReser += strlen(argv[i]);
    int tamWord = strlen(argv[i]);
    printf("%s  %d\n", argv[i], tamWord);
  }
  tamReser += 2 * (argc - 1); // Puede ser -2
  char *cadenaEnt = malloc(tamReser);
  char space[] = "  ";

  for (int i = 1; i < argc; i++) {
    strcat(cadenaEnt, argv[i]);
    if (i + 1 < argc)
      strcat(cadenaEnt, space);
  }

  printf("%s\n", cadenaEnt);
  int x = 0;
  while (cadenaEnt[x]) {
    x++;
  }
  x--;
  while (cadenaEnt[x]) {
    printf("%c", cadenaEnt[x]);
    x--;
  }

  free(cadenaEnt);
  return 0;
}
