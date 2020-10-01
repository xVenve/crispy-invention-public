#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
  FILE *ori = NULL;
  ori = fopen(argv[1], "r");
  if (ori == NULL) {
    return -1;
  }

  FILE *final = NULL;
  final = fopen(argv[2], "w");
  if (final == NULL) {
    return -1;
  }

  char carac;
  while (fscanf(ori, "%c", &carac) != EOF) // Lee un caracter, pero cuando llega al final devuelve EOF fscanf
  {
    fprintf(final, "%c", carac);
  }

  fclose(ori);
  fclose(final);
  return 0;
}
