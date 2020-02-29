package Semana6;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System. in);
		int n, c = 0, random = (int)(Math.random() * 100) + 1;
		boolean i = false;
		do {
			System.out.println("Introduzca un número entre 1 y 100: ");
			n = sc.nextInt();
			c++;
			if (n == random) {
				i = true;
			} else if (n > random) {
				System.out.println("Pruebe con un número más pequeño.");
			} else {
				System.out.println("Pruebe con un número más grande.");
			}

		} while (!i);
		System.out.println("Ha acertado, el número era " + random + " has necesitado " + c + " intentos.");
		sc.close();
	}

}