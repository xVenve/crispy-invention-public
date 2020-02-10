package Semana12;
import java.util.Scanner;
public class Ej1Persona {	
	private String nombre;
	private int edad;
	private int DNI;
	private char letraDNI;
	private String sexo;
	private float peso;
	private float altura;
	private char[] letras=new char[]{'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	Scanner sc=new Scanner(System.in);
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		while(edad<=0){
			System.out.println("Introduzca una edad correcta");
			edad=sc.nextInt();
		};
		this.edad = edad;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		while(dNI>=99999999||dNI<0) {
			System.out.println("Introduzca un número de DNI correcto");
			dNI=sc.nextInt();
		};
		DNI = dNI;	
		calcularLetraDni();
	}
	public char getLetraDNI() {
		return letraDNI;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		while(!sexo.equals("Hombre")&&!sexo.equals("Mujer")){
			System.out.println("Introduzca uno de estos dos sexos 'Hombre' o 'Mujer'");
			sexo=sc.next();
		};
		this.sexo = sexo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		while(peso<0){
			System.out.println("Introduzca un peso correcto");
			peso=sc.nextFloat();
		};
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		while(altura<0){
			System.out.println("Introduzca una altura correcta");
			altura=sc.nextFloat();
		};
		this.altura = altura;
	}
	private void calcularLetraDni() {
			letraDNI=letras[DNI%23];
	}
	public Ej1Persona(String nombre, int edad, int dNI, String sexo, float peso, float altura) {
		this.nombre = nombre;
		setEdad(edad);
		setDNI(dNI);
		setSexo(sexo);
		setPeso(peso);
		setAltura(altura);
	}
	public Ej1Persona() {
		sexo="Mujer";
	}
	public String toString() {
		
		return ("Información personal:\r\n" + 
				"Nombre: " +getNombre()+"\r\n" + 
				"Sexo: "+getSexo() +"\r\n" + 
				"Edad: "+getEdad()+" anios\r\n" + 
				"DNI: "+getDNI()+"-"+getLetraDNI()+"\r\n" + 
				"Peso: "+getPeso()+" kg\r\n" + 
				"Altura: "+getAltura()+" cm");
	}

}
