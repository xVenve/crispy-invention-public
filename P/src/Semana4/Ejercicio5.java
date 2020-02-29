package Semana4;

public class Ejercicio5 {

	public static void main(String[] args) {
		int a,
		b;
		boolean r, s;
		a = 3;
		b = 8;
		r = a == 0 || b >= a;
		s = a != 0 && b < a;
		System.out.println("r:" + r); //Es cierto porque una de las dos partes separadas por el operador lógico "||" (o) se cumple.
		System.out.println("s:" + s); //Es falso porque la segunda comparación de las dos separadas por el operador lógico "&&" (y) no se cumple.

	}

}
