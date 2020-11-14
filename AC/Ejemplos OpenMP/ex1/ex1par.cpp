// José Manuel Pérez Lobato 
#include <iostream>
#include <omp.h>

int main() {
  using namespace std;

  omp_set_num_threads(5);
    int numth= omp_get_num_threads();
    cout << "num threads antes: " << numth << endl;
  #pragma omp parallel
  {
    int id = omp_get_thread_num();
    numth= omp_get_num_threads();
    cout << "num threads después: " << numth << endl;
    for (int i=0; i<3; i++){
  //    cout << "Hola"<<endl;
      cout << "Hola(" << id << ") ";
    }
  }

  return 0;
}
