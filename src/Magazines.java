import java.util.ArrayList;

public class Magazines extends Items {
       private String magazineName;
       private int magazineCount;
       private String magazineProvider;
       private String magazineID;
       private ArrayList<ArrayList<Object>> magazinesDataContainer = new ArrayList<>();


       public String getMagazineID(){
           this.magazineID = String.format("Mgz%03d",magazinesDataContainer.size() +1);
           return this.magazineID;
       }

    public String addMagazine(String magazineName, String magazineProvider){

        ArrayList<Object> magazineData = new ArrayList<>();

        this.magazineName = magazineName;
        this.magazineProvider = magazineProvider;

        magazineData.add(this.magazineID);
        magazineData.add(magazineName);
        magazineData.add(magazineProvider);

        magazinesDataContainer.add(magazineData);

        System.out.println("New Magazine,");
        System.out.println("ID :" + magazineID);
        System.out.println("Name :" + magazineName);
        System.out.println("Provider :" + magazineProvider);


        return "Magazine added successfully.";

    }

    public void searchMagazine(String lookMagazineID){

        for (ArrayList<Object> lookMagazine:magazinesDataContainer){

            if (lookMagazine.get(0).equals(lookMagazineID.trim().toUpperCase().replaceAll("\\s+",""))){
                System.out.println("Magazine Found,\n");
                System.out.println("Magazine Name: " + lookMagazine.get(1));
                System.out.println("Magazine Provider : " + lookMagazine.get(2));
            }else {
                System.out.println("No Magazine for this ID !!!");
            }
        }

    }

    public void deleteMagazine(String targetMagazineID){

        int i = 0;

        for (ArrayList<Object> targetMagazine:magazinesDataContainer ){

            if (targetMagazine.get(0).equals(targetMagazineID)){
                System.out.println("Magazine Found,\n");
                System.out.println("Magazine Name : " + targetMagazine.get(1));
                System.out.println("Magazine provider : " + targetMagazine.get(2));

                magazinesDataContainer.remove(i);
                System.out.println(magazinesDataContainer);

            }else {
                i++;
            }
        }

    }

    @Override // we have to override otherwise make error and can not access
    public void displayDetails() {
        System.out.println("Magazine ID: " + magazineID);
        System.out.println("Magazine Name: " + magazineName);
    }
}
