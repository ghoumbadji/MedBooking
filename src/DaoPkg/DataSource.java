package DaoPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    // Attributes
    private Connection conn;

    // Methods
    /**
     * Permet de créer une connection à la bdd
     * @param URLDataBase
     * @param LoginDataBase
     * @param PwdDataBase
     */
    public void connect(String URLDataBase, String LoginDataBase, String PwdDataBase)
    {
        try {
            // Call to the MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Connection to the MySQL database through JDBC
            conn = DriverManager.getConnection(URLDataBase, LoginDataBase, PwdDataBase);
            // Creation of the SQL statement
        }
        catch (ClassNotFoundException | SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    // An overridden version of the previous method to have direct access to the connection

    /**
     * Permet de se connecter à la bdd
     */
    public void connect()
    {
        String URLDataBase;
        String LoginDataBase;
        String PwdDataBase ;

        // To be modified for test purposes
        URLDataBase = "jdbc:mysql://localhost:3306/medbooking_db";
        LoginDataBase = "pma";
        PwdDataBase = "pmapassword";
        this.connect(URLDataBase, LoginDataBase, PwdDataBase);
    }

    /**
     * Permet de se déconnecter à la bdd
     */
    public void disconnect()
    {
        try {
            conn.close();
        }
        catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }

    /**
     * Permet d'obtenir la connection
     * @return conn
     */
    public Connection getConnection()
    {
        return (conn);
    }
}