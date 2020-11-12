#include <chrono>
#include <cstring>
#include <dirent.h>
#include <fstream>
#include <iostream>
using namespace std;
using namespace std::chrono;
using clk = chrono::high_resolution_clock;

/* void copy(char *, DIR *);
void gauss(char *, DIR *);
void sobel(char *, DIR *);
 */

int main(int argc, char **argv) {

  // Controlar el numero de parametros
  if (argc != 4) {
    cout << "Wrong format:\n " << argv[0]
         << " operation in_path out_path\n   "
            "operation: copy, gauss, sobel\n";
    return -1;
  }

  // Comprobar que la operacion sea una de las admitidas
  if (strcmp(argv[1], "gauss") && strcmp(argv[1], "copy") &&
      strcmp(argv[1], "sobel")) {
    cout << "Unexpected operation:" << argv[1] << "\n"
         << argv[0]
         << " operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    return -1;
  }

  // Comprobar directorio de entrada existente
  DIR *input = opendir(argv[2]);
  if (input == NULL) {
    cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3]
         << "\nCannot open directory [" << argv[2] << "]"
         << "\n"
         << argv[0]
         << " operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    closedir(input);
    return -1;
  }

  // Comprobar directorio de salida existente
  DIR *output = opendir(argv[3]);
  if (output == NULL) {
    cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3]
         << "\nOutput directory [" << argv[2] << "] does not exist"
         << "\n"
         << argv[0]
         << " operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
    closedir(output);
    return -1;
  }

  cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3] << "\n";

  // SIN HACER  o archivo con otro
  // formato

  struct dirent *dir;
  while ((dir = readdir(input)) != NULL) {
    if (strcmp(dir->d_name, ".") != 0 && strcmp(dir->d_name, "..") != 0) {

      char *input = (char *)malloc(strlen(argv[2]) + strlen("/") +
                                   strlen(dir->d_name) + 1);

      strcpy(input, argv[2]);
      strcat(input, "/");
      strcat(input, dir->d_name);

      char *output = (char *)malloc(strlen(argv[3]) + strlen("/") +
                                    strlen(dir->d_name) + 1);

      strcpy(output, argv[3]);
      strcat(output, "/");
      strcat(output, dir->d_name);

      /* Poner tiempos
        Load time: 7305
        Store time: 6152
      */

      auto loadtimei = clk ::now();
      FILE *photo = fopen(input, "rb");
      unsigned char info[54];

      // Cabecera
      fread(info, sizeof(unsigned char), 54, photo);

      // Ancho y alto
      int width = *(int *)&info[18];
      int height = *(int *)&info[22];
      cout << width << "\n";
      cout << height << "\n";

      // 24 bits = 3 bytes por pixel
      int size = 3 * width * height;
      unsigned char *data = new unsigned char[size];

      cout << "Planos: " << *(unsigned short *)&info[26] << "\n";
      cout << "Bit count: " << *(unsigned short *)&info[28] << "\n";
      cout << "Valor compresion: " << *(int *)&info[30] << "\n";

      // Error de .bmp que no tenga un plano
      if (*(unsigned short *)&info[26] != 1) {
        cout << "Planes is not 1\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        return -1;
      }

      // Error de .bmp que no sea 24 bis por punto
      if (*(unsigned short *)&info[28] != 24) {
        cout << "Bit count is not 24.\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        return -1;
      }

      // Error de .bmp que no sea 0 la compresion
      if (*(int *)&info[30] != 0) {
        cout << "Compression is not 0.\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        return -1;
      }

      fread(data, sizeof(unsigned char), size, photo);
      auto loadtimef = clk ::now();

      if (strcmp(argv[1], "copy") == 0) {
        auto storetimei = clk ::now();
        ofstream foutput;

        foutput.open(output);
        foutput.write(reinterpret_cast<const char *>(info), 54);
        foutput.write(reinterpret_cast<const char *>(data), size);
        foutput.close();
        auto storetimef = clk ::now();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + storediff;

        cout << "File: \"" << input << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
      }

      if (strcmp(argv[1], "gauss") == 0) {
        cout << "Gauss: " << input << " en " << output << "\n";
      }

      if (strcmp(argv[1], "sobel") == 0) {
        cout << "Gauss y Sobel: " << input << " en " << output << "\n";
      }
      fclose(photo);
    }
  }

  closedir(input);
  closedir(output);
  return 0;
}

/* void copy(char *photo, DIR *output) {
  cout << "Copio: " << photo << " en " << output << "\n";
}

void gauss(char *photo, DIR *output) {
  cout << "Gauss: " << photo << " en " << output << "\n";
}

void sobel(char *photo, DIR *output) {
  // Ver como hacer que haga primero gauss, doble funcion en una o que reciba
  // parametros
  cout << "Gauss y Sobel: " << photo << " en " << output << "\n";
} */
