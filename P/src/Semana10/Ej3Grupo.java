package Semana10;
import java.util.Scanner;
public class Ej3Grupo {
    public String nombre;
    public int creacion; //anio>1800
    public Ej3Persona[] miembros; //n>0
    Scanner sc = new Scanner(System. in).useDelimiter(System.getProperty("line.separator"));
    public Ej3Grupo(String nombre) {
        this.nombre = nombre;

        do {
            System.out.println("Introduzca el anio de creacion (tiene que ser posterior a 1800 y anterior a 2019)");
            creacion = sc.nextInt();
        } while (creacion < 1800 || creacion > 2018);

        int n;

        do {
            System.out.println("De cuantos miembros esta compuesto el grupo?");
            n = sc.nextInt();
        } while (n < 1);
        miembros = new Ej3Persona[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Introduzca el nombre del miembro");
            miembros[i] = new Ej3Persona(sc.next());
        }
    }

}
