import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Select the choice number: ");

            switch (choice) {
                case 1 -> registerMember();
                case 2 -> addBook();
                case 3 -> addMagazine();
                case 4 -> search();
                case 5 -> delete();
                case 6 -> library.showAllItems();
                case 7 -> library.showAllMembers();
                case 8 -> {
                    System.out.println("Exiting Library Management System...");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Enter 1-8.");
            }
        }
    }

    // ---------- menu ----------

    private static void showMenu() {
        System.out.println("\n==========================================");
        System.out.println("       Library Management System");
        System.out.println("==========================================");
        System.out.println("1. Register a member");
        System.out.println("2. Add a book");
        System.out.println("3. Add a magazine");
        System.out.println("4. Search");
        System.out.println("5. Delete");
        System.out.println("6. Show all items");
        System.out.println("7. Show all members");
        System.out.println("8. Exit");
    }

    // ---------- input helpers ----------

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static boolean confirm(String prompt) {
        String answer = readLine(prompt + " (yes/no): ").trim().toLowerCase();
        return answer.equals("yes") || answer.equals("y");
    }

    // ---------- add ----------

    private static void registerMember() {
        System.out.println("\n==== Register a new member ====");
        String name = readLine("Enter member name: ");
        String email = readLine("Enter member email: ");

        try {
            Member member = new Member(name, email);
            library.registerMember(member);
            System.out.println("Member registered successfully.");
            member.displayDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addBook() {
        System.out.println("\n==== Add a new book ====");
        String title = readLine("Enter book title: ");
        String author = readLine("Enter author: ");

        try {
            Book book = new Book(title, author);
            library.addItem(book);
            System.out.println("Book added successfully.");
            book.displayDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addMagazine() {
        System.out.println("\n==== Add a new magazine ====");
        String title = readLine("Enter magazine name: ");
        String publisher = readLine("Enter publisher: ");

        try {
            Magazine magazine = new Magazine(title, publisher);
            library.addItem(magazine);
            System.out.println("Magazine added successfully.");
            magazine.displayDetails();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------- search ----------

    private static void search() {
        System.out.println("\n1. Search member");
        System.out.println("2. Search item (book / magazine)");
        int choice = readInt("Choice: ");

        if (choice == 1) {
            String id = readLine("Enter member ID (e.g. M0001): ");
            Member member = library.findMemberById(id);
            if (member == null) {
                System.out.println("No member found with that ID.");
            } else {
                member.displayDetails();
            }
        } else if (choice == 2) {
            String id = readLine("Enter item ID (e.g. B0001 or MGZ001): ");
            LibraryItem item = library.findItemById(id);
            if (item == null) {
                System.out.println("No item found with that ID.");
            } else {
                item.displayDetails();
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // ---------- delete ----------

    private static void delete() {
        System.out.println("\n1. Delete member");
        System.out.println("2. Delete item (book / magazine)");
        int choice = readInt("Choice: ");

        if (choice == 1) {
            String id = readLine("Enter member ID: ");
            Member member = library.findMemberById(id);
            if (member == null) {
                System.out.println("No member found with that ID.");
                return;
            }
            member.displayDetails();
            if (confirm("Delete this member?")) {
                library.removeMember(id);
                System.out.println("Member deleted.");
            } else {
                System.out.println("Nothing changed.");
            }

        } else if (choice == 2) {
            String id = readLine("Enter item ID: ");
            LibraryItem item = library.findItemById(id);
            if (item == null) {
                System.out.println("No item found with that ID.");
                return;
            }
            item.displayDetails();
            if (confirm("Delete this item?")) {
                library.removeItem(id);
                System.out.println("Item deleted.");
            } else {
                System.out.println("Nothing changed.");
            }

        } else {
            System.out.println("Invalid choice.");
        }
    }
}