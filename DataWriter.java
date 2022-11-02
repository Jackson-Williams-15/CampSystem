import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static void saveUsers(){
        UserList user = UserList.getInstance();
		ArrayList<User> users = user.getUsers();
		JSONArray jsonUser = new JSONArray();
		
		//creating all the user json objects
		for(int i=0; i< users.size(); i++) {
			jsonUser.add(getAllUserJSON(users.get(i)));
		}

  //Write user JSON file
  try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
    file.write(jsonUser.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }
    public static JSONObject getAllUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUUID().toString());
		userDetails.put(USER_FIRST_NAME, user.getFirstName().toString());
		userDetails.put(USER_LAST_NAME, user.getLastName().toString());
		userDetails.put(USER_PHONE_NUMBER, user.getPhone());
        userDetails.put(USER_CONTACT, user.getContact());
		userDetails.put(USER_DOB, user.getDateOfBirth());
		userDetails.put(USER_PASSWORD, user.getPassword().toString());
        
        return userDetails;
	}

	public static void saveCabins(){
        CabinList cabin = CabinList.getInstance();
		ArrayList<Cabin> cabins = cabin.getCabins();
		JSONArray jsonCabin = new JSONArray();
		
		//creating all the cabin json objects
		for(int i=0; i< cabins.size(); i++) {
			jsonCabin.add(getAllCabinsJSON(cabins.get(i)));
		}

  //Write cabin JSON file
  try (FileWriter file = new FileWriter(CABIN_FILE_NAME)) {
 
    file.write(jsonCabin.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }
    public static JSONObject getAllCabinsJSON(Cabin cabin) {
		JSONObject cabinDetails = new JSONObject();
		cabinDetails.put(CABIN_ID, cabin.getUUID().toString());
		cabinDetails.put(CABIN_NAME, cabin.getName());
		cabinDetails.put(CABIN_MIN_AGE, cabin.getMinAge());
		cabinDetails.put(CABIN_MAX_AGE, cabin.getMaxAge());
		cabinDetails.put(CABIN_STAFF_USER, cabin.getCounselor());
        cabinDetails.put(CABIN_CAMP_GROUP, cabin.getCamperGroup());
		cabinDetails.put(CABIN_SCHEDULE, cabin.getSchedule());
        
		JSONArray JSONActivity = new JSONArray();

		for(int i = 0; i < cabin.getActivity().size(); i++) {
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

		JSONArray JSONSchedule = new JSONArray();

		//NEED TO TURN SCHEDULE INTO ARRAYLIST
		for(int i = 0; i < cabin.getSchedule().size(); i++) {
			HashMap<String, Object> scheduleDetails = new HashMap<String, Object>();
			Schedule schedule = cabin.getSchedule().get(i);
			scheduleDetails.put(CABIN_SCHEDULE, schedule.getActivities());
			scheduleDetails.put(CABIN_DAY, schedule.getDay());
			JSONObject scheduleDetailsJSON = new JSONObject();
			JSONSchedule.add(scheduleDetailsJSON);
		}
		cabinDetails.put(CABIN_SCHEDULE, JSONSchedule);

		JSONObject cabinDetailsJSON = new JSONObject(cabinDetails);

        return cabinDetailsJSON;
	}

	public static void saveChild(){
        ChildList child = ChildList.getInstance();
		ArrayList<Child> children = child.getChildren();
		JSONArray jsonChild = new JSONArray();
		
		//creating the child json objects
		for(int i=0; i< children.size(); i++) {
			jsonChild.add(getAllChildJSON(children.get(i)));
		}

  //Write child JSON file
  try (FileWriter file = new FileWriter(CHILD_FILE_NAME)) {
 
    file.write(jsonChild.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
} 
// MAKE GETTER FOR CONTACT AND MEDS. CREATE DOC CLASS WITH GETTERS
    }
    public static JSONObject getAllChildJSON(Child child) {
		JSONObject childDetails = new JSONObject();
		childDetails.put(CHILD_ID, child.getUUID().toString());
		childDetails.put(CHILD_FIRST_NAME, child.getFirstName());
		childDetails.put(CHILD_LAST_NAME, child.getLastName());
		childDetails.put(CHILD_DOB, child.getBirth());
		childDetails.put(CHILD_ALLERGIES, child.getAllergies());
        //childDetails.put(CHILD_MEDS, child.getMeds());
		//childDetails.put(CHILD_DOCTOR, child.getContact());
        
        return childDetails;
	}

	public static void saveCamp(){
        CampList camp = CampList.getInstance();
		ArrayList<Camp> camps = camp.getCamps();
		JSONArray jsonCamp = new JSONArray();
		
		//creating Camp the json objects
		for(int i=0; i< camps.size(); i++) {
			jsonCamp.add(getAllCampJSON(camps.get(i)));
		}

  //Write Camp JSON file
  try (FileWriter file = new FileWriter(CAMP_FILE_NAME)) {
 
    file.write(jsonCamp.toJSONString());
    file.flush();

} catch (IOException e) {
    e.printStackTrace();
}
    }
    public static JSONObject getAllCampJSON(Camp camp) {
		JSONObject campDetails = new JSONObject();
		campDetails.put(CAMP_NAME, camp.getName());
        //campDetails.put(CAMP_UUID, camp.getUUID()); Should be able to be removed
        return campDetails;
	}

}


