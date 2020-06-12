package Laboratorio1;

public interface iPolinomio {
	public int getDegree();
	public int getCoeficient(int n);
	public void setCoeficient(int n, int newValue);
	public int getValue(int x);
	public iPolinomio suma(iPolinomio p);
	public void show();
}
