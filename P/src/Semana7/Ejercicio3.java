package Semana7;

public class Ejercicio3 {

    public static void main(String[] args) {
        String[][] anio = new String[12][];
        for (int i = 0; i < anio.length; i++) {
            switch (i) {
                case 1:
                    anio[i] = new String[28];
                    break;
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    anio[i] = new String[31];
                    break;
                default:
                    anio[i] = new String[30];
            }
        }
        anio[0][5] = "Hoy no hay clase";
        anio[9][19] = "Examen parcial";
        System.out.println("El n�mero de filas es " + anio.length);
        for (int i = 0; i < 12; i++) {
            System.out.println("El n�mero de columnas en la fila " + i + " es " + anio[i].length);
        }
    }

}
