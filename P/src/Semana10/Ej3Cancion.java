package Semana10;
import java.util.Scanner;
public class Ej3Cancion {
    public String titulo;
    public int duracion; // duracion>0
    public Scanner sc = new Scanner(System. in);
    public Ej3Cancion(String titulo) {
        this.titulo = titulo;

        do {
            System.out.println("Introduzca la duracion de la cancion en segundos(tiene que ser mayor de 0)");
            duracion = sc.nextInt();
        } while (duracion < 1);
    }

}
