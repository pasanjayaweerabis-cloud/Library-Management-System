import java.util.Scanner;
public class Main {

    public static void menu(){
        System.out.println("=========================================");
        System.out.println("======  Library Management System  ======\n");
        System.out.println("1. Register as a member\n");
        System.out.println("2. Add a Book\n");
        System.out.println("3. Add a Magazine\n");
        System.out.println("4. Search for items (by ID or Title)\n");
        System.out.println("5. Exit");
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Books book = new Books();
        Magazines mag = new Magazines();

        menu();

        System.out.println("Select the choice number : ");
        int userChoice = sc.nextInt();
        sc.nextLine();

        if(userChoice == 1){

        }

        if (userChoice == 2){

            System.out.println("Enter book ID: ");
            String bookID = sc.nextLine();
            System.out.println("Enter book Title: ");
            String bookTitle = sc.nextLine();
            System.out.println("Enter author: ");
            String bookAuthor = sc.nextLine();
            book.setData(bookID,bookTitle,bookAuthor);

            //System.out.println(book.booksDataContainer);
            System.out.println(book.booksData);

        }

        if(userChoice == 3){

            System.out.println("Enter magazine ID: ");
            String magazineID = sc.nextLine();
            System.out.println("Enter magazine Name: ");
            String magazineName = sc.nextLine();

            mag.setData(magazineID,magazineName);

            //System.out.println(mag.magazineDataContainer);
            System.out.println(mag.magazineData);

        }

        if(userChoice == 4){

        }

        if(userChoice == 5){

        }

        if(userChoice == 6){

        }

        if(userChoice == 7){

        }




    }
}

