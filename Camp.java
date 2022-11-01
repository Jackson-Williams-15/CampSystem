public class Camp 
{
    private String name;
    private String theme;
    private String cabin;
    private UserList userList;
    private int availability;
    private int sessions;

    public Camp(String name, String theme){
        this.name = name;
        this.theme = theme;
    }

    public Camp(Camp newCamp){
        this.name = newCamp.getName();
        this.theme = newCamp.getTheme();
        this.cabin = newCamp.getCabins();
    }

    public String getName(){
        return this.name;
    }

    public String getTheme(){
        return this.theme;
    }

    public String getCabins(){
        return this.cabin;
    }
    
    public Child findChild(String name, int age){
        return null;
    }
    private Cabin availableSpace(int availability){
        return null;

    }
    private int availableSessions(int sessions, int availability){
        return availability;
    }

    public String toString()
    {
        return "Name: " + this.name + " " + "\n" +
        "theme: " + this.theme+ "\n" +
        "Cabins: " + this.cabin;
    }
}
