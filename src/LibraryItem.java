// Inheritance, Encapsulation and Abstraction

// this is parent and super class
public abstract class LibraryItem {//inherit

    //encapsulate
    private String id;
    private String title;
    private boolean isAvailable;

    protected LibraryItem( String id, String title){

    }

    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void markBorrow(){

    }

    public void markReturned(){

    }


    public abstract void displayDetails();// abstract


}
