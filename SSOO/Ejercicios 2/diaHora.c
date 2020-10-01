#include <stdio.h>
#include <time.h>

int main() {
  time_t tiempoActual = time(NULL); // Obtener tiempo actual en formato time_t
  // char *tiempoTexto=ctime(&tiempoActual);	//Covertir time_t en string
  // printf("La fecha y hora actual es: %s\n", tiempoTexto);
  printf("La fecha y hora actual es: %s\n",
         asctime(localtime(&tiempoActual))); // asctime Convierte a string la estructura tm
  return 0;                                  // localtime convierte el formato time_t a la estructura tm
}
