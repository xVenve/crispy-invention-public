package Semana9;
import java.util.Scanner;
public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Ej1Telefono Nokia=new Ej1Telefono();
		System.out.println("Introduzca la marca de su telefono");
		Nokia.marca=sc.next();
		System.out.println("Introduzca el modelo de su telefono");
		Nokia.modelo=sc.next();
		System.out.println("Introduzca el año de su telefono");
		Nokia.anio=sc.nextInt();
		System.out.println("Su telefono es un "+Nokia.marca+" "+Nokia.modelo+" del anio "+Nokia.anio);
		sc.close();

	}

}
