package Semana1;

public interface iLibrary {
	public int getNumBooks();
	public void insert(String ti, String au, int ge);
	public void show();
	public void searchBooksByTitle(String ti);
	public iLibrary searchBooksByAuthors(String au);
	public iLibrary searchBooksByGender(int ge);
}
