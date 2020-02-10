package codigosfuente;

public class CasaReal {
	
	String nombre;
	
	public CasaReal(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	String sede;
	private int soldados;
	private int veneno;
	private String[][] Posesiones=new String[3][4];
	
	public void atacar(String nombre, String tipo, int bajas) {
	
		
	}

	public int getSoldados() {
		return soldados;
	}
	public void setSoldados(int soldados) {
		this.soldados = soldados;
	}
	public int getVeneno() {
		return veneno;
	}
	public void setVeneno(int veneno) {
		this.veneno = veneno;
	}
	public String[][] getPosesiones() {
		return Posesiones;
	}
	public void setPosesiones(String[][] posesiones) {
		Posesiones = posesiones;
	}
	

}
