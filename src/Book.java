public class Book extends LibraryItem {

    private static int counter = 0;
    private String author;

    public Book(String title, String author) {
        super(generateBookID(), title.trim().replaceAll("\\s+", " "));
        this.author = author.trim().replaceAll("\\s+", " ");
    }

    private static String generateBookID() {
        counter++;
        return String.format("B%04d", counter);
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Status: " + (getIsAvailable() ? "Available" : "Borrowed"));
    }

    @Override // toString is predefined java method where always placed in parent/super class. Must be return String
    public String toString() {
        return "Book ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author;
    }
}