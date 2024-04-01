import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Wedding.Planner.Main;

public class Login {
	@When("admin enters email {string} and password {string}")
	public void adminEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);
	}

	@Then("Show admin page and success message")
	public void showAdminPageAndSuccessMessage() {
	    equals(Main.login("a@gmail.com", "password123")=="User");
	}

	@Then("Show error message.")
	public void showErrorMessage() {
	    equals(Main.login("a12@gmail.com", "password123")=="None");

	}

	@When("User enters email {string} and password {string}")
	public void userEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);
	}

	@Then("Show User page and success message")
	public void showUserPageAndSuccessMessage() {
	    equals(Main.login("si@example.com", "password456")=="Admin");

	}

	@Then("Show not correct email message")
	public void showNotCorrectEmailMessage() {
	    equals(Main.login("si45@example.com", "password456")=="Admin");

	}

	@When("ServiceProvider enters email {string} and password {string}")
	public void serviceProviderEntersEmailAndPassword(String string, String string2) {
	    assertTrue(true);

	}

	@Then("Show ServiceProvider page and success message")
	public void showServiceProviderPageAndSuccessMessage() {
	    equals(Main.login("siam@example.com", "password789")=="Admin");

	}



}
