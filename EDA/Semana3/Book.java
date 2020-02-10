package Semana3;

public class Book {
	public String title;
	public String author;
	public String genre;
	
	public Book(String ti, String au, String ge) {
		title=ti;
		author=au;
		genre=ge;
	}
	public void show() {
		System.out.println("Title: "+title+" Author: "+author+" Genre: "+genre);
	}
}
