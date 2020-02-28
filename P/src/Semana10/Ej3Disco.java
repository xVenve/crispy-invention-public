package Semana10;
import java.util.Scanner;
public class Ej3Disco {
    public Ej3Cancion[] canciones; //n>0
    public String titulo;
    public int anio;
    public float precio; //anio>1877(era del sonido), precio>0
    public Ej3Grupo grupo;
    Scanner sc = new Scanner(System. in).useDelimiter(System.getProperty("line.separator"));
    public Ej3Disco(String titulo) {
        this.titulo = titulo;

        do {
            System.out.println("Introduzca el anio del lanzamiento(tiene que ser posterior a 1877(la era del sonido) y anterior a 2019)");
            anio = sc.nextInt();
        } while (anio < 1877 || anio > 2018);

        do {
            System.out.println("Introduzca el precio del disco(no puede ser negativo)");
            precio = sc.nextFloat();
        } while (precio < 0);

        int n;

        do {
            System.out.println("Cuantas canciones tiene el disco?(no puede ser menos de una)");
            n = sc.nextInt();
        } while (n < 1);
        canciones = new Ej3Cancion[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca el nombre de la cancion");
            canciones[i] = new Ej3Cancion(sc.next());
        }

        System.out.println("Introduce el nombre del grupo al que pertenece el disco");
        grupo = new Ej3Grupo(sc.next());
    }

}
