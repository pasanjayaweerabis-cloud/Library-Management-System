import java.util.ArrayList;

public class Members extends Items {
    private String memberName;
    private String memberID;
    private String memberEmail;

    private ArrayList<ArrayList<Object>> membersDataContainer = new ArrayList<>();

    public String getMemberID() {
        this.memberID = String.format("M%04d", membersDataContainer.size() + 1);
        return this.memberID;
    }

    public String addMember(String memberName, String memberEmail) {

        ArrayList<Object> memberData = new ArrayList<>();

        this.memberName = memberName;
        this.memberEmail = memberEmail;

        memberData.add(memberID);
        memberData.add(memberName);
        memberData.add(memberEmail);

        membersDataContainer.add(memberData);

        System.out.println("New Member,");
        System.out.println("ID :" + memberID);
        System.out.println("Name :" + memberName);
        System.out.println("Email :" + memberEmail);


        return "Member added successfully.";
    }


    @Override
    public void displayDetails() {

        System.out.println("All registered Members\n");

        for (ArrayList<Object> member : membersDataContainer) {
            System.out.println(member);
        }

    }
}
