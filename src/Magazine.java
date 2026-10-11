
public class Magazine extends LibraryItem {

    public static int counter =0;
    private String publisher;

    public Magazine (String publisher,String magazineTitle){
        super(generateMagazineID(),magazineTitle.trim().replaceAll("\\s+"," "));
        this.publisher = publisher.trim().replaceAll("\\s+"," ");
    }

    private static String generateMagazineID(){
        counter++;
        return String.format("Mgz%04d",counter);
    }

    public String getPublisher(){
        return publisher;
    }


    @Override
    public void displayDetails(){
        System.out.println("Magazine ID: "+ getId() );
        System.out.println("Magazine Title: "+ getTitle() );
        System.out.println("Magazine Publisher: "+  publisher  );
        System.out.println("Availability:  "+ (getIsAvailable() ? "Available" : "Unavailable" ));
    }

    @Override // toString is predefined java method where always placed in parent/super class. Must be return String
    public String toString(){
        return "Magazine ID: "+ getId() + ", Magazine Title: " + getTitle() + " , Magazine Publisher: " + publisher;
    }




}