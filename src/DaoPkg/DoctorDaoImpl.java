package DaoPkg;

import ModelPkg.Doctor;

import java.sql.*;
import java.util.ArrayList;

public class DoctorDaoImpl implements DoctorDao {
    // Attributes
    final Connection conn;

    // Methods

    /**
     * Constructeur, se connecte à la bdd
     */
    public DoctorDaoImpl() {
        DataSource ds = new DataSource();

        // Connection to the database
        ds.connect();
        conn = ds.getConnection();
    }

    // Search functions

    /**
     * Vérifie qu'un docteur existe déjà, permet de ne pas le mettre en double dans la bdd
     *
     * @param doctor
     * @return true si docteur existe, false sinon
     */
    @Override
    public Boolean checkIfDoctorExists(Doctor doctor) {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;

        try {
            //verify if the client already exists
            query = "SELECT * FROM `doctor` "
                    + "WHERE `first_name` = ? AND `last_name` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, doctor.getFirstName());
            prepStmt.setString(2, doctor.getLastName());
            rs = prepStmt.executeQuery();
            return (rs.next());
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (null);
    }

    /**
     * Permet d'avoir les informations d'un docteur à partir de son ID
     *
     * @param doctor_id
     * @return doctor avec id = doctor_id
     */
    @Override
    public Doctor getDoctorWithId(int doctor_id) {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;

        try {
            query = "SELECT * FROM doctor WHERE `doctor_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, doctor_id);
            rs = prepStmt.executeQuery();

            if (rs.next()) {
                return (new Doctor(rs.getInt("doctor_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email_address"),
                        rs.getString("specialities"), rs.getFloat("average_rating")));
            } else {
                return (null);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (null);
    }

    /**
     * Permet d'avoir les informations d'un docteur à partir de son nom complet
     *
     * @param full_name
     * @return doctor avec prénom = first_name et nom = last_name
     */
    @Override
    public Doctor getDoctorWithFullName(String full_name) {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;
        String[] name = full_name.split(" ");

        try {
            query = "SELECT * FROM doctor WHERE `first_name` = ? AND last_name = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, name[0]);
            prepStmt.setString(2, name[1]);
            rs = prepStmt.executeQuery();

            if (rs.next()) {
                return (new Doctor(rs.getInt("doctor_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email_address"),
                        rs.getString("specialities"), rs.getFloat("average_rating")));
            } else {
                return (null);
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (null);
    }

    @Override
    public ArrayList<Doctor> getDoctorList() {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;
        ArrayList<Doctor> doctorList = new ArrayList<>();

        try {
            query = "SELECT * FROM doctor";
            prepStmt = conn.prepareStatement(query);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                doctorList.add(new Doctor(rs.getInt("doctor_id"), rs.getString("first_name"),
                        rs.getString("last_name"), rs.getString("email_address"), rs.getString("specialities"),
                        rs.getFloat("average_rating")));
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (doctorList);
    }

    // Update functions

    /**
     * Ajoute un docteur à la bdd
     *
     * @param doctor
     */
    @Override
    public void addDoctor(Doctor doctor) {
        String query;
        PreparedStatement prepStmt;

        try {
            query = "INSERT INTO `doctor` (`first_name`, `last_name`, " +
                    "`email_address`,`specialities`) VALUES(?, ?, ?, ?)";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, doctor.getFirstName());
            prepStmt.setString(2, doctor.getLastName());
            prepStmt.setString(3, doctor.getEmailAddress());
            prepStmt.setString(4, doctor.getSpecialities());
            prepStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    /**
     * Met à jour la note moyenne du docteur
     *
     * @param doctor_id
     */
    @Override
    public void updateAverageRating(int doctor_id)
    {
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;
        ArrayList<Float> ratings = new ArrayList<>();
        float rating = 0f;
        float average_rating = 0f;

        // Get all the notes
        try {
            query = "SELECT * FROM `appointment` WHERE `doctor_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setInt(1, doctor_id);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                rating = rs.getFloat("rating");
                if (rating != 0) {
                    ratings.add(rating);
                }
            }
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }

        // Compute the average rating
        for (float nbr : ratings) {
            average_rating += nbr;
        }
        average_rating = average_rating/ratings.size();

        // Update the average rating
        try {
            query = "UPDATE `doctor` SET `average_rating` = ? WHERE `doctor_id` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setFloat(1, average_rating);
            prepStmt.setFloat(2, doctor_id);
            prepStmt.executeUpdate();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }
}