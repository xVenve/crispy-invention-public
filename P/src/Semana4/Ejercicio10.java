package Semana4;
import java.util.Scanner;
public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner temp = new Scanner(System. in);
		System.out.print("Introduzca una temperatura en grados centígrados: ");
		int C = temp.nextInt();
		float F;
		F = (((float)C * 9) / 5) + 32;
		System.out.print(F);
		temp.close();

	}

}
