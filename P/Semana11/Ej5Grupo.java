package Semana11;
import java.util.Scanner;

public class Ej5Grupo {
	private String nombre;
	private int creacion;//anio>1800
	private Ej5Persona[] miembros;//n>0
	Scanner sc=new Scanner(System.in).useDelimiter(System.getProperty("line.separator"));
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreacion() {
		return creacion;
	}

	public void setCreacion(int creacion) {
		this.creacion = creacion;
	}

	public Ej5Persona[] getMiembros() {
		return miembros;
	}

	public void setMiembros(Ej5Persona[] miembros) {
		this.miembros = miembros;
	}

	public Ej5Grupo(String nombre) {
		setNombre(nombre);;
		
		do {
			System.out.println("Introduzca el anio de creacion (tiene que ser posterior a 1800 y anterior a 2019)");
			setCreacion(sc.nextInt());
		}while (getCreacion()<1800||getCreacion()>2018);
		
		int n;
		
		do {
			System.out.println("De cuantos miembros esta compuesto el grupo?");
			n=sc.nextInt();
		}while(n<1);
		setMiembros(new Ej5Persona[n]);
		
		for(int i=0;i<n;i++) {
			System.out.println("Introduzca el nombre del miembro");
			miembros[i]=new Ej5Persona(sc.next());
		}
	}
	
}
