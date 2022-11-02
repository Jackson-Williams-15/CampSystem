import java.util.ArrayList;
import java.util.UUID;

public class CabinList
{
    private static ArrayList<Cabin> cabins;
    private static CabinList cabinList;

    /**
     * private constructor that sets the arraylist cabins = to the datareader getCabins method
     */
    private CabinList()
    {
        cabins = DataReader.getCabins();
    }

    /**
     * if there is no cabinList a new object cabinList is created and returns it.
     * @return cabinList
     */
    public static CabinList getInstance()
    {
        if(cabinList == null) return cabinList = new CabinList();
        return cabinList;
    }

    /**
     * adds a name into the cabins list
     * @param name
     */
    public void addCabin(String name)
    {
        cabinList.cabins.add(new Cabin(name));
    }

    /**
     * Loops through cabins and checks if the UUID matches the getUUID method.
     * If they match theCabin will be returned else return null
     * @param UUID checking for the UUID
     * @return null
     */
    public static Cabin getCabin(UUID UUID)
    {
        for(Cabin theCabin : cabins)
        {
            if(theCabin.getUUID() == UUID) return theCabin;
        }
        return null;
    }

    /**
     * getter method that gets cabins
     * @return this.cabins
     */

    public ArrayList<Cabin> getCabins()
    {
        return this.cabins;
    }

    /**
     * uses the method from the data writer to save the cabins
     * @param cabin saves cabins
     */
    public void saveCabin()
    {
        DataWriter.saveCabins();
    }
}
