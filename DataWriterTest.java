import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataWriterTest {
    private ArrayList<User> userList = UserList.getInstance().getUsers();
    private ArrayList<Child> childList = ChildList.getInstance().getChildren();
    private ArrayList<Cabin> cabinList = CabinList.getInstance().getCabins();
    private Camp campList; //= CampList.getInstance().getCamps();

    @BeforeClass
    public static void setup(){
       UserList.getInstance();
       DataWriter.saveUsers();

        ChildList.getInstance();
        DataWriter.saveChild();

        CabinList.getInstance();
        DataWriter.saveCabins();

        CampList.getInstance();
        DataWriter.saveCamp();

    }

    @AfterClass
    public static void tearDown(){
        /*UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();

        ChildList.getInstance().getChildren().clear();
        DataWriter.saveChild();

        CabinList.getInstance().getCabins().clear();

        CampList.getInstance().getCamps().clear();
        DataWriter.saveCamp();*/
    }

    @Test
    public void testWritingZeroUsers(){
        userList = DataReader.getAllUsers();
        assertEquals(0, userList.size());
    }

    @Test
    public void testWritingOneUser(){
        userList.add(new User("sam", "white", 1234567891, "email@email.com", "password", "3-10-1980"));
        DataWriter.saveUsers();
        assertEquals("sam", DataReader.getAllUsers().get(0).getFirstName());
    }

    @Test
    public void testWritingFiveUser(){
        userList.add(new User("Sam", "White", 1234567891, "email@email.com", "password", "3-10-1980"));
        userList.add(new User("Jake", "Smith", 1231231234, "email2@email.com", "password2", "3-11-1981"));
        userList.add(new User("Sarah", "Mark", 1987654321, "email3@email.com", "password3", "3-12-1982"));
        userList.add(new User("Frank", "William", 1034567852, "email4@email.com", "password4", "3-13-1983"));
        userList.add(new User("Jill", "Chase", 1023456777, "email5@email.com", "password5", "3-14-1984"));
        DataWriter.saveUsers();
        assertEquals("Jill", DataReader.getAllUsers().get(4).getFirstName());
    }

    @Test
    public void testWritingEmptyUser(){
        userList.add(new User("", "", 0, "", "", ""));
		DataWriter.saveUsers();
		assertEquals("", DataReader.getAllUsers().get(0).getFirstName());
    }

    @Test
    public void testWritingNullUser(){
        userList.add(new User(null, "", 0, "", "", ""));
		DataWriter.saveUsers();
		assertEquals(null, DataReader.getAllUsers().get(0).getFirstName());
    }
    /***************************************************************************************************/

    @Test
    public void testWritingZeroChildren(){
        childList = DataReader.getChildren();
        assertEquals(0, childList.size());
    }

    @Test
    public void testWritingOneChild(){
        childList.add(new Child("sam", "white", "11-14-2014"));
        DataWriter.saveChild();
        assertEquals("sam", DataReader.getChildren().get(0).getFirstName());
    }

    @Test
    public void testWritingFiveChildren(){
        childList.add(new Child("sam", "white", "11-14-2014"));
        childList.add(new Child("sam2", "white2", "12-14-2014"));
        childList.add(new Child("sam3", "white3", "1-14-2014"));
        childList.add(new Child("sam4", "white4", "2-14-2014"));
        childList.add(new Child("sam5", "white5", "3-14-2014"));
        DataWriter.saveChild();
        assertEquals("sam5", DataReader.getChildren().get(4).getFirstName());
    }

    @Test
    public void testWritingEmptyChild(){
        childList.add(new Child("", "", ""));
		DataWriter.saveChild();
		assertEquals("", DataReader.getChildren().get(0).getFirstName());
    }

    @Test
    public void testWritingNullChild(){
        childList.add(new Child(null, "", ""));
		DataWriter.saveChild();
		assertEquals(null, DataReader.getChildren().get(0).getFirstName());
    }

    @Test
    public void testWritingMedicationForChildren(){
        childList.add(new Child("sam", "white", "11-14-2014"));
        DataWriter.saveChild();
        childList.get(0).getMeds().add(new Medication("allergy medicine", "1 spray", "once a day"));
        DataWriter.saveChild();

        assertEquals("allergy medicine", DataReader.getChildren().get(0).getMeds().get(0).getType());
    }

    @Test
    public void testWritingContactForChildren(){
        childList.add(new Child("sam", "white", "11-14-2014"));
        DataWriter.saveChild();
        childList.get(0).getContact().add(new Contact("Frank", "Miller", 1234567890, "email@email.com"));
        DataWriter.saveChild();

        assertEquals("Frank", DataReader.getChildren().get(0).getContact().get(0).getFirstName());
    }
    /***************************************************************************************************/

    @Test
    public void testWritingZeroCabins(){
        cabinList = DataReader.getCabins();
        assertEquals(0, cabinList.size());
    }

    @Test
    public void testWritingOneCabin(){
        cabinList.add(new Cabin("coconut"));
        DataWriter.saveCabins();
        assertEquals("coconut", DataReader.getCabins().get(0).getName());
    }

    @Test
    public void testWritingFiveCabins(){
        cabinList.add(new Cabin("coconut"));
        cabinList.add(new Cabin("coconut2"));
        cabinList.add(new Cabin("coconut3"));
        cabinList.add(new Cabin("coconut4"));
        cabinList.add(new Cabin("coconut5"));
        DataWriter.saveCabins();
        assertEquals("coconut5", DataReader.getCabins().get(4).getName());
    }

    @Test
    public void testWritingEmptyCabin(){
        cabinList.add(new Cabin(""));
		DataWriter.saveCabins();
		assertEquals("", DataReader.getCabins().get(0).getName());
    }

    @Test
    public void testWritingNullCabin(){
        cabinList.add(new Cabin(null));
		DataWriter.saveCabins();
		assertEquals(null, DataReader.getCabins().get(0).getName());
    }
    /***************************************************************************************************/
    
    @Test
    public void testWritingZeroCamps(){
        
        /*
        for(Camp camp : campList){
            campList.add(camp);
        }*/

        campList = DataReader.getCamp();
        assertEquals(0, ((List<Camp>) campList).size());
    }

    @Test
    public void testWritingOneCamp(){
        ((List<Camp>) campList).add((Camp) new Camp("camp1"));
        DataWriter.saveCamp();
        assertEquals("camp1", ((List<Camp>) DataReader.getCamp()).get(0).getName());
    }

    @Test
    public void testWritingFiveCamps(){
        ((List<Camp>) campList).add((Camp) new Camp("camp1"));
        ((List<Camp>) campList).add((Camp) new Camp("camp2"));
        ((List<Camp>) campList).add((Camp) new Camp("camp3"));
        ((List<Camp>) campList).add((Camp) new Camp("camp4"));
        ((List<Camp>) campList).add((Camp) new Camp("camp5"));
        DataWriter.saveChild();
        assertEquals("camp5", ((List<Camp>) DataReader.getCamp()).get(4).getName());
    }

    @Test
    public void testWritingEmptyCamp(){
        ((List<Camp>) campList).add((Camp) new Camp(""));
		DataWriter.saveCamp();
		assertEquals("", ((List<Camp>) DataReader.getCamp()).get(0).getName());
    }

    @Test
    public void testWritingSessionForCamp(){
        ((List<Camp>) campList).add((Camp) new Camp("camp1"));
        DataWriter.saveCamp();
        ((List<Camp>) campList).get(0).getSessions().addAll((List<? extends Session>) new Session("Hawaiian", cabinList));
        DataWriter.saveCamp();

        assertEquals("Hawaiian ", ((List<Camp>) DataReader.getCamp()).get(0).getSessions().get(0).getTheme());
    }
}
