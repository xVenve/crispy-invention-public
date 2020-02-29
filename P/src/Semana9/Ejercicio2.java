package Semana9;
import java.util.Scanner;
public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		System.out.println("Introduzca el nombre, apellido, edad, posicion y equipo");
		Ej2JugadorFutbol Jugador1 = new Ej2JugadorFutbol(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.next(), sc.next());
		Ej2JugadorFutbol Jugador2 = new Ej2JugadorFutbol();
		Jugador2.nombre = Jugador1.nombre;
		Jugador2.apellido = Jugador1.apellido;
		Jugador2.edad = Jugador1.edad;
		Jugador2.posicion = Jugador1.posicion;
		Jugador2.equipo = Jugador1.equipo;
		Ej2JugadorFutbol Jugador3 = Jugador1;
		Jugador3.edad = 20;
		Jugador3.equipo = "Linares Deportivo";
		System.out.println(Jugador1.nombre + " " + Jugador1.apellido + ", " + Jugador1.edad);
		System.out.println(Jugador1.posicion + " del " + Jugador1.equipo + "\n");
		System.out.println(Jugador2.nombre + " " + Jugador2.apellido + ", " + Jugador2.edad);
		System.out.println(Jugador2.posicion + " del " + Jugador2.equipo + "\n");
		System.out.println(Jugador3.nombre + " " + Jugador3.apellido + ", " + Jugador3.edad);
		System.out.println(Jugador3.posicion + " del " + Jugador3.equipo);
		sc.close();

	}

}
