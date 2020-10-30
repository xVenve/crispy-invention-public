#include <iostream>
#include <omp.h>

int main() {

  using namespace std;

  constexpr long nsteps = 10000000;
  double t1 = omp_get_wtime();
  double step = 1.0 / double(nsteps);
  double sum = 0.0;
  int hilos = 0;
  double vector[8];
#pragma omp parallel
  {
    hilos = omp_get_num_threads();
    for (int i = 0 + (nsteps / 8) * omp_get_thread_num(); i < (nsteps / 8) * (omp_get_thread_num() + 1); ++i) {
      double x = (i + 0.5) * step;
      vector[omp_get_thread_num()] += 4.0 / (1.0 + x * x);
    }
  }
  for (int j = 0; j < 8; j++) {
    sum += vector[j];
  }
  double pi = step * sum;

  double t2 = omp_get_wtime();
  double diff = t2 - t1;
  cout << "Valor de pi: " << pi << '\n';
  cout << "Numero de hilos: " << hilos << '\n';
  cout << "Tiempo: " << diff << '\n';
}
