#include <cstring>
#include <dirent.h>
#include <iostream>
using namespace std;

void copy(char *, DIR *);
void gauss(char *, DIR *);
void sobel(char *, DIR *);

int main(int argc, char **argv) {

  // Controlar el numero de parametros
  if (argc < 4) {
    cout << "Wrong format:\n  image-seq operation in_path out_path\n   "
            "operation: copy, gauss, sobel\n";
    return -1;
  }

  // Comprobar que la operacion sea una de las admitidas
  if (strcmp(argv[1], "gauss") && strcmp(argv[1], "copy") &&
      strcmp(argv[1], "sobel")) {
    cout << "Unexpected operation:" << argv[1]
         << "\n  image-seq operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    return -1;
  }

  // Comprobar directorio de entrada existente
  DIR *input = opendir(argv[2]);
  if (input == NULL) {
    cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3]
         << "\nCannot open directory [" << argv[2] << "]"
         << "\n  image-seq operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    return -1;
  }

  // Comprobar directorio de salida existente
  DIR *output = opendir(argv[3]);
  if (output == NULL) {
    cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3]
         << "\nOutput directory [" << argv[2] << "] does not exist"
         << "\n  image-seq operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    return -1;
  }

  // Mirar error si esta vacio el de entrada, o archivo con otro formato

  if (strcmp(argv[1], "copy") == 0) {
    struct dirent *dir;
    while ((dir = readdir(input)) != NULL) {
      if (strcmp(dir->d_name, ".") != 0 && strcmp(dir->d_name, "..") != 0) {
        cout << dir->d_name << "\n";
        copy(dir->d_name, output);
      }
    }
  }

  if (strcmp(argv[1], "gauss") == 0) {
    struct dirent *dir;
    while ((dir = readdir(input)) != NULL) {
      if (strcmp(dir->d_name, ".") != 0 && strcmp(dir->d_name, "..") != 0) {
        cout << dir->d_name << "\n";
        gauss(dir->d_name, output);
      }
    }
  }

  if (strcmp(argv[1], "sobel") == 0) {
    struct dirent *dir;
    while ((dir = readdir(input)) != NULL) {
      if (strcmp(dir->d_name, ".") != 0 && strcmp(dir->d_name, "..") != 0) {
        cout << dir->d_name << "\n";
        // Funcion sobel
      }
    }
  }

  closedir(input);
  closedir(output);
  return 0;
}

void copy(char *photo, DIR *output) {
  cout << "Copio:" << photo << " en " << output << "\n";
}

void gauss(char *photo, DIR *output) {
  cout << "Gauss:" << photo << " en " << output << "\n";
}

void sobel(char *photo, DIR *output) {
  // Ver como hacer que haga primero gauss, doble funcion en una o que reciba
  // parametros
  cout << "Gauss y Sobel:" << photo << " en " << output << "\n";
}
