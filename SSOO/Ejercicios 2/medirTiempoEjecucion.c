
#include <stdio.h>
#include <time.h>

int main(){

clcok_t tiempo_inicio, tiempo_final;
double segundos;

tiempo_inicio = clock();

/*operación a medir tiempos, operación básica del código, normalmente bucles*/

tiempo_final = clock();

segundos = (double)(tiempo_inicio - timpo_final) / CLOCKS_PER_SEC; /*según que estes midiendo el tiempo en segundos es demasiado grande*/

printf("%f",segundos);


return 0;
}