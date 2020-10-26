package Semana6;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int c, n, m;

		System.out.println("Introduzca el numero y la cantidad de multiplos que desea: ");
		c = sc.nextInt();
		m = sc.nextInt();
		sc.close();
		for (n = c; n <= c * m; n = n + c) {
			System.out.println(n);
		}
	}

}
