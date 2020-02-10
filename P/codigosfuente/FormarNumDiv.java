package codigosfuente;
import java.util.Scanner;
public class FormarNumDiv {

	public static void main(String[] args) {
		int numg=0, numi,div=1;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Num entre 0-9");
			numi=sc.nextInt();
			if(numi!=-1) {
				numg=numg+(numi*div);
				div=div*10;	
			}		
		}while(numi!=-1);
		System.out.print("El resultado es "+numg+"/7 = "+((double)numg/7));
	}

}
