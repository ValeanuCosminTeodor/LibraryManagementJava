public class Main {

    public static void main(String[] args) {
        Address adresa1 = new Address("Strada 1", 225200, "Ap1");
        Author autor1 = new Author("Petrica", 22, adresa1);
        Editor editor1 = new Editor("Humanitas", adresa1);
        Category cat1 = new Category("Filosofie");
        Book book1 = new Book("Tanc Financiar", autor1, editor1, cat1, 100, 100);
        autor1.addBooktoAuthor(book1);
        editor1.addBooktoEditor(book1);
        cat1.addBooktoCategory(book1);
        System.out.println(book1.getTitle());
        Client client1 = new Client("Tudorelu", 50, adresa1);
        client1.rental(book1);
        client1.return_book(book1);
        System.out.println(client1.books_rented.size());
    }
}
