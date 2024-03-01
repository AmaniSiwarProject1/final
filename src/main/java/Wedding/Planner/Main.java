package Wedding.Planner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String EMAIL1;
    private static final String EMAIL = "Enter your Email please";
    private static final String PASS = "Enter your password please";
    private static String userType = "none";
    public static ArrayList<Users> UsersList = new ArrayList<>();
    public static ArrayList<Admin> AdminList = new ArrayList<>();
    public static ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<>();

    public static void setUserType(String type) {
        userType = type;
    }

    public static String getUserType() {
        return userType;
    }

    static Scanner input2 = new Scanner(System.in);

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
        if (num == 1) {
            signUp(fullInformationToSignUp());
            num = 2;
        }
        if (num == 2) {
            System.out.println(EMAIL);
            EMAIL1 = input2.next();
            System.out.println(PASS);
            String pass = input2.next();
            if (login(EMAIL1, pass)) {
                System.out.println("Login successful!");
                showMenu(getUserType());
            } else {
                showMenuForNone(); 
            }
        }
    }

    private static void showMenuForSp() {
        // TODO: Add menu for service provider
    }

    private static void showMenuForAd() {
        // TODO: Add menu for admin
    }

    private static void showMenuForUser() {
        System.out.println("------------------------------------------------");
        System.out.println("1. View Profile");
        System.out.println("2. Edit Profile");
        System.out.println("3. Search for Services");
        System.out.println("4. Book a Service");
        System.out.println("5. View My Bookings");
        System.out.println("6. Log out");
        System.out.println("------------------------------------------------");

        int num = input2.nextInt();
        switch (num) {
            case 1:
                // TODO: View Profile
                break;
            case 2:
                // TODO: Edit Profile
                break;
            case 3:
                // TODO: Search for Services
                break;
            case 4:
                // TODO: Book a Service
                break;
            case 5:
                // TODO: View My Bookings
                break;
            case 6:
                // TODO: Log out
                break;
            default:
                System.out.println("Invalid input. Please choose a number between 1 and 6.");
                break;
        }
    }

    public static boolean login(String email, String password) {
        for (Users user : UsersList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                setUserType("User");
                return true;
            }
        }

        for (Admin admin : AdminList) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                setUserType("Admin");
                return true;
            }
        }

        for (ServiceProvider provider : ServiceProviderList) {
            if (provider.getEmail().equals(email) && provider.getPassword().equals(password)) {
                setUserType("Provider");
                return true;
            }
        }

        return false;
    }

    public static boolean signUp(Users user) {
        UsersList.add(user);
        System.out.println("Done! You are now registered. Please log in.");
        return true;
    }

    public static void main(String[] args) {
        Users user1 = new Users("John Doe", "johndoe1@example.com", "password123");
        UsersList.add(user1);

        Admin admin1 = new Admin("Jane Doe", "janedoe@example.com", "password456");
        AdminList.add(admin1);

        ServiceProvider provider1 = new ServiceProvider("Bob Smith", "bobsmith@example.com", "password789", "Photography");
        ServiceProviderList.add(provider1);

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
            if (login(EMAIL1, pass)) {
                System.out.println("Login successful!");
                showMenu(getUserType());
            } else {
                showMenuForNone();
            }
        } else if (num == 3) {
            System.out.println("Thanks for visiting the program.");
            System.exit(0);
        }
    }
}
