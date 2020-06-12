package codigosfuente;

public class TestWhile {

	public static void main(String[] args) {
		int mes = 1,
		random;
		while (mes <= 100) {
			random = (int)(Math.random() * 100) + 1;
			System.out.println(random);
			mes++;
		}

	}

}
