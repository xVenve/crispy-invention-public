package Semana6;

import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {

		int contador = 0;
		double n, suma = 0;
		Scanner sc = new Scanner(System. in);
		do {
			System.out.println("Introduzca un numero(0 para finalizar): ");
			n = sc.nextDouble();
			suma = suma + n;
			contador++;

		} while (n != 0);
		if (contador == 1) {
			System.out.println("La suma de los números es: " + suma);
			System.out.println("La media de los números es: " + (
				contador - 1
			));
		} else {
			System.out.println("La suma de los números es: " + suma);
			System.out.println("La media de los números es: " + suma / (contador - 1));
		}
		sc.close();
	}

}
