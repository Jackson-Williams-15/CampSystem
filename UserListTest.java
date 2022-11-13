/**
 * @author Caleb Martin
 */
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class UserListTest
{
    private static ChildList childList;
    private static UserList userList;

    @BeforeEach
    public void setup(){
        UserList.getInstance().addU("c1", "w1", 
        838, "Wall@gmail.com", "Love", "1/20/2021");

    }

    @BeforeClass
    public static void oneTimeSetup()
    {
        UserList.getInstance().addUser(null);
        childList = ChildList.getInstance();
        userList = UserList.getInstance();
    }

    @Test
    public void TestAdd(){
        boolean test = UserList.getInstance().addU("c1", "w1", 
        838, "Wall@gmail.com", "Love", "1/20/2021");
        assertTrue(test);
    }
    @Test
    public void testAddNullFirstName(){
        boolean test = UserList.getInstance().addU(null, "w1", 
        838, "Wall@gmail.com", "Love", "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullLastName(){
        boolean test = UserList.getInstance().addU("c1", null, 
        838, "Wall@gmail.com", "Love", "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullNumber(){
        boolean test = UserList.getInstance().addU("c1", "w1", 
        813, "Wall@gmail.com", "Love", "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullEmail(){
        boolean test = UserList.getInstance().addU("c1", "w1", 
        838, null, "Love", "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullPassword(){
        boolean test = UserList.getInstance().addU("c1", "w1", 
        838, "Wall@gmail.com", null, "1/20/2021");
        assertFalse(test);
    }
    @Test
    public void testAddNullBirthday(){
        boolean test = UserList.getInstance().addU("c1", "w1", 
        838, "Wall@gmail.com", "Love", null);
        assertFalse(test);
    }


    @Test
    public void TestTest(){
        User testUser = new User("Test", "User", 0, "null", "null", "null");
        userList.addUser(testUser);
        assertEquals(testUser, userList.getUser(testUser.getUUID()));
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
    public void testGetReadUser()
    {
        assertNotNull(userList.getUser(UUID.fromString("16c7e243-f077-4246-9695-0f9662eda176")));
    }

    @Test
    public void testGetStaffUser()
    {
        assertNotNull(userList.getStaffUser(UUID.fromString("fa7cdb87-0440-4c51-bf70-f390eb99d99e")));
    }
    @Test
    public void getUser(){
        assertNotNull(userList.getUser(UUID.fromString("fa7cdb87-0440-4c51-bf70-f390eb99d99e")));
    }

    @Test
    public void testUserListManipulation()
    {
        User testUser = new User("Test", "User", 0, "null", "null", "null");
        userList.addUser(testUser);
        assertEquals(testUser, userList.getUser(testUser.getUUID()));
    }


    @Test
    public void testAddNull()
    {
        /*int userListSize = userList.getUsers().size();
        userList.addUser(null);
        assertNotEquals(userListSize+1, userList.getUsers().size());*/
        assertTrue(false); //Test fails, and messes up testGetReadUser in the process.
    }
    

}
