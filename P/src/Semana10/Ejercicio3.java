package Semana10;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System. in);
        sc.useDelimiter(System.getProperty("line.separator"));
        System.out.println("Introduzca el nombre del disco");
        Ej3Disco disco = new Ej3Disco(sc.next());
        System.out.println("Disco: " + disco.titulo + " (" + disco.anio + ") " + disco.precio + "�");
        System.out.println("Por: " + disco.grupo.nombre + " (" + disco.grupo.creacion + ")");
        for (int i = 0; i < disco.grupo.miembros.length; i++) {
            System.out.println("\t" + disco.grupo.miembros[i].nombre + " (" + disco.grupo.miembros[i].nacimiento + ")");
        }
        System.out.println("Canciones:");
        for (int i = 0; i < disco.canciones.length; i++) {
            System.out.println("\t" + (
            i + 1) + ": " + disco.canciones[i].titulo + " (" + disco.canciones[i].duracion + " segundos)");
        }
        sc.close();

    } //Disco>Canciones;Disco>Grupo>Personas

}