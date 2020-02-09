#include <stdio.h>

float calcularMedia(int v[], int n){
	int sum=0;
	for(int i=0; i<n; i++){
		sum+=v[i];
	}
	return (float)sum/n;
}

void ordenarVector(int *v, int n){

	for(int i=0; i<n-1; i++){
		for(int j=0; j<n-1-i; j++){
			if(v[j]>v[j+1]){ //menor a mayor
				int aux=v[j];
				v[j]=v[j+1];
				v[j+1]=aux;
			}
		}
	}

}

void imprimirVector(int *v, int n){
	for (int i = 0; i < n; ++i){
		printf("%d\t", v[i]);
	}
	printf("\n");
}

int main(){
	printf("Introduce la longitud del vector: \n");
	int N=0;

	scanf("%d", &N);
	int vec[N];
	for(int i=0; i<N; i++){
		printf("Valor para la posicion %d:\n", i+1);
		scanf("%d", &vec[i]);
	}

	float media=calcularMedia(vec, N);
	printf("La media es: %f\n", media);

	ordenarVector(vec, N);
	imprimirVector(vec, N);

	return 0;
}