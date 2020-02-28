package codigosfuente;
import java.util.Scanner;
public class CambioDeDivisa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System. in);
        int dol;
        double cambio;
        String moneda;
        System.out.print("Pais: ");
        String pais = sc.nextLine();
        System.out.print("Dolares: ");
        dol = sc.nextInt();

        switch (pais.toLowerCase()) {
            case "espa�a":
                cambio = 1.12;
                moneda = "Euros";
                break;
            case "francia":
                cambio = 1.12;
                moneda = "Euros";
                break;
            case "italia":
                cambio = 1.12;
                moneda = "Euros";
                break;
            case "inglaterra":
                cambio = 1.54;
                moneda = "Libras";
                break;
            case "suiza":
                cambio = 1.02;
                moneda = "Francos";
                break;
            default:
                cambio = 1;
                moneda = "Dolares";
        }

        System.out.print("Cambio: " + (
        dol / cambio) + " " + moneda);
        sc.close();
    }
}
