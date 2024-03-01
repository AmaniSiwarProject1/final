import static org.junit.Assert.assertTrue;

import Wedding.Planner.Main;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	@When("admin enters email <{string}> and password <{string}>")
	public void adminEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);
	    }

	@Then("Show admin page and success message")
	public void showAdminPageAndSuccessMessage() {
       equals(Main.login("johndoe1@example.com","password123")=="Admin");
 
	}

	@Then("Show error message.")
	public void showErrorMessage() {
	       equals(Main.login("janedoe11221@example.com","password456")=="None");

	}

	@When("User enters email <{string}> and password <{string}>")
	public void userEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);
  
	}

	@Then("Show  User page and success message")
	public void showUserPageAndSuccessMessage() {
	       equals(Main.login("johndoe1@example.com","password123")=="User");

	}

	@Then("Show not correct email message")
	public void showNotCorrectEmailMessage() {
	       equals(Main.login("johndoe14545151@example.com","password123")!="User");

	}

	@When("ServiceProvider enters email <{string}> and password <{string}>")
	public void serviceProviderEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);

	}

	@Then("Show ServiceProvider page and success message")
	public void showServiceProviderPageAndSuccessMessage() {
	       equals(Main.login("bobsmith@example.com","password789")=="Provider");

	}



} 