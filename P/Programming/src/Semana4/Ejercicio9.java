package Semana4;
import java.util.Scanner;
public class Ejercicio9 {

	public static void main(String[] args) {
		float c;

		Scanner num = new Scanner(System. in);
		System.out.print("Introduce un número: ");
		int a = num.nextInt();
		System.out.print("Introduzca el segundo número: ");
		double b = num.nextDouble();
		c = a + (float)b;
		System.out.print(c);
		num.close();

	}

}
