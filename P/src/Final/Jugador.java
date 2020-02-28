package Final;
public class Jugador {

    private String nombre;
    private String posicion;
    private double habilidad;
    private final double MAX_HABILIDAD = 50;

    public Jugador(String nombre, String posicion, int habilidad) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.habilidad = habilidad;
    }

    public double getValoracion() {
        return this.habilidad;
    }

    public String getposicion() {
        return this.posicion;
    }

    public void incrementarValoracion() {
        if (this.habilidad < MAX_HABILIDAD) {
            if (this.posicion.equals("P")) {
                this.habilidad += 0.5;
            } else {
                this.habilidad++;
            }
        }
    }

    public String toString() {
        String s = this.nombre + " " + this.posicion + " " + this.habilidad;
        return s;
    }

}
