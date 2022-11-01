import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataReader extends DataConstants {
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {

            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Child> childrenList = getChildren();

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
				Date dateOfBirth = ((Date)personJSON.get(USER_DOB));
				int phoneNumber = (int)personJSON.get(USER_PHONE_NUMBER);
                String type = (String)personJSON.get(USER_TYPE);
                
                if(type.equals("GuardianUser")) {
                    int campDuration = (int)personJSON.get(USER_CAMP_DURATION);
                    Date campDates = (Date)personJSON.get(USER_CAMP_DATES);

                    JSONArray childrenJSON = (JSONArray)personJSON.get(USER_CHILDREN);
                    ArrayList<Child> children = new ArrayList<Child>();
                    for(int j=0; j<childrenList.size(); j++) {
                        UUID childUUID = (UUID)childrenJSON.get(j);
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
                    Contact doctor = (Contact)personJSON.get(USER_DOCTOR);

                    JSONArray emergencyContactsJSON = (JSONArray)personJSON.get(USER_CONTACT);
                    ArrayList<Contact> emergencyContacts = new ArrayList<Contact>();
                    for(int j=0; j < emergencyContactsJSON.size(); j++) {
                        JSONObject emergencyContactJSON = (JSONObject)emergencyContactsJSON.get(j);
                        //string name string int string
                        String contactFirstName = (String)emergencyContactJSON.get("firstName");
                        String contactLastName = (String)emergencyContactJSON.get("lastName");
                        int contactPhoneNumber = (int)emergencyContactJSON.get("phoneNumber");
                        String contactEmail = (String)emergencyContactJSON.get("email");
                        emergencyContacts.add(new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmail));
                    }
                    JSONArray medicationsJSON = (JSONArray)personJSON.get(CHILD_MEDS);
                    ArrayList<Medication> medications = new ArrayList<Medication>();
                    for(int j=0; j < medicationsJSON.size(); j++) {
                        JSONObject medicationJSON = (JSONObject)medicationsJSON.get(j);
                        String medType = (String)medicationJSON.get("type");
                        String medDose = (String)medicationJSON.get("dose");
                        String medTime = (String)medicationJSON.get("time");
                        medications.add(new Medication(medType, medDose, medTime));
                    }
                    JSONArray allergiesJSON = (JSONArray)personJSON.get(CHILD_ALLERGIES);
                    ArrayList<String> allergies = new ArrayList<String>();
                    for(int j=0; j < allergiesJSON.size(); j++) {
                        JSONObject allergyJSON = (JSONObject)allergiesJSON.get(j);
                        String allergy = (String)allergyJSON.get(CHILD_ALLERGIES);
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

    public static ArrayList<Child> getChildren() {
        ArrayList<Child> children = new ArrayList<Child>();

        try {

            FileReader reader = new FileReader(CHILD_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String firstName = (String)personJSON.get(CHILD_FIRST_NAME);
				String lastName = (String)personJSON.get(CHILD_LAST_NAME);
                Date dateOfBirth = (Date)personJSON.get(CHILD_DOB);
                UUID id = UUID.fromString((String)personJSON.get(CHILD_ID));
                Contact doctor = (Contact)personJSON.get(CHILD_DOCTOR);
                
                JSONArray emergencyContactsJSON = (JSONArray)personJSON.get(CHILD_CONTACTS);
                ArrayList<Contact> emergencyContacts = new ArrayList<Contact>();
                for(int j=0; j < emergencyContactsJSON.size(); j++) {
                    JSONObject emergencyContactJSON = (JSONObject)emergencyContactsJSON.get(j);
                    //string name string int string
                    String contactFirstName = (String)emergencyContactJSON.get("firstName");
                    String contactLastName = (String)emergencyContactJSON.get("lastName");
                    int contactPhoneNumber = (int)emergencyContactJSON.get("phoneNumber");
                    String contactEmail = (String)emergencyContactJSON.get("email");
                    emergencyContacts.add(new Contact(contactFirstName, contactLastName, contactPhoneNumber, contactEmail));
                }

                JSONArray medicationsJSON = (JSONArray)personJSON.get(CHILD_MEDS);
                ArrayList<Medication> medications = new ArrayList<Medication>();
                for(int j=0; j < medicationsJSON.size(); j++) {
                    JSONObject medicationJSON = (JSONObject)medicationsJSON.get(j);
                    String type = (String)medicationJSON.get("type");
                    String dose = (String)medicationJSON.get("dose");
                    String time = (String)medicationJSON.get("time");
                    medications.add(new Medication(type, dose, time));
                }
                
                JSONArray allergiesJSON = (JSONArray)personJSON.get(CHILD_ALLERGIES);
                ArrayList<String> allergies = new ArrayList<String>();
                for(int j=0; j < allergiesJSON.size(); j++) {
                    JSONObject allergyJSON = (JSONObject)allergiesJSON.get(j);
                    String allergy = (String)allergyJSON.get(CHILD_ALLERGIES);
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

    public static ArrayList<Cabin> getCabins() {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();

        try {

            FileReader reader = new FileReader(CABIN_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray cabinsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < cabinsJSON.size(); i++) {
                JSONObject cabinJSON = (JSONObject)cabinsJSON.get(i);
                String name = (String)cabinJSON.get(CABIN_NAME);
				UUID id = UUID.fromString((String)cabinJSON.get(CABIN_ID));
                ArrayList<Child> camperGroup = (ArrayList<Child>)cabinJSON.get(CABIN_CAMP_GROUP);
                StaffUser staffUser = (StaffUser)cabinJSON.get(CABIN_STAFF_USER);
                int minAge = (int)cabinJSON.get(CABIN_MIN_AGE);
                int maxAge = (int)cabinJSON.get(CABIN_MAX_AGE);

                //arraylist activities, day enum
                JSONArray scheduleJSON = (JSONArray)cabinJSON.get(CABIN_SCHEDULE);
                Schedule[] schedule = new Schedule[7];
                for(int j=0; j < scheduleJSON.size() && j<7; j++) {
                    Day day = (Day)cabinJSON.get(CABIN_DAY);
                    JSONArray activitiesJSON = (JSONArray)cabinJSON.get(CABIN_ACTIVITIES);
                    ArrayList<Activity> activities = new ArrayList<Activity>();
                    for(int k=0; k < activitiesJSON.size(); k++) {
                        JSONObject activityJSON = (JSONObject)activitiesJSON.get(k);
                        Type type = (Type)activityJSON.get("type");
                        String activityName = (String)activityJSON.get("name");
                        String time = (String)activityJSON.get("time");
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

    public static ArrayList<Camp> getCamps() {
        ArrayList<Camp> camps = new ArrayList<Camp>();

        try {

            FileReader reader = new FileReader(CAMP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray campsJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Cabin> cabinsList = getCabins();
            
            for(int i=0; i < campsJSON.size(); i++) {
                JSONObject campJSON = (JSONObject)new JSONParser().parse(reader);
                String name = (String)campJSON.get(CAMP_NAME);
                UUID UUID = (UUID)campJSON.get(CAMP_UUID);

                JSONArray sessionsJSON = (JSONArray)campJSON.get(CAMP_SESSIONS);
                for(int j=0; j<sessionsJSON.size(); j++) {
                    JSONObject sessionJSON = (JSONObject)new JSONParser().parse(reader);
                    String theme = (String)sessionJSON.get(CAMP_SESSION_THEME);

                }

                camps.add(new Camp(name));
            }
            return camps;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
