// José Manuel Pérez Lobato 
#include <iostream>
#include <iomanip>
#include <chrono>
#include <vector>
#include <unistd.h>
#include <omp.h>

int main() {
  using namespace std;
  using namespace std::chrono;
  
  int num_threads;
  #pragma omp parallel
  {
    num_threads= omp_get_num_threads();
  } 
  vector<int>v(num_threads) ;
  #pragma omp parallel
  {
    v[omp_get_thread_num()]= omp_get_thread_num();
  }
//  for (int i=0;i<4; ++i) 
 //    cout << v[i]<< endl;

  int suma=0, sumaTot=0;
  #pragma omp parallel private(suma)
  {
 //   cout <<"a"<<endl;
    suma=0; //hay que inicializarla para cada thread
    //#pragma omp for schedule(static, 5) 
    //#pragma omp for schedule(dynamic, 5) 
    #pragma omp for schedule(guided, 1) 
   // #pragma omp for schedule(runtime) 
    for (int i=0; i<=20; i++){
      suma+=i; //utilizo la variable privada de cada thread. 
      cout << "th:"<< omp_get_thread_num()<<" i:"<< i<<endl;
    }
  //  cout << "th:"<< omp_get_thread_num()<<" suma:"<< suma<<endl;
    #pragma omp critical
    sumaTot+=suma;
  }
  cout <<"sumaTot:"<< sumaTot<< endl;
  cout << "suma:"<< suma << endl;
  return 0;  
}
