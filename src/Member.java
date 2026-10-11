public class Member {

    private static int counter = 0;

    private final String memberID;
    private final String memberName;
    private String memberEmail;

    public Member(String memberName, String memberEmail) {
        // final fields must be assigned exactly once, inside the constructor
        this.memberName = cleanName(memberName);
        this.memberEmail = cleanAndValidateEmail(memberEmail);
        this.memberID = generateMemberID();   // ID created only after input is valid
    }

    // ---------- private helpers ----------

    private static String generateMemberID() {
        counter++;
        return String.format("M%04d", counter);
    }

    private static String cleanName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        return name.trim().replaceAll("\\s+", " ");
    }

    private static String cleanAndValidateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        String cleaned = email.replaceAll("\\s+", "").toLowerCase();

        int at = cleaned.indexOf('@');
        int lastDot = cleaned.lastIndexOf('.');

        boolean valid = at > 0                              // something before @
                && at == cleaned.lastIndexOf('@')           // only one @
                && lastDot > at + 1                         // a dot after @, not right next to it
                && !cleaned.endsWith(".");                  // doesn't end with a dot

        if (!valid) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        return cleaned;
    }

    // ---------- getters ----------

    public String getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    // ---------- setter (validated) ----------

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = cleanAndValidateEmail(memberEmail);
    }

    // ---------- display ----------

    public void displayDetails() {
        System.out.println("Member ID: " + memberID
                + " | Name: " + memberName
                + " | Email: " + memberEmail);
    }

    @Override
    public String toString() {
        return "Member[" + memberID + ", " + memberName + ", " + memberEmail + "]";
    }
}