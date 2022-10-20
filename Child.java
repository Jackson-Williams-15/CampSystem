import java.sql.Date;
import java.util.ArrayList;

public class Child{
    private String firstName;
    private String lastName;
    private Date birthdate;
    private int age;
    private ArrayList<String> allergies;
    private ArrayList<Contact> emergencyContacts;
    private ArrayList<Medication> medications;
    public Child(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
    public void addMedication(Medication med){
        this.medications.add(med);
    }
    public void addContact(Contact contact){
        this.emergencyContacts.add(contact);
    }
    
}
