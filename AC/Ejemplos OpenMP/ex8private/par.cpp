// José Manuel Pérez Lobato
#include <chrono>
#include <iomanip>
#include <iostream>
#include <omp.h>
#include <unistd.h>
#include <vector>

int main() {
  using namespace std;
  using namespace std::chrono;

  int num_threads;
#pragma omp parallel
  { num_threads = omp_get_num_threads(); }
  vector<int> v(num_threads);
#pragma omp parallel
  { v[omp_get_thread_num()] = omp_get_thread_num(); }
  //  for (int i=0;i<4; ++i)
  //    cout << v[i]<< endl;

  int suma = 0, sumaTot = 0;
#pragma omp parallel private(suma)
  {
    cout << "a" << endl;
    suma = 0; // hay que inicializarla para cada thread
#pragma omp for
    for (int i = 0; i <= 10; i++) {
      cout << "th:" << omp_get_thread_num() << " i:" << i << endl;
      suma += i; // utilizo la variable privada de cada thread.
    }
    cout << "th:" << omp_get_thread_num() << " suma:" << suma << endl;
#pragma omp critical
    sumaTot += suma;
  }
  cout << "sumaTot:" << sumaTot << endl;
  cout << "suma:" << suma << endl;
  return 0;
}
