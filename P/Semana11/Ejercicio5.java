package Semana11;

import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		sc.useDelimiter(System.getProperty("line.separator")); 
		System.out.println("Introduzca el nombre del disco");
		Ej5Disco disco=new Ej5Disco(sc.next());
		
		System.out.println("Disco: "+disco.getTitulo()+" ("+disco.getAnio()+") "+disco.getPrecio()+"€");
		System.out.println("Por: "+disco.getGrupo().getNombre()+" ("+disco.getGrupo().getCreacion()+")");
		for(int i=0;i<disco.getGrupo().getMiembros().length;i++) {
			System.out.println("\t"+ disco.getGrupo().getMiembros()[i].getNombre()+" ("+disco.getGrupo().getMiembros()[i].getNacimiento()+")");
		}
		System.out.println("Canciones:");
		for(int i=0;i<disco.getCanciones().length;i++) {
			System.out.println("\t"+ (i+1)+": "+disco.getCanciones()[i].getTitulo()+" ("+disco.getCanciones()[i].getDuracion()+" segundos)");
		}
		sc.close();
	}
}
