package Wedding.Planner;
import java.util.*;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.List;

import Wedding.Planner.EventManagement.VenueEditor;

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
    public static EventManagement eventManager = new EventManagement();
    private static final Logger logger = Logger.getLogger(EventManagement.class.getName());

    public static void setUserType(String type) {
        userType = type;
    }

    public static String getUserType() {
        return userType;
    }

    public static Users fullInformationToSignUp() {
    	logger.info("Enter Your fullName:");
        String fullName = input2.next();
        logger.info("Enter Your Email:");
        String Email = input2.next();
        logger.info("Enter Your password:");
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
    	logger.info("You are not a user in this system!");
    	logger.info("Please sign up as a new user or log in again");
    	logger.info("1. Enter to Sign Up");
    	logger.info("2. Enter to Log in");
        int num = input2.nextInt();
        input2.nextLine();
        if (num == 1) {
            signUp(fullInformationToSignUp());
            num = 2;
        }
        if (num == 2) {
            System.out.println(EMAIL);
            EMAIL1 = input2.next();
            logger.info(PASS);
            String pass = input2.next();
            String userType = login(EMAIL1, pass);
            if (!userType.equals("None")) {
            	logger.info("Login successful!");
                showMenu(userType);
            } else {
                showMenuForNone(); 
            }
        }
    }

    private static void showMenuForSp() {
    	EventManagement eventManager1 = new EventManagement();
    	VenueEditor venueEditor = eventManager.new VenueEditor();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
        	logger.info("1. Add Event");
        	logger.info("2. List All Events");
        	logger.info("3. Update Events");
        	logger.info("4. Delete Events");
        	logger.info("5. Add Venue");
        	logger.info("6. calanderSuperProvider");
        	logger.info("7. Edit Venue");
        	logger.info("8. Delete Venue");
        	logger.info("9. Add Photo or Vedio: ");
        	logger.info("10. Exit");
        	logger.info("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 

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
                    	logger.info("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                        String eventDate = scanner.nextLine();
                        logger.info("Enter the time of the event you want to delete (hh:mm a): ");
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
                    	logger.info("Enter the name of the venue you want to edit: ");
                         String venueNameToEdit = scanner.nextLine();
                         
                         venueEditor.editVenue(venueNameToEdit);
                         break;                
                         case 8:
                        eventManager.deleteVenue();

                        break;
                         case 9:
                        	  eventManager.Photo();
                             break;

                    case 10:
                      
                    	logger.info("Thanks for visiting the program.");
                        System.exit(0);
                        break;
                    default:
                    	
                    	logger.info("Invalid choice. Please enter a number between 1 and 10.");
                        break;
                }
            } catch (InputMismatchException e) {
            	logger.info("Invalid input. Please enter a valid number.");
                scanner.nextLine(); 
                continue;
            }

        }

    }

    	
    

 private static void showMenuForAd() {
	 EventManagement eventManager1 = new EventManagement();
	VenueEditor venueEditor = eventManager.new VenueEditor();
    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {
    	logger.info("1. Add Event");
    	logger.info("2. List All Events");
    	logger.info("3. Update Events");
    	logger.info("4. Delete Events");
    	logger.info("5. Venue Mach");
    	logger.info("6. Add Venue");
    	logger.info("7. Calender for user");
    	logger.info("8. Calender for Admin");
    	logger.info("9. calanderSuperProvider");
    	logger.info("10. Edit Venue");
    	logger.info("11. Delete Venue");
    	logger.info("12. Add Photo or Vedio: ");
    	logger.info("13. Exit");
    	logger.info("Enter your choice: ");

        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();

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
                	logger.info("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                    String eventDate = scanner.nextLine();
                    logger.info("Enter the time of the event you want to delete (hh:mm a): ");
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
                	logger.info("Enter the name of the venue you want to edit: ");
                     String venueNameToEdit = scanner.nextLine();
                     
                     venueEditor.editVenue(venueNameToEdit);
                     break;                
                     case 11:
                    eventManager.deleteVenue();

                    break;
                     case 12:
                    	  eventManager.Photo();
                         break;

                case 13:
                  
                	logger.info("Thanks for visiting the program.");
                    System.exit(0);
                    break;
                default:
                	
                	logger.info("Invalid choice. Please enter a number between 1 and 10.");
                    break;
            }
        } catch (InputMismatchException e) {
        	logger.info("Invalid input. Please enter a valid number.");
            scanner.nextLine(); 
            continue;
        }

    }

}

    private static void showMenuForUser() {
    	EventManagement eventManager1 = new EventManagement();

        boolean running = true;

        while (running) {
        	logger.info("------------------------------------------------");
        	logger.info("1. View Profile");
        	logger.info("2. Edit Profile");
        	logger.info("3. Add Event");     
        	logger.info("4. Delete Event");  
        	logger.info("5. Update Event ");
        	logger.info("6. Add a venue based on your budget");
        	logger.info("7. Calender");
        	logger.info("8. Add Photo or Vedio: ");
        	logger.info("9. Log out");

        	logger.info("------------------------------------------------");
            Scanner scanner = new Scanner(System.in);
            int num = input2.nextInt();
            input2.nextLine(); 
            
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                	 eventManager1.addEvent();
                     break;
               case 4:
            	   logger.info("Enter the date of the event you want to delete (yyyy-MM-dd): ");
                   String eventDate = scanner.nextLine();
                   logger.info("Enter the time of the event you want to delete (hh:mm a): ");
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
                	logger.info("Thanks for visiting the program.");
                    System.exit(0);
                    break;

                default:
                	logger.info("Invalid input. Please choose a number between 1 and 7.");
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

        

        logger.info("------------------------------------------------");
        logger.info("1. Sign Up");
        logger.info("2. Log in");
        logger.info("3. Exit the program");
        logger.info("------------------------------------------------");

        int num = input2.nextInt();
        if (num == 1) {
            signUp(fullInformationToSignUp());
        } else if (num == 2) {
        	logger.info(EMAIL);
            EMAIL1 = input2.next();
            logger.info(PASS);
            String pass = input2.next();
            String userType = login(EMAIL1, pass);
            if (!userType.equals("None")) {
            	logger.info("Login successful!");
                showMenu(userType);
            } else {
                showMenuForNone();
            }
        } else if (num == 3) {
        	logger.info("Thanks for visiting the program.");
            System.exit(0);
        }
    }
}
