import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

public class UserList
{
    private static ArrayList<User> users;
    private static UserList userList;

    /**
     * Calls the data reader to write in the users from the JSON
     */
    private UserList()
    {
        users = DataReader.getAllUsers();
    }

    public boolean addU(String firstName, String lastName, int number, String email, 
    String password, String dateOfBirth){
        User user = new User(firstName, lastName, number, email, password, dateOfBirth);
        users.add(user);
        return true;
        
    }
    

    /**
     * Constructs the UserList for the program
     * @return The singleton form of the UserList
     */
    public static UserList getInstance()
    {
        if(userList == null) return userList = new UserList();
        return userList;
    }

    /**
     * Adds a new user to the list
     */
    public void addUser(User user)
    {
        userList.users.add(user);
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

    public static StaffUser getStaffUser(UUID UUID)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i) instanceof StaffUser && users.get(i).getUUID() == UUID) return (StaffUser)users.get(i);
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return users;
    }
    
    /**
     * Calls the DataWriter to save all users
     */
    public void saveUser()
    {
            DataWriter.saveUsers();
    }

}
