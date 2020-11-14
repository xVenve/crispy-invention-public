// José Manuel Pérez Lobato 
#include <iostream>
#include <iomanip>
#include <functional>
#include <numeric>
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
  vector<double> sum(nthreads);

  using clk = high_resolution_clock;  // using define un alias 
  auto t1 = clk::now();

  #pragma omp parallel 
  {
    int id = omp_get_thread_num();
    for (int i=id; i<nsteps; i+=nthreads) {
      double x = (i+0.5) * step;
      sum[id] += 4.0 / (1.0 + x * x);
    }
  }
  //double pi = step * accumulate(begin(sum), end(sum), 0);
  double pi = step * accumulate(sum.begin(), sum.end(), 0);

  auto t2 = clk::now();
  auto diff = duration_cast<microseconds>(t2-t1);

  cout << "Threads= " << nthreads << endl;
  cout << "PI= " << setprecision(10) << pi << endl;
  cout << "Tiempo= " << diff.count() << "us" << endl;

  return 0;  
}
