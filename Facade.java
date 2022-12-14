import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Facade 
{
    private Scanner in;
    private String[] userOptions = new String[4];
    private String[] guardianOptions = new String[4];
    private String[] counselorOptions = new String[4];
    private String[] directorOptions = new String[4];
    private ArrayList<Session> session;
    private ArrayList<String> registerChild;
    /*private ChildList childList = ChildList.getInstance();
    private UserList userList = UserList.getInstance();
    private CabinList cabinList = CabinList.getInstance();
    private Camp camp = DataReader.getCamps().get(0);*/


//Constructor adding in arrays of possible options between users
    public Facade(){
        in = new Scanner(System.in);
        userOptions[0] = "Log in as parent";
        userOptions[1] = "Log in as Counselor";
        userOptions[2] = "Log in as Director";
        userOptions[3] = "Logout";

        guardianOptions[0] = "Register Child";
        guardianOptions[1] = "View Camp Dates";
        guardianOptions[2] = "View Camp Duration";
        guardianOptions[3] = "Logout";

        counselorOptions[0] = "View Schedule";
        counselorOptions[1] = "Check Allergies";
        counselorOptions[2] = "Logout";
        counselorOptions[3] = "Logout";

        directorOptions[0] = "View User Profiles";
        directorOptions[1] = "Print Schedules";
        directorOptions[2] = "Logout";
        directorOptions[3] = "Logout";

    }
    //Code to run the driver that takes in all possible choices of user input
    //The values gChoice dChoice and cChoice relates to counselor director and guardian users
    //The system.out.println Holders are simply temporary print statements i added

    public void runDriver(){
        clear();
        System.out.println("Welcome to our Camp!");
        displayMenu();
            int choice = getNum();

            switch(choice){
                case 0:
                    userPass();
                    System.out.println("What would You like to do?");
                    for(int i = 0; i < guardianOptions.length; i++){
                        System.out.println((i+1) + ". " + guardianOptions[i]);
                    }
                    int gChoice = getNum();
                    if(gChoice == 0){
                        registerChild();
                    }
                    else if(gChoice == 1){
                        System.out.println("Holder View Camp dates");
                    }
                    else if(gChoice == 2){
                        System.out.println("Holder View Camp Duration");
                    }
                    break;
                case 1:
                    userPass();
                    System.out.println("What would you like to do?");
                    for(int i = 0; i < counselorOptions.length; i++){
                        System.out.println((i+1) + ". " + counselorOptions[i]);
                    }
                    int cChoice = getNum();
                    if(cChoice == 0){
                        System.out.println("Holder View Schedule");
                    }
                    else if(cChoice == 1){
                        System.out.println("Holder Check allergies");
                    }
                    break;
                case 2:
                    userPass();
                    System.out.println("What would you like to do?");
                    for(int i = 0; i < directorOptions.length; i++){
                        System.out.println((i+1) + ". " + directorOptions[i]);
                    }
                    int dChoice = getNum();
                    if(dChoice == 0){
                        System.out.println("Holder Director");
                    }
                    else if(dChoice == 1){
                        System.out.println("Holder Session");
                       // sessionSetUp();
                        
                    }
            }
    }
    //Allows User input on passwords and usernames
    public void userPass(){
        String userName;

        System.out.println("Enter UserName: ");
        userName = in.nextLine();
        System.out.println("UserName is:" + userName);
        clear();
    }

    //Keep All Guardian Methods together
    public void registerChild(){
        registerChild = new ArrayList<String>();

        while(in.hasNextLine()){
            String input = in.nextLine();

            if(input.equalsIgnoreCase("Done")){
                break;
            }
            registerChild.add(input);    
        }
    }

    



    //Keep all Director Methods together
    //Create Sessions for Director
/* 
    public void sessionSetUp(){
        session = camp.getSessions();
        
        System.out.println("Enter the theme for the session. Type 'Done' if you wish to cancel.");

        while(in.hasNextLine()){
            String input = in.nextLine();

            if(input.equalsIgnoreCase("Done")){
                break;
            }

            System.out.println("Enter the UUIDs for the cabins in this session. Type 'Done' when you are finished.");
            ArrayList<Cabin> sessionCabins = new ArrayList<Cabin>();
            while(in.hasNextLine())
            {
                String id = in.nextLine();

                if(id.equalsIgnoreCase("Done")){
                    break;
                }
                sessionCabins.add(cabinList.getCabin(UUID.fromString(input)));
            }
            session.add(new Session(input, sessionCabins));    
        }
        System.out.println(session);
    }
*/
    //Confused on how to take in session arraylist and randomly assign them to differen cabins.
    //Used to assign the sessions inputed by director user to random cabins
    public void cabinSchedule(){
        Random rand = new Random();
        for(int i =0; i<session.size();i++){
            int index = (int)(Math.random() * session.size());
        }
    }


    //Gets the number inputed by the user
    private int getNum(){
        int num;
        try{
            num = Integer.parseInt(in.nextLine())-1;
        } catch (Exception e) {
			clear();
			System.out.println("You need to enter a valid number\n");
			return -1;
		}
        clear();

        if (num < 0 || num > 4) {
			System.out.println("Oh no! You have chosen an invalid input.\n");
			return -1;
		}
        if(num == 4){
            System.exit(0);
        }
        return num;
    }

    //Displays the options from the UserOption array at the beginning of the run
    private void displayMenu(){
        System.out.println("What would you like to do?");
        for(int i = 0; i < userOptions.length; i++){
            System.out.println((i+1) + ". " + userOptions[i]);
        }
    }

    //Clears Program
    private void clear() {
		System.out.print("\033[H\033[2J"); 
	}






    public void addUser(String firstName, String lastName){
        
    }
    public void editUser(){}

    public void saveUser(){}

    public ArrayList<User> seeProfiles(){
        return null;
    }

    protected Contact getContact(){
        return null;
    }

    public void addChild(String name, ArrayList<String> allergies){}

    public Child getChild(String name){
        return null;
    }

    public ArrayList<String> getAllAllergies(){
        return null;
    }
    public boolean checkAllergies(String allergies){
        return false;
    }
    public String Medication(String type, String dose, String time){
        return time;
    }

    public void addToGroup(Child child){}

    public Child findChild(String name,int age){
        return null;
    }
    private Cabin availableSpace(int availabiliy){
        return null;
    }
    private int availableSessions(int sessions, int availability){
        return availability;
    }
    public String getSchedule(){
        return null;
    }

}
