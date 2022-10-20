import java.util.ArrayList;

public class StaffUser {
    private ArrayList<Contact> emergencyContact;
    private Contact doctor;
    public ArrayList<String> allergies;
    private ArrayList<Medication> medication;
    private Date birthday;


    public ArrayList<String> getAllAllergies(){
        return allergies;

    }

    public boolean checkAllergies(String allergy){
        return false;
    }
    public void staffSchedule(){

    }

    public String toString(){
        return null;
        
    }
}
