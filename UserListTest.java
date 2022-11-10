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

    @Test
    public void testListHasUsers()
    {
        assertNotEquals(0, userList.getUsers().size());
    }

    @Test
    public void testGetUser()
    {
        assertNotNull(userList.getUser(UUID.fromString("16c7e243-f077-4246-9695-0f9662eda176")));
    }

    @Test
    public void testGetStaffUser()
    {
        assertNotNull(userList.getStaffUser(UUID.fromString("fa7cdb87-0440-4c51-bf70-f390eb99d99e")));
    }

    @Test
    public void testUserListManipulation() //We don't have proper getters to test each method one at a time, so we have to try all at once
    {
        User testUser = new User("Test", "User", 0, "null", "null", "null");
        userList.addUser(testUser);
        assertEquals(testUser, userList.getUser(testUser.getUUID()));
    }
}
