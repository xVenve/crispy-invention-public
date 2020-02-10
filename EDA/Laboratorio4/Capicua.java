package Laboratorio4;

public class Capicua {
	public static void main(String[]args) {
		
	int n=1661;
	capicuacion(n);
	}
	
	public static void capicuacion(int n) {
		DList list=new DList();
		for(int i=0;i<Integer.toString(n).length();i++) {
			if(list.isEmpty()) {
				list.addLast(n%10);
			}else {
				int x=(int) ((n%Math.pow(10, i+1))-(list.trailer.prev.elem*Math.pow(10, i-1)));
				int y=(int) (x/(Math.pow(10, i)));
				list.addLast(y);
			}
						
		}
		System.out.println(list.toString());
		boolean capi=true;
		int i=0;
		for(DNode NodeIt1=list.header.next, NodeIt2=list.trailer.prev;i<(list.size/2)&&capi;NodeIt1=NodeIt1.next,NodeIt2=NodeIt2.prev,i++) {
			
				if(NodeIt1.elem!=NodeIt2.elem) {
					capi=false;
				}
		}
		if(capi) {
			System.out.println("Capicua");
		}else{
			System.out.println("Not Capicua");

		}
	}
	
}
