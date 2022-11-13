/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;

public class ChildListTest
{
    private ChildList childList2 = ChildList.getInstance();
    private static ChildList childList;

    @BeforeClass
    public static void oneTimeSetup()
    {
        childList = ChildList.getInstance();
    }

    @Test
    public void testGetInstance()
    {
        assertNotNull(childList);
    }

    @Test
    public void testDataAfterGetInstance()
    {
        assertNotNull(childList.getChildren());
    }

    @Test
    public void testListHasChildren()
    {
        assertNotEquals(0, childList.getChildren().size());
    }   

    @Test
    public void testGetReadChild()
    {
        Child gottenChild = childList.getChild(UUID.fromString("e9bcbd0a-6338-4bdd-b4fb-82d1b104fd48"));
        assertNotNull(gottenChild);
    }

    @Test
    public void testAddChild()
    {
        int childListSize = childList.getChildren().size();
        childList.addChild("Test", "Child", "1/1/1990");
        assertEquals(childListSize+1, childList.getChildren().size());
    }
    

    @Test
    public void testGetExistingChild()
    {
        Child testChild = childList.getChildren().get(0);
        assertEquals(testChild, childList.getChild(testChild.getUUID()));
    }

    @Test
    public void testAddNull()
    {
        int childListSize = childList.getChildren().size();
        childList.addChild(null, null, null);
        assertNotEquals(childListSize+1, childList.getChildren().size());
    }

}
