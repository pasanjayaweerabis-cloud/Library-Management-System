import java.util.ArrayList;

public class Books extends Items {

    private String bookID;
    private String bookTitle;
    private String author;
    private String bookAvailability;
    private ArrayList<ArrayList<Object>> booksDataContainer = new ArrayList<>();


    public String getBookID() {
        this.bookID = String.format("B%04d", booksDataContainer.size() + 1);
        return this.bookID;
    }

    public String addBook(String bookTitle, String author) {
        ArrayList<Object> booksData = new ArrayList<>();

        this.bookTitle = bookTitle;
        this.author = author;

        booksData.add(this.bookID);
        booksData.add(bookTitle);
        booksData.add(author);

        booksDataContainer.add(booksData);

        System.out.println("New Member,");
        System.out.println("ID :" + this.bookID);
        System.out.println("Name :" + bookTitle);
        System.out.println("Author :" + author);

        return "\nBook added successfully.";

    }

    public void searchBook(String lookBookID){

        for (ArrayList<Object> lookBook:booksDataContainer){

            if (lookBook.get(0).equals(lookBookID)){
                System.out.println("Book Found,\n");
                System.out.println("Book Title: " + lookBook.get(1));
                System.out.println("Author : " + lookBook.get(2));
            }else {
                System.out.println("No book for this ID !!!");
            }
        }

    }

    public void deleteBook(String targetBookID){

        int i = 0;

        for (ArrayList<Object> targetBook:booksDataContainer ){

            if (targetBook.get(0).equals(targetBookID.trim().toUpperCase().replaceAll("\\s+",""))){
                System.out.println("Book Found,\n");
                System.out.println("Book Title: " + targetBook.get(1));
                System.out.println("Author : " + targetBook.get(2));

                booksDataContainer.remove(i);
                System.out.println(booksDataContainer);

            }else {
                i++;
            }
        }

    }


    @Override
    public void displayDetails() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Book Title: " + bookTitle);
        System.out.println("Author: " + author);
//        System.out.println("Book Availability: " + bookAvailability );


    }
}

