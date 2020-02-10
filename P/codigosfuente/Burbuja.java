package codigosfuente;

public class Burbuja {

	public static void main(String[] args) {
		int[] burb=new int[500];
		
		for(int i=0;i<burb.length;i++) {
			burb[i]=(int)(Math.random()*100);
		}
		int nocambia=0;
		for(int i=0;i<burb.length;i++) {
			for(int j=1;j<burb.length-i;j++) {
				if(burb[j]<burb[j-1]) {
					nocambia=0;
					int aux=burb[j-1];
					burb[j-1]=burb[j];
					burb[j]=aux;
				}else {
					nocambia++;
				}
				
				for(int h=0;h<burb.length;h++) {
					System.out.print(burb[h]+" ");
				}
				System.out.println();
			}
			if (nocambia>=burb.length) {
				break;
			}
		}

	}

}
