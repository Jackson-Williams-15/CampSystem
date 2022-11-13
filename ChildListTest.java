/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class ChildListTest
{
    private static ChildList childList;

    @BeforeEach
    public void setUp()
    {
        ChildList.getInstance().aChild("Cam", "Wash", "1/10/2021");
    }

    @BeforeClass
    public static void oneTimeSetup()
    {
        childList = ChildList.getInstance();
    }
    @Test
    public void testAddValid(){
        boolean test = ChildList.getInstance().aChild("Cam", "Wash", "1/20/2021");
        assertTrue(test);
    }
    
    @Test 
    public void testAddNullFirstName(){
        boolean test = ChildList.getInstance().aChild(null, "Wash","1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullLastName(){
        boolean test = ChildList.getInstance().aChild("Cam", null, "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullBirthDate(){
        boolean test = ChildList.getInstance().aChild("Cam", "Wash", null);
        assertFalse(test);
    }
    @Test
    public void testEmptyFirstName(){
        boolean test = ChildList.getInstance().aChild("", "Wash", "1/20/2021");
        assertFalse(test);
    }

    @Test
    public void testEmptyLastName(){
        boolean test = ChildList.getInstance().aChild("Cam", "", "1/10/2021");
        assertFalse(test);
    }
    @Test
    public void testEmptyBirthDate(){
        boolean test = ChildList.getInstance().aChild("Cam", "Wash", "");
        assertFalse(test);
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
    public void testListHasChild(){
        assertEquals(1, childList.getChildren().size());
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
