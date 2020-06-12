package Semana4;

public class Library implements iLibrary {
	DNode header;
	DNode trailer;
	int size = 0;

	public int getNumBooks() {
		return size;
	}

	public void insertByTitle(String ti, String au, String ge) {
		Book b = new Book(ti, au, ge);
		if (isEmpty()) {
			addFirst(b);
		} else {
			if (!contains(b)) {
				boolean orden = false;
				boolean salir = false;
				boolean repeat = false;
				int index = -1;
				for (DNode NodeIt = header.next; NodeIt.elem != null && !orden; NodeIt = NodeIt.next, index++) {
					salir = false;
					for (int i = 0; NodeIt.elem.title.length() > i && i < ti.length() && !orden && !salir; i++) {
						if (NodeIt.elem.title.toLowerCase().charAt(i) != ti.toLowerCase().charAt(i) && !repeat) {
							if (NodeIt.elem.title.toLowerCase().charAt(i) > ti.toLowerCase().charAt(i)) {
								orden = true;
							} else {
								salir = true;
							}
						} else if (NodeIt.elem.title.toLowerCase().charAt(i) == ti.toLowerCase().charAt(i) || repeat) {
							repeat = true;
							if (NodeIt.elem.title.toLowerCase().charAt(i + 1) > ti.toLowerCase().charAt(i + 1)) {
								orden = true;
							} else if (NodeIt.elem.title.toLowerCase().charAt(i + 1) == ti.toLowerCase().charAt(i + 1)) {
								salir = true;
								orden = true;
							} else {
								index++;
								salir = true;
								orden = true;
							}
						}
					}
				}
				if (orden || repeat) {
					insertAt(index, b);
				} else if (salir) {
					insertAt(index + 1, b);
				}
			} else {
				System.out.println("Duplicate Book");
			}
		}
	}

	public void show() {
		for (DNode NodeIt = header.next; NodeIt.next != null; NodeIt = NodeIt.next) {
			System.out.println("Title: " + NodeIt.elem.title + " Author: " + NodeIt.elem.author + " Gender: " + NodeIt.elem.genre);
		}
	}

	public void searchBooksByTitle(String ti) {
		boolean found = false;
		for (DNode node = header.next; node.elem != null && !found; node = node.next) {
			if (node.elem.title.equals(ti)) {
				System.out.println("Searched book: \n" + node.elem.toString());
				found = true;
			}
		}
		if (!found) 
			System.out.println("Not found");
		}
	
	public iLibrary searchBooksByAuthors(String au) {
		Library list = new Library();
		for (DNode node = header.next; node.elem != null; node = node.next) {
			if (node.elem.author.equals(au)) {
				list.addLast(node.elem);
			}
		}
		return list;
	}

	public iLibrary searchBooksByGenre(String ge) {
		Library list = new Library();
		for (DNode node = header.next; node.elem != null; node = node.next) {
			if (node.elem.genre.equals(ge)) {
				list.addLast(node.elem);
			}
		}
		return list;
	}

	public void orderByAuthor() {

		DNode NodeIt;
		boolean change = false;
		if (size >= 2) {
			for (int i = 1; i < size; i++) {
				NodeIt = header.next;
				for (int j = 0; j < size - i; j++) {
					change = false;
					NodeIt = NodeIt.next;
					if (NodeIt.prev.elem.author.toLowerCase().charAt(0) > NodeIt.elem.author.toLowerCase().charAt(0)) {
						change = true;
					} else if (NodeIt.prev.elem.author.toLowerCase().charAt(0) == NodeIt.elem.author.toLowerCase().charAt(0) && NodeIt.prev.elem.author.toLowerCase().charAt(1) > NodeIt.elem.author.toLowerCase().charAt(1)) {
						change = true;
					}
					if (change) {
						DNode aux = NodeIt.prev;
						NodeIt.prev = aux.prev;
						aux.next = NodeIt.next;
						NodeIt.next.prev = aux;
						NodeIt.next = aux;
						aux.prev.next = NodeIt;
						aux.prev = NodeIt;
						NodeIt = aux;
					}
				}
			}
		}
	}

