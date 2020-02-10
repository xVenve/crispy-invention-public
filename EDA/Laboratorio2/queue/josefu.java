package Laboratorio2.queue;

public class josefu {
	public static int posJosefu(int n) {
		SQueue q=new SQueue();
		for(int i=0;i<n;i++) {
			q.enqueue(i+1);
		}
		do{
			for(int i=0;i<6;i++) {
				q.enqueue(q.dequeue());
			}
			System.out.println(q.dequeue());
		}while(q.size!=1);
		return q.front();
	}
	public static void main(String[] args) {
		int m=40;
		System.out.println("La posicion en la que debes colocarte para no morir es: "+posJosefu(m));
	}

}
