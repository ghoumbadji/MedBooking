package DaoPkg;

import ModelPkg.Appointment;

import java.sql.*;
import java.util.ArrayList;

public class AppointmentDaoImpl implements AppointmentDao {
    // Attributes
    final Connection conn;

    // Methods

    /**
     * Se connecte à la bdd
     */
    public AppointmentDaoImpl() {
        DataSource ds = new DataSource();

        // Connection to the database
        ds.connect();
        conn = ds.getConnection();
    }

    /**
     * Vérifie si le rendez-vous exise déjà
     * @param appointment
     * @return true si appointment existe, false sinon
     */
    public Boolean checkIfAppointmentExists(Appointment appointment) {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;

        try {
            // We consider the same doctor can't have two or more appointments at a
            // specific date at the same hour
            query = "SELECT * FROM `appointment` "
                    + "WHERE `date` = ? AND `hour` = ? AND `doctor_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, appointment.getDate());
            prepStmt.setString(2, appointment.getHour());
            prepStmt.setInt(3, appointment.getDoctorId());
            rs = prepStmt.executeQuery();
            return (rs.next());
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (null);
    }

    /**
     * Ajoute un rendez-vous
     * @param appointment
     */
    public void addAppointment(Appointment appointment) {
        // Variables
        String query;
        PreparedStatement prepStmt;

        // Operations
        try {
            // appointment_id is automatically set and client_id is null by default
            query = "INSERT INTO `appointment` (`address`, `date`, `hour`, `doctor_id`) "
                    + "VALUES (?, ?, ?, ?)";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, appointment.getAddress());
            prepStmt.setString(2, appointment.getDate());
            prepStmt.setString(3, appointment.getHour());
            prepStmt.setInt(4, appointment.getDoctorId());
            prepStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    /**
     * Permet d'obtenir tous les rendez-vous d'un client
     * @param client_id
     * @return appointments
     */
    public ArrayList<Appointment> getAppointmentsByClient(int client_id)
    {
        // Variables
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        Appointment appointment;

        // Operations
        try {
            query = "SELECT * FROM `appointment` "
                    + "WHERE `client_id` = ? "
                    + "ORDER BY `date`, `hour`";
            ;
            prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, client_id);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                appointment = new Appointment(rs.getInt("appointment_id"),
                        rs.getString("address"), rs.getString("date"),
                        rs.getString("hour"), rs.getInt("rating"),
                        rs.getInt("doctor_id"), rs.getInt("client_id"));
                appointments.add(appointment);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (appointments);
    }

    /**
     * Permet d'obtenir tous les rendez-vous dans la table des rdv
     * @param
     * @return appointments
     */
    @Override
    public ArrayList<Appointment> getAppointmentList()
    {
        // Variables
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        Appointment appointment;

        // Operations
        try {
            query = "SELECT * FROM `appointment`";
            prepStmt = conn.prepareStatement(query);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                appointment = new Appointment(rs.getInt("appointment_id"),
                        rs.getString("address"), rs.getString("date"),
                        rs.getString("hour"), rs.getInt("rating"),
                        rs.getInt("doctor_id"), rs.getInt("client_id"));
                appointments.add(appointment);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (appointments);
    }


    /**
     * Mets à jour un rendez-vous
     * @param appointment_id
     * @param appointment
     */
    public void updateAppointment(int appointment_id, Appointment appointment) {
        // Variables
        String query;
        PreparedStatement prepStmt;

        // Operations
        try {
            // The column appointment_id is not updated, just the other information (date, etc.)
            query = "UPDATE `appointment` "
                    + "SET `address` = ? , `date` = ?, `hour` = ?, `rating` = ?, "
                    + "`doctor_id` = ?, `client_id` = ? "
                    + "WHERE `appointment_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, appointment.getAddress());
            prepStmt.setString(2, appointment.getDate());
            prepStmt.setString(3, appointment.getHour());

            if (appointment.getRating() == null) {
                prepStmt.setNull(4, Types.NULL);
            }
            else {
                prepStmt.setInt(4, appointment.getRating());
            }

            prepStmt.setInt(5, appointment.getDoctorId());
            if (appointment.getClientId() == null) {
                prepStmt.setNull(6, Types.NULL);
            }
            else {
                prepStmt.setInt(6, appointment.getClientId());
            }
            prepStmt.setInt(7, appointment_id);
            prepStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    /**
     * Suprrime un rendez-vous
     * @param appointment_id
     */
    public void deleteAppointment(int appointment_id) {
        // Variables
        String query;
        PreparedStatement prepStmt;

        // Operations
        try {
            query = "DELETE FROM `appointment` "
                    + "WHERE `appointment_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, appointment_id);
            prepStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    /**
     * Filtre les rendez-vous par critère
     * @param criterion
     * @param criterionValue
     * @param beginDate
     * @param endDate
     * @return appointments
     */
    public ArrayList<Appointment> findByCriterion(String criterion, String criterionValue,
                                                  String beginDate, String endDate) {
        // Variables
        String query;
        PreparedStatement prepStmt;
        ResultSet rs = null;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        Appointment appointment;

        // Operations
        try {
            if (criterion.equals("general")) {
                query = "SELECT * FROM `appointment` "
                        + "WHERE `client_id` IS NULL "
                        + "AND `date` BETWEEN ? AND ? "
                        + "ORDER BY `date`, `hour`";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, beginDate);
                prepStmt.setString(2, endDate);
                rs = prepStmt.executeQuery();
            } else if (criterion.equals("doctor")) {
                String[] full_name = criterionValue.split(" ");
                query = "SELECT * FROM `appointment` "
                        + "INNER JOIN `doctor` ON `appointment`.`doctor_id` = `doctor`.`doctor_id` "
                        + "WHERE `client_id` IS NULL "
                        + "AND `first_name` = ? AND `last_name` = ? "
                        + "AND `date` BETWEEN ? AND ? "
                        + "ORDER BY `date`, `hour`";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, full_name[0]);
                prepStmt.setString(2, full_name[1]);
                prepStmt.setString(3, beginDate);
                prepStmt.setString(4, endDate);
                rs = prepStmt.executeQuery();
            } else if (criterion.equals("speciality")) {
                query = "SELECT * FROM `appointment` "
                        + "INNER JOIN `doctor` ON `appointment`.`doctor_id` = `doctor`.`doctor_id` "
                        + "WHERE `client_id` IS NULL "
                        + "AND `specialities` LIKE ? "
                        + "AND `date` BETWEEN ? AND ? "
                        + "ORDER BY `date`, `hour`";
                prepStmt = conn.prepareStatement(query);
                prepStmt.setString(1, "%" + criterionValue + "%");
                prepStmt.setString(2, beginDate);
                prepStmt.setString(3, endDate);
                rs = prepStmt.executeQuery();
            }
            while (rs.next()) {
                appointment = new Appointment(rs.getInt("appointment_id"),
                        rs.getString("address"), rs.getString("date"),
                        rs.getString("hour"), rs.getInt("rating"),
                        rs.getInt("doctor_id"), rs.getInt("client_id"));
                appointments.add(appointment);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (appointments);
    }
}