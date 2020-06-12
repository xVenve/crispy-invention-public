package Semana11;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		System.out.println(
			"Introduzca el nombre y apellido del estudiante y sus notas de programacion, algebra, calculo, fisica, escritura e info" +
			"rmacion"
		);
		Ej2estudiante Stiuden = new Ej2estudiante(
			sc.next(),
			sc.next(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble()
		);
		System.out.println("Nombre: " + Stiuden.getNombre() + " " + Stiuden.getApellido());
		System.out.println("Sus notas son:");
		System.out.println("Programacion: " + Stiuden.getProgramacion());
		System.out.println("Algebra: " + Stiuden.getAlgebra());
		System.out.println("Calculo: " + Stiuden.getCalculo());
		System.out.println("Fisica: " + Stiuden.getFisica());
		System.out.println("Escritura: " + Stiuden.getEscritura());
		System.out.println("Informacion: " + Stiuden.getInformacion());
		sc.close();
	}

}
