package codigosfuente;

public class Escalera {
	public static void main(String[] args) {
		int[] cartas=new int[899];
		int a=2;
		llenar(cartas);
		imprimir(cartas);
		escalera(cartas);
		suma(a);
		System.out.println("\n"+a);
		ordenar(cartas);
	}
	public static void suma(int b) {
		b++;
	}
	public static void llenar(int[] a) {
		for(int i=0; i<a.length;i++) {
			a[i]=(int)(Math.random()*1200)+1;
		}
	}
	public static void imprimir(int[] a) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void ordenar(int[] a) {
		int aux;
		for(int i=0;i<a.length;i++) {
			for(int j=1;j<a.length-i;j++) {
				if(a[j-1]>a[j]) {
					aux=a[j-1];
					a[j-1]=a[j];
					a[j]=aux;
				}
			}
		}
		imprimir(a);
	}
	public static void escalera(int[] b) {
		int[] a=new int[b.length];
		System.arraycopy(b, 0, a, 0, b.length);
		for(int i=0; i<a.length;i++) {
			for(int j=0; j<a.length;j++) {
				for(int k=0; k<a.length;k++) {
					for(int l=0; l<a.length;l++) {
						if(a[i]+1==a[j]&&a[j]+1==a[k]&&a[k]+1==a[l]) {
							System.out.println("\nHay escalera del "+a[i]+" al "+a[l]);
							a[i]=-1;
							a[j]=-1;
							a[k]=-1;
							a[l]=-1;
						}
					}
				}
			}
		}
		ordenar(a);
		imprimir(a);
	}
}
