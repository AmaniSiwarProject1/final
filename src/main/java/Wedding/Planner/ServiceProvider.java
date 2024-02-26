package Wedding.Planner;

public class ServiceProvider {
	 private String fullname;
	    private String password;
	    private String email;
	    private String phone;

	    public ServiceProvider(String email,String fullname, String password,String phone) {
	        this.fullname = fullname;
	        this.password = password;
	        this.email=email;
	        this.phone=phone;

}
	    
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getpassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getfullname() {
	        return fullname;
	    }
	    public void setfullname(String fullname) {
	        this.fullname = fullname;
	    }  
	    public String getphone() {
	        return phone;
	    }}