package Semana5;

import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzaca un caracter: ");
		String a = sc.next();

		switch (a) {
			case "0":
				System.out.println("Es un n�mero.");
				break;
			case "1":
				System.out.println("Es un n�mero.");
				break;
			case "2":
				System.out.println("Es un n�mero.");
				break;
			case "3":
				System.out.println("Es un n�mero.");
				break;
			case "4":
				System.out.println("Es un n�mero.");
				break;
			case "5":
				System.out.println("Es un n�mero.");
				break;
			case "6":
				System.out.println("Es un n�mero.");
				break;
			case "7":
				System.out.println("Es un n�mero.");
				break;
			case "8":
				System.out.println("Es un n�mero.");
				break;
			case "9":
				System.out.println("Es un n�mero.");
				break;
			default:
				System.out.println("Es una letra.");
		}
		sc.close();
	}
}
