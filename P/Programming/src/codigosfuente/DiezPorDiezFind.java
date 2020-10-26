package codigosfuente;

public class DiezPorDiezFind {
	// Sin acabar
	public static void main(String[] args) {
		String[][] caja = new String[10][10];
		int cxx, cxy, cyx, cyy;
		int ax = (int) (Math.random() * 10);
		int ay = (int) (Math.random() * 10);
		int bx = (int) (Math.random() * 10);
		int by = (int) (Math.random() * 10);
		if (ax <= bx) {
			if (ay > by && ax == bx) {
				caja[bx][by] = "X";
				cxx = bx;
				cxy = by;
			} else {
				caja[ax][ay] = "X";
				cxx = ax;
				cxy = ay;
			}
		} else {
			caja[bx][by] = "X";
			cxx = bx;
			cxy = by;

		}
		if (ax >= bx) {
			if (ay < by && ax == bx) {
				caja[bx][by] = "Y";
				cyx = bx;
				cyy = by;
			} else {
				caja[ax][ay] = "Y";
				cyx = ax;
				cyy = ay;
			}
		} else {
			caja[bx][by] = "Y";
			cyx = bx;
			cyy = by;
		}
		if (cxy < 9) {
			do {
				cxy++;
				caja[cxx][cxy] = "*";

			} while (cxy != cyy);
		}
		do {
			cxx++;
			caja[cxx][cxy] = "*";

		} while (cxx != cyx);

		for (int i = 0; i < caja.length; i++) {
			for (int j = 0; j < caja.length; j++) {
				if (caja[i][j] == null) {
					caja[i][j] = "_";
				}
				System.out.print(caja[i][j]);
			}
			System.out.print("\n");

		}

	}

}
