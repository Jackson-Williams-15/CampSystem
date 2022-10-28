import java.util.ArrayList;
import java.util.Scanner;

public class CampDriver {
    private Scanner in;
    private String[] userOptions = new String[3];
    private String[] guardianOptions = new String[3];
    private String[] counselorOptions = new String[3];
    private String[] directorOptions = new String[3];
    private ArrayList<String> session;


//Constructor adding in arrays of possible options between users
    public CampDriver(){
        in = new Scanner(System.in);
        userOptions[0] = "Log in as parent";
        userOptions[1] = "Log in as Counselor";
        userOptions[2] = "Log in as Director";

        guardianOptions[0] = "Register Child";
        guardianOptions[1] = "View Camp Dates";
        guardianOptions[2] = "View Camp Duration";

        counselorOptions[0] = "View Schedule";
        counselorOptions[1] = "Check Allergies";
        counselorOptions[2] = "Logout";

        directorOptions[0] = "View User Profiles";
        directorOptions[1] = "Create Schedule";
        directorOptions[2] = "Logout";

    }
    //Code to run the driver that takes in all possible choices of user input
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
                        System.out.println("Holder Register child");
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
                        sessionSetUp();
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
                        System.out.println("You Have Successfully Logged Out.");
                        clear();
                    }
            }
    }
    //Allows User input on passwords and usernames
    public void userPass(){
        String userName;
        String password;

        System.out.println("Enter UserName: ");
        userName = in.nextLine();
        System.out.println("UserName is:" + userName);
        System.out.println("Enter Password: ");
        password = in.nextLine();
        System.out.println("Password is: " + password);
        clear();
    }

    //Create Sessions for Director
    public void sessionSetUp(){
        session = new ArrayList<String>();
        
        System.out.println("What Sessions do you wish to create?");
        System.out.println("Type 'Done' when you are finished creating your session.");

        String play = in.nextLine();
            while(in.hasNextLine()){
                session.add(in.nextLine());
            if(play.equalsIgnoreCase("Done")){
                System.out.println(session);     
            }
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

        if (num < 0 || num > 3) {
			System.out.println("Oh no! You have chosen an invalid input.\n");
			return -1;
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

    //Tests Program
    public static void main(String[] args){
        CampDriver driver = new CampDriver();
        driver.runDriver();
    }

}
