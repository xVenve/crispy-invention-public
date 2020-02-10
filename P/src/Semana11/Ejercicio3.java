package Semana11;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduzca el nombre y apellido del estudiante y sus notas de programacion, algebra, calculo, fisica, escritura e informacion");
		Ej3Estudiante Stiuden=new Ej3Estudiante(sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		System.out.println("Nombre: "+ Stiuden.getNombre()+" "+Stiuden.getApellido());
		System.out.println("Sus notas son:");
		System.out.println("Programacion: "+ Stiuden.getProgramacion());
		System.out.println("Algebra: "+ Stiuden.getAlgebra());
		System.out.println("Calculo: "+ Stiuden.getCalculo());
		System.out.println("Fisica: "+ Stiuden.getFisica());
		System.out.println("Escritura: "+ Stiuden.getEscritura());
		System.out.println("Informacion: "+ Stiuden.getInformacion());
		sc.close();
	}
//En el programa principal no es necesario realizar cambios, lo unico que hemos cambiado han sido las variables donde se guardaban antes las 
//notas por una posicion del array
}
