package Laboratorio0;

public class Main {

	public static void main(String[] args) {
		Matriz H=new Matriz(2,2);
		Matriz J=new Matriz(2,2);
		J.MatrizRandom();
		H.MatrizRandom();
		H.Show();
		J.Show();
		H.Plus(J).Show();
		H.Minus(J).Show();
		if(!H.Equal(J)) {
			System.out.println("No igual");
			J.Transpose();
		}
		//H.MatrizIdentidad(3).Show();
	}

}
