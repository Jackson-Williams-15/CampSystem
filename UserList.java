import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class UserList
{
    private ArrayList<User> users;
    private static UserList userList;

    /**
     * Calls the data reader to write in the users from the JSON
     */
    private UserList(){}

    /**
     * Constructs the UserList for the program
     * @return The singleton form of the UserList
     */
    public static UserList getInstance()
    {
        return userList = new UserList();

    }

    /**
     * Creates a new user and adds it to the list
     * @param firstName The user's first name
     * @param lastName The user's last name
     * @param number The user's phone number
     * @param email The user's email address
     * @param password The user's password
     * @param dateOfBirth The user's DOB
     */
    public void addUser(String firstName, String lastName, int number, String email, String password, Date dateOfBirth)
    {
        userList.users.add(new User(firstName, lastName, number, email, password, dateOfBirth));
    }
    
    /**
     * Returns a user by matching a given UUID
     * @param UUID The UUID to match
     * @return The user if found, null if not found
     */
    public User getUser(UUID UUID)
    {
        for(User user : users)
        {
            if(user.getUUID() == UUID) return user;
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return users;
    }
    /**
     * Replaces the user item in the list with a new version
     * @param user The new version of the user
     */
    public void saveUser(User user)
    {
            DataWriter.saveUsers();
    }

}
