import java.util.ArrayList;

public class CampList {
    private ArrayList<Camp> camps;
    private static CampList campList;

    private CampList()
    {
        camps = new ArrayList<Camp>();
    }

    public static CampList getInstance()
    {
        if(campList == null) return campList = new CampList();
        return campList;
    }

    public void addCamp(Camp camp)
    {
        campList.camps.add(camp);
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
