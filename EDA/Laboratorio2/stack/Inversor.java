package Laboratorio2.stack;

import java.util.Scanner;

public class Inversor {
	public static String Invertir(String A) {
		SStack P= new SStack();
		for(int i=0; i<A.length();i++) {
			P.push(A.toUpperCase().charAt(i));
		}
		String B="";
		for(int i=0; i<A.length();i++) {
			B+=P.pop();
		}
		return B;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce la palabra a invertir");
		String A=sc.next();
		A=Invertir(A);
		System.out.println(A);
		sc.close();
	}

}
