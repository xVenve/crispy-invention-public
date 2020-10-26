package Semana4;

public class Ejercicio4 {

	public static void main(String[] args) {
		int a, b;
		float c = 3;
		boolean r, s, t, u, v, w, x;
		a = 3;
		b = 8;
		r = a == 0;
		s = a != 0;
		t = a <= b;
		u = b >= a;
		v = b > a;
		w = b < a;
		x = c == 3.0;
		System.out.println("r:" + r); // Como a es 3 no es igual a 0, es false
		System.out.println("s:" + s); // Como a es 3 y es distinto de 0, es true
		System.out.println("t:" + t); // Como a es 3 y b es 8 la afirmación de que a es menor o igual que b, es true.
		System.out.println("u:" + u); // Como b es 8 y a es 3 la afirmación de que b es mayor o igual que a, es true.
		System.out.println("v:" + v); // Como b es 8 y a es 3 la afirmación de que b es mayor que a, es true.
		System.out.println("w:" + w); // Como b es 8 y a es 3 la afirmación de que b es menor que a, es false.
		System.out.println("x:" + x); // Como c es 3 es igual a 3.0, por tanto, true.

	}

}
