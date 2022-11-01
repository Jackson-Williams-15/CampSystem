import java.util.ArrayList;

public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    private CampList()
    {
        camps = DataReader.getCamps();
    }

    public static CampList getInstance()
    {
        if(campList == null) return campList = new CampList();
        return campList;
    }

    public void addCamp(String name)
    {
        campList.camps.add(new Camp(name));
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
