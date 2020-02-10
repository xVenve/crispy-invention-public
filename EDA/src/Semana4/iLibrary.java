package Semana4;

public interface iLibrary {

	public int getNumBooks();
	public void insertByTitle(String ti, String au, String ge);
	public void show();
	public void searchBooksByTitle(String ti);
	public iLibrary searchBooksByAuthors(String au);
	public iLibrary searchBooksByGenre(String ge);
	public void orderByAuthor();

}


