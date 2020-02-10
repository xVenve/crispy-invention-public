package codigosfuente;

public class TestObjetosUsar {

	public static void main(String[] args) {
		
		String[][] meterarray= new String[2][2];
		
		TestObjetos Jorge=new TestObjetos("Jorge");
		Jorge.setEdad(18);
		Jorge.setAltura(175);
		Jorge.setColorojos("Negro");
		meterarray[0][0]="1";
		meterarray[0][1]="2";
		meterarray[1][0]="3";
		meterarray[1][1]="4";

		Jorge.setNumeroypisorepe(meterarray);
		
		TestObjetos Maria=new TestObjetos("Maria");
		Maria.setAltura(187);
		Maria.setEdad(23);
		Maria.setColorojos("Rojo");
		
		/*meterarray[0][0]="10";
		meterarray[0][1]="11";
		meterarray[1][0]="12";
		meterarray[1][1]="13";
		Maria.setNumeroypisorepe(meterarray);*/
		
		
		System.out.println(Jorge.getEdad());
		System.out.println(Maria.getColorojos());

	}

}
