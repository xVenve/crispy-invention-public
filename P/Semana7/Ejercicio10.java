package Semana7;
import java.util.Scanner;
public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Dimension de la matriz A");
		int[][] a= new int[sc.nextInt()][sc.nextInt()];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.println("Introduce el número de la posición "+i+" , "+j);
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("La matriz A es: ");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Dimension de la matriz B");
		int[][] b= new int[sc.nextInt()][sc.nextInt()];
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				System.out.println("Introduce el número de la posición "+i+" , "+j);
				b[i][j]=sc.nextInt();
			}
		}
		System.out.println("La matriz B es: ");
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}for(int l=0;l<a.length;l++) {
			for(int k=0;k<a[0].length;k++) {
				for(int i=0;i<b.length;i++) {
					for(int j=0;j<b[0].length;j++) {
						if(b[i][j]==a[l][k]) {
							System.out.println("El elemento "+b[i][j]+" esta incluido en ambas matrices");
						}
					}
				}
			}
		}
		sc.close();

	}

}
