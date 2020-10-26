package Semana9;

import java.util.Scanner;

//import java.util.Random;
public class Ej6Dado {
	public int suma = 0;
	public int repe = 0;
	public Scanner sc = new Scanner(System.in);
	public String nombre;
	public int tiradas;
	public int[] array;

	public Ej6Dado(String nombre, int tiradas) {
		this.nombre = nombre;
		if (tiradas <= 0) {
			Cambiartiradas();
		} else {
			this.tiradas = tiradas;
		}
		Rellenar(array, tiradas);
	}

	void Cambiartiradas() {
		do {
			System.out.println("Introduzca un valor positivo para las tiradas");
			this.tiradas = sc.nextInt();
		} while (tiradas <= 0);
	}

	void Rellenar(int[] array, int tiradas) {
		this.array = new int[tiradas];
		for (int i = 0; i < tiradas; i++) {
			this.array[i] = (int) (Math.random() * 6 + 1);
		}
	}

	int Repes() {
		int repeti2;
		for (int i = 6; i > 0; i--) {
			repeti2 = 0;
			for (int j = 0; j < tiradas; j++) {
				if (array[j] == i) {
					repeti2++;
				}
			}
			if (repe < repeti2) {
				repe = repeti2;
			}
		}
		return repe;
	}

	int Suma() {
		for (int j = 0; j < tiradas; j++) {
			suma += array[j];
		}
		return suma;
	}

	void Tiradas() {
		System.out.print("Las tiradas de " + nombre + " han sido: ");
		for (int j = 0; j < tiradas; j++) {
			System.out.print(array[j] + " ");
		}
		System.out.println();

	}

}
