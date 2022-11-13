import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffUserTest {
    private ArrayList<String> children;

    @BeforeEach
    public void everyTimeSetup()
    { 
        children.clear();
        children.add("allergy");
        
    }



    @Test
    public void checkAllergies(){
        boolean hasAllergy = children;
    }
}

