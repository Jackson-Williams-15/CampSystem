/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;
import java.util.ArrayList;

public class ActivityTest
{
    private Activity testActivity;
    
    @Before
    public void everyTimeSetup()
    {
        testActivity = new Activity(Type.CREATIVE, "Testing", "1:00 PM");
    }

    @Test
    public void testPackingListSetup()
    {
        //PackingList should be instantiated at object creation for ease of adding items
        assertNotNull(testActivity.getPackingList());
    }

    @Test
    public void testAddToPackingList()
    {
        ArrayList<String> newPackingList = new ArrayList<String>();
        testActivity.setPackingList(newPackingList);
        testActivity.addToPackingList("Code");
        newPackingList = testActivity.getPackingList();
        assertEquals("Code", newPackingList.get(0));
    }

    @Test
    public void testToString()
    {

    }
}