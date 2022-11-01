import java.util.ArrayList;

public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    private CampList()
    {

    }

    public static CampList getInstance()
    {
        if(campList == null) return campList = new CampList();
        return campList;
    }

    public void addCamp(String name, String theme)
    {
        campList.camps.add(new Camp(name, theme));
    }

    public ArrayList<Camp> getCamps()
    {
        return camps;
    }

    public void saveCamp()
    {
        DataWriter.saveCamp();
    }
}
