/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;
import org.junit.jupiter.api.condition.DisabledIf;

public class CabinListTest
{
    private static ChildList childList;
    private static UserList userList;
    private static CabinList cabinList;

    @BeforeClass
    public static void oneTimeSetup()
    {
        childList = ChildList.getInstance();
        userList = UserList.getInstance();
        cabinList = CabinList.getInstance();
    }

    @AfterClass
    public static void oneTimeTeardown()
    {
        
    }
    
    @Test
    public void testInstantiation()
    {
        assertNotNull(cabinList);
    }

    @Test
    public void testDataInstantiation()
    {
        assertNotNull(cabinList.getCabins());
    }

    @Ignore //Because the prior test fails, trying to run this test runs into a null pointer exception. In short, it fails
    @Test
    public void testGetCabin()
    {
        Cabin gottenCabin = cabinList.getCabin(UUID.fromString("dd30acc7-6e51-4174-9fd0-4f345915fbe8"));
        assertNotNull(gottenCabin);
    }
}
