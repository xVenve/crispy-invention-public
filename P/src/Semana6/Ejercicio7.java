package Semana6;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System. in);
        int suma;
        String luck;
        System.out.println("Introduce el a�o de nacimiento (4 d�gitos) y pulsa Enter ");
        suma = sc.nextInt();
        System.out.println("Introduce el mes en nacimiento y pulsa Enter");
        suma = suma + sc.nextInt();
        System.out.println("Introduce el dia de nacimiento y pulsa Enter");
        suma = suma + sc.nextInt();
        luck = Integer.toString(suma);
        suma = 0;
        for (int n = 0; n <= 3; n++) {

            suma = suma + luck.charAt(n) - 48;

        }

        System.out.println("Tu n�mero de la suerte es el " + suma);
        sc.close();
    }

}
