package Semana11;
import java.util.Scanner;

public class Ej5Cancion {
	private String titulo;
	private int duracion;// duracion>0
	private Scanner sc= new Scanner(System.in);
	
	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public Ej5Cancion(String titulo) {
		setTitulo(titulo);
		
		do {
				System.out.println("Introduzca la duracion de la cancion en segundos(tiene que ser mayor de 0)");
				setDuracion(sc.nextInt());
		}while (getDuracion()<1);
	}
	
}
