package p2;

public class Laboratorio2 {
	public static void main(String[] args) {
		AES myAES = new AES();
		myAES.doGenerateKey();
		myAES.generateKeyAndIV();
		myAES.doEncrypt();
		myAES.doDecrypt();
	}
}
