package ModelPkg;

public class Appointment {
    // Attributes
    private int appointment_id;
    private String address;
    private String date;
    private String hour;
    private Integer rating;
    private int doctor_id;
    private Integer client_id; // client_id can be null, so we use "Integer" instead of "int"


    // Methods
    public Appointment(int appointment_id, String address, String date, String hour,
                       Integer rating, int doctor_id, Integer client_id)
    {
        this.appointment_id = appointment_id;
        this.address = address;
        this.date = date;
        this.hour = hour;
        this.rating = rating;
        this.doctor_id = doctor_id;
        this.client_id = client_id;
    }

    // Getters
    public int getAppointmentId()
    {
        return (appointment_id);
    }

    public String getAddress()
    {
        return (address);
    }

    public String getDate()
    {
        return (date);
    }

    public String getHour()
    {
        return (hour);
    }

    public Integer getRating()
    {
        return (rating);
    }

    public int getDoctorId()
    {
        return (doctor_id);
    }

    public Integer getClientId()
    {
        return (client_id);
    }

    // Setters
    public void setAppointmentId(int appointment_id)
    {
        this.appointment_id = appointment_id;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setHour(String hour)
    {
        this.hour = hour;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }

    public void setDoctorId(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }

    public void setClientId(Integer client_id)
    {
        this.client_id = client_id;
    }
}