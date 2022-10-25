import java.sql.Date;
import java.util.ArrayList;

public class Child{
    private String firstName;
    private String lastName;
    private Date birthdate;
    private ArrayList<String> allergies;
    private ArrayList<Contact> emergencyContacts;
    private ArrayList<Medication> medications;
    public Child(String firstName, String lastName, Date birthdate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;

    }

    // Copy Constructor
    public Child(Child newChild){
        this.firstName = newChild.getFirstName();
        this.lastName = newChild.getLastName();
        this.emergencyContacts = newChild.getContact();
        this.birthdate = newChild.getBirth();
        this.allergies = newChild.getAllergies();
        this.medications = newChild.getMeds();
    }
    // Setters

    public void addMedication(Medication med){
        this.medications.add(med);
    }
    public void addContact(Contact contact){
        this.emergencyContacts.add(contact);
    }
    // Getter
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public Date getBirth(){
        return this.birthdate;
    }
    public ArrayList<String> getAllergies(){
        return this.allergies;
    }
    public ArrayList<Contact> getContact(){
        return this.emergencyContacts;
    }
    public ArrayList<Medication> getMeds(){
        return this.medications;
    }
    
}