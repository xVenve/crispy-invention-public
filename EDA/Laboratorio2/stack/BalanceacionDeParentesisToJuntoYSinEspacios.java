package Laboratorio2.stack;

import java.util.Scanner;

public class BalanceacionDeParentesisToJuntoYSinEspacios {

	public static boolean Comprobacionamiento(String P) {
		SStack s=new SStack();
		boolean coincide=true;
		for(int i=0;i<P.length()&&coincide;i++) {
			if(P.charAt(i)=='['||P.charAt(i)=='('||P.charAt(i)=='{') {
				s.push(P.charAt(i));
			}
			if(s.isEmpty()) {
				coincide=false;
			}else if(P.charAt(i)==']'||P.charAt(i)==')'||P.charAt(i)=='}') {
				switch (P.charAt(i)) {
				case ']':
					if(s.peak.elem=='[') {
						s.pop();
					}else {
						coincide=false;
					}
					break;
				case ')':
					if(s.peak.elem=='(') {
						s.pop();
					}else {
						coincide=false;
					}
					break;
				case '}':
					if(s.peak.elem=='}') {
						s.pop();
					}else {
						coincide=false;
					}
					break;
				}
				
			}
			
		}
		return coincide&&s.size==0;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce la formula");
		String A=sc.next();
		if(Comprobacionamiento(A)) {
			System.out.println("Es cierto que los parentesis estan wenos");
		}else {
			System.out.println("Wrong way");
		}
		sc.close();
	}

}
