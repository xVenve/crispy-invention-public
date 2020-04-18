
#include "queue.h"
#include <fcntl.h>
#include <math.h>
#include <pthread.h>
#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define NUM_CONSUMERS 1

/**
 * Entry point
 * @param argc
 * @param argv
 * @return
 */

pthread_mutex_t ring;
pthread_mutex_t des;
pthread_cond_t lleno;
pthread_cond_t vacio;
struct queue *cola;
const char *fichero;
FILE *descriptorP;
int total = 0;

struct param {
  int id_ini;
  int op;
};

// Cada hilo tiene acceso a su propio dominio de id`s, donde el nº de operaciones que tendrá asociado será
// floor(num.lineas/num.productores), leerá e insertará de uno en uno
void *producir(void *arg) {
  // Sacar parametros
  struct param *p = arg;

  // Hallamos el desciptor que corresponde al primer indice, para que no se mezclen bloquemas y desbloqueamos
  pthread_mutex_lock(&des);

  descriptorP = fopen(fichero, "r");
  int counter = 0;
  char chr;
  while (counter < p->id_ini) {
    chr = fgetc(descriptorP);
    if (chr == '\n') {
      counter++;
    }
  }                            // fin while
  FILE *current = descriptorP; // Almacenamos la posicion por la que va, de esta manera la podemos recuperar.

  pthread_mutex_unlock(&des);

  int i, i1, i2 = 0;
  for (int j = p->op; j > 0; j--) {
    // Sacamos los valores a introducir en el buffer del puntero, y salvamos la nueva posicion del mismo.
    pthread_mutex_lock(&des);

    descriptorP = current;
    fscanf(descriptorP, "%d %d %d", &i, &i1, &i2);
    current = descriptorP;

    pthread_mutex_unlock(&des);

    struct element temporal = {i1, i2};

    pthread_mutex_lock(&ring);
    while (queue_full(cola))
      pthread_cond_wait(&lleno, &ring);

    queue_put(cola, &temporal);
    pthread_cond_signal(&vacio);
    pthread_mutex_unlock(&ring);
  }
  pthread_exit(0);
}

void *consumir(int *numValores) {
  struct element data;
  // Bucle de todo mientras no se hallar leido todas las ops esperadas.
  for (int k = 0; k < *numValores; k++) {

    pthread_mutex_lock(&ring);

    while (queue_empty(cola))
      pthread_cond_wait(&vacio, &ring);

    struct element *data = queue_get(cola);

    switch (data->type) {
    case 1:
      total += 1 * data->time;
      // printf("1 %d\n",data->time);
      break;
    case 2:
      total += 3 * data->time;
      /// printf("3 %d\n",data->time );

      break;
    case 3:
      total += 10 * data->time;
      // printf("10 %d\n",data->time );

      break;
    default:
      perror("Valor no valido");
    }
    pthread_cond_signal(&lleno);
    pthread_mutex_unlock(&ring);
  }
  pthread_exit(0);
}

int calculo_lineas(const char filename[]) {
  FILE *file = fopen(filename, "r");
  char chr;
  int lines = 0;
  while (!feof(file)) {
    chr = fgetc(file);
    if (chr == '\n') {
      lines++;
    }
  }
  fclose(file);
  return lines;
}

int main(int argc, const char *argv[]) {

  if (argc > 4) {
    perror("Numero de argumentos invalido");
    return -1;
  }

  FILE *descriptor = fopen(argv[1], "r");

  int numVal;
  fscanf(descriptor, "%d", &numVal);
  int numLin = calculo_lineas(argv[1]);
  if (numVal > (numLin - 1)) {
    perror("Error: Se esperaban mas operaciones.");
    return -1;
  }

  int productores = atoi(argv[2]);
  if (productores <= 0) {
    perror("Error: Numero invalido de productores.");
    return -1;
  }
  int size = atoi(argv[3]);
  if (size <= 0) {
    perror("Error: Tamaño invalido.");
    return -1;
  }

  cola = queue_init(size);
  pthread_mutex_init(&ring, NULL);
  pthread_mutex_init(&des, NULL);
  pthread_cond_init(&lleno, NULL);
  pthread_cond_init(&vacio, NULL);

  int operaciones = floor((numVal / productores));
  int id_inicio = 1;
  pthread_t hilosP[productores];
  pthread_t hiloC;
  pthread_create(&hiloC, NULL, (void *)consumir, &numVal);
  int i;
  fichero = malloc(sizeof(char[strlen(argv[1])]));
  fichero = argv[1];
  struct param args[productores];
  for (i = 0; i < (productores - 1); i++) {

    args[i].op = operaciones;
    args[i].id_ini = id_inicio;
    pthread_create(&hilosP[i], NULL, (void *)producir, &args[i]);
    id_inicio += operaciones;
  }
  int op_ultimo = numVal - (i * operaciones);
  args[productores - 1].op = op_ultimo;
  args[productores - 1].id_ini = id_inicio;
  pthread_create(&hilosP[productores - 1], NULL, (void *)producir, &args[productores - 1]);

  for (int i = 0; i < productores; i++) {
    pthread_join(hilosP[i], NULL);
  }
  pthread_join(hiloC, NULL);

  printf("Total: %i €.\n", total);
  queue_destroy(cola);
  pthread_mutex_destroy(&des);
  pthread_mutex_destroy(&ring);
  pthread_cond_destroy(&lleno);
  pthread_cond_destroy(&vacio);
  fclose(descriptorP);
  fclose(descriptor);
  return 0;
}
