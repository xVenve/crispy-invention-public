package phase1;



//IMPORTANT:::: YOU CANNOT MODIFY OR EXTEND THIS CLASS. PLEASE, COME WITH YOUR LAB TEACHER ANY CHANGE OR EXTENSION THAT 
//YOU WOULD LIKE TO MAKE, SO SHE WILL ADVISE YOU THE BEST OPTION 

/**
 * A double-linked list class with sentinel nodes
 */

public class StudentsList implements IList {

	DNode header;
	DNode trailer;
	int size=0;

	/**
	 * Creates a doubly empty list
	 */
	public StudentsList() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev= header;
	}
	

	/**
	 * checks if the list is empty
	 */
	public boolean isEmpty() {
		return (header.next == trailer);
	}
	
	/**returns the number of students in the list**/
	public int getSize() {
		return size;
	}
	
	/**
	 * returns true if the list already contains a student with elem.email.
	 * Otherwise, it returns false.
	 */
	public boolean contains(Student elem) {
		boolean found=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && found==false; nodeIt = nodeIt.next) {
			Student current=nodeIt.elem;
			//if (nodeIt.elem.equals(elem)) {
			if (elem.email.compareTo(current.email)==0) {
				found=true;
			}
		}
		return found;
	}

	
	
	/**
	 * adds a student at the beginning of the list. First, it checks that this student does not belong to the list.
	 */
	public void addFirst(Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev= header;
		header.next.prev= newNode;
		header.next = newNode;
		size++;
	}


	/**
	 * adds a student at the end of the list. First, it checks that this student does not belong to the list.
	 */
	public void addLast(Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev= trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev= newNode;
		size++;
	}

	

	/**
	 * inserts a student at the position index of the list. First, it checks that this student does not belong to the list.
	 */
	public void insertAt(int index, Student elem) {
		if (this.contains(elem)) {
			System.out.println(elem.email + " already exists into the social network. You cannot added it!!!");
			return;
		}
		DNode newNode = new DNode(elem);
		int i = 0;
		boolean inserted=false;
		for (DNode nodeIt = header; nodeIt != trailer && inserted==false; nodeIt = nodeIt.next) {
			if (i == index) {
				newNode.next = nodeIt.next;
				newNode.prev= nodeIt;
				nodeIt.next.prev= newNode;
				nodeIt.next = newNode;
				inserted=true;
				size++;
			}
			++i;
		}
		if (!inserted) System.out.println("DList: Insertion out of bounds");
	}
	
	

	
	
	/**
	 * returns the index of the student elem into the list.  
	 * It returns -1 if the student does not exist
	 */
	public int getIndexOf(Student elem) {
		int index = -1;
		int pos=0;
		for (DNode nodeIt = header.next; nodeIt != trailer && index==-1; nodeIt = nodeIt.next) {
			if (nodeIt.elem.equals(elem)) {
				index=pos;
			} 
			++pos;
			
		}
		return index;
	}


	/**
	 * returns the first student from the list
	 */
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		header.next = header.next.next;
		header.next.prev= header;
		size--;
	}

	/**
	 * returns the last student from the list
	 */
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("DList: List is empty");
			return;
		}
		trailer.prev= trailer.prev.prev;
		trailer.prev.next = trailer;
		size--;
	}

	
	
	
	/**
	 * removes the student at the position index
	 */
	public void removeAt(int index) {
		int i = 0;
		boolean removed=false;
		for (DNode nodeIt = header.next; nodeIt != trailer && removed==false; nodeIt = nodeIt.next) {
			if (i == index) {
				nodeIt.prev.next = nodeIt.next;
				nodeIt.next.prev= nodeIt.prev;
				removed=true;
				size--;

			}
			++i;
		}
		if (!removed) System.out.println("DList: Deletion out of bounds");
	}

	
	

	
	
	/**
	 * returns the student at the position index. Returns null if the list does not contains this position
	 */
	public Student getAt(int index) {
		int i = 0;
		Student result=null;
		for (DNode nodeIt = header.next; nodeIt != trailer && result==null; nodeIt = nodeIt.next) {
			if (i == index) {
				result=nodeIt.elem;
			}
			++i;
		}
		if (result==null) System.out.println("DList: Get out of bounds");
		return result;
	}

	/**
	 * Returns a string with the students of the list
	 */
	public String toString() {
		String result = null;
		for (DNode nodeIt = header.next; nodeIt != trailer; nodeIt = nodeIt.next) {
			Student oStudent=nodeIt.elem;
			if (result==null)
				result="";
			result=result+oStudent.toString()+"\n";
		}
		return result == null ? "empty" : result;
	}

	
	/**
	 * checks if the invoking list is the same that the input list. The order of the students must be the same. 
	 * @param list
	 * @return
	 */
	public boolean equals(StudentsList list) {
		
		if (list==this) return true;
		if (list==null) return false; 

		if (list.getSize()!=this.getSize()) return false;
		
		for (int i=0; i<this.getSize(); i++) {
			Student s1=this.getAt(i);
			Student s2=list.getAt(i);
			if (!s1.equals(s2)) return false;
		}
		return true;
	}

	
	
}