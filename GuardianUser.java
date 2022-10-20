import java.util.ArrayList;

public class GuardianUser{

    private ArrayList<Child> children;
    private int campDuration;
    private Date campDates;
    public void addChild(Child child){
        this.children.add(child);
    }
    public Child getChild(String name){
        Child theChild;
        for (Child child : children) {
            if(child.firstName = name)
                theChild = child;
        }
        return theChild;
    }
}