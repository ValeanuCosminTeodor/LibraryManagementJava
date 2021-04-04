import java.util.ArrayList;

public class Category {
    private String name;
    ArrayList<Book> books=new ArrayList<Book>();

    public Category(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void addBooktoCategory(Book newBook){
        books.add(newBook);
    }

    public void show_books(){
        for (Book book : books) System.out.print(book + "\n");
    }
}
