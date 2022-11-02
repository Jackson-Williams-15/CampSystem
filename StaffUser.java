import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class StaffUser extends User{
    private ArrayList<Contact> emergencyContacts;
    private Contact doctor;
    public ArrayList<String> allergies;
    private ArrayList<Medication> medication;
    private Schedule schedule;

    public StaffUser(String firstName, String lastName, int number, String email, String password, String dateOfBirth, UUID id, Contact doctor, ArrayList<Contact> emergencyContacts, ArrayList<Medication> medication, ArrayList<String> allergies) {
        super(firstName, lastName, number, email, password, dateOfBirth, id);
        this.doctor = doctor;
        this.emergencyContacts = emergencyContacts;
        this.medication = medication;
        this.allergies = allergies;
    }

    public ArrayList<String> getAllAllergies(){
        return this.allergies;
    }

    public ArrayList<Medication> getAllMedication(){
        return this.medication;
    }

    public ArrayList<Contact> getEmergencyContact(){
        return this.emergencyContacts;
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
        return emergencyContacts.toString() + allergies.toString() + medication.toString() + schedule;
    }
}
