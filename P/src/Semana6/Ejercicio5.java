package Semana6;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System. in);
        int enter, suma, n = 4, d;

        System.out.println("Indica el l�mite superior para generar n�meros perfectos y pulsa. Enter: ");
        enter = sc.nextInt();

        do {
            suma = 1;
            for (d = 2; d < n; d++) {

                if ((n % d) == 0) {
                    suma = suma + d;
                }

            }
            if (suma == n) {
                System.out.println("El n�mero " + n + " es perfecto");
            }
            n++;

        } while (enter >= n);
        sc.close();
    }

}
