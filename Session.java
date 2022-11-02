import java.util.ArrayList;

public class Session {
    private String theme;
    private ArrayList<Cabin> cabins;

    public Session(String theme, ArrayList<Cabin> cabins)
    {
        this.theme = theme;
        this.cabins = cabins;
    }

    public String toString()
    {
        String output = "Theme: " + this.theme + "\n";
        int cabinCount = 1;
        for(Cabin cabin : cabins)
        {
            output += "Cabin "+cabinCount + "\n" + cabin.toString();
        }
        return output;
    }
}
