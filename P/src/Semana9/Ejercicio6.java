package Semana9;import java.util.Scanner;
public class Ejercicio6 {
	public static void main(String[]args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Introduzca el nombre del jugador 1 y el número de tiradas");
	Ej6Dado Jug1= new Ej6Dado(sc.next(), sc.nextInt());
	System.out.println("Introduzca el nombre del jugador 2 y el número de tiradas");
	Ej6Dado Jug2= new Ej6Dado(sc.next(), sc.nextInt());
	Jug1.Tiradas();
	Jug2.Tiradas();
	if(Jug1.Repes()>Jug2.Repes()) {
		System.out.println("Ha ganado: "+ Jug1.nombre);
	}else if(Jug1.Repes()<Jug2.Repes()){
		System.out.println("Ha ganado: "+ Jug2.nombre);
	}else {
		System.out.println("Ha habido un empate por repeticiones, el ganador se decidira por la suma de sus tiradas");
		if(Jug1.Suma()>Jug2.Suma()) {
			System.out.println("Ha ganado: "+ Jug1.nombre);
		}else {
			System.out.println("Ha ganado: "+ Jug2.nombre);
		}
	}
	sc.close();

	}
}
