import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    Statement establishConn(){
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "pao123");

            return conn.createStatement();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

    void DBAddAuthor(int id, String author_name, int age, String address, int nr_books_published){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO author VALUES" +
                    "('"+ id +"','" + author_name + "','" + age + "','" + address + "','" + nr_books_published+ "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowAuthors(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery("select * from author");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("author_name")+" "
                        +resultSet.getString("age")+" "
                        +resultSet.getString("author_address")+
                        " Number of books published:"+resultSet.getString("nr_books_published"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateAuthor(int id, String author_name, int age, String address, int nr_books_published){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update author set author_name = '" + author_name + "', age = " +
                    age + ", author_address = '" + address +"', nr_books_published = " + nr_books_published +
                    " where idauthor = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    void DBRemoveAuthor(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from author where idauthor = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void DBAddEditor(int id, String editor_name, int nr_books_published){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO editor VALUES" +
                    "('"+ id +"','" + editor_name + "','" + nr_books_published+ "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowEditors(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery("select * from editor");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("editor_name")+" "+
                        " Number of books published:"+resultSet.getString("nr_books_published"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateEditor(int id, String editor_name, int nr_books_published){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update editor set editor_name = '" + editor_name
                    +"', nr_books_published = " + nr_books_published +
                    " where ideditor = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void DBRemoveEditor(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from editor where ideditor = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void DBAddCategory(int id, String category_name){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO category VALUES" +
                    "('"+ id +"','" + category_name + "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowCategories(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery("select * from category");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("category_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateCategory(int id, String category_name){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update category set category_name = '" + category_name +"'"+
                    " where idcategory = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void DBRemoveCategory(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from category where idcategory = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void DBAddEmployee(int id, String employee_name, int age, String address, int salary, String position){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO employee VALUES" +
                    "('"+ id +"','" + employee_name + "','" + age + "','" + address + "','" + salary + "','" + position + "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowEmployees(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("employee_name")+" "
                        +resultSet.getString("age")+" "
                        +resultSet.getString("address")+
                        " Salary:"+resultSet.getString("salary")
                        +" "+resultSet.getString("position"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateEmployee(int id, String employee_name, int age, String address, int salary, String position){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update employee set employee_name = '" + employee_name + "', age = " +
                    age + ", address = '" + address +"', salary = " + salary +", position = '" + position + "'" +
                    " where idemployee = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void DBRemoveEmployee(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from employee where idemployee = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void DBAddClient(int id, String client_name, int age, String address, int nr_past_rentals, int nr_active_rentals){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO client VALUES" +
                    "('"+ id +"','" + client_name + "','" + age + "','" + address + "','" + nr_past_rentals + "','" + nr_active_rentals + "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowClients(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery("select * from client");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("client_name")+" "
                        +resultSet.getString("age")+" "
                        +resultSet.getString("address")+
                        " Number of past rentals:"+resultSet.getString("nr_past_rentals")
                        +" Number of active rentals:"+resultSet.getString("nr_active_rentals"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateClient(int id, String client_name, int age, String address, int nr_past_rentals, int nr_active_rentals){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update client set client_name = '" + client_name + "', age = " +
                    age + ", address = '" + address +"', nr_past_rentals = " + nr_past_rentals +", nr_active_rentals = '" + nr_active_rentals + "'" +
                    " where idclient = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void DBRemoveClient(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from client where idclient = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void DBAddBook(int id, int author_id, int editor_id, int category_id,String title, int copies, int available_copies ){
        Statement statement = establishConn();
        try {
            statement.executeUpdate("INSERT INTO book VALUES" +
                    "('"+ id +"','" + author_id + "','" + editor_id + "','" + category_id + "','" + title + "','" + copies + "','" + available_copies + "')");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBShowBooks(){
        Statement statement = establishConn();
        try {

            ResultSet resultSet = statement.executeQuery(
                    "SELECT book.title, author.author_name, editor.editor_name, category.category_name, book.copies, book.available_copies\n" +
                    "FROM book\n" +
                    "JOIN author on author.idauthor = book.author_id\n" +
                    "JOIN editor on editor.ideditor = book.editor_id\n" +
                    "JOIN category on category.idcategory = book.category_id");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("title")+" "
                        +resultSet.getString("author_name")+" "
                        +resultSet.getString("editor_name")+" "
                        +resultSet.getString("category_name")+
                        " Number of copies:"+resultSet.getString("copies")
                        +" Number of available copies:"+resultSet.getString("available_copies"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void DBUpdateBook(int id, int author_id, int editor_id, int category_id,String title, int copies, int available_copies ){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("update book set author_id = " + author_id + ", editor_id = " +
                    editor_id + ", category_id = " + category_id +", title = '" + title +"', copies = '" + copies +"', available_copies = '" + available_copies + "'" +
                    " where idbook = '" + id + "';");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    void DBRemoveBook(int id){
        Statement statement = establishConn();
        try{
            statement.executeUpdate("delete from book where idbook = '" + id +"';");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
