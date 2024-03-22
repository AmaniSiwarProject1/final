Feature: UploadFile


Scenario: User Uploads Unfindable File
  Given the user is on the file upload page
  When the user attempts to upload a file that cannot be found or does not exist
  Then the system displays an error message