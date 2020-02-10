package Semana7;
import java.util.*;
public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] a=new int[100];
		boolean b=false, b2=true;
		int c=0,r;
		do {
			do {
				b2=true;
				r=(int)((Math.random()*100)+1);
				for(int i=0;i<=c;i++) {
					if(a[i]==r) {
						b2=false;
					}
				}
			}while(!b2);
			a[c]=r;
			System.out.println("�Es tu numero el "+a[c]+"? (true/false)");
			b=sc.nextBoolean();
			c++;
			if (c==100) {
				b=true;
			}
		}while(!b);
		if(c!=100) {
			System.out.println("El numero de intentos fueron "+c);
		}else {
			System.out.println("�Estas mintiendo! �He intentado todos los n�meros!");
		}
	}

}
