import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    // ---------- helper ----------

    private String cleanId(String id) {
        if (id == null) {
            return "";
        }
        return id.replaceAll("\\s+", "").toUpperCase();
    }

    // ---------- items ----------

    public void addItem(LibraryItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
    }

    public LibraryItem findItemById(String id) {
        String cleaned = cleanId(id);
        for (LibraryItem item : items) {
            if (item.getId().equalsIgnoreCase(cleaned)) {
                return item;
            }
        }
        return null;   // not found
    }

    public boolean removeItem(String id) {
        LibraryItem item = findItemById(id);
        if (item == null) {
            return false;
        }
        return items.remove(item);
    }

    public void showAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        System.out.println("\n---- All Items ----");
        for (LibraryItem item : items) {
            item.displayDetails();   // polymorphism: Book or Magazine version runs
        }
    }

    // ---------- members ----------

    public void registerMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    public Member findMemberById(String id) {
        String cleaned = cleanId(id);
        for (Member member : members) {
            if (member.getMemberID().equalsIgnoreCase(cleaned)) {
                return member;
            }
        }
        return null;
    }

    public boolean removeMember(String id) {
        Member member = findMemberById(id);
        if (member == null) {
            return false;
        }
        return members.remove(member);
    }

    public void showAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No registered members.");
            return;
        }
        System.out.println("\n---- All Members ----");
        for (Member member : members) {
            member.displayDetails();
        }
    }
}