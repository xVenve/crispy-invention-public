package Semana4;
import java.util.Scanner;
public class Ejercicio12 {

	public static void main(String[] args) {
		
		Scanner tec=new Scanner(System.in);
		System.out.print("Introduzca la cantidad a depositar: ");
		float Ci= tec.nextFloat();
		System.out.print("Introduzca el interés anual: ");
		float i= tec.nextFloat();
		System.out.print("Introduzca el tiempo en años: ");
		int n= tec.nextInt();
		float Cf;
		
		Cf= Ci*(1+i*(float)n);
		System.out.println("Interés simple: "+ Cf);
		Cf= Ci*(float)Math.pow((1+i),n);
		System.out.println("Interés compuesto: "+ Cf);
		tec.close();


	}

}
