import java.util.ArrayList;
import java.util.UUID;

public class CabinList
{
    private static ArrayList<Cabin> cabins;
    private static CabinList cabinList;

    /**
     * 
     */
    private CabinList()
    {
        cabins = DataReader.getCabins();
    }

    /**
     * 
     * @return
     */
    public static CabinList getInstance()
    {
        if(cabinList == null) return cabinList = new CabinList();
        return cabinList;
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
    public static Cabin getCabin(UUID UUID)
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
    public void saveCabin()
    {
        DataWriter.saveCabins();
    }
}
