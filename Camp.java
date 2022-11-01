public class Camp 
{
    private String name;
    private String theme;
    private String cabin;
    private UserList userList;
    private int availability;
    private int sessions;

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
}
