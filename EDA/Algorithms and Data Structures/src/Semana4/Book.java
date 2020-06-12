package Semana4;

public class Book {
	public String title;
	public String author;
	public String genre;

	public Book(String title, String author, String genre) {
		this.title = title;
		this.author = author;
		this.genre = genre;
	}

	public boolean equls(Book b) {

		boolean result = false;
		result = b.title.equalsIgnoreCase(this.title) && b.author.equalsIgnoreCase(this.author);
		return result;
	}

	public String toString() {
		return "Title: " + title + " Author: " + author + " Gender: " + genre + "\n";
	}

}
