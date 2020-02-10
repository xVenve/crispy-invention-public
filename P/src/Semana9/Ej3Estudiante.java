package Semana9;

public class Ej3Estudiante {
	public String nombre;
	public String apellido;
	public double programacion;
	public double algebra;
	public double calculo;
	public double fisica;
	public double escritura;
	public double informacion;
	
	public Ej3Estudiante(String nombre, String apellido, double programacion, double algebra, double calculo,
			double fisica, double escritura, double informacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		if(programacion>10||programacion<0) {
			this.programacion=0;
		}else{
			this.programacion = programacion;
		}
		if(algebra>10||algebra<0) {
			this.algebra=0;
		}else{
		this.algebra = algebra;
		}
		if(calculo>10||calculo<0) {
			this.calculo=0;
		}else{
		this.calculo = calculo;
		}
		if(fisica>10||fisica<0) {
			this.fisica=0;
		}else{
		this.fisica = fisica;
		}
		if(escritura>10||escritura<0) {
			this.escritura=0;
		}else{
		this.escritura = escritura;
		}
		if(informacion>10||informacion<0) {
			this.informacion=0;
		}else{
		this.informacion = informacion;
		}
	}
}
