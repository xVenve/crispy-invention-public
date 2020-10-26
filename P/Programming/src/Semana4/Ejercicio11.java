package Semana4;

import java.util.Scanner;

public class Ejercicio11 {
	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);
		System.out.print("Cuanto tiempo en segundo quieres pasar a horas, minutos y segundos: ");
		int s = tec.nextInt();
		int h = s / 3600;
		s = s - (h * 3600);
		int m = s / 60;
		s = s - (m * 60);
		System.out.print("Son: " + h + " hora/s, " + m + " minuto/s y " + s + " segundo/s.");
		tec.close();

	}

}
