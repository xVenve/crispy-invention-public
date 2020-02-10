package Semana5;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("¿Cuantos años tienes?");
		int a=sc.nextInt();
		double b=9;
		
		if(a<5) {
			b=b*.4;
		}else if(a>5 && a<26) {
			b=b*.8;
		}else if(a>65) {
			b=b-b*.4;			
		}
		
		System.out.println("El precio es: "+b); 

	}

}
