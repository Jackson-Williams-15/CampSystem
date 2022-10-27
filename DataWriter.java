import java.util.ArrayList;
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
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUser.add(getAllUserJSON(users.get(i)));
		}

  //Write JSON file
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
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_PHONE_NUMBER, user.getPhone());
        userDetails.put(USER_CONTACT, user.getContact());
		userDetails.put(USER_DOB, user.getDateOfBirth());
        
        return userDetails;
	}
}

