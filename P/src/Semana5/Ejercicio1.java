package Semana5;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduzca dos n�meros.");
		int a=sc.nextInt();
		int b=sc.nextInt();
		if(a>b) {
			System.out.print(a + " es mayor.");
		}else {
			if(a<b) {
				System.out.print(b + " es mayor.");
			}else {
				System.out.print("Son iguales.");
			}
		}
		sc.close();		
		
	}

}
