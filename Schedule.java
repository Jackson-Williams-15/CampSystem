import java.util.ArrayList;

public class Schedule
{
    private Day day;
    private ArrayList<Activity> activities;

    public Schedule(ArrayList<Activity> activities, Day day){
        this.day = day;
        this.activities = activities;
    }
    public void addActivity(Activity active){
        this.activities.add(active);
    }
    public void removeActivity(Activity active){
        this.activities.remove(active);
    }

    public Day getDay()
    {
        return this.day;
    }
    public ArrayList<Activity> getActivities()
    {
        return this.activities;
    }

    public String toString(){
        return "The activity is " + activities;
    }
}