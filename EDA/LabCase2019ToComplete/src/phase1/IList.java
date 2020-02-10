package phase1;

/**
 * This interface will be provided to the students. NEVER MODIFY!!!
 * */

//IMPORTANT:::: YOU CANNOT MODIFY OR EXTEND THIS INTERFACE. PLEASE, COME WITH YOUR LAB TEACHER ANY CHANGE OR EXTENSION THAT 
//YOU WOULD LIKE TO MAKE, SO SHE WILL ADVISE YOU THE BEST OPTION 


/**
 * Define a list to store students without repetitions
 * @author isegurabe
 *
 */
public interface IList {

	/**
	 * adds a student at the beginning of the list. First, it checks that this student does not belong to the list.
	 */
	public void addFirst(Student newElem);
	/**
	 * adds a student at the end of the list. First, it checks that this student does not belong to the list.
	 */
	public void addLast(Student newElem);
	/**
	 * returns the first student from the list
	 */
	public void removeFirst();
	/**
	 * returns the last student from the list
	 */
	public void removeLast();
	/**
	 * inserts a student at the position index of the list. First, it checks that this student does not belong to the list.
	 */
	public void insertAt(int index, Student newElem);
	/**
	 * checks if the list is empty
	 */
	public boolean isEmpty();
	/**
	 * returns true if the list already contains a student with elem.email.
	 * Otherwise, it returns false.
	 */
	public boolean contains(Student elem);
	/**returns the number of students in the list**/
	public int getSize();
	/**
	 * returns the index of the student elem into the list.  
	 * It returns -1 if the student does not exist
	 */
	public int getIndexOf(Student elem);
	/**
	 * returns the student at the position index. Returns null if the list does not contains this position
	 */
	public Student getAt(int index);

	/**
	 * removes the student at the position index
	 */
	public void removeAt(int index);

}


