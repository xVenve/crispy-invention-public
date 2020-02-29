package Semana10;
//import java.util.Random;
public class Ej2Avion {
	public String numero;
	public int asientos;
	public Ej2Pasajero[] pasajeros;
	public String estado;
	public Ej2Isla origen;
	public Ej2Isla destino;
	public String compania;

	public Ej2Avion(String numero, int asientos, String estado, Ej2Isla origen, Ej2Isla destino, String compania) {
		this.numero = numero;
		this.asientos = asientos;
		if (estado != "cancelado" && estado != "puntual" && estado != "retrasado") {
			int i = (int)(Math.random() * 3);
			if (i == 0) {
				estado = "puntual";
			} else if (i == 1) {
				estado = "retrasado";
			} else {
				estado = "cancelado";
			}
			System.out.println("El estado intoducido no es valido, se le ha asignado el siguiente valor: " + estado);
		}
		this.estado = estado;
		this.origen = origen;
		this.destino = destino;
		this.compania = compania;
	}

}
