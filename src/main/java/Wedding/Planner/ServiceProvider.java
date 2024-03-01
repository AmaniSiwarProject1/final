package Wedding.Planner;

public class ServiceProvider {
    private String fullName;
    private String email;
    private String password;
    private String serviceType;

    public ServiceProvider(String fullName, String email, String password, String serviceType) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.serviceType = serviceType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
