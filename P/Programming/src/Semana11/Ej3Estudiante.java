package Semana11;
import java.util.Scanner;
public class Ej3Estudiante {
	private String nombre;
	private String apellido;
	private double[] notas = new double[6];
	Scanner sc = new Scanner(System. in);

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
		return notas[0];
	}
	public void setProgramacion(double programacion) {
		if (programacion < 0 || programacion > 10) {
			System.out.println("La nota en programacion no es valida");
			programacion = comprobarnota(programacion);
		}
		notas[0] = programacion;
	}
	public double getAlgebra() {
		return notas[1];
	}
	public void setAlgebra(double algebra) {
		if (algebra < 0 || algebra > 10) {
			System.out.println("La nota en algebra no es valida");
			algebra = comprobarnota(algebra);
		}
		notas[1] = algebra;
	}
	public double getCalculo() {
		return notas[2];
	}
	public void setCalculo(double calculo) {
		if (calculo < 0 || calculo > 10) {
			System.out.println("La nota en calculo no es valida");
			calculo = comprobarnota(calculo);
		}
		notas[2] = calculo;
	}
	public double getFisica() {
		return notas[3];
	}
	public void setFisica(double fisica) {
		if (fisica < 0 || fisica > 10) {
			System.out.println("La nota en fisica no es valida");
			fisica = comprobarnota(fisica);
		}
		notas[3] = fisica;
	}
	public double getEscritura() {
		return notas[4];
	}
	public void setEscritura(double escritura) {
		if (escritura < 0 || escritura > 10) {
			System.out.println("La nota en escritura no es valida");
			escritura = comprobarnota(escritura);
		}
		notas[4] = escritura;
	}
	public double getInformacion() {
		return notas[5];
	}
	public void setInformacion(double informacion) {
		if (informacion < 0 || informacion > 10) {
			System.out.println("La nota en informacion no es valida");
			informacion = comprobarnota(informacion);
		}
		notas[5] = informacion;
	}

	public double comprobarnota(double nota) {
		do {
			System.out.println("Introduzca la nota: ");
			nota = sc.nextDouble();
		} while (nota < 0 || nota > 10);
		return nota;
	}
	public Ej3Estudiante(
		String nombre,
		String apellido,
		double programacion,
		double algebra,
		double calculo,
		double fisica,
		double escritura,
		double informacion
	) {

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
