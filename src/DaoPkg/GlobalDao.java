package DaoPkg;

public class GlobalDao {
    private static final AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
    private static final ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
    private static final DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
    private static final EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

    /**
     * Retourne AppointmentDaoImpl
     * @return appointmentDaoImpl
     */
    public static AppointmentDaoImpl getAppointmentDaoImpl()
    {
        return (appointmentDaoImpl);
    }

    /**
     * Retourne ClientDaoImpl
     * @return clientDaoImpl
     */
    public static ClientDaoImpl getClientDaoImpl()
    {
        return (clientDaoImpl);
    }

    /**
     * Retourne DoctorDaoImpl
     * @return doctorDaoImpl
     */
    public static DoctorDaoImpl getDoctorDaoImpl()
    {
        return (doctorDaoImpl);
    }

    /**
     * Retourne EmployeeDaoImpl
     * @return employeeDaoImpl
     */
    public static EmployeeDaoImpl getEmployeeDaoImpl()
    {
        return (employeeDaoImpl);
    }
}