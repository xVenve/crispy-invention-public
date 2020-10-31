#include <iostream>
#include <omp.h>

int main() {
  using namespace std;

  cout << "Hilos antes del pragma " << omp_get_num_threads();

#pragma omp parallel num_threads(4)
  //  cout <<"Hilos justo despues del pragma"<< omp_get_num_threads();
  {
    int id = omp_get_thread_num();
    cout << "Hola(" << id << ") ";
    cout << "Mundo(" << id << ") ";
    cout << "Hilos en el bloque de pragma " << omp_get_num_threads();
  }

  cout << "Hilos del fin de programa " << omp_get_num_threads();

  return 0;
}
