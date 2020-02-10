package Semana3;

public class SList implements IList {

	public SNode first; 
	public SNode last;
	int size=0;
	
	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirst(Book newElem) {
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		if (first==null) last=newNode;
		first = newNode;
		size++;
	}
	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			if (first==null) last=null;
			size--;
		}
	}
	
	public void addLast(Book newElem) {
		SNode node = new SNode(newElem);
		if (isEmpty()) addFirst(newElem);
		else {
			last.next=node;
			last=node;
			size++;
		}	
		
	}	
	public void removeLast() {
		if (!isEmpty()) {
			if (size==1)
					removeFirst();
			else { 
				SNode nodeIt = first;
				while (nodeIt.next!=last) {
					nodeIt = nodeIt.next;
				}
				nodeIt.next=null;
				last=nodeIt;
				size--;
			}
			
		}
	}

	public int getSize() {
		return size;
	}

	public Book getAt(int index) {
		if(index<=size) {
			if(index==0) {
				return getFirst();
			}else if(index==size){
				return getLast();
			}else {
				SNode NodeIt=first;
				for(int i=0;i<index;i++) {
					NodeIt=NodeIt.next;
				}
			return NodeIt.elem;
			}
		}else {
			return null;
		}
	}	
	public void insertAt(int index, Book newElem) {
		System.out.println("adding : " + newElem.title + " at position: " + index);
		if(index<=size) {
			if(index==0) {
				addFirst(newElem);
			}else if(index==size){
				addLast(newElem);
			}else {
				SNode newNode=new SNode(newElem);
				SNode NodeIt=first;
				for(int i=0;i<index-1;i++) {
					NodeIt=NodeIt.next;
				}
				newNode.next=NodeIt.next;
				NodeIt.next=newNode;
				size++;
			}
		}
	}

	public boolean containsTi(String elem){
		boolean c=false;
		for(SNode NodeIt=first;c==false&&NodeIt!=null;NodeIt=NodeIt.next){
			if(NodeIt.elem.title.toLowerCase().equals(elem.toLowerCase())) {
				c=true;
			}
		}
		return c;
	}
	public boolean containsGe(String elem){
		boolean c=false;
		for(SNode NodeIt=first;c==false&&NodeIt!=null;NodeIt=NodeIt.next){
			if(NodeIt.elem.genre.toLowerCase().equals(elem.toLowerCase())) {
				c=true;
			}
		}
		return c;
	}

	public void removeAllGe(String elem) {
		int n=0;
		for(SNode NodeIt=first;NodeIt!=null;NodeIt=NodeIt.next,n++){
			if(NodeIt.elem.genre.toLowerCase().equals(elem.toLowerCase())) {
				removeAt(n);
				n--;
			}
		}
	}
	public void removeAt(int index) {
		if(index<size) {
			if(size==1) {
				removeFirst();
			}
			if(index==0) {
				removeFirst();
			}else if(index==size-1){
				removeLast();
			}else {
				int i = 0;
				SNode previousNode = null;
				boolean removed=false;
				for (SNode nodeIt = first; nodeIt != null && removed==false; nodeIt = nodeIt.next) {
					if (i == index) {
						previousNode.next = nodeIt.next;
						removed=true;
						size--;
					}
					++i;
					previousNode = nodeIt;
				}
				if (!removed) System.out.println("BList: Deletion out of bounds");
			}
		}
	}

	public int getIndexOfTi(String elem){
		int n=-1;
		boolean c=false;
		for(SNode NodeIt=first;c==false&&NodeIt!=null;NodeIt=NodeIt.next,n++){
			if(NodeIt.elem.title.toLowerCase().equals(elem.toLowerCase())) {
				c=true;
			}
		}
		if(c) {
			return n;
		}else {
			return -1;
		}
	}

	public Book getFirst() {
		if(isEmpty()) {
			return null;
		}else {
			return first.elem;
		}
	}
	public Book getLast() {
		if(isEmpty()) {
			return null;
		}else {
			return last.elem;
		}

	}

	public String toString() {
		String result = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = "Title: "+nodeIt.elem.title.toString()+" Author: "+nodeIt.elem.author.toString()+" Genre: "+nodeIt.elem.genre.toString();
			} else {
				result += "\n" + "Title: "+nodeIt.elem.title.toString()+" Author: "+nodeIt.elem.author.toString()+" Genre: "+nodeIt.elem.genre.toString();
			}
		}
		return result == null ? "empty" : result;
	}
}
