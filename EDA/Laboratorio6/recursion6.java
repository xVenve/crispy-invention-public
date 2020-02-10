package Laboratorio6;

public class recursion6 {
	public static int minimarray(int[] A) {
		int a=A[A.length-1];
		return minimarray(A,A.length-2, a);
	}
	public static int minimarray(int[] A, int i,int m) {
		if(m>A[i]) m=A[i];
		if(i==0) return m;
		return minimarray(A,i-1,m);
	}
	public static void main(String[] args) {
		int[] X=new int[] {3,5,9,2,11,12};
		System.out.print(minimarray(X));
	}
}
