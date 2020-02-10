package Semana11;
import java.util.Scanner;

public class Ej5Persona {
	private String nombre;
	private int nacimiento;//anio>1800
	Scanner sc= new Scanner(System.in);
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(int nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Ej5Persona(String nombre) {
		setNombre(nombre);
		
		do {
			System.out.println("Introduzca su anio de nacimiento (tiene que ser posterior a 1800 y anterior a 2019)");
			setNacimiento(sc.nextInt());
		}while (getNacimiento()<1800||getNacimiento()>2018);
	}
	
}
