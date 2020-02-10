package Laboratorio1;

public class Sample implements iSample{
	double m[];
	int size;
	public Sample(int h) {
		m=new double[h];
		size=h;
	}
	public Sample() {
		m=new double[] {5,4,3.65,2,1};
		size=m.length;
	}
	public double getMax(){
		double l=0;
		for(int i=0; i<size; i++) {
			if(l<m[i]) {
				l=m[i];
			}
		}
		return l;
	}
	public double getMin(){
		double l=0;
		for(int i=0; i<size; i++) {
			if(l>m[i]) {
				l=m[i];
			}
		}
		return l;
	}
	public double sum(){
		double l=0;
		for(int i=0; i<size; i++) {
			l+=m[i];
		}
		return l;
	}
	public double mean(){
		double l=sum();
		return (l/size);
	}
	public double median() {
		//Por si acaso
		double[] aux=new double[size];
		double c=0;
		System.arraycopy(m, 0, aux, 0, size);
		for(int i=0; i<size; i++) {
			for(int j=1;j<size-i;j++) {
				if(aux[i-1]>aux[i]) {
					c=aux[i];
					aux[i]=aux[i-1];
					aux[i-1]=c;
				}
			}
		}
		return aux[size/2];
	}
	
	public static void main(System[] args) {
		Sample s=new Sample();
		System.out.println("Maximo "+s.getMax());
		System.out.println("Minimo "+s.getMin());
		System.out.println("Suma "+s.sum());
		System.out.println("Media "+s.mean());
		System.out.println("Mediana "+s.median());

	}
}
