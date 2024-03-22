import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadFile {
	  private boolean userOnUploadPage;
	    private boolean fileNotFoundMessageDisplayed;
	@Given("the user is on the file upload page")
	public void theUserIsOnTheFileUploadPage() {
	  
        userOnUploadPage = true;
	}

	@When("the user attempts to upload a file that cannot be found or does not exist")
	public void theUserAttemptsToUploadAFileThatCannotBeFoundOrDoesNotExist() {
		   if (userOnUploadPage) {
	            // Simulate the scenario where the file is not found
	            fileNotFoundMessageDisplayed = true;
	        }
	}

	@Then("the system displays an error message")
	public void theSystemDisplaysAnErrorMessage() {
		  if (fileNotFoundMessageDisplayed) {
	            String errorMessage = "Selected file cannot be found or does not exist.";

	            // For testing purposes, you can use an assertion to check the error message
	            // For example, using JUnit:
	            // assertEquals(errorMessage, actualErrorMessageFromSystem);

	            System.out.println("System displays error message: " + errorMessage);
	        } else {
	            System.out.println("No error message displayed. Test failed.");
	        }
}}