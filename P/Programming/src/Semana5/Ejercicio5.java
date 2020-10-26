package Semana5;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca 3 numeros.");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		if (a < b) {
			if (b < c) {
				System.out.print(a + "<" + b + "<" + c);
			} else if (a < c) {
				System.out.print(a + "<" + c + "<" + b);
			} else {
				System.out.print(c + "<" + a + "<" + b);
			}
		} else {
			if (a < c) {
				System.out.print(b + "<" + a + "<" + c);
			} else if (b < c) {
				System.out.print(b + "<" + c + "<" + a);
			} else {
				System.out.print(c + "<" + b + "<" + a);
			}

		}
		sc.close();
	}
}
