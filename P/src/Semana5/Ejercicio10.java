package Semana5;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca una cantidad de dinero: ");
		double c=sc.nextDouble();
		int b;
		
		c=c*100;
		int a=(int)c;
		
		if(a>=50000) {
			b=a/50000;
			a=a-b*50000;
			System.out.println("500�: "+ b);
		}
		if(a>=20000) {
			b=a/20000;
			a=a-b*20000;
			System.out.println("200�: "+ b);
		}
		if(a>=10000) {
			b=a/10000;
			a=a-b*10000;
			System.out.println("100�: "+ b);
		}
		if(a>=5000) {
			b=a/5000;
			a=a-b*5000;
			System.out.println("50�: "+ b);
		}
		if(a>=2000) {
			b=a/2000;
			a=a-b*2000;
			System.out.println("20�: "+ b);
		}
		if(a>=1000) {
			b=a/1000;
			a=a-b*1000;
			System.out.println("10�: "+ b);
		}
		if(a>=500) {
			b=a/500;
			a=a-b*500;
			System.out.println("5�: "+ b);
		}
		if(a>=200) {
			b=a/200;
			a=a-b*200;
			System.out.println("2�: "+ b);
		}
		if(a>=100) {
			b=a/100;
			a=a-b*100;
			System.out.println("1�: "+ b);
		}
		if(a>=50) {
			b=a/50;
			a=a-b*50;
			System.out.println("0.5�: "+ b);
		}
		if(a>=20) {
			b=a/20;
			a=a-b*20;
			System.out.println("0.2�: "+ b);
		}
		if(a>=10) {
			b=a/10;
			a=a-b*10;
			System.out.println("0.1�: "+ b);
		}
		if(a>=5) {
			b=a/5;
			a=a-b*5;
			System.out.println("0.05�: "+ b);
		}
		if(a>=2) {
			b=a/2;
			a=a-b*2;
			System.out.println("0.02�: "+ b);
		}
		if(a>=1) {
			b=a/1;
			System.out.println("0.01�: "+ b);
		}
		sc.close();
	}

}
