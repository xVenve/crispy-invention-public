package Semana3;

public interface IList {

	public boolean isEmpty();

	public void addFirst(Book newElem);
	public void addLast(Book newElem);

	public void removeFirst();
	public void removeLast();

	public Book getFirst();
	public Book getLast();
	public int getSize();
	public boolean containsTi(String elem);
	public boolean containsGe(String elem);

	public int getIndexOfTi(String elem);

	public void insertAt(int index, Book newElem);
	public Book getAt(int index);
	public void removeAllGe(String elem);

	public void removeAt(int index);
	public String toString();

}
