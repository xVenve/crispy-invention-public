package Laboratorio2.stack;


public class SStack implements IStack {
	SNode peak = null;
	int size;

	
	public boolean isEmpty() {
		return peak == null;
	}

	public void push(Character newElem) {
		SNode newNode = new SNode(newElem);
		newNode.next = peak;
		peak = newNode;
		size++;
	}
	

	public Character pop() {
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		}
		Character elem = peak.elem;
		peak = peak.next;
		size--;
		return elem;
	}
	
	public Character top() {
		if (isEmpty()) {
			System.out.println("The stack is empty.");
			return null;
		}
		return peak.elem;
	}

	public String toString() {
		String result = "[";
		for (SNode nodeIt = peak; nodeIt != null; nodeIt = nodeIt.next) {
			if (result != "[") result = result + " ";
			result = result + nodeIt.elem.toString();			
		}
		return result +"]";
	}

	public int getSize() {
		return size;
	}

}
