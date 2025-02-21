package ModelPkg;

public class Doctor {
    // Attributes
    private int doctor_id;
    private String first_name;
    private String last_name;
    private String email_address;
    private String specialities;
    private Float average_rating;

    public Doctor(int doctor_id, String first_name, String last_name,
                  String email_address, String specialities, Float average_rating)
    {
        this.doctor_id = doctor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_address = email_address;
        this.specialities = specialities;
        this.average_rating = average_rating;
    }

    // Getters
    public int getDoctorId()
    {
        return (doctor_id);
    }

    public String getFirstName()
    {
        return (first_name);
    }

    public String getLastName()
    {
        return (last_name);
    }

    public String getEmailAddress()
    {
        return (email_address);
    }

    public String getSpecialities()
    {
        return (specialities);
    }

    public float getAverageRating()
    {
        return (average_rating);
    }

    // Setters
    public void setDoctorId(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    public void setEmailAddress(String email_address)
    {
        this.email_address = email_address;
    }

    public void setSpecialities(String specialities)
    {
        this.specialities = specialities;
    }

    public void setAverageRating(float average_rating)
    {
        this.average_rating = average_rating;
    }
}