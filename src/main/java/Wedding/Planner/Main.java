package Wedding.Planner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static String EMAIL1;
	private static String userType = "none" ;
	public static ArrayList <Users> UsersList= new ArrayList<Users>();
	public static ArrayList <Admin> AdminList= new ArrayList<Admin>();
	public static ArrayList <ServiceProvider> ServiceProviderList= new ArrayList<ServiceProvider>();
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
        return  new Users(fullName, Email, password);
    }
    public static boolean showMenu(String type )  {
    	boolean flag=false;
    	if (type.equals("User"))
    	{flag= true; showMenuForUser();}
    	else     	if (type.equals("Admin"))
    	{flag= true;showMenuForAd();}
    	
    	else if (type.equals("Provider")) {flag= true;showMenuForSp();}
    	else 	{flag= true; showMenuForNone();}

return flag;
	
    	
    }
    private static void showMenuForNone() {
		// TODO Auto-generated method stub
		
	}
	private static void showMenuForSp() {
		// TODO Auto-generated method stub
		
	}
	private static void showMenuForAd() {
		// TODO Auto-generated method stub
		
	}
	private static void showMenuForUser() {
		// TODO Auto-generated method stub
	}
public static String login(String Email , String passWord) {
    	
    	
	Users UserNumber1 = new Users("AYAAWWAD","ayahazeem3@gmail.com","123");
	Users UserNumber2 = new Users("LARA","lara@example.com","456");
	Users UserNumber3 = new Users("batool","batool@example.com","789");
	Users UserNumber4 = new Users("2","2","2");
	UsersList.add(UserNumber1);
	UsersList.add(UserNumber2);
	UsersList.add(UserNumber3);
	UsersList.add(UserNumber4);

	    Admin AdminNumber1= new Admin("Bayan","Bayan@example.com","1122");
    	AdminList.add(AdminNumber1);
    	Admin AdminNumber11 = new Admin("1","1","1");
    	AdminList.add(AdminNumber11);


    	ServiceProvider serviceproviderNumber1 = new ServiceProvider("Marwa","s12043062@stu.najah.edu","3344","0599689793");
    	ServiceProviderList.add(serviceproviderNumber1);
    	ServiceProvider serviceproviderNumber2 = new ServiceProvider("3","3","3","3");
    	ServiceProviderList.add(serviceproviderNumber2);

    	
    	
    	
for (Users user : UsersList) {
			
			if ((user.getEmail() .equals(Email))&&(user.getpassword().equals(passWord))) {
				
					setUserType("User");
				}
			
					
			}

for (Admin Admin : AdminList) {
	
	if ((Admin.getEmail() .equals(Email))&&(Admin.getpassword().equals(passWord))) {
		
			setUserType("Admin");
		}
	
			
	}
for (ServiceProvider provider:  ServiceProviderList) {
	
	if ((provider.getEmail() .equals(Email))&&(provider.getpassword().equals(passWord))) {
		
			setUserType("Provider");
		}
	
			
	}
		return getUserType();  

    }
public static boolean signup(Users U) {
	
	UsersList.add(U);
	
	System.out.println("done ! you are user please log in ");
	
	

	return true;
	
}
	
	public static void main(String[] args)  {
        System.out.println("------------------------------------------------");
        System.out.println("1. Sign Up");
        System.out.println("2. Log in");
        System.out.println("3. Exit the program");
        System.out.println("------------------------------------------------");

        int num = input2.nextInt();
        if (num == 1) {
            signUp(fullInformationToSignUp());
        }
        else if (num == 2) {
            System.out.print("Enter your email: ");
            String email = input2.next();
            System.out.print("Enter your password: ");
            String pass = input2.next();
            logIn(email, pass);
        }
        else if (num == 3) {
            System.out.println("Thanks for visiting the program.");
            System.exit(0);
        }
    }

    public static void signUp(Users user) {
        System.out.println("User signed up successfully!");
    }

    public static void logIn(String email, String password) {
        System.out.println("User logged in successfully!");
    }
}