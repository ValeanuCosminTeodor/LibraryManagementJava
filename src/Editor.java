import java.util.*;

public class Editor {
    private String name;
    private int nr_books_published = 0;
    SortedSet<Book> books_published = new TreeSet<Book>();

    public Editor(String name, Address address){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void addBooktoEditor(Book newBook){
        nr_books_published = nr_books_published + 1;
        books_published.add(newBook);
    }
}
