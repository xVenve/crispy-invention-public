package Laboratorio6;

public class recursion5 {
	public static boolean arrayorden(int[] A) {
		
		return arrayorden(A,A.length-1);
	}
	public static boolean arrayorden(int[] A, int i) {
		if(i==0) return true;
		return (A[i-1]<A[i])==arrayorden(A,i-1);
	}
	public static void main(String[] args) {
		int[] X=new int[] {3,5,9,10,11,12};
		System.out.print(arrayorden(X));
	}
}
