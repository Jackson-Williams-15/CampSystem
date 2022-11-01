import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class GuardianUser extends User {

    private ArrayList<Child> children;
    private int campDuration;
    private Date campDates;

    public GuardianUser(String firstName, String lastName, int phoneNumber, String email, String password, Date dateOfBirth, UUID id, ArrayList<Child> children, int campDuration, Date campDates) {
        super(firstName, lastName, phoneNumber, email, password, dateOfBirth, id);
        this.children = children;
        this.campDuration = campDuration;
        this.campDates = campDates;
    }
    
    public void addChild(Child child){
        this.children.add(child);
    }
    public Child getChild(String name){
        Child theChild = null;
        for (Child child : children) {
            if(child.getFirstName().equals(name))
                theChild = child;
        }
        return theChild;
    }

    public String toString()
    {
        return super.toString();
    }
}