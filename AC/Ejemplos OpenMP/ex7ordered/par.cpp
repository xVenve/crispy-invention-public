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
#pragma omp parallel for ordered
  for (int i = 0; i < 4; ++i) {
    cout << "Th:" << omp_get_thread_num() << endl;
    {
#pragma omp ordered
      cout << "En orden  " << omp_get_thread_num() << endl;
    }
  }

  return 0;
}
