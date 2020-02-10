package Semana11;
import java.util.Scanner;
public class Ej2estudiante {
	private String nombre;
	private String apellido;
	private double programacion;
	private double algebra;
	private double calculo;
	private double fisica;
	private double escritura;
	private double informacion;
	Scanner sc=new Scanner(System.in);
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getProgramacion() {
		return programacion;
	}
	public void setProgramacion(double programacion) {
		if (programacion<0||programacion>10) {
			System.out.println("La nota en programacion no es valida");
			programacion=comprobarnota(programacion);
		}
		this.programacion = programacion;
	}
	public double getAlgebra() {
		return algebra;
	}
	public void setAlgebra(double algebra) {
		if (algebra<0||algebra>10) {
			System.out.println("La nota en algebra no es valida");
			algebra=comprobarnota(algebra);
		}
		this.algebra = algebra;
	}
	public double getCalculo() {
		return calculo;
	}
	public void setCalculo(double calculo) {
		if (calculo<0||calculo>10) {
			System.out.println("La nota en calculo no es valida");
			calculo=comprobarnota(calculo);
		}
		this.calculo = calculo;
	}
	public double getFisica() {
		return fisica;
	}
	public void setFisica(double fisica) {
		if (fisica<0||fisica>10) {
			System.out.println("La nota en fisica no es valida");
			fisica=comprobarnota(fisica);
		}
		this.fisica = fisica;
	}
	public double getEscritura() {
		return escritura;
	}
	public void setEscritura(double escritura) {
		if (escritura<0||escritura>10) {
			System.out.println("La nota en escritura no es valida");
			escritura=comprobarnota(escritura);
		}
		this.escritura = escritura;
	}
	public double getInformacion() {
		return informacion;
	}
	public void setInformacion(double informacion) {
		if (informacion<0||informacion>10) {
			System.out.println("La nota en informacion no es valida");
			informacion=comprobarnota(informacion);
		}
		this.informacion = informacion;
	}
	
	public double comprobarnota(double nota) {
		do {
			System.out.println("Introduzca la nota: ");
			nota=sc.nextDouble();
		}while(nota<0||nota>10);
		return nota;
	}
	public Ej2estudiante(String nombre, String apellido, double programacion, double algebra, double calculo,
			double fisica, double escritura, double informacion) {
		
		setNombre(nombre);
		setApellido(apellido);
		setProgramacion(programacion);
		setAlgebra(algebra);
		setCalculo(calculo);
		setFisica(fisica);
		setEscritura(escritura);
		setInformacion(informacion);
	}
	
	
	
	
}
