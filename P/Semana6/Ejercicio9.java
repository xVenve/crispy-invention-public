package Semana6;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
		
		int p=0,i=0,random,cant;
		Scanner sc=new Scanner(System.in);
		do {
			
			System.out.println("Escribe un numero entre 10 y 50, para calcular pares e impares:");
			cant=sc.nextInt();
			
		}while(cant<10 || cant >50);
		
		for(int n=1;n<=cant;n++) {
			random=(int)(Math.random()*100);
			p=random%2==0?p+1:p;
			i=random%2!=0?i+1:i;
		}
		System.out.println("Han salido "+p+" numeros pares y "+i+" numeros impares.");
		sc.close();
	}

}
