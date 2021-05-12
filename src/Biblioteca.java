import java.util.ArrayList;
import java.util.Vector;

public class Biblioteca {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Author> authors = new ArrayList<>();
    ArrayList<Editor> editors = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Category> categories = new ArrayList<>();
    ArrayList<Address>  addresses = new ArrayList<>();

    public void Add_Book(String newTitle, Author newAuthor, Editor newEditor, Category newCategory, int newcopies, int newavailable_copies){
        Book book1 = new Book(newTitle, newAuthor, newEditor, newCategory, newcopies, newavailable_copies);
        newAuthor.addBooktoAuthor(book1);
        newEditor.addBooktoEditor(book1);
        newCategory.addBooktoCategory(book1);
        books.add(book1);
        System.out.println(book1.getTitle() + " a fost adaugata cu succes");
    }

    public void Remove_Book(Book book){
        books.remove(book);
        book.getAuthor().books_published.remove(book);
        book.getEditor().books_published.remove(book);
        book.getCategory().books.remove(book);
        System.out.println(book.getTitle() + " a fost stearsa cu succes");
    }

    public Book find_book(String title){
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Vector <Vector <String>>  saveBooks()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Book book : this.books)
        {
            Vector <String> line = new Vector <> ();

            line.add (book.getTitle ());
            line.add (book.getAuthor().getName());
            line.add (book.getEditor().getName());
            line.add (book.getCategory().getName());
            line.add (Integer.toString (book.getCopies ()));
            line.add (Integer.toString (book.getAvailable_copies()));

            Values.add (line);
        }

