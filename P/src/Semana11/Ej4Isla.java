package Semana11;

public class Ej4Isla {
	private String nombre;
	private float lat;
	private float alt;
	private String pais;
	private boolean habitada = true;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getAlt() {
		return alt;
	}

	public void setAlt(float alt) {
		this.alt = alt;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public boolean isHabitada() {
		return habitada;
	}

	public void setHabitada(boolean habitada) {
		this.habitada = habitada;
	}

	public Ej4Isla(String nombre, float lat, float alt, String pais) {
		setNombre(nombre);
		setLat(lat);
		setAlt(alt);
		setPais(pais);
	}
}
