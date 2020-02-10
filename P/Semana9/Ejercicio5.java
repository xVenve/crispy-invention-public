package Semana9;
import java.util.*;
public class Ejercicio5 {
	public static void main(String[]args){
		int anio;
		Scanner sc= new Scanner(System.in);
		System.out.println("Introduzca la asignatura y el cuatrimestre");
		Ej5Asignatura asig=new Ej5Asignatura(sc.next(),sc.next());
		System.out.println("Introduce el a�o en el que cursas la asignatura");
		anio=sc.nextInt();
		if(anio>2018||anio<2000) {
			anio=(int)(Math.random()*19+2000);
		}
		System.out.println("Cuantas clases de "+asig.nombre+" tienes en noviembre?");
		asig.fecha=new Ej5Fecha[sc.nextInt()];
		
		for(int i=0;i<asig.fecha.length;i++) {
			System.out.println("Introduce el d�a que tienes clase");
			asig.fecha[i]=new Ej5Fecha(sc.nextInt(), anio);
			if(asig.fecha[i].dia>30||asig.fecha[i].dia<1) {
				asig.fecha[i].dia=(int)(Math.random()*29+1);
			}
		}
		System.out.println("Asignatura: "+ asig.nombre);
		System.out.println("Cuatrimestre: "+ asig.cuatrimestre);
		System.out.println("Dias con clase: ");
		for(int i=0;i<asig.fecha.length;i++) {
			System.out.println(asig.fecha[i].dia+" de "+asig.fecha[i].mes+" de "+asig.fecha[i].anio);
		}
		sc.close();

	}
}
