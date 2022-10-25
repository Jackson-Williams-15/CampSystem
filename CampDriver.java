import java.util.Scanner;

public class CampDriver {
    private Scanner in;
    private String[] userOptions = new String[2];
    private String[] parentOptions = new String[2];
    private String[] counselorOptions = new String[2];
    private String[] directorOptions = new String[2];



    public CampDriver(){
        in = new Scanner(System.in);
        userOptions[0] = "1. Log in as parent";
        userOptions[1] = "2. Log in as Counselor";
        userOptions[2] = "3. Log in as Director";

        parentOptions[0] = "1. Register Child";
        parentOptions[1] = "2. View Camp Dates";
        parentOptions[2] = "3. View Camp Duration";

        counselorOptions[0] = "1. Register Child";
        counselorOptions[1] = "2. View Camp Dates";
        counselorOptions[2] = "3. View Camp Duration";

        directorOptions[0] = "1. Register Child";
        directorOptions[1] = "2. View Camp Dates";
        directorOptions[2] = "3. View Camp Duration";

    }
    public void runDriver(){
        clear();
        System.out.println("Welcome to our Camp!");
    }

    private int getNum(){
        int num;
        try{
            num = Integer.parseInt(in.nextLine()) - 1;
        } catch (Exception e) {
			clear();
			System.out.println("You need to enter a valid number\n");
			return -1;
		}
        clear();

        if (num < 0 || num > 3) {
			System.out.println("Sorry, your option is not in the valid range.\n");
			return -1;
		}
        return num;
    }
    private void displayMenu(){
        System.out.println("What would you like to do?");
        for(int i = 0; i < userOptions.length; i++){
            System.out.println(userOptions[i]);
        }
    }

    private void clear() {
		System.out.print("\033[H\033[2J");
	}
    public static void main(String[] args){
        CampDriver driver = new CampDriver();
        driver.runDriver();
    }

}
