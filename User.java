import java.util.UUID;
public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected Date dateOfBirth;
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
    public User(String firstName, String lastName, int number, String email, String password, Date dateOfBirth, UUID thisUUID){
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
    public User(String firstName, String lastName, int number, String email, String password, Date dateOfBirth){
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

    public Contact getContact(){
        return this.contact;
    }

    /**
     * Returns this user's UUID
     * @return this user's UUID
     */
    public UUID getUUID()
    {
        return this.thisUUID;
    }
}
