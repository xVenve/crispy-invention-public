package Laboratorio6;

/**
 * Método recursivo que tome dos enteros, x y n,
 * y devuelve x power n.
 *
 * @author xvenve
 */
public class recursion2 {
    /**
	 * Método recursivo que tome dos enteros, x y n,
	 * y devuelve x power n.
	 *
	 * @param x Base de la potencia
	 * @param n Exponente
	 *
	 * @return x^n
	 */
    public static int potencia(int x, int n) {
        if (n == 0) 
            return 1;
        return x * potencia(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.print(potencia(2, 10));
    }

}
