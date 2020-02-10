package Laboratorio6;

public class recursion4 {
	public static int sumarray(int[] A) {
		return sumarray(A,A.length-1);
	}
	public static int sumarray(int[] A, int i) {
		if(i==0) return A[0];
		return A[i]+sumarray(A,i-1);
	}
	public static void main(String[] args) {
		int[] X=new int[] {3,5,9,6,3,12};
		System.out.print(sumarray(X));
	}
}
