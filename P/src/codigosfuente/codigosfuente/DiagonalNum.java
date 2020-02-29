package codigosfuente;

public class DiagonalNum {
	public static void main(String[] args) {
		int[][] cinco = new int[5][5];
		for (int i = 0; i < cinco.length; i++) {
			for (int j = 0; j < cinco.length; j++) {
				if (i == j) {
					cinco[i][j] = 1;
				}
				System.out.print(cinco[i][j] + "  ");
			}
			System.out.println("\n");
		}
	}

}
