package Semana10;
import java.util.Scanner;
public class Ej3Persona {
	public String nombre;
	public int nacimiento;//anio>1800
	Scanner sc= new Scanner(System.in);
	public Ej3Persona(String nombre) {
		this.nombre = nombre;
		
		do {
			System.out.println("Introduzca su anio de nacimiento (tiene que ser posterior a 1800 y anterior a 2019)");
			nacimiento=sc.nextInt();
		}while (nacimiento<1800||nacimiento>2018);
	}
	
}
