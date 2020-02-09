#include <stdio.h>
#include <ctype.h>

void Upper(char a[]){
int i = 0;
while (a[i]){
    printf("%c", toupper(a[i]));
    i++;
	}
}

void Lower(char a[]){
	int i = 0;
	while (a[i]){
    	printf("%c", tolower(a[i]));
    	i++;
	}
}

void Palin(char *a){
	int i=0;
	while(a[i]){
		i++;
	}
	while(i>=0){
		printf("%c", a[i]);
		i--;
	}
	printf("\n");
}

void Salta(char *a){
	int i=0;
	int r=0;
	while(a[i]){
		if(a[i]=='r'){
		//if(a[i]=='r' || a[i]=='R'){ Mayusculas y minusculas
			r++;
		}
		if (a[i]==' ')
		{
			printf("\n");
		}else{
			printf("%c", a[i]);
		}
		i++;
	}
	printf("Numero de r (minusculas): %d\n", r);

}

int main(){
	char cad [100];
	printf("Introduce tu frase: ");
	fgets(cad, 100, stdin);
	Upper(cad);
	Lower(cad);
	Palin(cad);
	Salta(cad);
	return 0;
}