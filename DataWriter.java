import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    public void saveAllUsers(){
        UserList user = UserList.getInstance();
		ArrayList<UserList> users = user.getUser();
		JSONArray jsonUser = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUser.add(getUserJSON(users.get(i)));
		}

    }
    
    public boolean saveCamp(){
        return false;
    }
}
