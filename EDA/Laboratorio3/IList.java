package Laboratorio3;

public interface IList {

	public boolean isEmpty();

	public void addFirst(String newElem);

	public void addLast(String newElem);

	public void removeFirst();

	public void removeLast();
	
	public String getFirst();
	public String getLast();
	public int getSize();
	public boolean contains(String elem);
	public int getIndexOf(String elem);
	
	public void insertAt(int index, String newElem);
	public String getAt(int index);
	public void removeAll(String elem);

	public void removeAt(int index);

}


