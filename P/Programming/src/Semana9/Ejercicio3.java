package Semana9;
import java.util.Scanner;
public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		System.out.println(
			"Introduzca el nombre y apellido del estudiante y sus notas de programcion, algebra, calculo, fisica, escritura e infor" +
			"macion"
		);
		Ej3Estudiante Stiuden = new Ej3Estudiante(
			sc.next(),
			sc.next(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble(),
			sc.nextDouble()
		);
		System.out.println("Nombre: " + Stiuden.nombre + " " + Stiuden.apellido);
		System.out.println("Sus notas son:");
		System.out.println("Programacion: " + Stiuden.programacion);
		System.out.println("Algebra: " + Stiuden.algebra);
		System.out.println("Calculo: " + Stiuden.calculo);
		System.out.println("Fisica: " + Stiuden.fisica);
		System.out.println("Escritura: " + Stiuden.escritura);
		System.out.println("Informacion: " + Stiuden.informacion);
		sc.close();

	}

}
