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

    public Cabin(String name, UUID UUID)
    {
        this.name = name;
        this.thisUUID = UUID;
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

    public Schedule[] getSchedule()
    {
        return this.schedule;
    }

    public UUID getUUID()
    {
        return this.thisUUID;
    }
}
