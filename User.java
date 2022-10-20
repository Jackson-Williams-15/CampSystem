
public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected Date dateOfBirth;
    protected int phone;
    protected String password;
    protected Contact contact;
    public User(String name, int number, String email, String password, Date dateOfBirth){
        this.firstName = name;
        this.lastName = name;
        this.phone = number;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    protected Contact getContact(){
        return this.contact;
    }
}
