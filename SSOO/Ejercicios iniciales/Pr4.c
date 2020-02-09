
#include <stdio.h>

struct quebrado
{
	int num;
	int den; 
};

int menu(void){
	printf("Elija una de las siquientes opciones: \n1. Suma de quebrados\n2. Resta de quebrados\n3. Multiplicacion de quebrados\n4. Division de quebrados\n5. Salir\n");
	int op;
	scanf("%d",&op);
	return op;
}

void Leer_numero(struct quebrado *q){
	printf("Introduce el numerador\n");
	scanf("%d", &q->num);
	printf("Introduce el denominador\n");
	scanf("%d", &q->den);
}

struct quebrado suma(struct quebrado q, struct quebrado p){
	struct quebrado r;
	q.num=q.num*p.den;
	p.num=p.num*q.den;
	r.num=q.num+p.num;
	r.den=q.den*p.den;
	return r;
}

struct quebrado resta(struct quebrado q, struct quebrado p){
	struct quebrado r;
	q.num=q.num*p.den;
	p.num=p.num*q.den;
	r.num=q.num-p.num;
	r.den=q.den*p.den;
	return r;
}

struct quebrado multiplicacion(struct quebrado q, struct quebrado p){
	struct quebrado r;
	r.num=q.num*p.num;
	r.den=q.den*p.den;
	return r;
}

struct quebrado division(struct quebrado q, struct quebrado p){
	struct quebrado r;
	r.num=q.num*p.den;
	r.den=q.den*p.num;
	return r;
}

void reducir(struct quebrado q){
	int x;
	if(q.num<q.den){
		x=q.num;
	}else{
		x=q.den;
	}

	while(x>0 && q.num!=1 && q.den!=1){
		if(q.num%x==0 && q.den%x==0){
			q.num/=x;
			q.den/=x;
		}
		x--;
	}

	printf("Resultado reducido: %d\\%d\n", q.num, q.den);
}

int main()
{
	struct quebrado x;
	Leer_numero(&x);
	struct quebrado y;
	Leer_numero(&y);

	bcl:;
	int o=menu();
	struct quebrado r;
	switch(o){
		case 1: r=suma(x,y);
		break;
		case 2: r=resta(x,y);
		break;
		case 3: r=multiplicacion(x,y);
		break;
		case 4: r=division(x,y);
		break;
		case 5: goto fin;
		default: goto bcl;
	}
	printf("Resultado: %d/%d\n", r.num, r.den);
	reducir(r);
	goto bcl;

	fin:return 0;
}