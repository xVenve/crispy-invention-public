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
  for (int i = 0; i < 4; ++i)
    cout << v[i] << endl;

  int suma = 0;
#pragma omp parallel for
  for (int i = 0; i <= 100; i++) {
#pragma omp atomic
    suma += i;
  }
  cout << suma << endl;

  suma = 0;
#pragma omp parallel
#pragma omp for nowait
  for (int i = 0; i <= 100; i++) {
#pragma omp atomic
    suma += i;
  }
  cout << suma << endl;
  usleep(100);
  cout << suma << endl;

  /*
    constexpr long nsteps = 10000000;
    double step = 1.0 / double(nsteps);

    double sum = 0.0;
    #pragma omp parallel for reduction(+:sum)
    for (int i=0;i<nsteps; ++i) {
      double x = (i+0.5) * step;
      sum += 4.0 / (1.0 + x * x);
    }
    double pi = step * sum;

    auto t2 = clk::now();
    auto dif = duration_cast<microseconds>(t2-t1);

    cout << "PI= " << setprecision(10) << pi << endl;
    cout << "Time= " << dif.count() << "us" << endl;
  */
  return 0;
}
