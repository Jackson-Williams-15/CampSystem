import java.util.UUID;
import java.util.Date;
public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String dateOfBirth;
    protected int phone;
    protected String password;
    protected Contact contact;
    protected UUID thisUUID;

    /**
     * Constructor that assumes an existing UUID (assumes the User object already existed)
     * @param firstName The User's first name
     * @param lastName The user's last name
     * @param number The user's phone number
     * @param email The user's email address
     * @param password The user's password
     * @param dateOfBirth The user's DOB
     * @param thisUUID The user's UUID
     */
    public User(String firstName, String lastName, int number, String email, String password, String dateOfBirth, UUID thisUUID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = number;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.thisUUID = thisUUID;
    }

    /**
     * Constructor for new user (generates random UUID)
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param number The user's phone number
     * @param email The user's email address
     * @param password The user's password
     * @param dateOfBirth The user's DOB
     */
    public User(String firstName, String lastName, int number, String email, String password, String dateOfBirth){
        this(firstName, lastName, number, email, password, dateOfBirth, UUID.randomUUID());
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public int getPhone()
    {
        return this.phone;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Contact getContact(){
        return this.contact;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    /**
     * Returns this user's UUID
     * @return this user's UUID
     */
    public UUID getUUID()
    {
        return this.thisUUID;
    }

    public String toString()
    {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
        "Email: " + this.email + " Phone: " + this.phone + "\n" +
        "Birthday: " + this.dateOfBirth.toString() + "\n" +
        "Password: " + this.password + " UUID: " + this.thisUUID;
    }

    public static User getInstance() {
        return null;
    }
}
