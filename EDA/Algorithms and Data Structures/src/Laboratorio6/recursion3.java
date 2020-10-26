package Laboratorio6;

/**
 * Método recursivo que tome un número entero y devuelva el número de dígitos
 * que lo componen
 *
 * @author xvenve
 */
public class recursion3 {
	/**
	 * Método recursivo que tome un número entero y devuelva el número de dígitos
	 * que lo componen
	 *
	 * @param x Entero a determinar numero de digitos
	 *
	 * @return Numero de digitos que forman x
	 */
	public static int digitos(int x) {
		if (x > 10) {
			return 1 + digitos(x / 10);
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		System.out.print(digitos(3459893));
	}
}
