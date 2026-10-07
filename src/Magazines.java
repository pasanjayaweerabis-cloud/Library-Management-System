import java.util.ArrayList;

public class Magazines extends Items {
        String magazineName;
        int magazineCount;
        String magazineID;


    ArrayList<ArrayList<Object>> magazineDataContainer = new ArrayList<>();
    ArrayList<Object> magazineData = new ArrayList<>();

    public void setData(String magazineID,String magazineName){

        this.magazineID = magazineID;
        this.magazineName = magazineName;
        this.magazineCount = magazineDataContainer.size();

        magazineData.add(magazineID);
        magazineData.add(magazineName);
        magazineData.add(magazineCount);

        magazineDataContainer.add(magazineData);

    }

    @Override // we have to override otherwise make error and can not access
    public void displayDetails() {
        System.out.println("Magazine ID: " + magazineID);
        System.out.println("Magazine Name: " + magazineName);
    }
}
