package Semana10;
import java.util.Scanner;
public class Ejercicio1 {

	public static void main(String[] args) {
		Ej1Hora madrugada = new Ej1Hora(0, 0, 6, 0);
		Ej1Hora maniana = new Ej1Hora(6, 0, 12, 0);
		Ej1Hora tarde = new Ej1Hora(12, 0, 18, 0);
		Ej1Hora noche = new Ej1Hora(18, 0, 0, 0);
		Scanner sc = new Scanner(System. in);
		int n;
		System.out.println("Cuantos intervalos desea introducir?");
		n = sc.nextInt();
		Ej1Hora[] hora = new Ej1Hora[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Introduzca el intervalo termporal, hora y minutos y luego otra vez hora y minutos");
			hora[i] = new Ej1Hora(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			hora[i].Comparar(madrugada, maniana, tarde, noche);
		}
		sc.close();

	}
}
