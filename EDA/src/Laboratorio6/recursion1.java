package Laboratorio6;

/**
 * Método recursivo que devuelve la suma de los N primeros enteros
 * 
 * @author xvenve
 */
public class recursion1 {
	
	/**
	 * Método recursivo que devuelve la suma de los N primeros enteros
	 * 
	 * @param n Número de comienzo de la suma
	 * 
	 * @return int Suma de los n primeros enteros
	 */
	public static int sumaN(int n) {
		if(n==1) return 1;
		return n+sumaN(n-1);
	}

	public static void main(String[] args) {
		System.out.print(sumaN(5));
	}
}
