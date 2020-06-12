package Laboratorio6;

public class recursion7 {
	/**
	 * Método recursivo que toma un array de enteros y un entero y
	 * devuelve el índice de este entero en el array. Si el entero
	 * no existe en el array, el método devuelve -1.
	 *
	 * @param a Array en el que buscar el entero x
	 * @param x Valor del que deseamos conocer su posicion en el array
	 *
	 * @retun Indice del valor x en el array a. Y -1 si el array
	 * esta vacio o no se ha encontrado
	 */
	public static int find(int a[], int x) {
		if (a == null || a.length == 0) {
			System.out.println("Array vacio");
			return -1;
		}
		return find(a, x, 0);
	}
	/**
	 * Método auxiliar de find
	 *
	 * @param a Array en el que buscar el entero x
	 * @param x Valor del que deseamos conocer su posicion en el array
	 * @param pos Posicion del array a comprobar si contiene el valor x
	 *
	 * @retun Indice del valor x en el array a. Y -1 si el array
	 * esta vacio o no se ha encontrado
	 */
	private static int find(int a[], int x, int pos) {
		if (a[pos] == x) 
			return pos;
		
		if (pos == a.length - 1) 
			return -1;
		else 
			return find(a, x, pos + 1);

		}
	}
