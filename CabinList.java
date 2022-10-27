import java.util.ArrayList;
import java.util.UUID;

public class CabinList
{
    private ArrayList<Cabin> cabins;
    private static CabinList cabinList;

    /**
     * 
     */
    private CabinList()
    {

    }

    /**
     * 
     * @return
     */
    public static CabinList getInstance()
    {
        return cabinList = new CabinList();
    }

    /**
     * 
     * @param name
     */
    public void addCabin(String name)
    {
        cabinList.cabins.add(new Cabin(name));
    }

    /**
     * 
     * @param UUID
     * @return
     */
    public Cabin getCabin(UUID UUID)
    {
        for(Cabin theCabin : cabins)
        {
            if(theCabin.getUUID() == UUID) return theCabin;
        }
        return null;
    }

    public ArrayList<Cabin> getCabins()
    {
        return this.cabins;
    }

    /**
     * 
     * @param cabin
     */
    public void saveCabin(Cabin cabin)
    {

    }
}