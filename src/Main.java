import java.util.Scanner;

public class Main implements venomCodes {

    static Scanner sc = new Scanner(System.in);
    static Books book = new Books();
    static Magazines mag = new Magazines();
    static Members mem = new Members();

    public static void menu() {
        System.out.println("===========================================================================================================================");
        System.out.println("======  Library Management System  ===============================================\n");
        System.out.println("1. Register as a member ");
        System.out.println("2. Add a Book ");
        System.out.println("3. Add a Magazine ");
        System.out.println("4. Search an items  ");
        System.out.println("5. Delete an items ");
        System.out.println("6. Exit\n");
    }

    static public void addMember() {

        System.out.println("\n==== Adding a new member =====\n");
        System.out.println("New member ID: " + mem.getMemberID());

        System.out.print("Enter member Name: ");
        String memberName = sc.nextLine();
        System.out.print("Enter member Email: ");
        String memberEmail = sc.nextLine();

        System.out.println(mem.addMember(memberName, memberEmail));
    }

    static public void addBook() {

        System.out.println("\n==== Adding a new Book =====\n");
        System.out.println("New book ID: " + book.getBookID());

        System.out.print("Enter book Title: ");
        String bookTitle = sc.nextLine();
        System.out.print("Enter author: ");
        String bookAuthor = sc.nextLine();

        System.out.println(book.addBook(bookTitle, bookAuthor));
    }

    static public void addMagazine() {

        System.out.println("\n==== Adding a new Magazine =====\n");
        System.out.println("New magazine ID: " + mag.getMagazineID());

        System.out.print("Enter magazine Name: ");
        String magazineName = sc.nextLine();
        System.out.print("Enter magazine Provider: ");
        String magazineProvider = sc.nextLine();

        System.out.println(mag.addMagazine(magazineName, magazineProvider));
    }

    static public void searchMember() {
        System.out.println("Enter member ID : (Ex: M0001)");
        String lookMemberID = sc.nextLine();

        mem.searchMember(lookMemberID);
    }

    static public void searchBook() {
        System.out.println("Enter Book ID : (Ex: B0001)");
        String lookBookID = sc.nextLine();

        book.searchBook(lookBookID);
    }

    static public void searchMagazine() {
        System.out.println("Enter magazine ID : (Ex: Mgz001)");
        String lookMagazineID = sc.nextLine();

        mag.searchMagazine(lookMagazineID);
    }

    static public void deleteMember() {
        System.out.println("Enter member ID : (Ex: M0001)");
        String targetMemberID = sc.nextLine();

        mem.deleteMember(targetMemberID);
    }

    static public void deleteBook() {
        System.out.println("Enter Book ID : (Ex: B0001)");
        String targetBookID = sc.nextLine();

        book.deleteBook(targetBookID);
    }

    static public void deleteMagazine() {
        System.out.println("Enter magazine ID : (Ex: Mgz001)");
        String targetMagazineID = sc.nextLine();

        mag.deleteMagazine(targetMagazineID);
    }

    @Override
    public void adminMode() {
        System.out.println("Pasan");
    }

    static public void exit() {
        System.out.println("Exiting Library Management System...");
    }

////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        while (true) {
            menu();
            System.out.println("Select the choice number : ");
            int userChoice = sc.nextInt();
            sc.nextLine();

            if (userChoice == 1) {
                addMember();
            } else if (userChoice == 2) {
                addBook();
            } else if (userChoice == 3) {
                addMagazine();
            } else if (userChoice == 4) {

                System.out.println("-----Enter Choice number-----\n");
                System.out.print("1.Search Member");
                System.out.print("2.Search Book");
                System.out.print("3.Search Magazine\n");

                System.out.println("Choice number : ");
                int searchNum = sc.nextInt();
                sc.nextLine();

                if (searchNum == 1) {
                    searchMember();
                } else if (searchNum == 2) {
                    searchBook();
                } else if (searchNum == 3) {
                    searchMagazine();
                }

            } else if (userChoice == 5) {

                System.out.println("-----Enter Choice number-----\n");
                System.out.print("1.Delete Member");
                System.out.print("2.Delete Book");
                System.out.print("3.Delete Magazine\n");

                System.out.println("Enter the Number : ");
                int deleteNum = sc.nextInt();
                sc.nextLine();

                if (deleteNum == 1) {
                    deleteMember();
                } else if (deleteNum == 2) {
                    deleteBook();
                } else if (deleteNum == 3) {
                    deleteMagazine();
                }

            } else if (userChoice == 6) {
                exit();
                break;
            }
        }
    }
}
