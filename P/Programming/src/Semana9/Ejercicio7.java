package Semana9;
import java.util.Scanner;
public class Ejercicio7 {
	public static void main(String[] args) {
		boolean F;
		int Numprod = 0;
		String Busqueda;
		Ej7Array Produc = new Ej7Array();
		Produc.Productos = new Ej7Productos[10];
		Scanner sc = new Scanner(System. in);
		int op;
		do {
			System.out.println(
				"Seleccione opcion \n1. Añadir producto \n2. Buscar producto \n3. Modificar stock y precio \n4. Salir"
			);
			op = sc.nextInt();
			switch (op) {
				case 1:
					if (Numprod < 10) {
						System.out.println("Introduzca el nombre del producto, su precio y su cantidad en stock");
						Produc.Productos[Numprod] = new Ej7Productos(sc.next(), sc.nextFloat(), sc.nextInt());
						Numprod++;
					} else {
						System.out.println("Ya se han anadido el numero maximo de productos");
					}
					break;

				case 2:
					System.out.println("Introduzca el nombre del producto");
					Busqueda = sc.next();
					F = true;
					for (int i = 0; i < Numprod; i++) {
						if (Busqueda == Produc.Productos[i].nombre) {
							System.out.println("El precio es " + Produc.Productos[i].precio);
							System.out.println("Hay " + Produc.Productos[i].stock + " unidades\n");
							F = false;
						}
					}
					if (F) {
						System.out.println("El producto no esta en stock\n");
					}
					break;
				case 3:
					System.out.println("Introduzca el nombre del producto");
					Busqueda = sc.next();
					F = true;
					for (int i = 0; i < Numprod; i++) {
						if (Busqueda == Produc.Productos[i].nombre) {
							System.out.println("Introduce el nuevo precio");
							Produc.Productos[i].precio = sc.nextFloat();
							System.out.println("Introduce la cantidad de unidades");
							Produc.Productos[i].stock = sc.nextInt();
							F = false;
						}
					}
					if (F) {
						System.out.println("El producto no esta en stock, anadelo con la opcion anadir");
					}
					break;
			}
		} while (op != 4);
		System.out.println("Gracias por usar el programa");
		sc.close();

	}

}
