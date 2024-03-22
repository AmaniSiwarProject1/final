Feature: UploadFile


Scenario: User Uploads Unfindable File
  Given the user is on the file upload page
  When the user attempts to upload a file that cannot be found or does not exist
  Then the system displays an error message
   
   
   
   Scenario: User Successfully Uploads a File
  Given the user is on the file upload page
  When the user selects a file to upload and the file meets the upload requirements
  Then the system confirms successful file upload