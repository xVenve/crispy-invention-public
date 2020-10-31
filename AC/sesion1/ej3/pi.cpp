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
#pragma omp atomic
    sum += vector[omp_get_thread_num()];
  }

  double pi = step * sum;

  double t2 = omp_get_wtime();
  double diff = t2 - t1;
  cout << "Atomic:" << '\n';
  cout << "Valor de pi: " << pi << '\n';
  cout << "Numero de hilos: " << hilos << '\n';
  cout << "Tiempo: " << diff << '\n';

  sum = 0.0;
  hilos = 0;
  double vector2[8];
#pragma omp parallel
  {
    hilos = omp_get_num_threads();
    for (int i = 0 + (nsteps / omp_get_num_threads()) * omp_get_thread_num();
         i < (nsteps / omp_get_num_threads()) * (omp_get_thread_num() + 1); ++i) {
      double x = (i + 0.5) * step;
      vector2[omp_get_thread_num()] += 4.0 / (1.0 + x * x);
    }
#pragma omp critical
    sum += vector2[omp_get_thread_num()];
  }

  pi = step * sum;

  t2 = omp_get_wtime();
  diff = t2 - t1;
  cout << "Critical:" << '\n';
  cout << "Valor de pi: " << pi << '\n';
  cout << "Numero de hilos: " << hilos << '\n';
  cout << "Tiempo: " << diff << '\n';

  return 0;
}
