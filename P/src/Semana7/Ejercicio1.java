package Semana7;

public class Ejercicio1 {

    public static void main(String[] args) {
        int[] a = {
            4,
            6,
            3,
            56
        };
        a[0] = a[3];
        System.out.println(a[0] + "  " + a[3]);
        a[3] = 20;
        System.out.println(a[0] + "  " + a[3]);
        //No cambia el primero, por que al igualar los dos elementos solo se copia el contenido no la direccion de memoria.
        a[0] = 30;
        System.out.println(a[0] + "  " + a[3]);
        //Tampoco cambia el valor del segundo al darle un nuevo valor al primero, por la misma razon de antes.

    }

}
