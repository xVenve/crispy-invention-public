package Semana12;
import java.util.Random;
public class Ejercicio2 {

	public static void main(String[] args) {
		Ej2Rectangulo[] R=new Ej2Rectangulo[(int)(Math.random()*1000)+10];
		for(int i=0;i<R.length;i++) {
			R[i]=new Ej2Rectangulo((int)(Math.random()*10)+1, (int)(Math.random()*10)+1);
		}
		System.out.println("Cuadrados: ");
		for(int i=0;i<R.length;i++) {
			if(R[i].isCuadrado()) {
				System.out.println(R[i].toString());
			}
		}
		System.out.println("Area maxima: ");
		for(int i=0;i<R.length;i++) {
			if(R[i].area(R[i])==100) {
				System.out.println(R[i].toString());
			}
		}
		System.out.println("Maximo perimetro:");
		for(int i=0;i<R.length;i++) {
			if(R[i].perimetro(R[i])==40) {
				System.out.println(R[i].toString());
			}
		}
		System.out.println("Maximo lado:");
		for(int i=0;i<R.length;i++) {
			if(R[i].getBase()==10||R[i].getAltura()==10) {
				System.out.println(R[i].toString());
				if(R[i].cuadrar(R[i])) {
					System.out.println("Se ha cambiado la base");
				}else {
					System.out.println("Se ha cambiado la altura");
				}
			}
		}
	}

}
