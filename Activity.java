/**
 * @author Caleb Martin of CCMJ
 */
import java.util.ArrayList;

public class Activity
{
    private Type type;
    private String name;
    private String time;
    private String description;
    private ArrayList<String> packingList;

    /**
     * Creates an instance of an activity
     * @param type The type of activity
     * @param name The name of the activity
     * @param time The time the activity is held
     */
    public Activity(Type type, String name, String time)
    {
        this.type = type;
        this.name = name;
        this.time = time;
    }

    /**
     * Sets the description of the activity
     * @param description The description to add
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Adds an item to the activity's packing list
     * @param item The item to add
     */
    public void addToPackingList(String item)
    {
        this.packingList.add(item);
    }

    /**
     * Sets the entire packing list to a new list
     * @param items The list to set
     */
    public void setPackingList(ArrayList<String> packingList)
    {
        this.packingList = packingList;
    }
}
