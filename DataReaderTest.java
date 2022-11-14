import java.util.ArrayList;
import java.util.UUID;

import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class DataReaderTest {
    private UserList userList = UserList.getInstance();
    private ChildList childList = ChildList.getInstance();
    private CabinList cabinList = CabinList.getInstance();
    private CampList campList = CampList.getInstance();

    @Before
    public void setup() {

        childList.getChildren().clear();
        Contact janeDoctor = new Contact("Doctor", "Who", 1876543210, "who@gmail.com");
        ArrayList<String> janeAllergies = new ArrayList<String>();
        janeAllergies.add("pollen");
        janeAllergies.add("peanuts");
        janeAllergies.add("cats");
        ArrayList<Medication> janeMedications = new ArrayList<Medication>();
        janeMedications.add(new Medication("tylenol", "one tablet", "before breakfast"));
        UUID janeID = UUID.randomUUID();
        ArrayList<Contact> janeContacts = new ArrayList<Contact>();
        janeContacts.add(new Contact("John", "Doe", 1876674230, "johnd@gmail.com"));
        janeContacts.add(new Contact("Florence", "Doe", 1877654923, "flo@gmail.com"));
        Child jane = new Child("Jane", "Doe", "1/1/2010", janeID, janeAllergies, janeDoctor, janeContacts, janeMedications);
        childList.addChild("Jane", "Doe", "1/1/2010");

        Contact tomDoctor = new Contact("Doctor", "Smith", 1871234210, "dsmith@gmail.com");
        ArrayList<String> tomAllergies = new ArrayList<String>();
        tomAllergies.add("eggs");
        tomAllergies.add("soy");
        ArrayList<Medication> tomMedications = new ArrayList<Medication>();
        tomMedications.add(new Medication("ibuprofen", "two pills", "before bed"));
        UUID tomID = UUID.randomUUID();
        ArrayList<Contact> tomContacts = new ArrayList<Contact>();
        tomContacts.add(new Contact("Paul", "McDonald", 1876543210, "pmcdonald@gmail.com"));
        tomContacts.add(new Contact("Mary", "McDonald", 1356478965, "marym@gmail.com"));
        Child tom = new Child("Tom", "McDonald", "1/1/2011", tomID, tomAllergies, tomDoctor, tomContacts, tomMedications);
        childList.addChild("Tom", "McDonald", "1/1/2011");

        userList.getUsers().clear();
        UUID jakeID = UUID.randomUUID();
        DirectorUser jake = new DirectorUser("Jake", "Sim", 1234567890, "jakesim@yahoo.com", "23456", "12/30/1990", jakeID);
        userList.addUser(jake);

        UUID johnID = UUID.randomUUID();
        ArrayList<Child> johnChildren = new ArrayList<Child>();
        johnChildren.add(jane);
        ArrayList<String> campDates = new ArrayList<String>();
        campDates.add("10/24/2022");
        GuardianUser john = new GuardianUser("John", "Doe", 1876674230, "johnd@gmail.com", "1234", "10/12/1900", johnID, johnChildren, 7, campDates);
        userList.addUser(john);

        UUID maryID = UUID.randomUUID();
        ArrayList<Child> maryChildren = new ArrayList<Child>();
        maryChildren.add(tom);
        ArrayList<String> maryCampDates = new ArrayList<String>();
        campDates.add("10/24/2022");
        GuardianUser mary = new GuardianUser("Mary", "McDonald", 1356478965, "marym@gmail.com", "1234", "10/12/1900", maryID, maryChildren, 7, maryCampDates);
        userList.addUser(mary);

        UUID andrewID = UUID.randomUUID();
        Contact andrewDoctor = new Contact("Doctor", "Walkup", 1871233210, "walkup@gmail.com");
        ArrayList<Contact> andrewContacts = new ArrayList<Contact>();
        andrewContacts.add(new Contact("Tim", "Liu", 1876543210, "pmcdonald@gmail.com"));
        ArrayList<Medication> andrewMedications = new ArrayList<Medication>();
        andrewMedications.add(new Medication("prozac", "one pill", "in the morning"));
        ArrayList<String> andrewAllergies = new ArrayList<String>();
        andrewAllergies.add("shellfish");
        StaffUser andrew = new StaffUser("Andrew", "Liu", 1904872309, "andrewl@gmail.com", "123456", "12/08/2000", andrewID, andrewDoctor, andrewContacts, andrewMedications, andrewAllergies);
        userList.addUser(andrew);

        cabinList.getCabins().clear();
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();
        UUID tigerCabinUUID = UUID.randomUUID();
        ArrayList<Child> tigerCampers = new ArrayList<Child>();
        tigerCampers.add(jane);
        Schedule[] tigerSchedule = new Schedule[7];
        ArrayList<Activity> tigerMondayActivities = new ArrayList<Activity>();
        tigerMondayActivities.add(new Activity(Type.CREATIVE, "painting", "9:00am"));
        tigerMondayActivities.add(new Activity(Type.WATER, "swimming", "10:00am"));
        tigerMondayActivities.add(new Activity(Type.PHYSICAL, "archery", "1:00pm"));
        tigerMondayActivities.add(new Activity(Type.COMPETITIVE, "capture the flag", "2:00pm"));
        ArrayList<Activity> tigerTuesdayActivities = new ArrayList<Activity>();
        tigerTuesdayActivities.add(new Activity(Type.PHYSICAL, "volleyball", "9:00am"));
        tigerTuesdayActivities.add(new Activity(Type.WATER, "kayaking", "10:00am"));
        tigerTuesdayActivities.add(new Activity(Type.CREATIVE, "clay sculpting", "1:00pm"));
        tigerTuesdayActivities.add(new Activity(Type.COMPETITIVE, "dodgeball", "2:00pm"));
        ArrayList<Activity> tigerWednesdayActivities = new ArrayList<Activity>();
        tigerWednesdayActivities.add(new Activity(Type.CREATIVE, "bracelet making", "9:00am"));
        tigerWednesdayActivities.add(new Activity(Type.PHYSICAL, "hiking", "10:00am"));
        tigerWednesdayActivities.add(new Activity(Type.COMPETITIVE, "basketball", "1:00pm"));
        tigerWednesdayActivities.add(new Activity(Type.WATER, "sailing", "2:00pm"));
        ArrayList<Activity> tigerThursdayActivities = new ArrayList<Activity>();
        tigerThursdayActivities.add(new Activity(Type.COMPETITIVE, "ultimate frisbee", "9:00am"));
        tigerThursdayActivities.add(new Activity(Type.PHYSICAL, "free time", "10:00am"));
        tigerThursdayActivities.add(new Activity(Type.WATER, "canoeing", "1:00pm"));
        tigerThursdayActivities.add(new Activity(Type.CREATIVE, "build birdhouses", "2:00pm"));
        ArrayList<Activity> tigerFridayActivities = new ArrayList<Activity>();
        tigerFridayActivities.add(new Activity(Type.CREATIVE, "painting", "9:00am"));
        tigerFridayActivities.add(new Activity(Type.WATER, "swimming", "10:00am"));
        tigerFridayActivities.add(new Activity(Type.PHYSICAL, "archery", "1:00pm"));
        tigerFridayActivities.add(new Activity(Type.COMPETITIVE, "capture the flag", "2:00pm"));
        ArrayList<Activity> tigerSaturdayActivities = new ArrayList<Activity>();
        tigerSaturdayActivities.add(new Activity(Type.CREATIVE, "tie-dying", "9:00am"));
        tigerSaturdayActivities.add(new Activity(Type.WATER, "kayaking", "10:00am"));
        tigerSaturdayActivities.add(new Activity(Type.COMPETITIVE, "soccer", "1:00pm"));
        tigerSaturdayActivities.add(new Activity(Type.PHYSICAL, "campfire", "5:00pm"));
        ArrayList<Activity> tigerSundayActivities = new ArrayList<Activity>();
        tigerSundayActivities.add(new Activity(Type.PHYSICAL, "free time", "9:00am"));
        tigerSundayActivities.add(new Activity(Type.WATER, "water balloon fight", "10:00am"));
        tigerSundayActivities.add(new Activity(Type.CREATIVE, "drawing", "1:00pm"));
        tigerSundayActivities.add(new Activity(Type.COMPETITIVE, "capture the flag", "2:00pm"));
        tigerSchedule[0] = new Schedule(tigerMondayActivities, Day.Monday);
        tigerSchedule[1] = new Schedule(tigerTuesdayActivities, Day.Tuesday);
        tigerSchedule[2] = new Schedule(tigerWednesdayActivities, Day.Wednesday);
        tigerSchedule[3] = new Schedule(tigerThursdayActivities, Day.Thursday);
        tigerSchedule[4] = new Schedule(tigerFridayActivities, Day.Friday);
        tigerSchedule[5] = new Schedule(tigerSaturdayActivities, Day.Saturday);
        tigerSchedule[6] = new Schedule(tigerSundayActivities, Day.Sunday);
        Cabin tigers = new Cabin("tigers", tigerCabinUUID, andrew, tigerCampers, 11, 12, tigerSchedule);
        cabinList.addCabin("tigers");

        campList.getCamps().clear();
        ArrayList<Cabin> campCabins = new ArrayList<Cabin>();
        campCabins.add(tigers);
        ArrayList<Session> sessions = new ArrayList<Session>();
        sessions.add(new Session("Hawaiian", campCabins));
        Camp camp = new Camp("Camp Congaree", sessions);
        campList.addCamp(camp);
    }

    @After
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    //test getAllUsers
    @Test
    public void testGetAllUsersSize() {
        assertEquals(4, userList.getUsers().size());
    }
    @Test
    public void testGetZeroUsers() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.getUsers().size());
    }
    @Test
    public void testGetNullUser() {
        UserList.getInstance().getUsers().clear();
        User nullUser = null;
        userList.addUser(nullUser);
        assertEquals(0, userList.getUsers().size());
    }
    @Test
    public void testGetEmptyUser() {
        UserList.getInstance().getUsers().clear();
        User empty = new User("","",0,"","","");
        userList.addUser(empty);
        assertEquals(1, userList.getUsers().size());
    }
    
    @Test
    public void testGetUserFirstName() {
        assertEquals("Jake", userList.getUsers().get(0).getFirstName());
    }
    @Test
    public void testGetUserPhoneNumber() {
        assertEquals(1234567890, userList.getUsers().get(0).getPhone());
    }

    //test getChildren
    @Test
    public void testGetChildrenSize() {
        assertEquals(2, childList.getChildren().size());
    }
    @Test
    public void testGetZeroChildren() {
        ChildList.getInstance().getChildren().clear();
        DataWriter.saveChild();
        assertEquals(0, childList.getChildren().size());
    }
    @Test
    public void testGetNullChildren() {
        ChildList.getInstance().getChildren().clear();
        childList.addChild(null, null, null);
        assertEquals(0, childList.getChildren().size());
    }
    @Test
    public void testGetEmptyChild() {
        ChildList.getInstance().getChildren().clear();
        childList.addChild("","","");
        assertEquals(1, childList.getChildren().size());
    }
    @Test
    public void testGetChildLastName() {
        assertEquals("Doe", childList.getChildren().get(0).getLastName());
    }
    @Test
    public void testGetChildAllergiesSize() {
        assertEquals(3, childList.getChildren().get(0).getAllergies().size());
    }
    @Test
    public void testGetChildDoctorName() {
        assertEquals("Doctor", childList.getChildren().get(0).getDoctor().getFirstName());
    }
    @Test
    public void testGetChildMedicationDose() {
        assertEquals("one tablet", childList.getChildren().get(0).getMeds().get(0).getDose());
    }

    //test getCabins
    @Test
    public void testGetCabinsSize() {
        assertEquals(1, cabinList.getCabins().size());
    }
    @Test
    public void testGetZeroCabins() {
        CabinList.getInstance().getCabins().clear();
        DataWriter.saveCabins();
        assertEquals(0, cabinList.getCabins().size());
    }
    @Test
    public void testGetNullCabins() {
        CabinList.getInstance().getCabins().clear();
        cabinList.addCabin(null);
        assertEquals(0, cabinList.getCabins().size());
    }
    @Test
    public void testGetEmptyCabin() {
        CabinList.getInstance().getCabins().clear();
        cabinList.addCabin("");
        assertEquals(1, cabinList.getCabins().size());
    }
    @Test
    public void testGetCabinCounselor() {
        assertEquals("Andrew", cabinList.getCabins().get(0).getCounselor().getFirstName());
    }
    @Test
    public void testGetCabinScheduleActivity() {
        assertEquals("painting", cabinList.getCabins().get(0).getSchedule()[0].getActivity().get(0).getName());
    }

    //test getCamp
    @Test
    public void testGetNullCamp() {
        CampList.getInstance().getCamp().clear();
        Camp nullCamp = null;
        campList.addCamp(nullCamp);
        assertEquals(0, campList.getCamps().size());
    }
    @Test
    public void testGetEmptyCamp() {

    }

}
