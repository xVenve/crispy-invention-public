package codigosfuente;
import java.util.Scanner;
public class MatrizIrregular {
    public static void main(String[] args) {
        //Creamos solamente las filas del array
        float[][] matriz = new float[20][];
        Scanner sc = new Scanner(System. in);
        for (int ii = 0; ii < 20; ii++) {
            System.out.println("Introduce el n�mero de elementos de la fila " + ii);
            int ele = sc.nextInt();
            if (ele < 2) {
                System.out.println("Hacen falta al menos 2 elementos");
                ele = 10;
            }
            matriz[ii] = new float[ele];
        }
        //Rellenamos el array y lo imprimimos a la vez
        for (int filas = 0; filas < matriz.length; filas++) {
            for (int cols = 0; cols < matriz[filas].length; cols++) {
                matriz[filas][cols] = 1.0 F;
                System.out.print(matriz[filas][cols] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
