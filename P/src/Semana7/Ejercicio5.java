package Semana7;
import java.util. *;
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System. in);
        System.out.println("Introduzca la dimensi�n de su array");
        double[] a = new double[sc.nextInt()];
        int total = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random() * 49 + 1);
            total += a[i];
        }
        System.out.print("La suma de todos los elementos es " + total);
        sc.close();
    }
}
