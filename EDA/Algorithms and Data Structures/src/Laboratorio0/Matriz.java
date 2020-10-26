package Laboratorio0;

/**
 * Representa una matriz matemática de enteros y sus operaciones.
 *
 * @author xvenve
 */
public class Matriz {
	private int M;
	private int N;
	private int[][] data;

	public Matriz() {
	}

	/**
	 * Constructor de la matriz mxn de ceros
	 * 
	 * @param m Filas
	 * @param n Columnas
	 */
	public Matriz(int m, int n) {
		M = m;
		N = n;
		data = new int[M][N];
	}

	/**
	 * Rellena la matriz con valores comprendidos entre 0 y 10
	 */
	public void MatrizRandom() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = (int) (Math.random() * 11);
			}
		}
	}

	/**
	 * Imprime la matriz por pantalla
	 */
	public void Show() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Transpone la matriz que lo invoca
	 *
	 * @return Matriz transpuesta
	 */
	public Matriz Transpose() {
		Matriz T = new Matriz(N, M);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				T.data[j][i] = this.data[i][j];
			}
		}
		return T;
	}

	/**
	 * Suma la matriz que invoca con la pasada como parametro
	 *
	 * @param R Matriz a sumar
	 *
	 * @return Resultado de la suma de las matrices
	 */
	public Matriz Plus(Matriz R) {
		Matriz G = new Matriz();
		if (R.M == this.M && R.N == this.N) {
			G = new Matriz(M, N);
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					G.data[i][j] = this.data[i][j] + R.data[i][j];
				}
			}
		} else {
			System.out.println("No se pueden sumar");
		}
		return G;
	}

	/**
	 * Resta la matriz que invoca con la pasada como parametro
	 *
	 * @param R Matriz a restar
	 *
	 * @return Resultado de la resta de las matrices
	 */
	public Matriz Minus(Matriz R) {
		Matriz G = new Matriz();
		if (R.M == this.M && R.N == this.N) {
			G = new Matriz(M, N);
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					G.data[i][j] = this.data[i][j] - R.data[i][j];
				}
			}
		} else {
			System.out.println("No se pueden restar");
		}
		return G;
	}

	/**
	 * Comprueba si son iguales la matriz que invoca y la pasada por parametro
	 *
	 * @param R Matriz con la que comparar
	 *
	 * @return true Son iguales / false Son distintas
	 */
	public boolean Equal(Matriz R) {
		boolean G = true;
		if (R.M == this.M && R.N == this.N) {
			for (int i = 0; i < M && G; i++) {
				for (int j = 0; j < N && G; j++) {
					G = R.data[i][j] == this.data[i][j];
				}
			}
		} else {
			G = false;
		}
		return G;
	}

	/**
	 * Crea una matriz identidad de tamaño NxN
	 *
	 * @param N Dimension de la matriz
	 *
	 * @return Matriz identidad NxN
	 */
	public static Matriz MatrizIdentidad(int N) {
		Matriz I = new Matriz(N, N);
		for (int i = 0; i < N; i++) {
			I.data[i][i] = 1;
		}
		return I;
	}

	public static void main(String[] args) {
		Matriz H = new Matriz(2, 2);
		Matriz J = new Matriz(2, 2);
		J.MatrizRandom();
		H.MatrizRandom();
		H.Show();
		J.Show();
		H.Transpose().Show();
		H.Plus(J).Show();
		H.Minus(J).Show();
		if (!H.Equal(J)) {
			System.out.println("No igual");
		} else {
			System.out.println("Igual");
		}
		MatrizIdentidad(3).Show();

	}
}
