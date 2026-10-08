import java.util.ArrayList;
import java.util.Scanner;
public class Members extends Items {

    Scanner sc = new Scanner(System.in);

    private String memberID;
    private String memberName;
    private String memberEmail;
    private ArrayList<ArrayList<Object>> membersDataContainer = new ArrayList<>();

    public String getMemberID() {
        memberID = String.format("M%04d", membersDataContainer.size() + 1);
        return memberID;
    }

    public String addMember(String memberName, String memberEmail) {

        ArrayList<Object> memberData = new ArrayList<>();

        this.memberName = memberName.trim().replaceAll("\\s+"," ").toUpperCase();
        this.memberEmail = memberEmail.trim().replaceAll("\\s+","");

        memberData.add(memberID);
        memberData.add(this.memberName);
        memberData.add(this.memberEmail);

        membersDataContainer.add(memberData);

        System.out.println("\n"+memberID + ", " + this.memberName +", "+ this.memberEmail);

        return "Member added successfully.\n";
    }


    public void searchMember(String lookMemberID){

        for (ArrayList<Object> lookMember:membersDataContainer ){

            if (lookMember.get(0).equals(lookMemberID.trim().toUpperCase().replaceAll("\\s+",""))){
                System.out.println("Member Found,\n");
                System.out.println(lookMember.get(0));
                System.out.println("Member Name: " + lookMember.get(1));
                System.out.println("Member Email: " + lookMember.get(2));
            }else {
                System.out.println("No member for this ID !!!");
            }
        }

    }

    public void deleteMember(String targetMemberID){

        int i = 0;

        for (ArrayList<Object> targetMember:membersDataContainer ){

            if (targetMember.get(0).equals(targetMemberID)){
                System.out.println("Member Found,\n");
                System.out.println(targetMember.get(0));
                System.out.println("Member Name: " + targetMember.get(1));
                System.out.println("Member Email: " + targetMember.get(2));

                System.out.println("Do you need to delete this member (yes/no) ? : ");
                String userResponse = sc.nextLine().trim().toLowerCase().replaceAll("\\s+","");

                if (userResponse.equals("yes")){
                    membersDataContainer.remove(i);
                    System.out.println(membersDataContainer);
                }else if(userResponse.equals("no")){
                    System.out.println("Nothing changed");
                    break;
                }else{
                    System.out.println("Wrong Input, nothing changed...");
                    break;
                }

            }else {
                i++;
            }
        }

    }


    @Override
    public void displayDetails() {

        System.out.println("All registered Members\n");

        for (ArrayList<Object> member : membersDataContainer) {
            System.out.println("Member ID: " + member.get(0) +", Member Name: "+ member.get(1) + " Member Email: "+member.get(2));
        }

    }
}
