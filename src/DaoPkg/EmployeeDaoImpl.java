package DaoPkg;

import java.sql.*;
import java.util.*;

public class EmployeeDaoImpl implements EmployeeDao
{
    // Attributes
    final Connection conn;

    /**
     * Constructeur, se connecte à la bdd
     */
    public EmployeeDaoImpl()
    {
        DataSource ds = new DataSource();

        // Connection to the database
        ds.connect();
        conn = ds.getConnection();
    }

    /**
     * Vérifie que le compte existe, permet de se connecter
     * @param mail_address
     * @param password
     * @return true si info correctes, false sinon
     */
    @Override
    public boolean checkAccount(String mail_address, String password)
    {
        String emp_password = null;
        String query;
        PreparedStatement prepStmt;
        ResultSet rs;

        try {
            query = "SELECT * FROM `employee` WHERE `email_address` = ?";
            prepStmt = conn.prepareStatement(query);
            prepStmt.setString(1, mail_address);
            rs = prepStmt.executeQuery();
            if (rs.next()) {
                emp_password = rs.getString("password");
            }
            else {
                return (false);
            }
        }
        catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
        return (Objects.equals(emp_password, password));
    }
}
