package Laboratorio6;

/**
 * Método recursivo que tome un array de enteros
 * y compruebe si el array está ordenado (orden ascendente).
 *
 * @author xvenve
 */
public class recursion5 {
    /**
	 * Método recursivo que tome un array de enteros
	 * y compruebe si el array está ordenado (orden ascendente).
	 *
	 * @param A Array a comprobar
	 *
	 * @return 1 Ordenado / 0 Desordenado
	 */
    public static boolean arrayorden(int[] A) {

        return arrayorden(A, A.length - 1);
    }
    /**
	 * Método auxiliar de arrayorden
	 *
	 * @param A Array a comprobar
	 * @param i Posicion del array a comprobar orden
	 *
	 * @return 1 Ordenado / 0 Desordenado
	 */
    private static boolean arrayorden(int[] A, int i) {
        if (i == 0) 
            return true;
        return (A[i - 1] < A[i]) == arrayorden(A, i - 1);
    }
    public static void main(String[] args) {
        int[] X = new int[]{
            3,
            5,
            9,
            10,
            11,
            12
        };
        System.out.print(arrayorden(X));
    }
}
