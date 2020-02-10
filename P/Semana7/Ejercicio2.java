package Semana7;

public class Ejercicio2 {

	public static void main(String[] args) {
		int[] a= {5,3,8,9};
		int[] b=a;
		a[0]=1;
		System.out.println(b[0]);
		//Si cambia el elemento, ya que al igualar el segundo array al primero copia su dirrecion
		b[2]=99;
		System.out.println(a[2]);
		//Si cambia, por que ambos arrays apuntan al mismo espacio de memoria
		int[] c= {55,33,22,44,88};
		int[] d= new int[5];
		System.arraycopy(c, 0, d, 0, 5);
		c[0]=1;
		System.out.println(d[0]);
		//Con este codigo solo copia el contenido del array y no su direccion de memorio, por lo que ambas son independientes y el cambiar uno no influye en el otro.
		d[2]=99;
		System.out.println(c[2]);
	}

}
