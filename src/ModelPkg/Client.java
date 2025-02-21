package ModelPkg;

public class Client {
    // Attributes
    private int client_id;
    private String first_name;
    private String last_name;
    private String dateOfBirth;
    private String email_address;
    private String password;

    // Methods
    public Client(int client_id, String first_name, String last_name, String dateOfBirth,
                  String email_address, String password)
    {
        this.client_id = client_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dateOfBirth = dateOfBirth;
        this.email_address = email_address;
        this.password = password;
    }

    // Getters
    public int getClientId()
    {
        return (client_id);
    }

    public String getFirstName()
    {
        return (first_name);
    }

    public String getLastName()
    {
        return (last_name);
    }

    public String getDateOfBirth()
    {
        return (dateOfBirth);
    }

    public String getEmailAddress()
    {
        return (email_address);
    }

    public String getPassword()
    {
        return (password);
    }

    //Setters
    public void setClientId(int client_id)
    {
        this.client_id = client_id;
    }

    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public void setMailAddress(String email_address)
    {
        this.email_address = email_address;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
