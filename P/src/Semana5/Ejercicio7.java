package Semana5;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca una coordenada (Primero x y después y): ");
		int x=sc.nextInt();
		int y=sc.nextInt();
		if(x>0) {
			if(y>0) {
				System.out.print("La coordenada introducida pertenece al 1º cuadrante.");
			}else {
				System.out.print("La coordenada introducida pertenece al 4º cuadrante.");
			}
		}else {
			if(y>0) {
				System.out.print("La coordenada introducida pertenece al 2º cuadrante.");
			}else {
				System.out.print("La coordenada introducida pertenece al 3º cuadrante.");

			}
		}

	}

}
