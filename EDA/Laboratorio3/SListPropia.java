package Laboratorio3;

public class SListPropia implements IList {

	public SNode first; 
	public SNode last;
	int size=0; 
	
	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirst(String newElem) {
		
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		if (first==null) last=newNode;
		first = newNode;
		size++;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
			size--;
		}
	}
	
	public void addLast(String newElem) {
		
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

	public String getAt(int index) {
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
	
	public void insertAt(int index, String newElem) {
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

	public boolean contains(String elem) {
		boolean c=false;
		for(SNode NodeIt=first;c==false&&NodeIt!=null;NodeIt=NodeIt.next){
			if(NodeIt.elem.equals(elem)) {
				c=true;
			}
		}
		return c;
	}

	public void removeAll(String elem) {
		int n=0;
		for(SNode NodeIt=first;NodeIt!=null;NodeIt=NodeIt.next,n++){
			if(NodeIt.elem.equals(elem)) {
				removeAt(n);
				n--;
			}
		}
	}

	public void removeAt(int index) {
		if(index<size) {
			if(size==1) {
				removeFirst();
				removeLast();
			}
			if(index==0) {
				removeFirst();
			}else if(index==size-1){
				removeLast();
			}else {
				SNode NodeIt=first;
				for(int i=0;i<index-1;i++) {
					NodeIt=NodeIt.next;
				}
				NodeIt.next=NodeIt.next.next;
				size--;
			}
		}
	}

	public int getIndexOf(String elem) {
		int n=-1;
		boolean c=false;
		for(SNode NodeIt=first;c==false&&NodeIt!=null;NodeIt=NodeIt.next,n++){
			if(NodeIt.elem.equals(elem)) {
				c=true;
			}
		}
		if(c) {
			return n;
		}else {
			return -1;
		}
	}

	public String getFirst() {
		if(isEmpty()) {
			return null;
		}else {
			return first.elem;
		}
	}

	public String getLast() {
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
				result = nodeIt.elem.toString();
			} else {
				result += "," + nodeIt.elem.toString();
			}
		}
		return result == null ? "empty" : result;
	}

	

	public static void main(String[] args) {
		// incomplete test
		IList list = new SListPropia();
		System.out.println(list.toString());
		System.out.println("isEmpty?" + list.isEmpty());

		list.addLast("1");
		System.out.println(list.toString());

		list.removeLast();
		System.out.println(list.toString());
		
		list.addLast("1");
		System.out.println(list.toString());

		list.removeFirst();
		System.out.println(list.toString());
		
		list.addLast("1");
		list.addLast("1");
		System.out.println(list.toString());
		
		list.addFirst("2");
		System.out.println(list.toString());
		
		list.addFirst("3");
		System.out.println(list.toString());
		
		list.addLast("4");
		System.out.println(list.toString());
		
		list.insertAt(2, "5");
		System.out.println(list.toString());
		
		System.out.println(list.contains("3"));
		
		list.removeAll("1");
		System.out.println(list.toString());
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.getAt(2));
		System.out.println(list.getIndexOf("2"));
		list.removeAt(3);
		System.out.println(list.toString());
	}
}
