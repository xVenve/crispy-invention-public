package Laboratorio6;

public class recursion1 {
	
	public static int sumaN(int n) {
		if(n==1) return 1;
		return n+sumaN(n-1);
	}

	public static void main(String[] args) {
		System.out.print(sumaN(5));
	}
}
