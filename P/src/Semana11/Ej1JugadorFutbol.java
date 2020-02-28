package Semana11;
public class Ej1JugadorFutbol {
    private String nombre,
    apellido,
    posicion,
    equipo;
    private int edad;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        if (posicion.equals("portero") || posicion.equals("defensa") || posicion.equals("centrocampista") || posicion.equals("delantero")) {} else {
            int i = (int)(Math.random() * 4);
            switch (i) {
                case 0:
                    posicion = "portero";
                    break;
                case 1:
                    posicion = "defensa";
                    break;
                case 2:
                    posicion = "centrocampista";
                    break;
                case 3:
                    posicion = "delantero";
            }
        }
        this.posicion = posicion;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad < 16 || edad > 50) {
            edad = 25;
        }
        this.edad = edad;

    }
    public Ej1JugadorFutbol(String nombre, String apellido, String posicion, String equipo, int edad) {
        setNombre(nombre);
        setApellido(apellido);
        setPosicion(posicion);
        setEquipo(equipo);
        setEdad(edad);
    }

}
