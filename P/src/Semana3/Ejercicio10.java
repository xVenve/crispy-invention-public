package Semana3;

public class Ejercicio10 {
	public static void main(String[] arg) {
		int a = 16;
		int b = a;
		System.out.println(b);
		a = 61;
		System.out.println(b);
		// La segunda variable no cambia, puesto que le hemos cambiado el valor a la primera (a) despues de haberle asignado su
		// valor original a la variable "b" y no lo hemos actualizado.

		String c = "hello";
		String d = c;
		System.out.println(d);
		c = "hola";
		System.out.println(d);
		//Con la variable String ocurre lo mismo que en el anterior caso.

	}

}
