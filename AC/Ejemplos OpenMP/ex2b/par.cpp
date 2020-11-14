// José Manuel Pérez Lobato
#include <algorithm>
#include <chrono>
#include <functional>
#include <iomanip>
#include <iostream>
#include <numeric>
#include <vector>

#include <omp.h>

#include <iostream>

int main() {
  using namespace std;
  using namespace std::chrono;

  constexpr long nsteps = 10000000;
  double step = 1.0 / double(nsteps);

  int nthreads;
#pragma omp parallel
  nthreads = omp_get_num_threads();
  vector<double> sum(nthreads);

  using clk = high_resolution_clock;
  auto t1 = clk::now();
  double sumaT = 0;
  //  #pragma omp parallel
  {
    //   int id = omp_get_thread_num();
#pragma omp parallel for reduction(+ : sumaT)
    for (int i = 0; i < nsteps; i += 1) {
      double x = (i + 0.5) * step;
      sumaT += 4.0 / (1.0 + x * x);
    }
  }
  // double pi = step * accumulate(begin(sum), end(sum), 0);
  //  double pi = step * accumulate(sum.begin(), sum.end(), 0);

  double pi2 = step * sumaT;
  auto t2 = clk::now();
  auto diff = duration_cast<microseconds>(t2 - t1);

  cout << "Threads= " << nthreads << endl;
  cout << "PI2= " << setprecision(10) << pi2 << endl;
  cout << "Tiempo= " << diff.count() << "us" << endl;

  return 0;
}
