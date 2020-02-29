package Semana11;

public class Ej4Avion {
	private String numero;
	private int asientos;
	private Ej4Pasajero[] pasajeros;
	private String estado;
	private Ej4Isla origen;
	private Ej4Isla destino;
	private String compania;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public Ej4Pasajero[] getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Ej4Pasajero[] pasajeros) {
		this.pasajeros = pasajeros;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Ej4Isla getOrigen() {
		return origen;
	}

	public void setOrigen(Ej4Isla origen) {
		this.origen = origen;
	}

	public Ej4Isla getDestino() {
		return destino;
	}

	public void setDestino(Ej4Isla destino) {
		this.destino = destino;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Ej4Avion(String numero, int asientos, String estado, Ej4Isla origen, Ej4Isla destino, String compania) {
		setNumero(numero);
		setAsientos(asientos);
		if (estado.equals("cancelado") || estado.equals("puntual") || estado.equals("retrasado")) {} else {
			int i = (int)(Math.random() * 3);
			if (i == 0) {
				estado = "puntual";
			} else if (i == 1) {
				estado = "retrasado";
			} else {
				estado = "cancelado";
			}
			System.out.println("El estado introducido no es valido, se le ha asignado el siguiente valor: " + estado);
		}
		setEstado(estado);
		setOrigen(origen);
		setDestino(destino);
		setCompania(compania);
	}

}
