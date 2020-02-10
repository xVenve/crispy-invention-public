package Semana7;
import java.util.Random;
public class Ejercicio4 {

	public static void main(String[] args) {
		//a
		String[] quiniela=new String[15];
		int n;
		for(int i=0;i<quiniela.length;i++) {
			n=(int)(Math.random()*3);
			if(n==0) {
				quiniela[i]="X";
			}else if(n==1) {
				quiniela[i]="1";
			}else{
				quiniela[i]="2";
			}
			System.out.print(quiniela[i]+"  ");
		}
		System.out.println("\n");
		//b
		String[][] quiniela2=new String[15][38];
		for(int j=0;j<quiniela2[0].length;j++) {
			for(int i=0;i<quiniela2.length;i++) {
				n=(int)(Math.random()*3);
				if(n==0) {
					quiniela2[i][j]="X";
				}else if(n==1) {
					quiniela2[i][j]="1";
				}else{
					quiniela2[i][j]="2";
				}
				System.out.print(quiniela2[i][j]+"  ");
			}
			System.out.println();
	}
	}
}
