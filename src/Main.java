import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Scanner;
import java.sql.*;

public class Main {

    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) throws Exception {
        biblioteca.FreshStart();
        //biblioteca.LoadData();
        System.out.println("Welcome to library database! ");
        System.out.println("1. See all entries from...");
        System.out.println("2. Add an entry to...");
        System.out.println("3. Update an entry from...");
        System.out.println("4. Remove an entry from...");
        System.out.println("5. Add a rental for a client");
        System.out.println();
        System.out.println("0. Exit");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type the number of the action you want: ");
        int option = keyboard.nextInt();
        while (option != 0){
            if (option == 1){
                System.out.println("1. Books");
                System.out.println("2. Authors");
                System.out.println("3. Categories");
                System.out.println("4. Clients");
                System.out.println("5. Editors");
                System.out.println("6. Employees");
                System.out.println("Type the number of the action you want: ");
                int option2 = keyboard.nextInt();
                if (option2==1) {
                    biblioteca.DBShowBooks();
                }
                if (option2==2) {
                    biblioteca.DBShowAuthors();
                }
                if (option2==3) {
                    biblioteca.DBShowCategories();
                }
                if (option2==4) {
                    biblioteca.DBShowClients();
                }
                if (option2==5) {
                    biblioteca.DBShowEditors();
                }
                if (option2==6) {
                    biblioteca.DBShowEmployees();
                }
                System.out.println("----------------------------------");
            }

            if (option == 2){
                System.out.println("1. Books");
                System.out.println("2. Authors");
                System.out.println("3. Categories");
                System.out.println("4. Clients");
                System.out.println("5. Editors");
                System.out.println("6. Employees");
                System.out.println("Type the number of the action you want: ");
                int option2 = keyboard.nextInt();
                if (option2==1) {
                    System.out.println("Book ID: ");
                    int id_book = keyboard.nextInt();
                    System.out.println("Author ID: ");
                    int id_author = keyboard.nextInt();
                    System.out.println("Editor ID: ");
                    int id_editor = keyboard.nextInt();
                    System.out.println("Category ID: ");
                    int id_category = keyboard.nextInt();
                    System.out.println("Title: ");
                    keyboard.nextLine();
                    String title = keyboard.nextLine();
                    System.out.println("Number of copies: ");
                    int copies = keyboard.nextInt();
                    System.out.println("Number of available copies: ");
                    int available_copies = keyboard.nextInt();
                    biblioteca.DBAddBook(id_book, id_author, id_editor, id_category, title, copies, available_copies);
                }
                if (option2==2) {
                    System.out.println("Author ID: ");
                    int id_author = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Number of books published: ");
                    int nr_books_published = keyboard.nextInt();
                    biblioteca.DBAddAuthor(id_author, name, age, address, nr_books_published);
                }
                if (option2==3) {
                    System.out.println("Category ID: ");
                    int id_category = keyboard.nextInt();
                    System.out.println("Title:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    biblioteca.DBAddCategory(id_category, name);
                }
                if (option2==4) {
                    System.out.println("Client ID: ");
                    int id_client = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Number of past rentals: ");
                    int nr_past_rentals = keyboard.nextInt();
                    System.out.println("Number of active rentals(Max 3): ");
                    int nr_active_rentals = keyboard.nextInt();
                    biblioteca.DBAddClient(id_client, name, age, address, nr_past_rentals, nr_active_rentals);
                }
                if (option2==5) {
                    System.out.println("Editor ID: ");
                    int id_editor = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Number of books published: ");
                    int nr_books = keyboard.nextInt();
                    biblioteca.DBAddEditor(id_editor, name, nr_books);
                }
                if (option2==6) {
                    System.out.println("Employee ID: ");
                    int id_employee = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Salary: ");
                    int salary = keyboard.nextInt();
                    System.out.println("Position:");
                    keyboard.nextLine();
                    String position = keyboard.nextLine();
                    biblioteca.DBAddEmployee(id_employee, name, age, address, salary, position);
                }
                System.out.println("----------------------------------");
            }
            if (option==3){
                System.out.println("1. Books");
                System.out.println("2. Authors");
                System.out.println("3. Categories");
                System.out.println("4. Clients");
                System.out.println("5. Editors");
                System.out.println("6. Employees");
                System.out.println("Type the number of the action you want: ");
                int option2 = keyboard.nextInt();
                if (option2 == 1){
                    System.out.println("Book ID: ");
                    int id_book = keyboard.nextInt();
                    System.out.println("Author ID: ");
                    int id_author = keyboard.nextInt();
                    System.out.println("Editor ID: ");
                    int id_editor = keyboard.nextInt();
                    System.out.println("Category ID: ");
                    int id_category = keyboard.nextInt();
                    System.out.println("Title: ");
                    keyboard.nextLine();
                    String title = keyboard.nextLine();
                    System.out.println("Number of copies: ");
                    int copies = keyboard.nextInt();
                    System.out.println("Number of available copies: ");
                    int available_copies = keyboard.nextInt();
                    biblioteca.DBUpdateBook(id_book, id_author, id_editor, id_category, title, copies, available_copies);
                }
                if (option2 == 2){
                    System.out.println("Author ID: ");
                    int id_author = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Number of books published: ");
                    int nr_books_published = keyboard.nextInt();
                    biblioteca.DBUpdateAuthor(id_author, name, age, address, nr_books_published);
                }
                if (option2 == 3){
                    System.out.println("Category ID: ");
                    int id_category = keyboard.nextInt();
                    System.out.println("Title:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    biblioteca.DBUpdateCategory(id_category, name);
                }
                if (option2 == 4){
                    System.out.println("Client ID: ");
                    int id_client = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Number of past rentals: ");
                    int nr_past_rentals = keyboard.nextInt();
                    System.out.println("Number of active rentals(Max 3): ");
                    int nr_active_rentals = keyboard.nextInt();
                    biblioteca.DBUpdateClient(id_client, name, age, address, nr_past_rentals, nr_active_rentals);
                }
                if (option2 == 5){
                    System.out.println("Editor ID: ");
                    int id_editor = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Number of books published: ");
                    int nr_books = keyboard.nextInt();
                    biblioteca.DBUpdateEditor(id_editor, name, nr_books);
                }
                if (option2 == 6){
                    System.out.println("Employee ID: ");
                    int id_employee = keyboard.nextInt();
                    System.out.println("Name:");
                    keyboard.nextLine();
                    String name = keyboard.nextLine();
                    System.out.println("Age: ");
                    int age = keyboard.nextInt();
                    System.out.println("Address:");
                    keyboard.nextLine();
                    String address = keyboard.nextLine();
                    System.out.println("Salary: ");
                    int salary = keyboard.nextInt();
                    System.out.println("Position:");
                    keyboard.nextLine();
                    String position = keyboard.nextLine();
                    biblioteca.DBUpdateEmployee(id_employee, name, age, address, salary, position);
                }
                System.out.println("----------------------------------");
            }
            if (option==4){
                System.out.println("1. Books");
                System.out.println("2. Authors");
                System.out.println("3. Categories");
                System.out.println("4. Clients");
                System.out.println("5. Editors");
                System.out.println("6. Employees");
                System.out.println("Type the number of the action you want: ");
                int option2 = keyboard.nextInt();
                if (option2==1){
                    System.out.println("Book ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveBook(id);
                }
                if (option2==2){
                    System.out.println("Author ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveAuthor(id);
                }
                if (option2==3){
                    System.out.println("Category ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveCategory(id);
                }
                if (option2==4){
                    System.out.println("Client ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveClient(id);
                }
                if (option2==5){
                    System.out.println("Editor ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveEditor(id);
                }
                if (option2==6){
                    System.out.println("Employee ID: ");
                    int id = keyboard.nextInt();
                    biblioteca.DBRemoveEmployee(id);
                }
                System.out.println("----------------------------------");
            }
            if (option==5){
                System.out.println("rental");
            }
            if (option<0 || option>5){
                System.out.println("There is no action with that number");
                System.out.println();
            }
            System.out.println("1. See all entries from...");
            System.out.println("2. Add an entry to...");
            System.out.println("3. Update an entry from...");
            System.out.println("4. Remove an entry from...");
            System.out.println("5. Add a rental for a client");
            System.out.println();
            System.out.println("0. Exit");
            option = keyboard.nextInt();
        }
        //biblioteca.SaveData();
        /*
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
        biblioteca.SaveData(); */
    }

}

