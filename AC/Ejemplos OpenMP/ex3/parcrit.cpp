// José Manuel Pérez Lobato 
#include <iostream>
#include <iomanip>
#include <chrono>
#include <vector>
#include <algorithm>

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
  double pi = 0.0;

  using clk = high_resolution_clock;
  auto t1 = clk::now();

  #pragma omp parallel 
  {
    int id = omp_get_thread_num();
    double sum = 0.0;
    for (int i=id; i<nsteps; i+=nthreads)
    {
      double x = (i+0.5) * step;
      sum += 4.0 / (1.0 + x * x);
    }
    #pragma omp critical
    pi += sum * step;
  }

  auto t2 = clk::now();
  auto diff = duration_cast<microseconds>(t2-t1);

  cout << "Threads= " << nthreads << endl;
  cout << "PI= " << setprecision(10) << pi << endl;
  cout << "Tiempo= " << diff.count() << "us" << endl;

  return 0;  
}
