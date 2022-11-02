import java.util.ArrayList;
import java.util.UUID;

public class Cabin {
    private StaffUser counselor;
    private ArrayList<Child> camperGroup;
    private String name;
    private int minAge;
    private int maxAge;
    private Schedule[] schedule;
    private UUID thisUUID;
    private ArrayList<Activity> activity;
    public Cabin(String name, UUID UUID)
    {
        this.name = name;
        this.thisUUID = UUID;
    }

    public Cabin(String name, UUID UUID, StaffUser counselor, ArrayList<Child> camperGroup, int minAge, int maxAge, Schedule[] schedule) {
        this.name = name;
        this.thisUUID = UUID;
        this.counselor = counselor;
        this.camperGroup = camperGroup;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.schedule = schedule;
    }

    public Cabin(String name) {
        this(name, UUID.randomUUID());
    }

    public void addToGroup(Child child) {
        this.camperGroup.add(child);
    }

    public StaffUser getCounselor()
    {
        return this.counselor;
    }

    public ArrayList<Child> getCamperGroup()
    {
        return this.camperGroup;
    }

    public String getName()
    {
        return this.name;
    }

    public int getMinAge()
    {
        return this.minAge;
    }

    public int getMaxAge()
    {
        return this.maxAge;
    }

    public ArrayList<Activity> getActivity(){
        return this.activity;
    }

    public Schedule[] getSchedule()
    {
        return this.schedule;
    }

    public UUID getUUID()
    {
        return this.thisUUID;
    }

    public String toString()
    {
        return "Name: " + this.name + "\n" +
        "Min Age: " + this.minAge + " Max Age: " + this.maxAge + "\n" +
        "UUID: " + this.thisUUID;
    }
}
