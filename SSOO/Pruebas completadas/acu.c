#include <stdio.h>

int main() 
{
        int a;
        int c=0;  
        printf("Introducir numero: ");
        scanf("%d",&a);
        while(a!=0){
                c+=a;
                a--;
        }
        printf("La suma total es: %d\n",c);
        return 0;
}