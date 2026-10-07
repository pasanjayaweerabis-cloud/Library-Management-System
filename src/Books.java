import java.util.ArrayList;
public class Books extends Items {

    private String bookID;
    private String bookTitle;
    private String author;
    private String bookAvailability;

    ArrayList<ArrayList<Object>> booksDataContainer = new ArrayList<>();
    ArrayList<Object> booksData = new ArrayList<>();

    public void setData(String bookID,String bookTitle,String author){

        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.author = author;

        booksData.add(bookID);
        booksData.add(bookTitle);
        booksData.add(author);

        booksDataContainer.add(booksData);

    }

    @Override
    public void displayDetails() {
        System.out.println("Book ID: " + bookID );
        System.out.println("Book Title: " + bookTitle );
        System.out.println("Author: " + author );
//        System.out.println("Book Availability: " + bookAvailability );

        System.out.println(booksData);

    }
}
