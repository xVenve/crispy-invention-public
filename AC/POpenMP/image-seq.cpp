#include <chrono>
#include <cmath>
#include <cstring>
#include <dirent.h>
#include <fstream>
#include <iostream>
#include <stdlib.h>
using namespace std;
using namespace std::chrono;
using clk = chrono::high_resolution_clock;

void gauss(int, int, unsigned char *, unsigned char *);

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
    return -1;
  }

  // Comprobar directorio de salida existente
  DIR *output = opendir(argv[3]);
  if (output == NULL) {
    cout << "Input path: " << argv[2] << "\nOutput path: " << argv[3]
         << "\nOutput directory [" << argv[3] << "] does not exist"
         << "\n"
         << argv[0]
         << " operation in_path out_path\n   operation: copy, "
            "gauss, sobel\n";
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

      string name = dir->d_name;

      // Comprobación de formato
      int position = name.find_last_of(".");
      string extension = name.substr(position + 1);
      int result = extension.compare("bmp");
      if (result != 0) {
        cout << "Error processing \"" << nameinput << "\" \n"
             << " Unexpected file without .bmp extension: " << name << "\n";
        continue;
      }

      auto loadtimei = clk ::now();
      FILE *photo = fopen(nameinput, "rb");
      if (photo == NULL)
        cout << "Error processing \"" << nameinput << "\" \n"
             << "Error al abrir el fichero." << '\n';

      // Cabecera
      unsigned char *info = new unsigned char[54];
      int freaderror = fread(info, sizeof(unsigned char), 54, photo);
      if (freaderror < 0) {
        cout << "Error processing \"" << nameinput << "\" \n"
             << "ERROR al leer la cabecera de la imagen" << '\n';
        continue;
      }

      // Ancho y alto
      int width = *(int *)&info[18];
      int height = *(int *)&info[22];

      // 24 bits = 3 bytes por pixel
      int size = *(int *)&info[2] - *(int *)&info[10];
      unsigned char *data = new unsigned char[size - height * (width % 4)];

      // Error de .bmp que no tenga un plano
      if (*(unsigned short *)&info[26] != 1) {
        cout << "Error processing \"" << nameinput << "\" \n"
             << "Planes is not 1\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        continue;
      }

      // Error de .bmp que no sea 24 bits por punto
      if (*(unsigned short *)&info[28] != 24) {
        cout << "Error processing \"" << nameinput << "\" \n"
             << "Bit count is not 24.\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        continue;
      }

      // Error de .bmp que no sea 0 la compresion
      if (*(int *)&info[30] != 0) {
        cout << "Error processing \"" << nameinput << "\" \n"
             << "Compression is not 0.\n " << argv[0]
             << " operation in_path out_path\n   operation: copy, "
                "gauss, sobel\n";
        continue;
      }

      // Lectura de los datos de imagen
      fseek(photo, *(int *)&info[10], SEEK_SET);
      if (width % 4 == 0) {
        freaderror = fread(data, sizeof(unsigned char), size, photo);
      } else {
        for (int i = 0; i < height && freaderror >= 0; i++) {
          freaderror = fread(&data[i * width * 3], sizeof(unsigned char),
                             width * 3, photo);
          fseek(photo, (width % 4), SEEK_CUR);
        }
      }

      if (freaderror < 0) {
        cout << "ERROR al leer el cuerpo de la imagen" << '\n';
        return -1;
      }
      auto loadtimef = clk ::now();

      // FUNCION COPY
      if (strcmp(argv[1], "copy") == 0) {
        ofstream foutput;

        auto storetimei = clk ::now();
        foutput.open(nameoutput);
        // creacion de la cabecera
        foutput.write("B", 1);
        foutput.write("M", 1);
        int tamanoarchivo = size + 54;
        foutput.write(reinterpret_cast<const char *>(&tamanoarchivo), 4);
        int cero = 0;
        int cincocuatro = 54;
        int cuarenta = 40;
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cincocuatro), 4);
        foutput.write(reinterpret_cast<const char *>(&cuarenta), 4);
        foutput.write(reinterpret_cast<const char *>(&width), 4);
        foutput.write(reinterpret_cast<const char *>(&height), 4);
        int uno = 1;
        foutput.write(reinterpret_cast<const char *>(&uno), 2);
        int veinticuatro = 24;
        foutput.write(reinterpret_cast<const char *>(&veinticuatro), 2);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&size), 4);
        int resolucion = 2835;
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);

        // Creacion de datos imagen
        unsigned char c = 0;
        if (width % 4 == 0) {
          foutput.write(reinterpret_cast<const char *>(data), size);
        } else {
          for (int i = 0; i < height; i++) {
            foutput.write(reinterpret_cast<const char *>(&data[3 * i * width]),
                          width * 3);
            if (width % 4 != 0) {
              foutput.write(reinterpret_cast<const char *>(&c), width % 4);
            }
          }
        }

        auto storetimef = clk ::now();
        foutput.close();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + storediff;

        cout << "File: \"" << nameinput << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
      }

      // FUNCION GAUSS
      if (strcmp(argv[1], "gauss") == 0) {

        unsigned char *res = new unsigned char[size - height * (width % 4)];
        auto gausstimei = clk ::now();
        gauss(width, height, data, res);
        auto gausstimef = clk ::now();

        auto storetimei = clk ::now();
        ofstream foutput;
        foutput.open(nameoutput);

        // creacion de la cabezera
        foutput.write("B", 1);
        foutput.write("M", 1);
        int tamanoarchivo = size + 54;
        foutput.write(reinterpret_cast<const char *>(&tamanoarchivo), 4);
        int cero = 0;
        int cincocuatro = 54;
        int cuarenta = 40;
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cincocuatro), 4);
        foutput.write(reinterpret_cast<const char *>(&cuarenta), 4);
        foutput.write(reinterpret_cast<const char *>(&width), 4);
        foutput.write(reinterpret_cast<const char *>(&height), 4);
        int uno = 1;
        foutput.write(reinterpret_cast<const char *>(&uno), 2);
        int veinticuatro = 24;
        foutput.write(reinterpret_cast<const char *>(&veinticuatro), 2);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&size), 4);
        int resolucion = 2835;
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        // Creacion de datos imagen
        unsigned char c = 0;
        if (width % 4 == 0) {
          foutput.write(reinterpret_cast<const char *>(res), size);
        } else {
          for (int i = 0; i < height; i++) {
            foutput.write(reinterpret_cast<const char *>(&res[3 * i * width]),
                          width * 3);
            if (width % 4 != 0) {
              foutput.write(reinterpret_cast<const char *>(&c), width % 4);
            }
          }
        }
        auto storetimef = clk ::now();
        foutput.close();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto gaussdiff = duration_cast<microseconds>(gausstimef - gausstimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + storediff + gaussdiff;

        cout << "File: \"" << nameinput << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Gauss time: " << gaussdiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
        free(res);
      }

      // FUNCION SOBEL
      if (strcmp(argv[1], "sobel") == 0) {
        unsigned char *gaussres =
            new unsigned char[size - height * (width % 4)];

        auto gausstimei = clk ::now();
        gauss(width, height, data, gaussres);
        auto gausstimef = clk ::now();

        int mx[3][3] = {{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};

        int my[3][3] = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};

        unsigned char *sobel = new unsigned char[size - height * (width % 4)];
        auto sobeltimei = clk ::now();
        for (int i = 0; i < height; i++) {
          for (int j = 0; j < width; j++) {
            int xx = 0;
            int xy = 0;
            int xz = 0;

            int yx = 0;
            int yy = 0;
            int yz = 0;
            for (int s = -1; s < 2; s++) {
              for (int t = -1; t < 2; t++) {
                // Condición para marcado de bordes
                if ((i + s) < height && (j + t) < width && (i + s) >= 0 &&
                    (j + t) >= 0) {
                  xx += mx[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t))];
                  xy += mx[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t)) + 1];
                  xz += mx[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t)) + 2];

                  yx += my[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t))];
                  yy += my[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t)) + 1];
                  yz += my[s + 1][t + 1] *
                        gaussres[3 * ((i + s) * width + (j + t)) + 2];
                }
              }
            }
            sobel[3 * (i * width + j)] = (abs(xx) + abs(yx)) / 8;
            sobel[3 * (i * width + j) + 1] = (abs(xy) + abs(yy)) / 8;
            sobel[3 * (i * width + j) + 2] = (abs(xz) + abs(yz)) / 8;
          }
        }
        auto sobeltimef = clk ::now();

        auto storetimei = clk ::now();
        ofstream foutput;
        foutput.open(nameoutput);
        // creacion de la cabecera
        foutput.write("B", 1);
        foutput.write("M", 1);
        int tamanoarchivo = size + 54;
        foutput.write(reinterpret_cast<const char *>(&tamanoarchivo), 4);
        int cero = 0;
        int cincocuatro = 54;
        int cuarenta = 40;
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cincocuatro), 4);
        foutput.write(reinterpret_cast<const char *>(&cuarenta), 4);
        foutput.write(reinterpret_cast<const char *>(&width), 4);
        foutput.write(reinterpret_cast<const char *>(&height), 4);
        int uno = 1;
        foutput.write(reinterpret_cast<const char *>(&uno), 2);
        int veinticuatro = 24;
        foutput.write(reinterpret_cast<const char *>(&veinticuatro), 2);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&size), 4);
        int resolucion = 2835;
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&resolucion), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);
        foutput.write(reinterpret_cast<const char *>(&cero), 4);

        // Creacion de datos imagen
        unsigned char c = 0;
        if (width % 4 == 0) {
          foutput.write(reinterpret_cast<const char *>(sobel), size);
        } else {
          for (int i = 0; i < height; i++) {
            foutput.write(reinterpret_cast<const char *>(&sobel[3 * i * width]),
                          width * 3);
            if (width % 4 != 0) {
              foutput.write(reinterpret_cast<const char *>(&c), width % 4);
            }
          }
        }
        auto storetimef = clk ::now();
        foutput.close();

        auto loaddiff = duration_cast<microseconds>(loadtimef - loadtimei);
        auto gaussdiff = duration_cast<microseconds>(gausstimef - gausstimei);
        auto sobeldiff = duration_cast<microseconds>(sobeltimef - sobeltimei);
        auto storediff = duration_cast<microseconds>(storetimef - storetimei);
        auto sum = loaddiff + gaussdiff + storediff + sobeldiff;

        cout << "File: \"" << nameinput << "\"(time: " << sum.count() << ")\n";
        cout << "  Load time: " << loaddiff.count() << "\n";
        cout << "  Gauss time: " << gaussdiff.count() << "\n";
        cout << "  Sobel time: " << sobeldiff.count() << "\n";
        cout << "  Store time: " << storediff.count() << "\n";
        free(gaussres);
        free(sobel);
      }

      free(nameinput);
      free(data);
      free(info);
      free(nameoutput);
      fclose(photo);
    }
  }

  closedir(input);
  closedir(output);
  return 0;
}

void gauss(int width, int height, unsigned char *data, unsigned char *res) {
  int m[5][5] = {{1, 4, 7, 4, 1},
                 {4, 16, 26, 16, 4},
                 {7, 26, 41, 26, 7},
                 {4, 16, 26, 16, 4},
                 {1, 4, 7, 4, 1}};

  for (int i = 0; i < height; i++) {
    for (int j = 0; j < width; j++) {
      int x = 0;
      int y = 0;
      int z = 0;
      for (int s = -2; s < 3; s++) {
        for (int t = -2; t < 3; t++) {
          // Condición para marcado de bordes
          if ((i + s) < height && (j + t) < width && (i + s) >= 0 &&
              (j + t) >= 0) {
            x += m[s + 2][t + 2] * data[3 * ((i + s) * width + (j + t))];
            y += m[s + 2][t + 2] * data[3 * ((i + s) * width + (j + t)) + 1];
            z += m[s + 2][t + 2] * data[3 * ((i + s) * width + (j + t)) + 2];
          }
        }
      }
      res[3 * (i * width + j)] = x / 273;
      res[3 * (i * width + j) + 1] = y / 273;
      res[3 * (i * width + j) + 2] = z / 273;
    }
  }
}
