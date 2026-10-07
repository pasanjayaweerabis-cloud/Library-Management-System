import java.util.ArrayList;

public class Magazines extends Items {
       private String magazineName;
       private int magazineCount;
       private String magazineID;


    ArrayList<ArrayList<Object>> magazinesDataContainer = new ArrayList<>();
    ArrayList<Object> magazineData = new ArrayList<>();

    public void addMagazine(String magazineID,String magazineName){

        this.magazineID = magazineID;
        this.magazineName = magazineName;
        this.magazineCount = magazinesDataContainer.size();

        magazineData.add(magazineID);
        magazineData.add(magazineName);
        magazineData.add(magazineCount);

        magazinesDataContainer.add(magazineData);

    }

    @Override // we have to override otherwise make error and can not access
    public void displayDetails() {
        System.out.println("Magazine ID: " + magazineID);
        System.out.println("Magazine Name: " + magazineName);
    }
}
