import java.util.ArrayList;
import java.util.UUID;

public class Camp 
{
    /**
     * create variables that will be utilized throughout the camp program
     */
    private String name;
    private int availability;
    private ArrayList<Session> sessions;

    /**
     * Camp constructor that initializes the name parameter to a previous name variable
     * @param name
     */
    public Camp(String name){
        this.name = name;
    }

    /**
     * initialize name and sessions
     * @param name sets the name of camp to previous made string name
     * @param sessions sets sessions to a previously made session arraylist
     */
    public Camp(String name, ArrayList<Session> sessions) {
        this.name = name;
        this.sessions = sessions;
    }

    /**
     * Constructs the newCamp parameter to equal String name
     * @param newCamp takes in a method getName() defined in the class
     */
    public Camp(Camp newCamp){
        this.name = newCamp.getName();
    }

    /**
     * getter statement that returns name
     * @return this.name
     */
    public String getName(){
        return this.name;
    }

     /**
     * getter statement that returns sessions
     * @return this.sessions
     */
    public ArrayList<Session> getSessions()
    {
        return this.sessions;
    }
    /**
     * Method that searches for the child within cabin
     * @param name Search for name
     * @param age Search for age
     * @return null
     */
    public Child findChild(String name, int age){
        return null;
    }

    /**
     * toString method that Prints the name of the camp
     */
    public String toString()
    {
        return "Name: " + this.name;
    }
}
