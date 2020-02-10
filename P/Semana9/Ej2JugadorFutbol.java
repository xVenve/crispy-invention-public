package Semana9;

public class Ej2JugadorFutbol {
	
	public String nombre;
	public String apellido;
	public int edad;
	public String posicion;
	public String equipo;
	
	public Ej2JugadorFutbol(String nombre, String apellido, int edad, String posicion, String equipo) {
		if(nombre=="") {
			this.nombre="Anonimo";
		}else {
			this.nombre = nombre;
		}
		this.apellido = apellido;
		
		this.edad = edad;
		if(edad<18||edad>40) {
			System.out.println("Edad no válida para jugar");
		}
		this.posicion = posicion;
		this.equipo = equipo;
	}
	
	public Ej2JugadorFutbol() {
	}
}
