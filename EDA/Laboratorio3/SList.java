package Laboratorio3;


public class SList implements IList {

	public SNode first; 
	public SNode last;
	int size;
	public void addFirst(String newElem) {
		
		SNode newNode = new SNode(newElem);
		if (isEmpty()) {
			first=newNode;
			last=newNode;
		} else {
			newNode.next = first;
			first = newNode;
		}
		
		size++;
	}
	public void addLast(String newElem) {
		
		
		if (isEmpty()) addFirst(newElem); 
		else {
			SNode node = new SNode(newElem);
			last.next = node;
			last=node;
			size++;
		}
	}
	public void insertAt(int index, String newElem) {
		
		System.out.println("adding : " + newElem + " at position: " + index);
		
		SNode newNode = new SNode(newElem);
		if (index == 0) 
			addFirst(newElem);
		else if (index==size) 
			addLast(newElem);
		else {
			int i = 1;
			boolean inserted=false;
			for (SNode nodeIt = first; nodeIt != null && inserted==false; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted=true;
					size++;
				}
				++i;
			}
			if (!inserted) System.out.println("SList: Insertion out of bounds");
		}
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public boolean contains(String elem) {
		boolean found=false;
		for (SNode nodeIt = first; nodeIt != null && 
				found==false; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				found= true;
			}
		}
		return found;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			if (first==null) last=null;
			size--;
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
	public void removeAll(String elem) {
		int pos=getIndexOf(elem);
		while (pos!=-1) {
			removeAt(pos);
			pos=getIndexOf(elem);
		}
	}
	public void removeAt(int index) {
		
		System.out.println("removing at position: " + index);
		if (index==0) removeFirst();
		else if (index==size-1) removeLast();
		else {
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
			if (!removed) System.out.println("SList: Deletion out of bounds");
		}
	}

	public int getSize() {
		return size;
	}

	public int getIndexOf(String elem) {
		System.out.println("index of " + elem);
		
		int index = -1;
		int pos=0;
		for (SNode node = first; node != null && index==-1; node = node.next) {
			if (node.elem.equals(elem)) {
				index=pos;
			}
			++pos;
		}
		return index;
	}

	public String getFirst() {
		return isEmpty()?null:first.elem; 
	}
	public String getLast() {
		String result=null;
		if (!isEmpty()) result=last.elem;
		return result;
	}
	
	public String getAt(int index) {
		int i = 0;
		String result=null;
		for (SNode nodeIt = first; nodeIt != null && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result= nodeIt.elem;
			}
			++i;
		}
		if (result==null) System.out.println("SList: Get out of bounds");
		return result;
	}

	public String toString() {
		String result = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (result == null) {
				result = nodeIt.elem.toString();
			} else {
				result += "," + nodeIt.elem.toString();
			}
		}
		return result == null ? "empty" : result;
	}
}
