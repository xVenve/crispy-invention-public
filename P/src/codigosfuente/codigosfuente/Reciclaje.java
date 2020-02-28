package codigosfuente;
import java.util.Scanner;
public class Reciclaje {
    enum Reciclaje2 {
        CASCARAS,
        BOTELLA,
        PERIODICO,
        BOTE,
        TETRABRICK,
        ZAPATO
    }
    public static void main(String[] args) {
        Scanner lee = new Scanner(System. in);
        System.out.println("Introduce el elemento");
        String s = lee.next();
        Reciclaje2 basura = Reciclaje2.valueOf(s);
        switch (basura) {
            case CASCARAS:
            case ZAPATO:
                System.out.println("No se recicla");
                break;
                //usamos el default para todo lo dem�s
            default:
                System.out.println("Se recicla");
        }
        lee.close();
    }
}
