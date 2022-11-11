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
    private Activity nullActivity;
    private Activity blankActivity;
    private Activity badActivity;
    
    @Before
    public void everyTimeSetup()
    {
        testActivity = new Activity(Type.CREATIVE, "Testing", "1:00 PM");
        nullActivity = new Activity(null, null, null);
        blankActivity = new Activity(Type.CREATIVE, "", "");
        badActivity = new Activity(Type.CREATIVE, "Testing", "InvalidTimeString");
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
        assertEquals("Testing\n1:00 PM\nnull\n", testActivity.toString());
    }

    @Test
    public void testConstructNullType()
    {
        assertTrue(nullActivity == null || nullActivity.getType() != null);
    }

    @Test
    public void testConstructNullName()
    {
        assertTrue(nullActivity == null || nullActivity.getName() != null);
    }

    @Test
    public void testConstructBlankName()
    {
        assertTrue(blankActivity == null || blankActivity.getName() != "");
    }

    @Test
    public void testConstructNullTime()
    {
        assertTrue(nullActivity == null || nullActivity.getTime() != null);
    }

    @Test
    public void testConstructBlankTime()
    {
        assertTrue(blankActivity == null || blankActivity.getTime() != "");
    }

    @Test
    public void testConstructGoodTime() //This is meant to demonstrate that the regex can correctly identify valid times
    {
        assertTrue(testActivity == null || testActivity.getTime().matches("((1[0-2])|[1-9]):[0-5][0-9]\s((AM)|(PM))"));
    }

    @Test
    public void testConstructBadTime()
    {
        assertTrue(badActivity == null || badActivity.getTime().matches("((1[0-2])|[1-9]):[0-5][0-9]\s((AM)|(PM))"));
    }
    
}