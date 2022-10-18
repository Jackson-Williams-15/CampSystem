import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;
    private UserList userList;

    private UserList(){}

    public UserList getInstance(){
        return userList;

    }

    public void addUser(String firstName, String lastName){

    }
    
    public User getUser(String userName){
        return null;
    }

    public void editUser(ArrayList<User> users){

    }

    public void saveUser(ArrayList<User> users){

    }

}
