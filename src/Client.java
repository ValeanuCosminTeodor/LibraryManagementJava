import java.util.ArrayList;

class Client extends Person{
    private int nr_past_rentals;
    ArrayList<Book> books_rented= new ArrayList<Book>();
    private int active_rentals = 3;

    public Client(String name, int age, Address address){
        this.nr_past_rentals = 0;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void rental(Book rented_book){
        if (rented_book.is_available()) {
            active_rentals = active_rentals - 1;
            books_rented.add(rented_book);
        }
        else System.out.println("Nu sunt exemplare disponibile pentru aceasta carte");
    }

    public void return_book(Book rented_book){
        books_rented.remove(rented_book);
        active_rentals = active_rentals + 1;
        nr_past_rentals = nr_past_rentals + 1;
    }

    public void details(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of past rentals: " + nr_past_rentals);
        System.out.println("Number of active rentals: " + nr_past_rentals + "(Max 3 per client)");
    }
}
