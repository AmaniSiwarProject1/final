import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Wedding.Planner.Main;
import Wedding.Planner.Users;

public class SignUp {
	@Given("infomation about user.")
	public void infomationAboutUser() {
		assertTrue(true);	  
	}

	@When("user request to sign up.")
	public void userRequestToSignUp() {
		assertTrue(true);
	}

	@Then("the user added to customer list and will apper log in screen")
	public void theUserAddedToCustomerListAndWillApperLogInScreen() {
	Users u= new Users("amaniodeh225@gmail.com","Amani Odeh","123456");
	assertTrue(Main.signUp(u));

	}



}
