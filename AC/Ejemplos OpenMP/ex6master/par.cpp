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
  {
    v[omp_get_thread_num()] = omp_get_thread_num();
    cout << "Th:" << omp_get_thread_num() << endl;
#pragma omp master
    { cout << "Maestro  " << omp_get_thread_num() << endl; }
  }
#pragma omp parallel
  {
    v[omp_get_thread_num()] = omp_get_thread_num();
    cout << "Th:" << omp_get_thread_num() << endl;
#pragma omp single
    { cout << "Un hilo  " << omp_get_thread_num() << endl; }
  }
  usleep(10);
  for (int i = 0; i < 4; ++i)
    cout << v[i] << endl;

  return 0;
}
