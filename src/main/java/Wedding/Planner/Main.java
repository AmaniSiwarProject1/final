package Wedding.Planner;
import java.util.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.List;

import Wedding.Planner.EventManagment.VenueEditor;

public class Main {
    static List<AddEvent> newEventsList = new ArrayList<>();

    static String EMAIL1;
    private static final String EMAIL = "Enter your Email please";
    private static final String PASS = "Enter your password please";
    private static String userType = "none";
    public static ArrayList<Users> UsersList = new ArrayList<>();
    public static ArrayList<Admin> AdminList = new ArrayList<>();
    public static ArrayList<ServiceProvider> ServiceProviderList = new ArrayList<>();
    static Scanner input2 = new Scanner(System.in);
    public static EventManagment eventManager = new EventManagment();

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
    	 EventManagment eventManager1 = new EventManagment();
    	 VenueEditor venueEditor = eventManager.new VenueEditor();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Event");
            System.out.println("2. List All Events");
            System.out.println("3. Update Events");
            System.out.println("4. Delete Events");
            System.out.println("5. Add Venue");
            System.out.println("6. calanderSuperProvider");
            System.out.println("7. Edit Venue");
            System.out.println("8. Delete Venue");
            System.out.println("9. Add Photo or Vedio: ");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        eventManager1.addEvent();
                        break;

                    case 2:
                        eventManager1.listAllEvents();
                        break;

                    case 3:
                        eventManager1.updateEvent(newEventsList);
                        break;

                    case 4:
                        System.out.println("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                        String eventDate = scanner.nextLine();
                        System.out.println("Enter the time of the event you want to delete (hh:mm a): ");
                        String eventTime = scanner.nextLine();
                        eventManager1.deleteEvent(eventDate, eventTime);
                        break;

                  

                    case 5:
                        eventManager1.AddnewVenue();
                        break;

                  

                

                    case 6:
                        eventManager.calanderSuperProvider();
                        break;
                    case 7:
                    	 System.out.println("Enter the name of the venue you want to edit: ");
                         String venueNameToEdit = scanner.nextLine();
                         
                         // استدعاء الدالة editVenue من كائن VenueEditor
                         venueEditor.editVenue(venueNameToEdit);
                         break;                
                         case 8:
                        eventManager.deleteVenue();

                        break;
                         case 9:
                        	  eventManager.Photo();
                             break;

                    case 10:
                      
                        System.out.println("Thanks for visiting the program.");
                        System.exit(0);
                        break;
                    default:
                    	
                        System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

        }

    }

    	
    

 private static void showMenuForAd() {
	 EventManagment eventManager1 = new EventManagment();
	 VenueEditor venueEditor = eventManager.new VenueEditor();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
        System.out.println("1. Add Event");
        System.out.println("2. List All Events");
        System.out.println("3. Update Events");
        System.out.println("4. Delete Events");
        System.out.println("5. Venue Mach");
        System.out.println("6. Add Venue");
        System.out.println("7. Calender for user");
        System.out.println("8. Calender for Admin");
        System.out.println("9. calanderSuperProvider");
        System.out.println("10. Edit Venue");
        System.out.println("11. Delete Venue");
        System.out.println("12. Add Photo or Vedio: ");
        System.out.println("13. Exit");
        System.out.print("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    eventManager1.addEvent();
                    break;

                case 2:
                    eventManager1.listAllEvents();
                    break;

                case 3:
                    eventManager1.updateEvent(newEventsList);
                    break;

                case 4:
                    System.out.println("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                    String eventDate = scanner.nextLine();
                    System.out.println("Enter the time of the event you want to delete (hh:mm a): ");
                    String eventTime = scanner.nextLine();
                    eventManager1.deleteEvent(eventDate, eventTime);
                    break;

                case 5:
                    eventManager1.Venueadd();
                    break;

                case 6:
                    eventManager1.AddnewVenue();
                    break;

                case 7:
                    eventManager.Calander1();
                    break;

                case 8:
                    eventManager.calander2();
                    break;

                case 9:
                    eventManager.calanderSuperProvider();
                    break;
                case 10:
                	 System.out.println("Enter the name of the venue you want to edit: ");
                     String venueNameToEdit = scanner.nextLine();
                     
                     // استدعاء الدالة editVenue من كائن VenueEditor
                     venueEditor.editVenue(venueNameToEdit);
                     break;                
                     case 11:
                    eventManager.deleteVenue();

                    break;
                     case 12:
                    	  eventManager.Photo();
                         break;

                case 13:
                  
                    System.out.println("Thanks for visiting the program.");
                    System.exit(0);
                    break;
                default:
                	
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Consume the invalid input
            continue;
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
            System.out.println("4. Delete Event");  
            System.out.println("5. Update Event ");
            System.out.println("6. Add a venue based on your budget");
            System.out.println("7. Calender");
            System.out.println("8. Add Photo or Vedio: ");
            System.out.println("9. Log out");

            System.out.println("------------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            int num = input2.nextInt();
            input2.nextLine(); 
            
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
            	   System.out.println("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                   String eventDate = scanner.nextLine();
                   System.out.println("Enter the time of the event you want to delete (hh:mm a): ");
                   String eventTime = scanner.nextLine();
                   eventManager1.deleteEvent(eventDate, eventTime);
                   break;
                      
                case 5:
                	eventManager1.updateEvent(newEventsList);

                    break;

                case 6:
                	 eventManager1.Venueadd();

                    break;
                case 7:
                	eventManager.calander2();
                	break;
                case 8:
                	 eventManager.Photo();
                     break;
                case 9:
                	System.out.println("Thanks for visiting the program.");
                    System.exit(0);
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

        newEventsList.add(new AddEvent("Bride1", "Groom1", "2024-05-20", "10:00 AM", 100, "Venue1", "Location1", "Phone1","2500"));
        newEventsList.add(new AddEvent("Bride2", "Groom2", "2024-06-15", "11:30 AM", 150, "Venue2", "Location2", "Phone2","2500"));
        newEventsList.add(new AddEvent("Bride3", "Groom3", "2024-07-10", "02:00 PM", 200, "Venue3", "Location3", "Phone3","4000"));

        

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
