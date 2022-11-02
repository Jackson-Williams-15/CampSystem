import java.util.ArrayList;
import java.util.UUID;

public class Camp 
{
    private String name;
    private int availability;
    private ArrayList<Session> sessions;

    public Camp(String name){
        this.name = name;
    }

    public Camp(String name, ArrayList<Session> sessions) {
        this.name = name;
        this.sessions = sessions;
    }

    public Camp(Camp newCamp){
        this.name = newCamp.getName();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Session> getSessions()
    {
        return this.sessions;
    }

    public Child findChild(String name, int age){
        return null;
    }

    public String toString()
    {
        return "Name: " + this.name;
    }
}
