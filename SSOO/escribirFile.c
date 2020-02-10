#include <stdio.h>

int main(void){
	FILE *escribir=NULL;
	escribir= fopen("entradas.txt","w");

	if(escribir==NULL)
		return -1;

	int x=0;
	while(x<1000){
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				fprintf(escribir, "%d\t\t", x);
				x++;
			}
			fprintf(escribir, "\n");
		}
		fprintf(escribir, "\n");
	}

	fclose(escribir);
	return 0;
}