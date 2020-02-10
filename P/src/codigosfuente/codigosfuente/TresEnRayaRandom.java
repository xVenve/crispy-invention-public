package codigosfuente;

	import java.util.Scanner;
	import java.util.Random;

	public class TresEnRayaRandom {
		
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			int x,y,n=sc.nextInt();
			String[][] tablero=new String[n][n];
			for(int i=0; i<n;i++) {
				do {
					x=(int)(Math.random()*(n-1));
					y=(int)(Math.random()*(n-1));
				}while(tablero[x][y]=="X" || tablero[x][y]=="O");
				tablero[x][y]="X";
				do {
					x=(int)(Math.random()*(n-1));
					y=(int)(Math.random()*(n-1));
				}while(tablero[x][y]=="X" || tablero[x][y]=="O");
				tablero[x][y]="O";

					
			}
			for(int i=0; i<n;i++) {
				for(int j=0; j<n;j++) {
					if(tablero[i][j]==null)
						tablero[i][j]="b";
					System.out.print(tablero[i][j]+"  ");
				}
				System.out.print("\n");

			}

			
		}
	}

