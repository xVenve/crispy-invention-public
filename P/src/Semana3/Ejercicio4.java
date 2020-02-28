package Semana3;

public class Ejercicio4 {
    public static void main(String[] arg) {
        /*final int a=8;
		a=6;
		System.out.print(a);
		*/

        //El valor de la variable "a" no cambia, porque al declarar la variable "a" de tipo int le hemos asignado
        //el modificador "final" y un valor inicial.

        final int b;
        b = 5;
        System.out.print(b);
        //Sí funciona, porque no habiamos asignado un valor inicial.
        //b=20;
        System.out.print(b);
        //Al igual que en la primera prueba, tras asignarle un valor a una variable con el modificador "final"
        //es imposible cambiarlo.

    }

}
