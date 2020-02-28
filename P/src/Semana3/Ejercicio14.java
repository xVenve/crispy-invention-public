package Semana3;

public class Ejercicio14 {
    public static void main(String[] arg) {

        int a = 2147483647;
        a = a + 1;
        System.out.println(a);
        //Es posible imprimirlo, pero el valor devuelto por pantalla no corresponde al valor aritmetico de la
        //operacion, las operaciones se hacen dentro del rango del tipo, si se excede tanto por arriba como por
        //abajo el resultado tomara un valor incorrecto pero siempre dentro del rango.

        float b = 3.40282347E+38 f;
        b = b * 10;
        System.out.print(b);
        //Se va al infinito.

    }

}
