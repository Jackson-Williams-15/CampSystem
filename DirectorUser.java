
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class DirectorUser extends User {
    private ArrayList<User> userProfile;

    public DirectorUser(String firstName, String lastName, int phoneNumber, String email, String password, Date dateOfBirth, UUID thisUUID) {
        super(firstName, lastName, phoneNumber, email, password, dateOfBirth, thisUUID);  
    }
    public ArrayList<User> seeProfiles(){
        return this.userProfile;
    }
}