#include <cstring>
#include <dirent.h>
#include <iostream>
using namespace std;

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

  // Mirar error si esta vacio el de entrada

  closedir(input);
  closedir(output);
  return 0;
}
