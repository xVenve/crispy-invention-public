package Semana9;
import java.util.Scanner;

public class Ej4Triangulo {
	Scanner sc=new Scanner(System.in);
	public float base;
	public float altura;
	public Ej4Triangulo(float base, float altura) {
		if(base<=0) {
			Cambiarbase();
		}else {
			this.base = base;
		}
		if(altura<=0) {
			Cambiaralt();
		}else {
			this.altura = altura;
		}
		
	}
	void Cambiarbase() {
		do {
		System.out.println("Introduzca un valor positivo para la base");
		this.base=sc.nextFloat();
		}while(base<=0);
		
	}
	void Cambiaralt() {
		do {
		System.out.println("Introduzca un valor positivo para la altura");
		this.altura=sc.nextFloat();
		}while(altura<=0);
		
	}
	void area(float ba, float alt){
		System.out.println("El area es "+(ba*alt/2));
	}
	void perimetro(float ba, float alt) {
		float hip=(float)Math.sqrt((ba*ba)+(alt*alt));
		System.out.println("El perimetro es "+ (ba+alt+hip));
		
	}
	
	
}
