package Semana9;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca la base y la altura del triangulo rectangulo");
		Ej4Triangulo Triangulo = new Ej4Triangulo(sc.nextFloat(), sc.nextFloat());
		do {
			System.out.println(
					"-Introduzca 0 para calcular el area del triangulo \n-Introduzca 1 para calcular su perimetro");
			op = sc.nextInt();
		} while (op > 1 || op < 0);
		if (op == 0) {
			Triangulo.area(Triangulo.base, Triangulo.altura);
		} else {
			Triangulo.perimetro(Triangulo.base, Triangulo.altura);
		}
		sc.close();

	}

}
