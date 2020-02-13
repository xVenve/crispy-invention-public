package Semana5;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el a�os que desea saber si es bisiesto y el a�o actual: ");
		int b=sc.nextInt();
		int a=sc.nextInt();
		if(b%4==0) {
			if(b%100==0) {
				if(b%400==0) {
					if(b<=a) {
						System.out.println(b+" fue bisiesto.");
					}else {
						System.out.println(b+" ser� bisiesto.");
					}
				}else {
					if(b<=a) {
						System.out.println(b+" no fue bisiesto.");
					}else {
						System.out.println(b+" no ser� bisiesto.");
					}					
				}
			}else {
				if(b<=a) {
					System.out.println(b+" fue bisiesto.");
				}else {
					System.out.println(b+" ser� bisiesto.");
				}
			}
		}else {
			if(b<=a) {
				System.out.println(b+" no fue bisiesto.");
			}else {
				System.out.println(b+" no ser� bisiesto.");
			}
		}
		sc.close();

	}

}
