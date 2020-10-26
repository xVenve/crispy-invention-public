package Semana3;

public interface iLibrary {
	public void insert(String ti, String au, String ge);

	public void searchBooksByTitle(String ti);

	public SList searchBooksByAuthors(String au);

	public SList searchBooksByGenre(String ge);

	public void deleteBooksByGenre(String ge);
}
