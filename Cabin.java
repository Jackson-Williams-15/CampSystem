import java.util.ArrayList;

public class Cabin {
    private StaffUser counselor;
    private ArrayList<Child> camperGroup;
    private String name;
    private int minAge;
    private int maxAge;
    private Schedule[] schedule;

    public Cabin(String name) {
        this.name = name;
    }

    public void addToGroup(Child child) {

    }
}
