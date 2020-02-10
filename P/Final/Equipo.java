package Final;
public class Equipo {
	
	private String nombreEquipo;
	private Jugador[] jugadores;
	
	public Equipo(String nombre) {
		this.nombreEquipo = nombre;
		this.jugadores = new Jugador[10];
		this.jugadores[0] = new Jugador("jugador_"+0, "P", (int)(Math.random()*50+1));
		for (int i = 1; i < this.jugadores.length; i++){
			this.jugadores[i] = new Jugador("jugador_"+i, "J", (int)(Math.random()*50+1));
		}
	}
	
	public String getNombreEquipo(){
		return this.nombreEquipo;
	}

	public Jugador[] OrdenarSegunValoracion() {
		
		Jugador auxJugador;
		Jugador[] jugadoresOrdenado = new Jugador[jugadores.length];
		for (int i = 0; i < jugadores.length; i++){
			jugadoresOrdenado[i] = jugadores[i];
		} 
		
		for (int i = 1; i < jugadoresOrdenado.length; i++){
			for (int j = 0; j < jugadoresOrdenado.length-i; j++){
				if (jugadoresOrdenado[j].getValoracion() < jugadoresOrdenado[j+1].getValoracion()){
					auxJugador = jugadoresOrdenado[j+1];
					jugadoresOrdenado[j+1] = jugadoresOrdenado[j];
					jugadoresOrdenado[j] = auxJugador;
				}
			}
		}
		
		return jugadoresOrdenado;		
	}
	
	public double getValoracionTop5() {
		
		double valoracion = 0.0;
		Jugador[] jugadoresOrdenado = OrdenarSegunValoracion();
		int contador = 0, i = 0;
		
		while (contador < 5){
			if (jugadoresOrdenado[i].getposicion().equals("J")){
				valoracion += jugadoresOrdenado[i].getValoracion();
				contador++;
			}
			i++;
		}
		
		return valoracion;		
	}
	
	public void entrenamiento() {
		
		for (Jugador j: this.jugadores) {
			j.incrementarValoracion();
		}		
	}
	
	public String toString(){
		String s = this.nombreEquipo;
		for (int i = 0; i < jugadores.length; i++){
			s += "\n\t" + jugadores[i].toString();
		}
		return s;
	}

}
