package Semana3;

public class Ejercicio11 {
	public static void main(String[] arg) {
		int a,b;
		int c,d;
		a = 2;
		b = 3 * 3;
		c = 7 / 3;
		d = a + b * c;
		System.out.println(d);
		//El resultado es 20; a es 2, b es 9, c es 2 porque al ser de tipo int y la operacion 7/3 dar como 
		//resultado 2.333 se redondea al numero entero mas cercano (2), por lo tanto d sera igual a 2+9*2=20.
	}

}
