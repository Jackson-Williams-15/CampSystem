
public class Contact {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, int phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString()
    {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
        "Email: " + this.email + " Phone: " + this.phoneNumber + "\n";
    }
}
