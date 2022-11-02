import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ChildList
{
    private static ArrayList<Child> children;
    private static ChildList childList;

    private ChildList()
    {
        children = DataReader.getChildren();
    }

    public static ChildList getInstance()
    {
        if(childList == null) return childList = new ChildList();
        return childList;
    }

    public void addChild(String firstName, String lastName, String birthdate)
    {
        childList.children.add(new Child(firstName, lastName, birthdate));
    }

    public static Child getChild(UUID UUID)
    {
        for(Child child : children)
        {
            if(child.getUUID() == UUID) return child;
        }
        return null;
    }

    public ArrayList<Child> getChildren()
    {
        return children;
    }

    public void saveChildren()
    {
        DataWriter.saveChild();
    }
}
