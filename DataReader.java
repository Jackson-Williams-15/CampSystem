import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataReader extends DataConstants {
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<User>();

        try {

            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();

            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(USER_ID));
				String firstName = (String)personJSON.get(USER_FIRST_NAME);
				String lastName = (String)personJSON.get(USER_LAST_NAME);
				Date dateOfBirth = ((Date)personJSON.get(USER_DOB));
				String phoneNumber = (String)personJSON.get(USER_PHONE_NUMBER);
				
				users.add(new User(id, firstName, lastName, dateOfBirth, phoneNumber));
            }
            return users;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Camp getCamp(){
        return null;
    }
    
}
