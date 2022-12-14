import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

	/**
	 * gets list of users and writes it to JSON file
	 */
    public static void saveUsers(){
        UserList user = UserList.getInstance();
		ArrayList<User> users = user.getUsers();
		JSONArray jsonUser = new JSONArray();
		 
		// creates jsonObject
		for(int i=0; i< users.size(); i++) {
			jsonUser.add(getAllUserJSON(users.get(i)));
		}
		// write json file
  try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
    file.write(jsonUser.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }

	/**
	 * Makes user a JSON object
	 * @param user the user being made into a JSON Object
	 * @return returns a JSON object representation of the user
	 */
    public static JSONObject getAllUserJSON(User user) {
		HashMap<String, Object> userDetails = new HashMap<String, Object>();
		userDetails.put(USER_ID, user.getUUID().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName().toString());
		userDetails.put(USER_LAST_NAME, user.getLastName().toString());
		userDetails.put(USER_PHONE_NUMBER, user.getPhone());
        userDetails.put(USER_CONTACT, user.getContact());
		userDetails.put(USER_DOB, user.getDateOfBirth());
		userDetails.put(USER_PASSWORD, user.getPassword().toString());

		JSONObject userDetailsJSON = new JSONObject(userDetails);
        return userDetailsJSON;
	}

	/**
	 * gets list of cabins and writes it to JSON file
	 */
	public static void saveCabins(){
        CabinList cabin = CabinList.getInstance();
		ArrayList<Cabin> cabins = cabin.getCabins();
		JSONArray jsonCabin = new JSONArray();
		
		for(int i=0; i< cabins.size(); i++) {
			jsonCabin.add(getAllCabinsJSON(cabins.get(i)));
		}

  try (FileWriter file = new FileWriter(CABIN_FILE_NAME)) {
 
    file.write(jsonCabin.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }

	/**
	 * Makes cabins a JSON object
	 * @param cabin the cabin being made into a JSON Object
	 * @return returns a JSON object representation of the cabin
	 */
    public static JSONObject getAllCabinsJSON(Cabin cabin) {
		HashMap<String, Object> cabinDetails = new HashMap<String, Object>();
		cabinDetails.put(CABIN_ID, cabin.getUUID().toString());
		cabinDetails.put(CABIN_NAME, cabin.getName());
		cabinDetails.put(CABIN_MIN_AGE, cabin.getMinAge());
		cabinDetails.put(CABIN_MAX_AGE, cabin.getMaxAge());
		cabinDetails.put(CABIN_STAFF_USER, cabin.getCounselor());
        cabinDetails.put(CABIN_CAMP_GROUP, cabin.getCamperGroup());
		cabinDetails.put(CABIN_SCHEDULE, cabin.getSchedule());
        
		/**
		 * converts array of schedules into arraylist to save schedules in cabin
		 */
		Schedule [] schedules = cabin.getSchedule();
		ArrayList<Schedule> cabinSchedules = new ArrayList<Schedule>();
		for(Schedule schedule : schedules)
		{
			cabinSchedules.add(schedule);
		}

		JSONArray JSONSchedule = new JSONArray();
		
		  for(int i = 0; i < cabinSchedules.size(); i++) {
			HashMap<String, Object> scheduleDetails = new HashMap<String, Object>();
			Schedule schedule = cabinSchedules.get(i);
			scheduleDetails.put(CABIN_SCHEDULE, schedule.getActivities());
			scheduleDetails.put(CABIN_DAY, schedule.getDay());
			JSONObject scheduleDetailsJSON = new JSONObject();
			JSONSchedule.add(scheduleDetailsJSON);
		}
		cabinDetails.put(CABIN_SCHEDULE, JSONSchedule);

		JSONArray JSONActivity = new JSONArray();
		/** 
		for(int i = 0; i < cabinActivities.getActivities().size(); i++) {
			HashMap<String, Object> activityDetails = new HashMap<String, Object>();
			Activity activity = cabin.getActivity().get(i);
			activityDetails.put(ACTIVITY_NAME, activity.getName());
			activityDetails.put(ACTIVITY_TYPE, activity.getType());
			activityDetails.put(ACTIVITY_TIME, activity.getTime());
			activityDetails.put(ACTIVITY_DESCRIPTION, activity.getDescription());
			JSONObject activityDetailsJSON = new JSONObject(activityDetails);

			JSONActivity.add(activityDetailsJSON);
		}
		cabinDetails.put(CABIN_ACTIVITIES, JSONActivity);
		*/
		
		JSONObject cabinDetailsJSON = new JSONObject(cabinDetails);

        return cabinDetailsJSON;
	}

	/**
	 * gets list of children and writes it to JSON file
	 */
	public static void saveChild(){
        ChildList child = ChildList.getInstance();
		ArrayList<Child> children = child.getChildren();
		JSONArray jsonChild = new JSONArray();
		
		for(int i=0; i< children.size(); i++) {
			jsonChild.add(getAllChildJSON(children.get(i)));
		}

  try (FileWriter file = new FileWriter(CHILD_FILE_NAME)) {
 
    file.write(jsonChild.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
} 

    }

	/**
	 * Makes children a JSON object
	 * @param child the child being made into a JSON Object
	 * @return returns a JSON object representation of the child
	 */
    public static JSONObject getAllChildJSON(Child child) {
		HashMap<String, Object> childDetails = new HashMap<String, Object>();
		childDetails.put(CHILD_ID, child.getUUID().toString());
		childDetails.put(CHILD_FIRST_NAME, child.getFirstName());
		childDetails.put(CHILD_LAST_NAME, child.getLastName());
		childDetails.put(CHILD_DOB, child.getBirth());
		childDetails.put(CHILD_ALLERGIES, child.getAllergies());
        childDetails.put(CHILD_MEDS, child.getMeds());
		childDetails.put(CHILD_DOCTOR, child.getDoctor());
        
		JSONArray JSONMeds = new JSONArray();

		for(int i = 0; i < child.getMeds().size(); i++) {
			HashMap<String, Object> medicationDetails = new HashMap<String, Object>();
			Medication medication = child.getMeds().get(i);
			medicationDetails.put(MED_TYPE, medication.getType());
			medicationDetails.put(MED_DOSE, medication.getDose());
			medicationDetails.put(MED_TIME, medication.getTime());
			JSONObject medicationDetailsJSON = new JSONObject(medicationDetails);

			JSONMeds.add(medicationDetailsJSON);
		}
		childDetails.put(CHILD_MEDS, JSONMeds);

		JSONArray JSONContact = new JSONArray();
		for(int i = 0; i < child.getContact().size(); i++) {
			HashMap<String, Object> contactDetails = new HashMap<String, Object>();
			Contact contact = child.getContact().get(i);
			contactDetails.put(CONTACT_FIRST_NAME, contact.getFirstName());
			contactDetails.put(CONTACT_LAST_NAME, contact.getLastName());
			contactDetails.put(CONTACT_EMAIL, contact.getEmail());
			contactDetails.put(CONTACT_PHONE_NUMBER, contact.getPhoneNumber());

			JSONObject contactDetailsJSON = new JSONObject(contactDetails);

			JSONContact.add(contactDetailsJSON);
		}
		childDetails.put(CHILD_CONTACTS, JSONContact);

		JSONObject childDetailsJSON = new JSONObject(childDetails);
        return childDetailsJSON;
	}	
		
/**
	 * gets list of camps and writes it to JSON file
	 */
	public static void saveCamp(){
        CampList camp = CampList.getInstance();
		ArrayList<Camp> camps = camp.getCamps();
		JSONArray jsonCamp = new JSONArray();
		
		for(int i=0; i< camps.size(); i++) {
			jsonCamp.add(getAllCampJSON(camps.get(i)));
		}

  try (FileWriter file = new FileWriter(CAMP_FILE_NAME)) {
 
    file.write(jsonCamp.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }

	/**
	 * Makes camp a JSON object
	 * @param camp the camp being made into a JSON Object
	 * @return returns a JSON object representation of the camp
	 */
    public static JSONObject getAllCampJSON(Camp camp) {
		HashMap<String, Object> campDetails = new HashMap<String, Object>();
		campDetails.put(CAMP_NAME, camp.getName());

		JSONArray JSONSession = new JSONArray();
		for(int i = 0; i < camp.getSessions().size(); i++) {
			HashMap<String, Object> sessionDetails = new HashMap<String, Object>();
			Session session = camp.getSessions().get(i);
			sessionDetails.put(CAMP_SESSION_THEME, session.getTheme());
			sessionDetails.put(SESSION_CABIN, session.getCabins());

			JSONObject sessionDetailsJSON = new JSONObject(sessionDetails);

			JSONSession.add(sessionDetailsJSON);
		}
		campDetails.put(CAMP_SESSIONS, JSONSession);
		JSONObject campDetailsJSON = new JSONObject(campDetails);

        return campDetailsJSON;
	}

}


