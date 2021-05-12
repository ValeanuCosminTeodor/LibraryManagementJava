public class Book implements Comparable<Book>{
    private String title;
    private Author author;
    private Editor editor;
    private Category category;
    private int copies;
    private int available_copies;

    public Book (String newTitle, Author newAuthor, Editor newEditor, Category newCategory, int newcopies, int newavailable_copies){
        this.title = newTitle;
        this.author = newAuthor;
        this.editor = newEditor;
        this.category = newCategory;
        this.copies = newcopies;
        this.available_copies = newavailable_copies;
        author.addBooktoAuthor(this);
    }

    public Author getAuthor(){ return author;}

    public Editor getEditor(){ return editor;}

    public Category getCategory(){ return category;}

    public String getTitle() {
        return title;
    }

    public int getCopies() { return copies;}

    public int getAvailable_copies() { return available_copies;}

    public void setName(String newTitle) {
        this.title = newTitle;
    }

    public void addCopies(int nr_newcopies){
        this.copies = this.copies + nr_newcopies;
    }

    public void rentcopy(){
        this.available_copies = this.available_copies - 1;
    }

    public boolean is_available(){
        return this.available_copies > 0;
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }
}
