package Semana10;
import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System. in);
        System.out.println("Introduce los datos de la isla de origen, nombre, latitud, altitud y pais al que pertenece");
        Ej2Isla origen = new Ej2Isla(sc.next(), sc.nextFloat(), sc.nextFloat(), sc.next());
        System.out.println("Introduce los datos de la isla de destino, nombre, latitud, altitud y pais al que pertenece");
        Ej2Isla destino = new Ej2Isla(sc.next(), sc.nextFloat(), sc.nextFloat(), sc.next());
        System.out.println("Introduce los datos del avion que viajara de " + origen.nombre + " a " + destino.nombre + ":");
        System.out.println("Numero del avion, numero de asientos, estado(puntual, retrasado o cancelado) y compa�ia");
        Ej2Avion avion = new Ej2Avion(sc.next(), sc.nextInt(), sc.next(), origen, destino, sc.next());
        avion.pasajeros = new Ej2Pasajero[avion.asientos];
        for (int i = 0; i < avion.asientos && i < 3; i++) {
            System.out.println("Introduzca los datos del pasajero, nombre, apellido e identficador");
            avion.pasajeros[i] = new Ej2Pasajero(sc.next(), sc.next(), sc.next(), avion.numero);
        }
        System.out.print("Ya han sido asignados todos los datos");
        sc.close();
    }
}
