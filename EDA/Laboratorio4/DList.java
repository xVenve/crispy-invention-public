package Laboratorio4;

import java.util.Random;

public class DList implements IList {
	DNode header;
	DNode trailer;
	int size=0;

	public DList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev= header;
	}

	public void addFirst(Integer elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
	}
	public void addLast(Integer elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
	}

	
	public void insertAt(int index, Integer elem) {
		if(index<=size) {
			DNode newNode=new DNode(elem);
			if(index==0) {
				addFirst(elem);
			}else if(index==size){
				addLast(elem);
			}else {
				int c=0;
				boolean inserted=false;
				for(DNode NodeIt=header;NodeIt!=null&&!inserted;NodeIt=NodeIt.next) {
					if(index==c) {
						newNode.next=NodeIt.next;
						newNode.prev=NodeIt;
						NodeIt.next.prev=newNode;
						NodeIt.next=newNode;
						size++;
						inserted=true;
					}
					c++;
				}
			}
		}
	}

	

	
	public boolean isEmpty() {
		return (header.next == trailer);
	}

	
	public boolean contains(Integer elem) {
		boolean found=false;
		for(DNode NodeIt=header.next;NodeIt!=null&&!found;NodeIt=NodeIt.next) {
			found=NodeIt.elem==elem;
		}
		return found;
	}

	
	public int getIndexOf(Integer elem) {
		int index = -1;
		int c=0;
		for(DNode NodeIt=header.next;NodeIt!=null&&index==-1;NodeIt=NodeIt.next,c++) {
			if(NodeIt.elem==elem) {
				index=c;
			}
		}
		return index;
	}

	
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev= header;
		size--;
	}

	
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev= trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}

	
	public void removeAll(Integer elem) {
		int index=getIndexOf(elem);
		while(index!=-1) {
			removeAt(index);
			index=getIndexOf(elem);
		}
	}

	
	
	public void removeAt(int index) {
		if(index<=size) {
			if(index==0) {
				removeFirst();
			}else if(index==size){
				removeLast();
			}else {
				int c=0;
				boolean removed=false;
				for(DNode NodeIt=header.next;NodeIt!=null&&!removed;NodeIt=NodeIt.next) {
					if(index==c) {
						NodeIt.prev.next=NodeIt.next;
						NodeIt.next.prev=NodeIt.prev;
						size--;
						removed=true;
					}
					c++;
				
				}
			}
		}
	}

	
	public int getSize() {
	return size;
	}

	
	public Integer getFirst() {
		Integer result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=header.next.elem;
		return result;
	}

	public Integer getLast() {
		Integer result=null;
		if (isEmpty()) {
			System.out.println("DList: List is empty");
		} else result=trailer.prev.elem;
		return result;
	}

	
	public Integer getAt(int index) {
		int i = 0;
		Integer result=null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result=nodeIt.elem;
			}
			++i;
		}
		if (result==null) System.out.println("DList: Get out of bounds");
		return result;
	}

	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next){
			if (result == null) {
				result = String.valueOf(nodeIt.elem);
			} else {
				result += "," + String.valueOf(nodeIt.elem);
			}
		}
		return result == null ? "empty" : result;
	}

	

	
	
	public static void main(String[] args) {
		// incomplete test
		Random rn=new Random();
		DList list = new DList();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());
		for (int i=0; i<100; i++) {
			list.insertAt(i, Integer.valueOf(rn.nextInt(100)));
		}
		list.removeLast();
		list.insertAt(2, 30);
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		list.removeAt(5);
		System.out.println("removed element at position 5\n "+list.toString());
		System.out.println("Indice\n "+list.getIndexOf(83));
		list.removeAll(83);
		System.out.println("removed all 83\n "+list.toString());
		
	}
}