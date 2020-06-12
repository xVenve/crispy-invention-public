package Semana5;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System. in);
		System.out.println("Introduzca los dos n�meros enteros que desea dividir.");
		int a = sc.nextInt();
		int b = sc.nextInt();

		if (b == 0) {
			System.out.println("No se puede dividir por cero usando enteros.");
		} else {
			System.out.print((float)a / b);
		}
		sc.close();
	}

}
