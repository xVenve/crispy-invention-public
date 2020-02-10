package Laboratorio7;


public class SList implements IList {

	public SNode first; 
	
	
	public void addFirst(String newElem) {
		
		SNode newNode = new SNode(newElem);
		newNode.next = first;
		first = newNode;
	}

	
	
	public void addLast(String newElem) {
		
		
		if (isEmpty()) addFirst(newElem); 
		else {

			SNode node = new SNode(newElem);
			
			SNode last = first;
			while (last.next!=null) {
				last = last.next;
			}
			
			last.next = node;
		}
	}
	
	
	
	

	
	@Override
	public void insertAt(int index, String newElem) {
		
		System.out.println("adding : " + newElem + " at position: " + index);
		
		SNode newNode = new SNode(newElem);
		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			int i = 1;
			boolean inserted=false;
			for (SNode nodeIt = first; nodeIt != null && inserted==false; nodeIt = nodeIt.next) {
				if (i == index) {
					newNode.next = nodeIt.next;
					nodeIt.next = newNode;
					inserted=true;
				}
				++i;
			}
			if (!inserted) System.out.println("SList: Insertion out of bounds");
		}
	}

	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public boolean contains(String elem) {
		boolean found=false;
		for (SNode nodeIt = first; nodeIt != null && found==false; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				found= true;
			}
		}
		return found;
	}

	public void removeFirst() {
		if (!isEmpty()) {
			first = first.next;
		}
	}

	public void removeLast() {
		SNode lastNode = null;
		SNode previousNode = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			previousNode = lastNode;
			lastNode = nodeIt;
		}
		if (previousNode == null) first=null;
		else previousNode.next = null;
	}


	@Override
	public void removeAll(String elem) {
		System.out.println("removing all " + elem);
		SNode previousNode = null;
		for (SNode nodeIt = first; nodeIt != null; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				if (previousNode == null) {
					first = nodeIt.next;
				} else {
					previousNode.next = nodeIt.next;
				}
			} else {
				previousNode = nodeIt;
			}
		}
	}

	@Override
	public void removeAt(int index) {
		
		System.out.println("removing at position: " + index);
		
		int i = 0;
		SNode previousNode = null;
		boolean removed=false;
		for (SNode nodeIt = first; nodeIt != null && removed==false; nodeIt = nodeIt.next) {
			if (i == index) {
				if (previousNode == null) {
					first = nodeIt.next;
				} else {
					previousNode.next = nodeIt.next;
				}
				removed=true;
			}
			++i;
			previousNode = nodeIt;
		}
		if (!removed) System.out.println("SList: Deletion out of bounds");
	}

	@Override
	public int getSize() {
		int size = 0;
		for (SNode node = first; node != null; node = node.next) {
			++size;
		}
		return size;
	}

	@Override
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

	@Override
	public String getFirst() {
		String result=null;
		if (first == null) {
			System.out.println("SList: List is empty");
		} else result=first.elem;
		return result;
	}

	@Override
	public String getLast() {
		SNode lastNode = null;
		for (SNode node = first; node != null; node = node.next) {
			lastNode = node;
		}
		String result=null;
		if (lastNode == null) {
			System.out.println("SList: List is empty");
		} else result=lastNode.elem;
		return result;
	}

	@Override
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

	

	public static void main(String[] args) {
		// incomplete test
		IList list = new SList();
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
		
		list.removeAll("0");
		System.out.println(list.toString());
		
		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		list.removeFirst();
		list.removeLast();
		System.out.println(list.toString());

		System.out.println("First: " + list.getFirst());
		System.out.println("Last: " + list.getLast());
		
		
		System.out.println("Size: " + list.getSize());
		
		for (int i=0; i<list.getSize();i++) {
			System.out.println("Element at position " + i + ":"+ list.getAt(i));
		}
		

		
		list.insertAt(5, "6");
		System.out.println(list.toString());
		list.insertAt(0, "7");
		System.out.println(list.toString());
		
		list.insertAt(list.getSize()+5, "9");
		System.out.println(list.toString());
		
		
		list.removeAll("1");
		System.out.println(list.toString());
		
		System.out.println("contains 1?" + list.contains("1"));
		System.out.println("contains 7?" + list.contains("7"));

		System.out.println("isEmpty?" + list.isEmpty());

		System.out.println(list.getIndexOf("7"));
		System.out.println(list.getIndexOf("1"));
		System.out.println("Index of 6? " + list.getIndexOf("6"));

		list.removeAt(5);
		System.out.println(list.toString());
		list.removeAt(2);

		System.out.println(list.toString());

		
	}
}
