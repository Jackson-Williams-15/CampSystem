import java.util.ArrayList;
import java.util.Scanner;

public class Facade 
{
    public void addUser(String firstName, String lastName){
        
    }
    public void editUser(){}

    public void saveUser(){}

    public ArrayList<User> seeProfiles(){
        return null;
    }

    protected Contact getContact(){
        return null;
    }

    public void addChild(String name, ArrayList<String> allergies){}

    public Child getChild(String name){
        return null;
    }

    public ArrayList<String> getAllAllergies(){
        return null;
    }
    public boolean checkAllergies(String allergies){
        return false;
    }
    public String Medication(String type, String dose, String time){
        return time;
    }

    public void addToGroup(Child child){}

    public Child findChild(String name,int age){
        return null;
    }
    private Cabin availableSpace(int availabiliy){
        return null;
    }
    private int availableSessions(int sessions, int availability){
        return availability;
    }
    public String getSchedule(){
        return null;
    }

}
