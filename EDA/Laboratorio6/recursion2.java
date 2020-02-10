package Laboratorio6;

public class recursion2 {
	public static int potencia(int x,int n) {
		if(n==0) return 1;
		return x*potencia(x,n-1);
	}
	
	public static void main(String[] args) {
		System.out.print(potencia(2,10));
	}

}
