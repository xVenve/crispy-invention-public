#include <chrono>
#include <cmath>
#include <cstring>
#include <dirent.h>
#include <fstream>
#include <iostream>
using namespace std;
using namespace std::chrono;
using clk = chrono::high_resolution_clock;

/* void copy(char *, DIR *);
void sobel(char *, DIR *);

void gauss(int , int ,unsigned char *,unsigned char *,int, char*);
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

  struct dirent *dir;
  while ((dir = readdir(input)) != NULL) {
    if (strcmp(dir->d_name, ".") != 0 && strcmp(dir->d_name, "..") != 0) {

      char *nameinput = (char *)malloc(strlen(argv[2]) + strlen("/") +
                                       strlen(dir->d_name) + 1);

      strcpy(nameinput, argv[2]);
      strcat(nameinput, "/");
      strcat(nameinput, dir->d_name);

      char *nameoutput = (char *)malloc(strlen(argv[3]) + strlen("/") +
                                        strlen(dir->d_name) + 1);

      strcpy(nameoutput, argv[3]);
      strcat(nameoutput, "/");
      strcat(nameoutput, dir->d_name);

      auto loadtimei = clk ::now();
      FILE *photo = fopen(nameinput, "rb");
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

      // Error de .bmp que no sea 24 bits por punto
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
      // FUNCION COPY
      if (strcmp(argv[1], "copy") == 0) {
        auto storetimei = clk ::now();
        ofstream foutput;

        foutput.open(nameoutput);
        foutput.write(reinterpret_cast<const char *>(info), 54);
        foutput.write(reinterpret_cast<const char *>(data), size);
        foutput.close();
        auto storetimef = clk ::now();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + storediff;

        cout << "File: \"" << nameinput << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
      }

      // FUNCION GAUSS
      if (strcmp(argv[1], "gauss") == 0) {

        int m[5][5] = {{1, 4, 7, 4, 1},
                       {4, 16, 26, 16, 4},
                       {7, 26, 41, 26, 7},
                       {4, 16, 26, 16, 4},
                       {1, 4, 7, 4, 1}};

        unsigned char *res = new unsigned char[size];

        auto gausstimei = clk ::now();
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int red = 0;
            int green = 0;
            int blue = 0;
            for (int s = -2; s < 3; s++) {
              for (int t = -2; t < 3; t++) {
                // Condición para marcado de bordes
                if ((i + s) <= height && (j + t) <= width && (i + s) >= 0 &&
                    (j + t) >= 0) {
                  red +=
                      m[s + 2][t + 2] * data[3 * ((i + s) * width + (j + t))];
                  green += m[s + 2][t + 2] *
                           data[3 * ((i + s) * width + (j + t)) + 1];
                  blue += m[s + 2][t + 2] *
                          data[3 * ((i + s) * width + (j + t)) + 2];
                }
              }
            }
            res[3 * (i * width + j)] = red / 273;
            res[3 * (i * width + j) + 1] = green / 273;
            res[3 * (i * width + j) + 2] = blue / 273;
          }
        }
        auto gausstimef = clk ::now();
        auto storetimei = clk ::now();

        ofstream foutput;
        foutput.open(nameoutput);
        foutput.write(reinterpret_cast<const char *>(info), 54);
        foutput.write(reinterpret_cast<const char *>(res), size);

        foutput.close();

        auto storetimef = clk ::now();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto gaussdiff = duration_cast<microseconds>(gausstimef - gausstimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + storediff + gaussdiff;

        cout << "File: \"" << nameinput << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Gauss time: " << gaussdiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
      }

      // FUNCION SOBEL
      if (strcmp(argv[1], "sobel") == 0) {
        cout << "Gauss y Sobel: " << nameinput << " en " << nameoutput << "\n";
      }

      free(nameinput);
      free(nameoutput);
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


void gauss(int width, int height,unsigned char * data,unsigned char * info,int
size, char* output) {

}

void sobel(char *photo, DIR *output) {
  // Ver como hacer que haga primero gauss, doble funcion en una o que reciba
  // parametros
  cout << "Gauss y Sobel: " << photo << " en " << output << "\n";
} */
