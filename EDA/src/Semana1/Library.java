package Semana1;

public class Library implements iLibrary {
    public Book[] b;
    public int numB;

    public Library() {
        b = new Book[1000];
        numB = 0;
    }

    public int getNumBooks() {
        return numB;
    }
    public void insert(String ti, String au, int ge) {
        boolean r = false;
        if (numB < b.length && ge < 3 && ge > -1) {
            for (int i = 0; i < numB && !r; i++) {
                r = ti.toLowerCase().equals(b[i].title.toLowerCase());
            }
            if (!r) {
                b[numB] = new Book(ti, au, ge);
                numB++;
            } else {
                System.out.println("Existing book");
            }
        } else if (ge > 3 || ge < -1) {
            System.out.println("Wrong gender");
        } else {
            System.out.println("Library full");
        }
    }
    public void show() {
        for (int i = 0; i < numB; i++) {
            if (b[i].gender == 0) {
                System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Novela");
            } else if (b[i].gender == 1) {
                System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Historia");
            } else {
                System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Ensayo");
            }
        }
    }
    public void searchBooksByTitle(String ti) {
        boolean found = false;
        for (int i = 0; i < numB && !found; i++) {
            found = ti.toLowerCase().equals(b[i].title.toLowerCase());
            if (found) {
                if (b[i].gender == 0) {
                    System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Novela");
                } else if (b[i].gender == 1) {
                    System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Historia");
                } else {
                    System.out.println("Title: " + b[i].title + " Author: " + b[i].author + " Gender: Ensayo");
                }
            }
        }
    }
    public iLibrary searchBooksByAuthors(String au) {
        Library auB = new Library();
        for (int i = 0; i < numB; i++) {
            if (au.toLowerCase().equals(b[i].author.toLowerCase())) {
                auB.insert(b[i].title, au, b[i].gender);
            }
        }
        return auB;
    }
    public iLibrary searchBooksByGender(int ge) {
        Library auG = new Library();
        for (int i = 0; i < numB; i++) {
            if (ge == b[i].gender) {
                auG.insert(b[i].title, b[i].author, ge);
            }
        }
        return auG;
    }

    public static void main(String[] args) {
        Library l = new Library();
        //Generos: 0 Novela 1 Historia 2 Ensayo
        l.insert("Harry Potter", "Rowling", 0);
        l.insert("Lunes", "Delibes", 2);
        l.show();
        System.out.println(l.getNumBooks());
        l.insert("Lunes", "Richard", 1);
        l.insert("El Quijote", "Cervantes", 5);
        l.insert("Cujo", "Stephen", 1);
        l.show();
        System.out.println(l.getNumBooks());
        l.insert("Carrie", "Stephen", 0);
        l.show();
        System.out.println(l.getNumBooks());
        System.out.println("Lunes book: ");
        l.searchBooksByTitle("Lunes");
        System.out.println("Stephen books: ");
        l.searchBooksByAuthors("Stephen").show();
        System.out.println("Novel books: ");
        l.searchBooksByGender(0).show();
    }
}
