package Semana4;

public class Ejercicio8 {
	public static void main(String[] args) {

		int a = 5,
		b = 3,
		c = 20,
		d = 20;
		c -= ++a / b - 3 + a % b; //A la variable "a" se le suma uno, a/b=2 (6/3=2), a%b=0 (6%3=0),
		//2-3+0= -1. A "c" se le resta este resultado por lo tanto 20-(-1)=21
		d -= ++a / (b + 3 - 4 * a) % b; //Ahora a vale 7, 4*a=28, b+3-28= -22, 7/-22=0, 0%3=0, por lo tanto, c= 20-0= 0
		System.out.println("c:" + c);
		System.out.println("d:" + d);
	}

}
