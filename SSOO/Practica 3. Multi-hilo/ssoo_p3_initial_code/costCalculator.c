
#include "queue.h"
#include <fcntl.h>
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
int main(int argc, const char *argv[]) {

  // PRUEBA BUFFER
  printf("Inicio\n");
  struct queue *cola = queue_init(3);

  printf("He inicializado\n");
  struct element elem = {1, 2};

  queue_put(cola, &elem);

  printf("Vacia %d\n", queue_empty(cola));
  printf("Llena %d\n", queue_full(cola));

  struct element *elem2 = queue_get(cola);
  struct element elem3 = {10, 20};

  printf("Vacia %d\n", queue_empty(cola));

  printf("Type %d, time %d\n", elem2->type, elem2->time);
  printf("Type %d, time %d\n", elem3.type, elem3.time);
  queue_destroy(cola);
  //

  int total = 0;
  printf("Total: %i €.\n", total);

  return 0;
}
