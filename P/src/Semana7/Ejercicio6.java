package Semana7;
import java.util. *;
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System. in);
        int[] a = new int[20];
        int b;
        do {
            System.out.println("Introduzca un numero entre el 1 y el 9 ambos inclusive");
            b = sc.nextInt();
        } while (b < 1 || b > 9);
        for (int i = 0; i < 20; i++) {
            a[i] = (int)(Math.random() * 9 + 1);
            if (a[i] == b) {
                System.out.println("El numero " + b + " esta en la posicion " + i);
            } else {
                System.out.println("El numero " + b + " no esta en el array");
            }
        }
        sc.close();
    }
}