	public Library() {
		header = new DNode(null);
		trailer = new DNode(null);
		header.next = trailer;
		trailer.prev = header;
	}
	public void addFirst(Book elem) {
		DNode newNode = new DNode(elem);
		newNode.next = header.next;
		newNode.prev = header;
		header.next.prev = newNode;
		header.next = newNode;
		size++;
	}
	public void addLast(Book elem) {
		DNode newNode = new DNode(elem);
		newNode.next = trailer;
		newNode.prev = trailer.prev;
		trailer.prev.next = newNode;
		trailer.prev = newNode;
		size++;
	}
	public void insertAt(int index, Book elem) {
		if (index <= size) {
			DNode newNode = new DNode(elem);
			if (index == 0) {
				addFirst(elem);
			} else if (index == size) {
				addLast(elem);
			} else {
				int c = 0;
				boolean inserted = false;
				for (DNode NodeIt = header; NodeIt != null && !inserted; NodeIt = NodeIt.next) {
					if (index == c) {
						newNode.next = NodeIt.next;
						newNode.prev = NodeIt;
						NodeIt.next.prev = newNode;
						NodeIt.next = newNode;
						size++;
						inserted = true;
					}
					c++;
				}
			}
		}
	}
	public boolean isEmpty() {
		return (header.next == trailer);
	}
	public boolean contains(Book elem) {
		boolean found = false;
		if (!isEmpty()) {
			for (DNode NodeIt = header.next; NodeIt.elem != null && !found; NodeIt = NodeIt.next) {
				found = NodeIt.elem.equls(elem);
			}
		}
		return found;
	}

	public static void main(String[] args) {
		Library lib = new Library();

		lib.insertByTitle("Carrie", "Stephen", "Novela");
		lib.insertByTitle("El Quijote", "Cervantes", "Historia");
		lib.insertByTitle("Cujo", "Stephen", "Historia");
		lib.show();
		System.out.println("\tTrying a duplicate: ");
		lib.insertByTitle("Carrie", "Stephen", "Terror");
		System.out.println();
		lib.insertByTitle("Harry Potter", "Rowling", "Novela");
		lib.insertByTitle("Lunes", "Delibes", "Ensayo");
		lib.insertByTitle("Alastor", "Farrell", "Novela");

		lib.insertByTitle("Darry Potter", "Ka", "Novela");
		lib.insertByTitle("Rlastor", "La", "Novela");
		lib.insertByTitle("Eunes", "Ja", "Ensayo");
		lib.insertByTitle("Flastor", "Ma", "Novela");
		lib.insertByTitle("Garry Potter", "Ca", "Novela");
		lib.insertByTitle("Hunes", "Oa", "Ensayo");
		lib.insertByTitle("Ilastor", "Pa", "Novela");
		lib.insertByTitle("Aarry Potter", "Qa", "Novela");
		lib.insertByTitle("Bunes", "Ha", "Ensayo");
		lib.insertByTitle("Bgc", "Ba", "Ensayo");
		lib.insertByTitle("Bgb", "Ca", "Novela");
		lib.insertByTitle("Bc", "Ea", "Novela");
		lib.insertByTitle("Ba", "Ga", "Ensayo");

		lib.show();
		System.out.println();
		System.out.println("Total books: " + lib.getNumBooks());
		System.out.println();
		lib.searchBooksByTitle("Harry Potter");

		System.out.println("\tSearch by author 'Stephen':");
		lib.searchBooksByAuthors("Stephen").show();

		System.out.println("\tSearch by genre 'Novela':");
		lib.searchBooksByGenre("Novela").show();

		System.out.println("Order by Author:");
		lib.orderByAuthor();
		lib.show();
	}
}