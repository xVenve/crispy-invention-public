package Semana4;

public class Ejercicio6 {
    public static void main(String[] arg) {
        int a = 4;
        float b = 13.3 F;
        boolean c = false;
        a += 2; //Le suma a "a" 2.
        System.out.println(a);
        a -= 3; //Le resta a "a" 3.
        System.out.println(a);
        a *= 3; //Multiplica a "a" por 3.
        System.out.println(a);
        a /= 2; //Divide "a" entre 2. (El resultado es 4 debido a que redondea a números enteros)
        System.out.println(a);
        a %= 4; //"a" se transforma en el resto de la división 4%4=0.
        System.out.println(a);
        b /= 2; //Divide "b" entre 2.
        System.out.println(b);
        c &= true; //El operador de asignación compara el contenido de la variable con el valor 'true', al ser el primero 'false', el resultado es 'false'
        System.out.println(c);
        c |= true; //El operador de asignación compara el contenido de la variable con el valor 'true', al ser uno de los dos 'true', el resultado es 'true'
        System.out.println(c);
    }

}
