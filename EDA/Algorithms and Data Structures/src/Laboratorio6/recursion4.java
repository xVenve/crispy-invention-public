package Laboratorio6;

/**
 * Método recursivo que toma un array de enteros y devuelve la suma de sus
 * elementos.
 *
 * @author xvenve
 */
public class recursion4 {
	/**
	 * Método recursivo que toma un array de enteros y devuelve la suma de sus
	 * elementos.
	 *
	 * @param A Array de enteros a sumar.
	 *
	 * @return Suma de los enteros que componene A
	 */
	public static int sumarray(int[] A) {
		return sumarray(A, A.length - 1);
	}

	/**
	 * Método auxiliar de sumarray
	 *
	 * @param A Array de enteros a sumar.
	 * @param i Posición del array a sumar
	 *
	 * @return Suma de los enteros que componene A
	 */
	private static int sumarray(int[] A, int i) {
		if (i == 0)
			return A[0];
		return A[i] + sumarray(A, i - 1);
	}

	public static void main(String[] args) {
		int[] X = new int[] { 3, 5, 9, 6, 3, 12 };
		System.out.print(sumarray(X));
	}
}
