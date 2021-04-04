import java.util.ArrayList;

class Author extends Person{
    ArrayList<Book> books_published=new ArrayList<Book>();
    private int nr_books_published = 0;

    public Author(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public void addBooktoAuthor(Book newBook){
        books_published.add(newBook);
        nr_books_published = nr_books_published + 1;
    }
    public void details(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of books published: " + nr_books_published);
    }
}
