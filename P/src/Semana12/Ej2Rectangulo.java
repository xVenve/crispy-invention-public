package Semana12;
import java.util.*;
public class Ej2Rectangulo {
	private int base, altura;
	private boolean cuadrado;
	Scanner sc=new Scanner(System.in);
	
	public boolean isCuadrado() {
		return cuadrado;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		while(base<0){
			System.out.println("Introduzca una base correcta");
			base=sc.nextInt();
		};
		this.base = base;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		while(altura<0){
			System.out.println("Introduzca una altura correcta");
			altura=sc.nextInt();
		};
		this.altura = altura;
	}
	public Ej2Rectangulo(int base, int altura) {
		setBase(base);
		setAltura(altura);
		cuadrado=altura==base;
	}
	public Ej2Rectangulo(int base) {
		setBase(base);
		setAltura(base);
		cuadrado=true;
	}
	public String toString() {
		String forma;
		if(cuadrado) {
			forma="cuadrado";
		}else {
			forma="rectangulo";
		}
		return("Un "+forma+" de base "+getBase()+" y altura "+ getAltura());
	}
	public boolean equals(Ej2Rectangulo R1, Ej2Rectangulo R2) {
		boolean r;
		if(R1.base==R2.base&&R1.altura==R2.altura) {
			r= true;
		}else if(R1.base==R2.altura&&R1.altura==R2.base) {
			r= true;
		}else {
			r=false;
		}
		return r;
	}
	public int perimetro(Ej2Rectangulo R) {
		return (2*R.base+2*R.altura);
		
	}
	public int area(Ej2Rectangulo R) {
		return (R.base*R.altura);
	}
	public int mayor(Ej2Rectangulo R) {
		int m;
		if(R.base>R.altura) {
			m=R.base;
		}else {
			m=R.altura;
		}
		return m;
	}
	public boolean cuadrar(Ej2Rectangulo R) {
	boolean m;
		if(R.base>R.altura) {
			m=false;
			altura=base;
		}else {
			m=true;
			base=altura;
		}
		return m;
	}
}
