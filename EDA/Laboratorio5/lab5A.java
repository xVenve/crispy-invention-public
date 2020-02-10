package Laboratorio5;

import java.util.Arrays;

public class lab5A {
	public static int[] randomList(int n) {
		int[] A=new int[n];
		for(int i=0;i<A.length;i++) {
			A[i]=(int)((Math.random()*26)-13);
		}
		return A;
	}
	public static int sumList(int[] data) {
		int n=0;
		for(int i=0;i<data.length; i++) {
			n+=data[i];
		}
		return n;
	}
	public boolean search(int x, int[] data) {
		if (data==null)	{
			System.out.println("Error:	array	is	null!!!");
			return false;
			}
			boolean found=false;
			for (int i=0;	i<data.length &&	!found;i++)	{
			if (data[i]==x)	
			found=true;
			}
			return found;
	}
	
	
	public static boolean binary_search(int[] data, int x) {
		if (data==null) {
		System.out.println("Error: array is empty!!!");
		return false;
		}
		int left=0;
		int right=data.length-1;
		boolean found=false;
		while (left<=right && !found) {
		int mid = left + (right - left) / 2;
		if (data[mid]==x) {
		found=true;
		} else if (data[mid]>x) {
		right=mid-1;
		} else {
		left=mid+1;
		}
		}
		return found;
		}
	
	
	public static boolean search_binary(int n, int[] a) {
		Arrays.sort(a);
		int l=0;
		int r=a.length-1;
		boolean e=false;
		while(l<=r&&!e) {
			int m=l+(r-l)/2;
			if(a[m]==n) {
				e=true;
			}else if(a[m]>n) {
				r=m-1;
			}else {
				l=m+1;
			}
		}
		return e;
	}
	public static int sumPair(int[] vector) {
		int n=0;
		for(int i=0;i<vector.length;i++) {
			for(int j=i+1;j<vector.length;j++) {
				if(i!=j &&vector[i]+vector[j]==0) {
					n++;
				}
			}
		}
		return n;
	}
	public static int sumTriple0(int[]	data)	{
		int result=0; //1
		for (int i=0;	i<data.length;	i++) //2n+2
			for (int j=0;	j<data.length;	j++) //n*(2n+2)
				for (int k=0;	k<data.length;	k++)		//n^2*(2n+2)=2n^3+2n^2
					if (i!=j &&	j!=k &&	i!=k &&	data[i]+data[j]+data[k]==0)	
						//condici�n:	n^3*(3+3+1+1)=8n^3
						result++;	//n^3
		return result;
	}
	
	public static void main(String[]args) {
		for(int n=1;n<=100000000;n*=10) {
			int[] data= randomList(n);
			long start=System.nanoTime();
			sumList(data);
			long end=System.nanoTime();
			System.out.println(n+"-->"+(end-start));
		}
		int[] t= randomList(10);
		long start=System.nanoTime();
		if(search_binary(5,t)) {
			System.out.println("Encontrado");
		}
		
		long end=System.nanoTime();
		System.out.println(end-start);
		int[] f= randomList(10);
		System.out.println(sumPair(f)+ " pares");
	}
}
