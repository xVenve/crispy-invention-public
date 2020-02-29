package Semana11;

public class Ej4Pasajero {
	private String nombre;
	private String apellidos;
	private String iden;
	private String billete;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getIden() {
		return iden;
	}

	public void setIden(String iden) {
		this.iden = iden;
	}

	public String getBillete() {
		return billete;
	}

	public void setBillete(String billete) {
		this.billete = billete;
	}

	public Ej4Pasajero(String nombre, String apellidos, String iden, String billete) {
		setNombre(nombre);
		setApellidos(apellidos);
		setIden(iden);
		setBillete(billete);
	}
}
