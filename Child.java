import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Child{
    private String firstName;
    private String lastName;
    private String birthdate;
    private ArrayList<String> allergies;
    private Contact doctor;
    private ArrayList<Contact> emergencyContacts;
    private ArrayList<Medication> medications;
    private UUID thisUUID;

    public Child(String firstName, String lastName, String dateOfBirth, UUID UUID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = dateOfBirth;
        this.thisUUID = UUID;
    }

    public Child(String firstName, String lastName, String dateOfBirth, UUID UUID, ArrayList<String> allergies, Contact doctor, ArrayList<Contact> emergencyContacts, ArrayList<Medication> medications) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = dateOfBirth;
        this.thisUUID = UUID;
        this.allergies = allergies;
        this.doctor = doctor;
        this.emergencyContacts = emergencyContacts;
        this.medications = medications;
    }

    public Child(String firstName, String lastName, String birthdate){
        this(firstName, lastName, birthdate, UUID.randomUUID());
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
    public String getBirth(){
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
    public UUID getUUID()
    {
        return this.thisUUID;
    }
    
    public String toString()
    {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
        "Birthday: " + this.birthdate.toString() + "\n" +
        "UUID: " + this.thisUUID;
    }
}