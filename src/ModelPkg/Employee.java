package ModelPkg;

public class Employee
{
    // Attributes
    private int emp_id;
    private String last_name;
    private String first_name;
    private String mail_address;
    private String password;

    // Methods
    public Employee(int emp_id, String first_name, String last_name, String mail_address,
                    String password)
    {
        this.emp_id = emp_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.mail_address = mail_address;
        this.password = password;
    }

    // Getters
    public int getEmpID()
    {
        return (emp_id);
    }

    public String getFirstName()
    {
        return (first_name);
    }

    public String getLastName()
    {
        return (last_name);
    }

    public String getMailAddress()
    {
        return (mail_address);
    }

    public String getPassword()
    {
        return (password);
    }

    // Setters
    public void setEmpID(int emp_id)
    {
        this.emp_id = emp_id;
    }

    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    public void setMailAddress(String mail_address)
    {
        this.mail_address = mail_address;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
