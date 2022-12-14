import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader extends DataConstants {

    /**
     * Reads in user JSON file and populates array list of users
     * 
     * @return Returns array list of users of type guardian, director, and staff
     */
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {

            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Child> childrenList = getChildren();

            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
				String dateOfBirth = ((String)personJSON.get(USER_DOB));
				int phoneNumber = ((Long)personJSON.get(USER_PHONE_NUMBER)).intValue();
                String type = (String)personJSON.get(USER_TYPE);
                
                if(type.equals("GuardianUser")) {
                    int campDuration = ((Long)personJSON.get(USER_CAMP_DURATION)).intValue();
                    JSONArray campDatesJSON = (JSONArray)personJSON.get(USER_CAMP_DATES);
                    ArrayList<String> campDates = new ArrayList<String>();
                    for(int j = 0; j < campDatesJSON.size(); j++) {
                        String campDate = campDatesJSON.get(j).toString();
                        campDates.add(campDate);
                    }

                    JSONArray childrenJSON = (JSONArray)personJSON.get(USER_CHILDREN);
                    ArrayList<Child> children = new ArrayList<Child>();
                    for(int j=0; j<childrenList.size(); j++) {
                        UUID childUUID = UUID.fromString((String)childrenJSON.get(j));
                        if(childrenList.get(j).getUUID() == childUUID) {
                            children.add(ChildList.getChild(childUUID));
                            break;
                        }
                    }

                    users.add(new GuardianUser(firstName, lastName, phoneNumber, email, password, dateOfBirth, id, children, campDuration, campDates));
                }
                else if(type.equals("DirectorUser")) {
                    users.add(new DirectorUser(firstName, lastName, phoneNumber, email, password, dateOfBirth, id));
                }
                else if(type.equals("StaffUser")) {
                    JSONObject doctorJSON = (JSONObject)personJSON.get(USER_DOCTOR);
                    String doctorFirstName = (String)doctorJSON.get(CONTACT_FIRST_NAME);
                    String doctorLastName = (String)doctorJSON.get(CONTACT_LAST_NAME);
                    int doctorPhoneNumber = ((Long)doctorJSON.get(CONTACT_PHONE_NUMBER)).intValue();
                    String doctorEmail = (String)doctorJSON.get(CONTACT_EMAIL);
                    Contact doctor = new Contact(doctorFirstName, doctorLastName, doctorPhoneNumber, doctorEmail);

                    JSONArray emergencyContactsJSON = (JSONArray)personJSON.get(USER_CONTACT);
                    ArrayList<Contact> emergencyContacts = new ArrayList<Contact>();
                    for(int j = 0; j < emergencyContactsJSON.size(); j++) {
                        JSONObject emergencyContactJSON = (JSONObject)emergencyContactsJSON.get(j);
                        //string name string int string
                        String contactFirstName = (String)emergencyContactJSON.get(CONTACT_FIRST_NAME);
                        String contactLastName = (String)emergencyContactJSON.get(CONTACT_LAST_NAME);
                        int contactPhoneNumber = ((Long)emergencyContactJSON.get(CONTACT_PHONE_NUMBER)).intValue();
                        String contactEmail = (String)emergencyContactJSON.get(CONTACT_EMAIL);
                        emergencyContacts.add(new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmail));
                    }

                    JSONArray medicationsJSON = (JSONArray)personJSON.get(USER_MEDS);
                    ArrayList<Medication> medications = new ArrayList<Medication>();
                    for(int j = 0; j < medicationsJSON.size(); j++) {
                        JSONObject medicationJSON = (JSONObject)medicationsJSON.get(j);
                        String medType = (String)medicationJSON.get(MED_TYPE);
                        String medDose = (String)medicationJSON.get(MED_DOSE);
                        String medTime = (String)medicationJSON.get(MED_TIME);
                        medications.add(new Medication(medType, medDose, medTime));
                    }
                    JSONArray allergiesJSON = (JSONArray)personJSON.get(USER_ALLERGIES);
                    ArrayList<String> allergies = new ArrayList<String>();
                    for(int j = 0; j < allergiesJSON.size(); j++) {
                        String allergy = allergiesJSON.get(j).toString();
                        allergies.add(allergy);
                    }

                    users.add(new StaffUser(firstName, lastName, phoneNumber, email, password, dateOfBirth, id, doctor, emergencyContacts, medications, allergies));
                }
            }
            return users;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads in child JSON file and populates array list of children
     * 
     * @return Returns array list of children
     */
    public static ArrayList<Child> getChildren() {
        ArrayList<Child> children = new ArrayList<Child>();

        try {

            FileReader reader = new FileReader(CHILD_FILE_NAME);
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String firstName = (String)personJSON.get(CHILD_FIRST_NAME);
				String lastName = (String)personJSON.get(CHILD_LAST_NAME);
                String dateOfBirth = (String)personJSON.get(CHILD_DOB);
                UUID id = UUID.fromString((String)personJSON.get(CHILD_ID));

                JSONObject doctorJSON = (JSONObject)personJSON.get(CHILD_DOCTOR);
                String doctorFirstName = (String)doctorJSON.get(CONTACT_FIRST_NAME);
                String doctorLastName = (String)doctorJSON.get(CONTACT_LAST_NAME);
                int doctorPhoneNumber = ((Long)doctorJSON.get(CONTACT_PHONE_NUMBER)).intValue();
                String doctorEmail = (String)doctorJSON.get(CONTACT_EMAIL);
                Contact doctor = new Contact(doctorFirstName, doctorLastName, doctorPhoneNumber, doctorEmail);

                JSONArray emergencyContactsJSON = (JSONArray)personJSON.get(CHILD_CONTACTS);
                ArrayList<Contact> emergencyContacts = new ArrayList<Contact>();
                for(int j = 0; j < emergencyContactsJSON.size(); j++) {
                    JSONObject emergencyContactJSON = (JSONObject)emergencyContactsJSON.get(j);
                    String contactFirstName = (String)emergencyContactJSON.get(CONTACT_FIRST_NAME);
                    String contactLastName = (String)emergencyContactJSON.get(CONTACT_LAST_NAME);
                    int contactPhoneNumber = ((Long)emergencyContactJSON.get(CONTACT_PHONE_NUMBER)).intValue();
                    String contactEmail = (String)emergencyContactJSON.get(CONTACT_EMAIL);
                    emergencyContacts.add(new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmail));
                }

                JSONArray medicationsJSON = (JSONArray)personJSON.get(CHILD_MEDS);
                ArrayList<Medication> medications = new ArrayList<Medication>();
                for(int j = 0; j < medicationsJSON.size(); j++) {
                    JSONObject medicationJSON = (JSONObject)medicationsJSON.get(j);
                    String type = (String)medicationJSON.get(MED_TYPE);
                    String dose = (String)medicationJSON.get(MED_DOSE);
                    String time = (String)medicationJSON.get(MED_TIME);
                    medications.add(new Medication(type, dose, time));
                }
                
                JSONArray allergiesJSON = (JSONArray)personJSON.get(CHILD_ALLERGIES);
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j = 0; j < allergiesJSON.size(); j++) {
                    String allergy = allergiesJSON.get(j).toString();
                    allergies.add(allergy);
                }
				children.add(new Child(firstName, lastName, dateOfBirth, id, allergies, doctor, emergencyContacts, medications));
            }
            return children;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads in cabin JSON file and populates array list of cabins
     * 
     * @return Returns array list of cabins
     */
    public static ArrayList<Cabin> getCabins() {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();

        try {

            FileReader reader = new FileReader(CABIN_FILE_NAME);
            JSONArray cabinsJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Child> childrenList = getChildren();

            for(int i = 0; i < cabinsJSON.size(); i++) {
                JSONObject cabinJSON = (JSONObject)cabinsJSON.get(i);
                String name = (String)cabinJSON.get(CABIN_NAME);
				UUID id = UUID.fromString((String)cabinJSON.get(CABIN_ID));

                JSONArray childrenJSON = (JSONArray)cabinJSON.get(CABIN_CAMP_GROUP);
                ArrayList<Child> camperGroup = new ArrayList<Child>();
                for(int j = 0; j<childrenList.size(); j++) {
                    UUID childUUID = UUID.fromString((String)childrenJSON.get(j));
                    if(childrenList.get(j).getUUID() == childUUID) {
                        camperGroup.add(ChildList.getChild(childUUID));
                        break;
                    }
                }

                UUID staffUUID = UUID.fromString((String)cabinJSON.get(CABIN_STAFF_USER));
                StaffUser staffUser = UserList.getStaffUser(staffUUID);
                int minAge = ((Long)cabinJSON.get(CABIN_MIN_AGE)).intValue();
                int maxAge = ((Long)cabinJSON.get(CABIN_MAX_AGE)).intValue();

                //arraylist activities, day enum
                JSONArray schedulesJSON = (JSONArray)cabinJSON.get(CABIN_SCHEDULE);
                Schedule[] schedule = new Schedule[7];
                for(int j = 0; j < schedulesJSON.size(); j++) {
                    JSONObject scheduleJSON = (JSONObject)schedulesJSON.get(j);
                    Day day = Day.valueOf((String)scheduleJSON.get(CABIN_DAY));
                    JSONArray activitiesJSON = (JSONArray)scheduleJSON.get(CABIN_ACTIVITIES);
                    ArrayList<Activity> activities = new ArrayList<Activity>();
                    for(int k=0; k < activitiesJSON.size(); k++) {
                        JSONObject activityJSON = (JSONObject)activitiesJSON.get(k);
                        Type type = Type.valueOf((String)activityJSON.get(ACTIVITY_TYPE));
                        String activityName = (String)activityJSON.get(ACTIVITY_NAME);
                        String time = (String)activityJSON.get(ACTIVITY_TIME);
                        activities.add(new Activity(type, activityName, time));
                    }
                    schedule[j] = new Schedule(activities, day);
                }
				cabins.add(new Cabin(name, id, staffUser, camperGroup, minAge, maxAge, schedule));
            }
            return cabins;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads in camp JSON file
     * 
     * @return Returns camp
     */
    public static Camp getCamp() {
        try {

            FileReader reader = new FileReader(CAMP_FILE_NAME);
            JSONObject campJSON = (JSONObject)new JSONParser().parse(reader);
            ArrayList<Cabin> cabinsList = getCabins();
            String name = (String)campJSON.get(CAMP_NAME);

            JSONArray sessionsJSON = (JSONArray)campJSON.get(CAMP_SESSIONS);
            ArrayList<Session> sessions = new ArrayList<Session>();
            for(int j=0; j<sessionsJSON.size(); j++) {
                JSONObject sessionJSON = (JSONObject)new JSONParser().parse(reader);
                String theme = (String)sessionJSON.get(CAMP_SESSION_THEME);

                JSONArray cabinsJSON = (JSONArray)new JSONParser().parse(reader);
                ArrayList<Cabin> cabins = new ArrayList<Cabin>();
                for(int k=0; k<cabinsList.size(); k++) {
                    UUID cabinUUID = (UUID)cabinsJSON.get(j);
                    if(cabinsList.get(j).getUUID() == cabinUUID) {
                        cabins.add(CabinList.getCabin(cabinUUID));
                        break;
                    }
                }
                sessions.add(new Session(theme, cabins));
            }
            return new Camp(name, sessions);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
