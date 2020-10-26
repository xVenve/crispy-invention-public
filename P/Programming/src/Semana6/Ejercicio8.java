package Semana6;

import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n, g;
		System.out.println("De que orden quieres el cuadrado latino: ");
		n = sc.nextInt();
		int[] latino = new int[n];

		for (int i = 0; i < n; i++) {

			latino[i] = i + 1;

		}
		for (int j = 0; j < n; j++) {

			for (int k = 0; k < n; k++) {
				System.out.print(latino[k] + "  ");
			}
			System.out.print("\n");
			g = latino[n - 1];

			for (int l = n - 1; l > 0; l--) {

				latino[l] = latino[l - 1];
			}
			latino[0] = g;

		}
		sc.close();

	}

}
