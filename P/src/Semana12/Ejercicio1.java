package Semana12;
import java.util.Scanner;
public class Ejercicio1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System. in);
		Ej1Persona Jesus = new Ej1Persona("Jesus", 23, 23123123, "Hombre", 131, 324);
		Ej1Persona Mujer = new Ej1Persona();
		System.out.println("Introduzca el nombre");
		Mujer.setNombre(sc.next());
		System.out.println("Introduzca la edad");
		Mujer.setEdad(sc.nextInt());
		System.out.println("Introduzca el numero de DNI");
		Mujer.setDNI(sc.nextInt());
		System.out.println("Introduzca el peso");
		Mujer.setPeso(sc.nextFloat());
		System.out.println("Introduzca la altura");
		Mujer.setAltura(sc.nextFloat());
		System.out.println("Introduzca el nombre, la edad y el numero de DNI");
		Ej1Persona Mujer2 = new Ej1Persona(sc.next(), sc.nextInt(), sc.nextInt(), "Mujer", 90, 185);
		System.out.println("Persona 1: \n" + Jesus.toString());
		System.out.println("Persona 2: \n" + Mujer.toString());
		System.out.println("Persona 3: \n" + Mujer2.toString());
		sc.close();
	}
}
