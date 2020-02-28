package Final;
public class Calendario {

    private Equipo[] equipos;
    private Partido[][] partidos;
    private int numPartidosJornada;
    private int numJornadasIda;

    public Calendario(int numEquipos) {
        equipos = new Equipo[numEquipos];
        numPartidosJornada = numEquipos / 2;
        numJornadasIda = numEquipos - 1;
        partidos = new Partido[numJornadasIda][numPartidosJornada];
    }

    public void introducirEquipos() {
        for (int i = 0; i < this.equipos.length; i++) {
            this.equipos[i] = new Equipo("Equipo_" + i);
        }
    }

    public void rotar(Equipo[] equipos) {
        Equipo aux;

        for (int i = 1; i < equipos.length - 1; i++) {
            aux = equipos[i];
            equipos[i] = equipos[i + 1];
            equipos[i + 1] = aux;
        }
    }

    public void generarCalendario() {

        Equipo[] equiposRotacion = new Equipo[equipos.length];
        System.arraycopy(equipos, 0, equiposRotacion, 0, equipos.length);

        for (int i = 0; i < numJornadasIda; i++) {
            for (int j = 0; j < numPartidosJornada; j++) {
                partidos[i][j] = new Partido(equiposRotacion[j], equiposRotacion[equiposRotacion.length - j - 1]);
            }
            rotar(equiposRotacion);
        }
    }

    public void imprimirCalendario() {

        System.out.println("\nCalendario de liga: ");
        for (int i = 0; i < numJornadasIda; i++) {
            System.out.println("Partidos jornada " + (
            i + 1));
            for (int j = 0; j < numPartidosJornada; j++) {
                if (partidos[i][j] != null) {
                    Partido p = partidos[i][j];
                    System.out.println("\t " + p.getEquipoLocal() + " vs. " + p.getEquipoVisitante());
                }
            }
        }
    }

    public static void main(String[] args) {

        Equipo equipo1 = new Equipo("Equipo_1");
        equipo1.entrenamiento();

        Equipo equipo2 = new Equipo("Equipo_2");
        equipo2.entrenamiento();

        Partido partido = new Partido(equipo1, equipo2);
        partido.jugarPartido();
        String resultado = partido.toString();
        System.out.println(resultado);

        Calendario calendarioLiga = new Calendario(6);
        calendarioLiga.introducirEquipos();
        calendarioLiga.generarCalendario();
        calendarioLiga.imprimirCalendario();
    }
}
