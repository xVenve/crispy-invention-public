package Laboratorio6;

public class recursion3 {
	public static int digitos(int x) {
		if(x>10) {
			return  1+digitos(x/10);
		}else {
			return 1;			
		}
	}
	
	public static void main(String[] args) {
		System.out.print(digitos(3459893));
	}
}
