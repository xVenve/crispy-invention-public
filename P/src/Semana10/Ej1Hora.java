package Semana10;

public class Ej1Hora {
	public int horai;
	public int mini;
	public int horaf;
	public int minf;	
	public Ej1Hora(int horai, int mini, int horaf, int minf) {
		
		if(mini>59||mini<0) {
			this.mini=0;
		}else {
			this.mini = mini;
		}
		
		if(minf>59||minf<0) {
			this.minf=0;
		}else {
			this.minf = minf;
		}
		
		if(horai>23||horai<0) {
			if(horaf>23||horaf<0) {
				horai=0;
				horaf=0;
			}else {
				horai=horaf;
				if(mini>minf) {
					int g=mini;
					mini=minf;
					minf=g;
				}
			}
		}
			
			if(horaf>23||horaf<0) {
				horaf=horai;
				if(mini>minf) {
					int g=mini;
					mini=minf;
					minf=g;
				}
			}
				

		if(horai>horaf) {
			int g=horaf;
			horaf=horai;
			horai=g;
			g=mini;
			mini=minf;
			minf=g;
		}else if(horai==horaf) {
			if(mini>minf) {
				int g=mini;
				mini=minf;
				minf=g;
			}
		}
		
		this.horai=horai;
		this.horaf=horaf;
		this.mini=mini;
		this.minf=minf;
	}
	void Comparar(Ej1Hora madrugada, Ej1Hora maniana, Ej1Hora tarde, Ej1Hora noche) {
		System.out.println("Intervalo temporal: ["+horai+":"+mini+"-"+horaf+":"+minf+"]");
		System.out.print("Pertenece a: ");
		if(horai<madrugada.horaf) {
			System.out.print("madrugada");
			if(horaf>=madrugada.horaf) {
				System.out.print(", maniana");
				if(horaf>=maniana.horaf) {
					System.out.print(", tarde");
					if(horaf>=tarde.horaf) {
						System.out.print(", noche");
					}
				}
			}
		}else if(horai<maniana.horaf) {
			System.out.print("maniana");
			if(horaf>=maniana.horaf) {
				System.out.print(", tarde");
				if(horaf>=tarde.horaf) {
					System.out.print(", noche");
				}
			}
		}else if(horai<tarde.horaf) {
			System.out.print("tarde");
			if(horaf>=tarde.horaf) {
				System.out.print(", noche");
			}
		}else {
			System.out.print("noche");
		}
		System.out.println("\n");
	}
}
