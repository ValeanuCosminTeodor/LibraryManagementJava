import java.util.ArrayList;

class Client extends Person{
    private int nr_past_rentals;
    private int active_rentals;
    ArrayList<Book> books_rented= new ArrayList<>();


    public Client(String name, int age, Address address){
        this.nr_past_rentals = 0;
        this.name = name;
        this.age = age;
        this.address = address;
        this.active_rentals = 0;
    }

    public int getNr_past_rentals() {return nr_past_rentals;}

    public void setNr_past_rentals(int i) {this.nr_past_rentals = i;}

    public int getActive_rentals() {return active_rentals;}

    public void setActive_rentals(int i) {this.active_rentals = i;}

    public void rental(Book rented_book){
        if (rented_book.is_available()) {
            this.active_rentals = this.active_rentals + 1;
            books_rented.add(rented_book);
        }
        else System.out.println("Nu sunt exemplare disponibile pentru aceasta carte");
    }

    public void return_book(Book rented_book){
        this.active_rentals = this.active_rentals - 1;
        this.nr_past_rentals = this.nr_past_rentals + 1;
        books_rented.remove(rented_book);
    }

    public void details(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Number of past rentals: " + nr_past_rentals);
        System.out.println("Number of active rentals: " + active_rentals + "(Max 3 per client)");
    }
}
