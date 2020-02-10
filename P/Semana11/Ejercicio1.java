package Semana11;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduzca el nombre, apellido, posicion, equipo y edad");
		Ej1JugadorFutbol Jugador1=new Ej1JugadorFutbol(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt());		
		System.out.println(Jugador1.getNombre()+" "+Jugador1.getApellido()+", "+Jugador1.getEdad());
		System.out.println(Jugador1.getPosicion()+" del "+Jugador1.getEquipo()+"\n");
		sc.close();

	}
}
