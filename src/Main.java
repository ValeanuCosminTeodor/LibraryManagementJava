import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

public class Main {

    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) throws Exception {
        biblioteca.FreshStart();
        biblioteca.LoadData();
        Address adresa1 = new Address("Strada 1", 225200, "Ap1");
        biblioteca.addresses.add(adresa1);
        Author autor1 = new Author("Petrica", 22, adresa1);
        biblioteca.authors.add(autor1);
        Editor editor1 = new Editor("Humanitas", 0);
        biblioteca.editors.add(editor1);
        Category cat1 = new Category("Filosofie");
        biblioteca.categories.add(cat1);
        biblioteca.Add_Book("Tanc Financiar", autor1, editor1, cat1, 100, 100);
        System.out.println(biblioteca.books.get(0).getTitle());
        Client client1 = new Client("Tudor", 50, adresa1);
        biblioteca.clients.add(client1);
        client1.rental(biblioteca.find_book("Tanc Financiar"));
        client1.return_book(biblioteca.find_book("Tanc Financiar"));
        System.out.println(client1.books_rented.size());
        biblioteca.find_book("Tanc Financiar").setName("Tanc Financiar 2");
        biblioteca.Remove_Book(biblioteca.find_book("Tanc Financiar 2"));
        client1.details();
        biblioteca.SaveData();
    }

}

