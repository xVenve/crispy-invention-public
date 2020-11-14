// José Manuel Pérez Lobato 
#include <iostream>
#include <omp.h>

int tot1=0;
int tot2=0;

int f1(){
    for (int i=0; i<1000;i++)
      tot1++;
    return tot1;
}
int f2(){
    for (int i=0; i<1000;i++)
      tot2++;
    return tot2;
}
int main() {
  using namespace std;
  int tot1=0,tot2=0;
  omp_set_num_threads(6);
  int numth= omp_get_num_threads();
  cout << "num threads antes" << numth << endl;
  double t1=omp_get_wtime();
  #pragma omp parallel
  {
cout << "T";
    numth= omp_get_num_threads();
  cout << "num threads dentro" << numth << endl;
    for (int i=0; i<1000;i++)
       tot1++;
    //#pragma omp critical
    for (int i=0; i<1000;i++)
    #pragma omp atomic
      tot2++;
  }
  double t2=omp_get_wtime();
  double tdif=t2-t1;
  cout << "tot1:" << tot1 << " \n";
  cout << "tot2:" << tot2 << " \n";
  cout << "tiempo:" << tdif << " \n";
  return 0;
}
