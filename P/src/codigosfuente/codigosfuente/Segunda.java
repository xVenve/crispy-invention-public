package codigosfuente;

public class Segunda {

	public static void main(String[] args) {

		CasaReal oStark = new CasaReal("Stark");
		oStark.sede = "Invernalia";
		String[][] asignarPosesion = new String[3][4];
		asignarPosesion[0][0] = "Fuego Valyrio";
		asignarPosesion[0][1] = "300";
		asignarPosesion[1][0] = "Veneno";
		asignarPosesion[1][1] = "20";
		asignarPosesion[2][0] = "Soldados";
		asignarPosesion[2][1] = "100";
		asignarPosesion[2][2] = "300";
		asignarPosesion[2][3] = "45";

		oStark.setPosesiones(asignarPosesion);

		CasaReal oLann = new CasaReal("Lannister");
		oLann.atacar("Stark", "Inmaculado", 40);
		System.out.println("Fin");

	}

}