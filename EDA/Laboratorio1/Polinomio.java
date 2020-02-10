package Laboratorio1;

import java.util.*;
public class Polinomio implements iPolinomio{
	int data[];
	public Polinomio() {
		
	}
	public Polinomio(int n) {
		Scanner sc=new Scanner(System.in);
		data= new int[n];
		for(int i=0;i<n;i++) {
			System.out.println("Introduzca el coeficiente de grado "+ i);
			setCoeficient(i, sc.nextInt());
		}
		sc.close();
	}
	public int getDegree() {
		return data.length;
	}
	
	public int getCoeficient(int n) {
		//if(n>=0&&n<data.length) {
			return data[n];
		//}
	//	return 0;
	}
	public void setCoeficient(int n, int newValue) {
		if(n>=0&&n<data.length) {
			data[n]= newValue;
		}
	}
	public int getValue(int x) {
		int value=0;
		for(int i=0;i<data.length;i++) {
			value+=data[i]*(int)Math.pow(x,i);
		}
		return value;
	}
	public iPolinomio suma(iPolinomio p) {
		Polinomio r=new Polinomio();
		if(p.getDegree()>=this.getDegree()) {
			r.data= new int[p.getDegree()];
		}else {
			r.data= new int[this.getDegree()];
		}
		for(int i=0;i<r.getDegree();i++) {
			if(p.getDegree()<=i) {
				r.data[i]=this.getCoeficient(i);
			}else if(this.getDegree()<=i) {
				r.data[i]=p.getCoeficient(i);
			}else {
				r.data[i]=p.getCoeficient(i)+this.getCoeficient(i);
			}
		}
		return r;
	}
	public void show(){
		for(int i=0;i<this.getDegree(); i++) {
			System.out.print(getCoeficient(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Polinomio a=new Polinomio(3);
		Polinomio b=new Polinomio(2);
		System.out.println("Grado: "+a.getDegree()+
				" Coeficiente 1º: "+a.getCoeficient(1)+
				" Valor para x con valor 2: "+a.getValue(2));
		a.show();
		//a.setCoeficient(0, 5);
		System.out.println("Grado: "+b.getDegree()+
				" Coeficiente 1º: "+b.getCoeficient(1)+
				" Valor para x con valor 2: "+b.getValue(2));
		b.show();
		//b.setCoeficient(0, 5);
		System.out.print("Suma: ");
		a.suma(b).show();
	}
}
