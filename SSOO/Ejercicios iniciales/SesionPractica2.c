#include <stdio.h>

int main() {
  // write(1,)
  int fd = creat("fichero.txt", 0644);
  pid = fork();
  if (pid == 0) {
    close(1);
    dup(fd);
    close(fd);
    exec("mycat");
  } else {
    close(fd);
  }
}

// Contar veces que aparece perro.

// cat fichero | grep perro | wc -w
// cat pasa el fichero a grep, que pone una vez cada ocurrencia y el wc cuenta
// las palabras

// | indica pipe
// & se ejecuta en background

// Crear pipe
int main() {
  int pi[2];
  pipe(pi);
  read(pi[0], );
  write(pi[1], );
}

// cat fichero| grep perro
int main() {
  int fd[2]; // lo creo antes para que lo tengan padre e hijos
  pipe(fd);
  pid = fork();
  if (pid == 0) { // Lo que hace el hijo
    close(1);
    close(fd[0]); // Queremos en el hijo solo el de escritura
    dup(fd[1]);
    close(fd[1]); // Ya appunta a la salida 1 el write, podemos cerrarlo
    exec("cat");
  } else { // El padre tiene que crear otro nuevo hijo que reciba, el grep
    pid = fork();
    if (pid == 0) {
      close(0);
      close(fd[1]); // No necesita el de escritura, solo lectura
      dup(fd[0]);
      close(fd[0]); // Ya tenemo el de lectura redirigido, podemo cerrarlo
      exec("grep");
    } else {
      wait(); // No se donde se coloca
    }
  }
  close(fd[0]);
  close(fd[1]);
}
