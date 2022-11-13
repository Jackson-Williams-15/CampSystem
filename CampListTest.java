/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;

public class CampListTest
{
    private static CampList campList;
    private static Camp testCamp;

    @BeforeClass
    public static void oneTimeSetup()
    {
        campList = CampList.getInstance();
        testCamp = new Camp("Test");
    }

    @Test
    public void testGetInstance()
    {
        assertNotNull(campList);
    }

    @Test
    public void testAddCamp()
    {
        int listSize = campList.getCamps().size();
        campList.addCamp(testCamp);
        assertEquals(listSize+1, campList.getCamps().size());
    }
    
    @Test
    public void testAddCampData()
    {
        campList.addCamp(testCamp);
        assertEquals(testCamp, campList.getCamps().get(0));
    }

}
