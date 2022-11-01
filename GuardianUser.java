import java.util.ArrayList;
import java.util.Date;

public class GuardianUser{

    private ArrayList<Child> children;
    private int campDuration;
    private Date campDates;
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