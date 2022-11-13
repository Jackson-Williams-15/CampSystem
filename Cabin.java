import java.util.ArrayList;
import java.util.UUID;

public class Cabin {
    /**
     * Initialized my variables that will be utilized throughout the class
     */
    private StaffUser counselor;
    private ArrayList<Child> camperGroup;
    private String name;
    private int minAge;
    private int maxAge;
    private Schedule[] schedule;
    private UUID thisUUID;

    /**
     * Constructor for Cabin class
     * @param name initialize the String name in the parameter
     * @param UUID initializes the UUID to thisUUID
     */

    public Cabin(String name, UUID UUID)
    {
        this.name = name;
        this.thisUUID = UUID;
    }


    /**
     * 
     */
    public Cabin(String name, UUID UUID, StaffUser counselor, ArrayList<Child> camperGroup, int minAge, int maxAge, Schedule[] schedule) {
        this.name = name;
        this.thisUUID = UUID;
        this.counselor = counselor;
        this.camperGroup = camperGroup;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.schedule = schedule;
    }

    /**
     * @param name Creates a random UUID with string name
     */

    public Cabin(String name) {
        this(name, UUID.randomUUID());
    }

    /**
     * Allows the child to be set to their camper group
     * @param child adds the child to camper group arraylist
     */

    public void addToGroup(Child child) {
        this.camperGroup.add(child);
    }

    /**
     * get statement that returns the counselor
     * @return this.counselor
     */

    public StaffUser getCounselor()
    {
        return this.counselor;
    }
    /**
     * get statements that returns the arraylist of camperGroup
     * @return this.camperGroup
     */
    public ArrayList<Child> getCamperGroup()
    {
        return this.camperGroup;
    }

    /**
     * get statement that returns name
     * @return this.name
     */

    public String getName()
    {
        return this.name;
    }

    /**
     * get statement that returns minAge
     * @return this.minAge
     */

    public int getMinAge()
    {
        return this.minAge;
    }

    /**
     * get statement that returns maxAge
     * @return this.maxAge
     */

    public int getMaxAge()
    {
        return this.maxAge;
    }

    /**
     * get statement that returns schedule
     * @return this.schedule
     */

    public Schedule[] getSchedule()
    {
        return this.schedule;
    }

    /**
     * get statement that returns the UUID
     * @return this.thisUUID
     */

    public UUID getUUID()
    {
        return this.thisUUID;
    }

    /**
     * to string method that prints and return all the values previously declared within the class
     */

    public String toString()
    {
        return "Name: " + this.name + "\n" +
        "Min Age: " + this.minAge + " Max Age: " + this.maxAge + "\n" +
        "UUID: " + this.thisUUID;
    }
}
