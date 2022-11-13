/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
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
    public void testGetInstance()
    {
        assertNotNull(cabinList);
    }

    @Test
    public void testDataAfterGetInstance()
    {
        assertNotNull(cabinList.getCabins());
    }

    @Test
    public void testListHasCabins()
    {
        assertNotEquals(0, cabinList.getCabins().size());
    }

    @Test
    public void testGetReadCabin()
    {
        Cabin gottenCabin = cabinList.getCabin(UUID.fromString("dd30acc7-6e51-4174-9fd0-4f345915fbe8"));
        assertNotNull(gottenCabin);
    }

    @Test
    public void testAddCabin()
    {
        int cabinListSize = cabinList.getCabins().size();
        cabinList.addCabin("Test");
        assertEquals(cabinListSize+1, cabinList.getCabins().size());
    }

    @Test
    public void testGetExistingCabin()
    {
        Cabin cabinToGet = cabinList.getCabins().get(0);
        assertEquals(cabinToGet, cabinList.getCabin(cabinToGet.getUUID()));
    }

    @Test
    public void testAddNull()
    {
        int cabinListSize = cabinList.getCabins().size();
        cabinList.addCabin(null);
        assertNotEquals(cabinListSize+1, cabinList.getCabins().size());
    }

}
