package Semana6;

public class Ejercicio6 {
	public static void main(String[] args) {

		int a,
		b,
		c,
		v,
		aa = 0,
		bb = 0,
		cc = 0;
		for (v = 1; v <= 10; v++) {

			a = (int)(Math.random() * 2);
			b = (int)(Math.random() * 2);
			c = (int)(Math.random() * 2);
			System.out.println("El resultado de la tirada " + v + " es: ");
			if (a == 1) {
				System.out.println("El jugador 1 ha sacado CARA");
			} else {
				System.out.println("El jugador 1 ha sacado CRUZ");
			}
			if (b == 1) {
				System.out.println("El jugador 2 ha sacado CARA");
			} else {
				System.out.println("El jugador 2 ha sacado CRUZ");
			}
			if (c == 1) {
				System.out.println("El jugador 3 ha sacado CARA");
			} else {
				System.out.println("El jugador 3 ha sacado CRUZ");
			}

			if (a == b) {
				if (a == c) {
					System.out.println("Ha habido empate en la tirada " + v + "\n");
				} else {
					cc++;
					System.out.println("Ha ganado el jugador 3 en la tirada " + v + "\n");
				}
			} else if (a == c) {
				bb++;
				System.out.println("Ha ganado el jugador 2 en la tirada " + v + "\n");
			} else {
				aa++;
				System.out.println("Ha ganado el jugador 1 en la tirada " + v + "\n");
			}

			System.out.println("EL RESULTADO HASTA EL MOMENTO ES:");
			System.out.println("JUGADOR 1 -->" + aa + " PUNTOS");
			System.out.println("JUGADOR 2 -->" + bb + " PUNTOS");
			System.out.println("JUGADOR 3 -->" + cc + " PUNTOS\n");

		}
		if (aa >= bb) {
			if (aa >= cc) {
				if (aa == cc) {
					System.out.println(
						"LOS GANADORES FINALES HAN SIDO EL JUGADOR 1 CON " + aa + " PUNTOS Y EL JUGADOR 3 CON " + cc + " PUNTOS"
					);
				} else {
					if (aa == bb) {
						System.out.println(
							"LOS GANADORES FINALES HAN SIDO EL JUGADOR 1 CON " + aa + " PUNTOS Y EL JUGADOR 2 CON " + bb + " PUNTOS"
						);
					} else 
						System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 1 CON " + aa + " PUNTOS");
					}
				} else {
				System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 3 CON " + cc + " PUNTOS");
			}
		} else {
			if (bb >= cc) {
				if (bb == cc) {
					System.out.println(
						"LOS GANADORES FINALES HAN SIDO EL JUGADOR 2 CON " + bb + " PUNTOS Y EL JUGADOR 3 CON " + cc + " PUNTOS"
					);
				} else {
					System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 2 CON " + bb + " PUNTOS");
				}
			} else {
				System.out.println("EL GANADOR FINAL HA SIDO EL JUGADOR 3 CON " + cc + " PUNTOS");
			}
		}

	}

}
