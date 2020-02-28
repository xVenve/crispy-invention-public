package Semana5;
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System. in);
        System.out.println("Introduzca su sueldo y a�os de antig�edad: ");
        double s = sc.nextDouble();
        int a = sc.nextInt();
        if (s < 500) {
            if (a < 10) {
                s = s * 1.05;
            } else {
                s = s * 1.2;
            }
        }
        System.out.println("Su sueldo es: " + s);
        sc.close();
    }

}
