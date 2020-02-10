package Semana11;

import java.util.Scanner;
public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce los datos de la isla de origen, nombre, latitud, altitud y pais al que pertenece");
		Ej4Isla origen=new Ej4Isla(sc.next(), sc.nextFloat(), sc.nextFloat(), sc.next());
		
		System.out.println("Introduce los datos de la isla de destino, nombre, latitud, altitud y pais al que pertenece");
		Ej4Isla destino=new Ej4Isla(sc.next(), sc.nextFloat(), sc.nextFloat(), sc.next());
		
		System.out.println("Introduce los datos del avion que viajara de "+origen.getNombre()+" a "+destino.getNombre()+":");
		System.out.println("Numero del avion, numero de asientos, estado(puntual, retrasado o cancelado) y compañia");
		
		Ej4Avion avion=new Ej4Avion(sc.next(), sc.nextInt(), sc.next(), origen, destino, sc.next());
		avion.setPasajeros(new Ej4Pasajero[avion.getAsientos()]);
		for(int i=0; i<avion.getAsientos()&&i<3;i++) {
			System.out.println("Introduzca los datos del pasajero, nombre, apellido e identficador");
			avion.getPasajeros()[i]=new Ej4Pasajero(sc.next(), sc.next(), sc.next(), avion.getNumero());
		}
		System.out.print("Ya han sido asignados todos los datos");
		sc.close();
	}
}
