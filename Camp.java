import java.util.ArrayList;
import java.util.UUID;

public class Camp 
{
    private String name;
    private int availability;
    private UUID thisUUID;
    private ArrayList<Session> sessions;

    public Camp(String name){
        this.name = name;
    }

    public Camp(Camp newCamp){
        this.name = newCamp.getName();
    }

    public String getName(){
        return this.name;
    }
    
    public Child findChild(String name, int age){
        return null;
    }

    public String toString()
    {
        return "Name: " + this.name;
    }
}
