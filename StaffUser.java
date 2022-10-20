import java.util.ArrayList;

public class StaffUser extends User{
    private ArrayList<Contact> emergencyContact;
    private Contact doctor;
    public ArrayList<String> allergies;
    private ArrayList<Medication> medication;
    private Schedule schedule;
    public StaffUser(String name, int number, String email, String password, Date dateOfBirth) {
        super(name, number, email, password, dateOfBirth);
    }

    public ArrayList<String> getAllAllergies(){
        return this.allergies;
    }

    public ArrayList<Medication> getAllMedication(){
        return this.medication;
    }

    public ArrayList<Contact> getEmergencyContact(){
        return this.emergencyContact;
    }

    public boolean checkAllergies(String allergy){
        return false;
    }
    public void staffSchedule(StaffUser schedule){
        this.schedule = schedule.getSchedule(); 
    }
    public Schedule getSchedule(){
        return this.schedule;
    }
    public String toString(){
        return emergencyContact.toString() + allergies.toString() + medication.toString() + schedule;
    }
}
