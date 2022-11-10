/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;

public class ChildListTest
{
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
    public void testGetChild()
    {
        Child gottenChild = childList.getChild(UUID.fromString("e9bcbd0a-6338-4bdd-b4fb-82d1b104fd48"));
        assertNotNull(gottenChild);
    }
}
