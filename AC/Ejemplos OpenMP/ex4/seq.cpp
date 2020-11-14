// José Manuel Pérez Lobato
#include <chrono>
#include <iomanip>
#include <iostream>

int main() {
  using namespace std;
  using namespace std::chrono;
  using clk = chrono::high_resolution_clock;

  auto t1 = clk::now();

  constexpr long nsteps = 10000000;
  double step = 1.0 / double(nsteps);

  double sum = 0.0;
  for (int i = 0; i < nsteps; ++i) {
    double x = (i + 0.5) * step;
    sum += 4.0 / (1.0 + x * x);
  }
  double pi = step * sum;

  auto t2 = clk::now();
  auto dif = duration_cast<microseconds>(t2 - t1);

  cout << "PI= " << setprecision(10) << pi << endl;
  cout << "Time= " << dif.count() << "us" << endl;

  return 0;
}