        return (Values);
    }

    public void loadBooks (Vector <Vector <String>> books) throws Exception {
        for (Vector <String> line : books)
        {
            this.Add_Book (line.get (0), Find_Author(line.get (1)), Find_Editor(line.get(2)), Find_Category(line.get(3)), Integer.parseInt (line.get (4)), Integer.parseInt (line.get (5)));
        }
    }

    public Author Find_Author(String name){
        for (Author author : this.authors)
        {
            if (author.getName().equals(name)) return author;
        }
        return null;
    }

    public Editor Find_Editor(String name){
        for (Editor editor : this.editors)
        {
            if (editor.getName().equals(name)) return editor;
        }
        return null;
    }

    public Category Find_Category(String name){
        for (Category category : this.categories)
        {
            if (category.getName().equals(name)) return category;
        }
        return null;
    }

    public Vector <Vector <String>>  saveAddresses()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Address address : this.addresses)
        {
            Vector <String> line = new Vector <> ();

            line.add (address.getStreet ());
            line.add (Integer.toString (address.getZip_code ()));
            line.add (address.getApartament());

            Values.add (line);
        }

        return (Values);
    }

    public void loadAddresses (Vector <Vector <String>> addresses) throws Exception {
        for (Vector <String> line : addresses)
        {
            Address addressaux = new Address(line.get(0), Integer.parseInt (line.get(1)), line.get(2) );
            this.addresses.add(addressaux);
        }
    }

    public Vector <Vector <String>>  saveAuthors()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Author author : this.authors)
        {
            Vector <String> line = new Vector <> ();

            line.add (author.getName());
            line.add (Integer.toString (author.getAge ()));
            line.add (author.getAddress().getStreet());
            line.add (Integer.toString(author.getAddress().getZip_code()));
            line.add (author.getAddress().getApartament());
            line.add (Integer.toString (author.getNr_books_published ()));
            Values.add (line);
        }

        return (Values);
    }

    public void loadAuthors (Vector <Vector <String>> authors) throws Exception {
        for (Vector <String> line : authors)
        {
            Address addressaux = new Address(line.get(2), Integer.parseInt (line.get(3)), line.get(4) );
            Author authoraux = new Author(line.get(0),Integer.parseInt (line.get(1)), addressaux);
            authoraux.setBooks_published(Integer.parseInt(line.get(5)));
            this.authors.add(authoraux);
        }
    }

    public Vector <Vector <String>>  saveCategories()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Category category : this.categories)
        {
            Vector <String> line = new Vector <> ();

            line.add (category.getName());

            Values.add (line);
        }

        return (Values);
    }

    public void loadCategories (Vector <Vector <String>> categories) throws Exception {
        for (Vector <String> line : categories)
        {
            Category categoryaux = new Category(line.get(0));
            this.categories.add(categoryaux);
        }
    }

    public Vector <Vector <String>>  saveClients()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Client client : this.clients)
        {
            Vector <String> line = new Vector <> ();

            line.add (client.getName());
            line.add (Integer.toString (client.getAge ()));
            line.add (client.getAddress().getStreet());
            line.add (Integer.toString(client.getAddress().getZip_code()));
            line.add (client.getAddress().getApartament());
            line.add (Integer.toString (client.getNr_past_rentals ()));
            line.add (Integer.toString (client.getActive_rentals()));
            for (Book book : client.books_rented)
            {
                line.add (book.getTitle());
            }

            Values.add (line);
        }

        return (Values);
    }

    public void loadClients (Vector <Vector <String>> clients) throws Exception {
        for (Vector <String> line : clients)
        {
            Address addressaux = new Address(line.get(2), Integer.parseInt (line.get(3)), line.get(4) );
            Client clientaux = new Client(line.get(0),Integer.parseInt (line.get(1)), addressaux);
            clientaux.setNr_past_rentals(Integer.parseInt(line.get(5)));
            clientaux.setActive_rentals(Integer.parseInt(line.get(6)));
            this.clients.add(clientaux);
        }
    }

    public Vector <Vector <String>>  saveEditors()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Editor editor : this.editors)
        {
            Vector <String> line = new Vector <> ();

            line.add (editor.getName());
            line.add (Integer.toString (editor.getNr_books_published()));

            Values.add (line);
        }

        return (Values);
    }

    public void loadEditors (Vector <Vector <String>> editors) throws Exception {
        for (Vector <String> line : editors)
        {
            Editor editoraux = new Editor(line.get(0), Integer.parseInt(line.get(1)));
            this.editors.add(editoraux);
        }
    }

    public Vector <Vector <String>>  saveEmployees()
    {
        Vector <Vector <String>> Values = new Vector <> ();

        for (Employee employee : this.employees)
        {
            Vector <String> line = new Vector <> ();

            line.add (employee.getName());
            line.add (Integer.toString (employee.getAge ()));
            line.add (employee.getAddress().getStreet());
            line.add (Integer.toString(employee.getAddress().getZip_code()));
            line.add (employee.getAddress().getApartament());
            line.add (Integer.toString (employee.getSalary ()));
            line.add (employee.getPosition());

            Values.add (line);
        }

        return (Values);
    }

    public void loadEmployees (Vector <Vector <String>> employees) throws Exception {
        for (Vector <String> line : employees)
        {
            Address addressaux = new Address(line.get(2), Integer.parseInt (line.get(3)), line.get(4) );
            Employee employeeaux = new Employee(line.get(0),Integer.parseInt (line.get(1)), addressaux, Integer.parseInt(line.get(5)), line.get(6));
            this.employees.add(employeeaux);
        }
    }

    void SaveData() {
        CSVMng.getInstance().saveCSV (this.saveAddresses (), "Addresses.csv");
        CSVMng.getInstance().saveCSV (this.saveBooks (), "Books.csv");
        CSVMng.getInstance().saveCSV (this.saveAuthors (), "Authors.csv");
        CSVMng.getInstance().saveCSV (this.saveCategories (), "Categories.csv");
        CSVMng.getInstance().saveCSV (this.saveClients (), "Clients.csv");
        CSVMng.getInstance().saveCSV (this.saveEditors (), "Editors.csv");
        CSVMng.getInstance().saveCSV (this.saveEmployees (), "Employees.csv");
    }

    void LoadData () throws Exception {

        this.loadAddresses (CSVMng.getInstance ().loadCSV ("Addresses.csv"));
        this.loadAuthors (CSVMng.getInstance ().loadCSV ("Authors.csv"));
        this.loadCategories (CSVMng.getInstance ().loadCSV ("Categories.csv"));
        this.loadClients (CSVMng.getInstance ().loadCSV ("Clients.csv"));
        this.loadEditors (CSVMng.getInstance ().loadCSV ("Editors.csv"));
        this.loadEmployees (CSVMng.getInstance ().loadCSV ("Employees.csv"));
        this.loadBooks (CSVMng.getInstance ().loadCSV ("Books.csv"));
    }

    void FreshStart(){
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<Editor> editors = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Address>  addresses = new ArrayList<>();
    }
}
