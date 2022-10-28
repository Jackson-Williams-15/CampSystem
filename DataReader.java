import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataReader extends DataConstants {
    public ArrayList<User> getAllUsers() {
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
                String email = (String)personJSON.get(USER_EMAIL);
                String password = (String)personJSON.get(USER_PASSWORD);
				Date dateOfBirth = ((Date)personJSON.get(USER_DOB));
				int phoneNumber = (int)personJSON.get(USER_PHONE_NUMBER);
				
				users.add(new User(firstName, lastName, phoneNumber, email, password, dateOfBirth));
            }
            return users;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Child> getChildren() {
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

				children.add(new Child(firstName, lastName, dateOfBirth, id));
            }
            return children;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Cabin> getCabins() {
        ArrayList<Cabin> cabins = new ArrayList<Cabin>();

        try {

            FileReader reader = new FileReader(CABIN_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				UUID id = UUID.fromString((String)personJSON.get(CABIN_ID));
				String name = (String)personJSON.get(CABIN_NAME);

				cabins.add(new Cabin(name, id));
            }
            return cabins;

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
