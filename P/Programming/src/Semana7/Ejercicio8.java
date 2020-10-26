package Semana7;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el orden de la matriz cuadrada");
		int b = sc.nextInt();
		char[][] a = new char[b][b];
		for (int j = 0; j < a.length; j++) {
			for (int i = 0; i < a.length; i++) {
				if (j != 0 && j != (a.length - 1) && i != 0 && i != (a.length - 1)) {
					a[j][i] = ' ';
				} else {
					a[j][i] = '*';
				}
				System.out.print(a[j][i]);
			}
			System.out.println();
			sc.close();
		}
	}
}
