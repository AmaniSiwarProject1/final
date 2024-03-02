package Wedding.Planner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    static String EMAIL1;
    private static final String EMAIL = "Enter your Email please";
    private static final String PASS = "Enter your password please";
    private static String userType = "none";
    public static ArrayList<Users> UsersList = new ArrayList<>();
    public static ArrayList<Admin> AdminList = new ArrayList<>();
    public static ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<>();
    static Scanner input2 = new Scanner(System.in);
    static EventManagment eventManager = new EventManagment();

    public static void setUserType(String type) {
        userType = type;
    }

    public static String getUserType() {
        return userType;
    }

    public static Users fullInformationToSignUp() {
        System.out.println("Enter Your fullName:");
        String fullName = input2.next();
        System.out.println("Enter Your Email:");
        String Email = input2.next();
        System.out.println("Enter Your password:");
        String password = input2.next();
        return new Users(fullName, Email, password);
    }

    public static boolean showMenu(String type) {
        boolean flag = false;
        if (type.equals("User")) {
            flag = true;
            showMenuForUser();
        } else if (type.equals("Admin")) {
            flag = true;
            showMenuForAd();
        } else if (type.equals("Provider")) {
            flag = true;
            showMenuForSp();
        } else {
            flag = true;
            showMenuForNone();
        }
        return flag;
    }

    private static void showMenuForNone() {
        System.out.println("You are not a user in this system!");
        System.out.println("Please sign up as a new user or log in again");
        System.out.println("1. Enter to Sign Up");
        System.out.println("2. Enter to Log in");
        int num = input2.nextInt();
        input2.nextLine();
        if (num == 1) {
            signUp(fullInformationToSignUp());
            num = 2;
        }
        if (num == 2) {
            System.out.println(EMAIL);
            EMAIL1 = input2.next();
            System.out.println(PASS);
            String pass = input2.next();
            String userType = login(EMAIL1, pass);
            if (!userType.equals("None")) {
                System.out.println("Login successful!");
                showMenu(userType);
            } else {
                showMenuForNone(); 
            }
        }
    }

    private static void showMenuForSp() {
        // TODO: Add menu for service provider
    }

    private static void showMenuForAd() {
        EventManagment eventManager1 = new EventManagment();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Event");
            System.out.println("2. List All Events");
            System.out.println("3. Remove Events");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    eventManager1.addEvent();
                    break;

                case 2:
                    // TODO: Implement List All Events
                    break;

                case 3:
                    // TODO: Implement Remove Events
                    break;

                case 4:
                    running = false; // Exit the loop and return to the main menu
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }


    private static void showMenuForUser() {
        EventManagment eventManager1 = new EventManagment();

        boolean running = true;

        while (running) {
            System.out.println("------------------------------------------------");
            System.out.println("1. View Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Add Event");     
            System.out.println("4. Log out");
            System.out.println("------------------------------------------------");

            int num = input2.nextInt();
            input2.nextLine(); // Consume newline character

            switch (num) {
                case 1:
                    // TODO: View Profile
                    break;
                case 2:
                    // TODO: Edit Profile
                    break;
                case 3:
                    eventManager1.addEvent();
                    break;

                case 4:
                    // TODO: Log out
                    running = false; // Exit the loop and return to the main menu
                    break;

                default:
                    System.out.println("Invalid input. Please choose a number between 1 and 7.");
                    break;
            }
        }
    }

    public static String login(String email, String password) {
        for (Users user : UsersList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                setUserType("User");
                return "User";
            }
        }

        for (Admin admin : AdminList) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                setUserType("Admin");
                return "Admin";
            }
        }

        for (ServiceProvider provider : ServiceProviderList) {
            if (provider.getEmail().equals(email) && provider.getPassword().equals(password)) {
                setUserType("Provider");
                return "Provider";
            }
        }

        return "None";
    }

    public static boolean signUp(Users user) {
        UsersList.add(user);
        System.out.println("Done! You are now registered. Please log in.");
        return true;
    }

    public static void main(String[] args) {
        Users user1 = new Users("John Doe", "a@gmail.com", "password123");
        UsersList.add(user1);

        Admin admin1 = new Admin("Jane Doe", "si@example.com", "password456");
        AdminList.add(admin1);

        ServiceProvider provider1 = new ServiceProvider("Bob Smith", "siam@example.com", "password789", "Photography");
        ServiceProviderList.add(provider1);

        List<AddEvent> newEventsList = new ArrayList<>();

        newEventsList.add(new AddEvent("Bride1", "Groom1", "2024-05-20", "10:00 AM", 100, "Venue1", "Location1", "Phone1"));
        newEventsList.add(new AddEvent("Bride2", "Groom2", "2024-06-15", "11:30 AM", 150, "Venue2", "Location2", "Phone2"));
        newEventsList.add(new AddEvent("Bride3", "Groom3", "2024-07-10", "02:00 PM", 200, "Venue3", "Location3", "Phone3"));

        

        System.out.println("------------------------------------------------");
        System.out.println("1. Sign Up");
        System.out.println("2. Log in");
        System.out.println("3. Exit the program");
        System.out.println("------------------------------------------------");

        int num = input2.nextInt();
        if (num == 1) {
            signUp(fullInformationToSignUp());
        } else if (num == 2) {
            System.out.print(EMAIL);
            EMAIL1 = input2.next();
            System.out.print(PASS);
            String pass = input2.next();
            String userType = login(EMAIL1, pass);
            if (!userType.equals("None")) {
                System.out.println("Login successful!");
                showMenu(userType);
            } else {
                showMenuForNone();
            }
        } else if (num == 3) {
            System.out.println("Thanks for visiting the program.");
            System.exit(0);
        }
    }
}
