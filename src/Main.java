import java.util.Scanner;

public class Main {


    public static void menu() {
        System.out.println("=========================================");
        System.out.println("======  Library Management System  ======\n");
        System.out.println("1. Register as a member \n");
        System.out.println("2. Add a Book \n");
        System.out.println("3. Add a Magazine \n");
        System.out.println("4. Search for items (by ID or Title) \n");
        System.out.println("5. Delete an item (by ID or Title) \n");
        System.out.println("6. Exit\n");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Books book = new Books();
        Magazines mag = new Magazines();
        Members mem = new Members();

        while (true) {

            menu();

            System.out.println("Select the choice number : ");
            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) {

                System.out.println("New member ID: "+ mem.getMemberID());

                System.out.println("Enter member Name :");
                String memberName = sc.nextLine();

                System.out.println("Enter member email :");
                String memberEmail = sc.nextLine();

                System.out.println(mem.addMember(memberName, memberEmail));


            } else if (userChoice == 2) {

                System.out.println("Enter book ID: ");
                String bookID = sc.nextLine();
                System.out.println("Enter book Title: ");
                String bookTitle = sc.nextLine();
                System.out.println("Enter author: ");
                String bookAuthor = sc.nextLine();
                book.addBook(bookID, bookTitle, bookAuthor);

                System.out.println(book.booksDataContainer);

            } else if (userChoice == 3) {

                System.out.println("Enter magazine ID: ");
                String magazineID = sc.nextLine();
                System.out.println("Enter magazine Name: ");
                String magazineName = sc.nextLine();

                mag.addMagazine(magazineID, magazineName);

                //System.out.println(mag.magazineDataContainer);
                System.out.println(mag.magazineData);

            } else if (userChoice == 4) {
                mem.displayDetails();
            } else if (userChoice == 5) {

            } else if (userChoice == 6) {
                System.out.println("Exiting Library Management System...");
                break;
            }


        }


    }
}

