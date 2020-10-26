package codigosfuente;

public class A {
	private B obj = new B();

	public void show() {
		System.out.println(obj.getContenido());
	}

	public static void main(String args[]) {
		A objA = new A();
		objA.show();
	}

}
