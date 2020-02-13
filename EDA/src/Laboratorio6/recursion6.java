package Laboratorio6;

/**
 * Método recursivo que toma un array de enteros y devuelve el 
 * elemento más pequeño.
 * 
 * @author xvenve
 */
public class recursion6 {
	/**
	 * Método recursivo que toma un array de enteros y devuelve 
	 * el elemento más pequeño.
	 * 
	 * @param A Array en el que buscar
	 * 
	 * @return Valor mas pequeño del array
	 */
	public static int minimarray(int[] A) {
		int a=A[A.length-1];
		return minimarray(A,A.length-2, a);
	}
	/**
	 * Metodo auxiliar miniarray
	 * 
	 * @param A Array en el que buscar
	 * @param i Posicion a comprobar si contiene el menor
	 * @param m El menor valor encontrado que arrastramos
	 * 
	 * @return Valor mas pequeño del array
	 */
	private static int minimarray(int[] A, int i,int m) {
		if(m>A[i]) m=A[i];
		if(i==0) return m;
		return minimarray(A,i-1,m);
	}
	public static void main(String[] args) {
		int[] X=new int[] {3,5,9,2,11,12};
		System.out.print(minimarray(X));
	}
}
