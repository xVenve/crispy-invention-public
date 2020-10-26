package Final;

public class Partido {

	private Equipo local;
	private Equipo visitante;
	private String resultado = "No disputado";

	public Partido(Equipo local, Equipo visitante) {
		this.local = local;
		this.visitante = visitante;
	}

	public String getEquipoLocal() {
		return this.local.getNombreEquipo();
	}

	public String getEquipoVisitante() {
		return this.visitante.getNombreEquipo();
	}

	public void jugarPartido() {

		int golesLocal = (int) (Math.random() * 3), golesVisitante = (int) (Math.random() * 3);

		if (local.getValoracionTop5() > visitante.getValoracionTop5()) {
			golesLocal++;
		} else {
			golesVisitante++;
		}

		if (golesLocal == golesVisitante) {
			this.resultado = "Empate";
		} else {
			this.resultado = golesLocal + "-" + golesVisitante;
		}
	}

	public String toString() {
		String s = this.local.toString() + "\n vs. " + this.visitante.toString() + "\n" + this.resultado;
		return s;
	}
}
