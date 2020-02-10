package Semana3;

public class Library implements iLibrary{
	SList lib;
	public Library() {
		lib=new SList();
	}
	public void insert(String ti, String au,String ge) {
		//Si es como la semana 1 que solo caben 1000 libros, 
		//el if seria: if(!lib.containsTi(ti)&&lib.size<=1000) 
		//y su mensaje: System.out.println("Library full");
		if(!lib.containsTi(ti)) {
			Book b=new Book(ti, au, ge);
			lib.addLast(b);
		}else {
			System.out.println("Existing book");
		}
	}
	public void searchBooksByTitle(String ti) {
		if(!lib.containsTi(ti)||lib.isEmpty()) {
			System.out.print("Book not found");
		}else {
			int ind=lib.getIndexOfTi(ti);
			lib.getAt(ind).show();
		}
	}
	public SList searchBooksByAuthors(String au) {
		SList aux=new SList();
		if(!lib.isEmpty()) {
			int ind=0;
			while(ind<lib.size) {
				if(lib.getAt(ind).author.toLowerCase().equals(au.toLowerCase())) {
				aux.addLast(lib.getAt(ind));
				}
				ind++;
			}
		}
		return aux;
	}
	public SList searchBooksByGenre(String ge) {
		SList aux=new SList();
		if(!lib.isEmpty()) {
			int ind=0;
			while(ind<lib.size) {
				if(lib.getAt(ind).genre.toLowerCase().equals(ge.toLowerCase())) {
					aux.addLast(lib.getAt(ind));
				}
				ind++;
			}
		}
		return aux;
	}
	public void deleteBooksByGenre(String ge) {
		if(lib.containsGe(ge)) {
			lib.removeAllGe(ge);
		}else {
			System.out.print("There is no book of this genre");
		}
	}
	
	public static void main(String[] args) {
		Library l=new Library();

		System.out.println("\tInserting books");
		l.insert("Harry Potter","Rowling" , "Novela");
		l.lib.getLast().show();
		l.insert("Lunes", "Delibes", "Ensayo");
		l.lib.getLast().show();
		
		System.out.println("\tTrying a duplicate title");
		l.insert("Lunes", "Richard", "Historia");
		
		System.out.println("\tInserting books");
		l.insert("El Quijote", "Cervantes", "Historia");
		l.lib.getLast().show();
		l.insert("Cujo", "Stephen", "Historia");
		l.lib.getLast().show();
		l.insert("Carrie", "Stephen", "Novela");
		l.lib.getLast().show();
		
		System.out.println("\tSearch title Lunes book: ");
		l.searchBooksByTitle("Lunes");
		
		System.out.println("\tAuthor Stephen books: ");
		System.out.println(l.searchBooksByAuthors("Stephen").toString());
		
		System.out.println("\tGenre Novela books: ");
		System.out.println(l.searchBooksByGenre("Novela").toString());
		
		System.out.println("\tPreDelete books: ");
		System.out.println(l.lib.toString());
		
		System.out.println("\tPostDeleting novel books: ");
		l.deleteBooksByGenre("Novela");
		System.out.println(l.lib.toString());
	}
}
