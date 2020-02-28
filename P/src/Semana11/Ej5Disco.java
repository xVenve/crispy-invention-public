package Semana11;
import java.util.Scanner;

public class Ej5Disco {
    private Ej5Cancion[] canciones; //n>0
    private String titulo;
    private int anio;
    private float precio; //anio>1877(era del sonido), precio>0
    private Ej5Grupo grupo;
    Scanner sc = new Scanner(System. in).useDelimiter(System.getProperty("line.separator"));

    public Ej5Cancion[] getCanciones() {
        return canciones;
    }

    public void setCanciones(Ej5Cancion[] canciones) {
        this.canciones = canciones;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Ej5Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Ej5Grupo grupo) {
        this.grupo = grupo;
    }

    public Ej5Disco(String titulo) {
        setTitulo(titulo);

        do {
            System.out.println("Introduzca el anio del lanzamiento(tiene que ser posterior a 1877(la era del sonido) y anterior a 2019)");
            setAnio(sc.nextInt());
        } while (getAnio() < 1877 || getAnio() > 2018);

        do {
            System.out.println("Introduzca el precio del disco(no puede ser negativo)");
            setPrecio(sc.nextFloat());
        } while (getPrecio() < 0);

        int n;

        do {
            System.out.println("Cuantas canciones tiene el disco?(no puede ser menos de una)");
            n = sc.nextInt();
        } while (n < 1);
        setCanciones(new Ej5Cancion[n]);
        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca el nombre de la cancion");
            canciones[i] = new Ej5Cancion(sc.next());
        }

        System.out.println("Introduce el nombre del grupo al que pertenece el disco");
        grupo = new Ej5Grupo(sc.next());
    }

}
