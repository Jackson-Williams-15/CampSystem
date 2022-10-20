
import java.util.ArrayList;

public class GuardianUser{

    private ArrayList<Child> children;
    private int campDuration;
    private Date campDates;
    public void addChild(Child child){
        this.children.add(child);
    }
    public Child getChild(String firstName){
        Child theChild = void;
        for (Child child : children) {
            if(child.getFirstName() == firstName)
                theChild = new Child(child);
        }
        return theChild;
    }
}