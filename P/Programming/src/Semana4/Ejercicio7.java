package Semana4;

public class Ejercicio7 {

	public static void main(String[] args) {
		int a = 5, b = 3;
		boolean r = true, s = false;
		a += b + 8 * b;
		r &= s; //
		System.out.println("a:" + a); // El resultado es 32, porque 8*3=24, 24+3=27 y 27+5=32.
		System.out.println("b:" + b); // El valor de b es 3.
		System.out.println("r:" + r); // El operador de asignación asigna a r el valor de false ya que una de las dos
										// variables es false.
		System.out.println("s:" + s); // El valor de s es false.
	}

}
