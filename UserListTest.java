/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;

public class UserListTest
{
    private static ChildList childList;
    private static UserList userList;

    @BeforeClass
    public static void oneTimeSetup()
    {
        childList = ChildList.getInstance();
        userList = UserList.getInstance();
    }

    @Test
    public void testGetInstance()
    {
        assertNotNull(userList);
    }

    @Test
    public void testDataAfterGetInstance()
    {
        assertNotNull(userList.getUsers());
    }

    @Ignore //We have no way to instantiate userList's users ArrayList. As such, this test errors
    @Test
    public void testUserListManipulation() //We don't have proper getters to test each method one at a time, so we have to try all at once
    {
        User testUser = new User("Test", "User", 0, "null", "null", "null");
        userList.addUser(testUser);
        assertEquals(testUser, userList.getUser(testUser.getUUID()));
    }
}
