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
	            fileNotFoundMessageDisplayed = true;
	        }
	}

	@Then("the system displays an error message")
	public void theSystemDisplaysAnErrorMessage() {
		  if (fileNotFoundMessageDisplayed) {
	            String errorMessage = "Selected file cannot be found or does not exist.";

	          

	            System.out.println("System displays error message: " + errorMessage);
	        } else {
	            System.out.println("No error message displayed. Test failed.");
	        }
}
	 private boolean fileUploadSuccessful;
	@When("the user selects a file to upload and the file meets the upload requirements")
	public void theUserSelectsAFileToUploadAndTheFileMeetsTheUploadRequirements() {
		 if (userOnUploadPage) {
	            
	            fileUploadSuccessful = true;
	        }
	}

	@Then("the system confirms successful file upload")
	public void theSystemConfirmsSuccessfulFileUpload() {
		if (fileUploadSuccessful) {
            String successMessage = "File uploaded successfully.";

            
            System.out.println("System confirms: " + successMessage);
        } else {
            System.out.println("File upload failed.");
        }
	}




}