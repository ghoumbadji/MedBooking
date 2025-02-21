package DaoPkg;
import ModelPkg.Appointment;
import ModelPkg.Client;

import java.sql.*;
import java.util.*;

public class ClientDaoImpl implements ClientDao {
  final Connection conn;

  /**
   * Constructeur, se connecte à la bdd
   */
  public ClientDaoImpl()
  {
    DataSource ds = new DataSource();

    // Connection to the database
    ds.connect();
    conn = ds.getConnection();
  }

  // Search functions

  /**
   * Vérifie que le client existe, permet de ne pas faire le même compte deux fois
   * @param client
   * @return true si client existe, false sinon
   */
  @Override
  public Boolean checkIfClientExists(Client client)
  {
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;

    try {
      query = "SELECT * FROM `client` "
            + "WHERE `first_name` = ? AND `last_name` = ? AND `email_address` = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setString(1, client.getFirstName());
      prepStmt.setString(2, client.getLastName());
      prepStmt.setString(3, client.getEmailAddress());
      rs = prepStmt.executeQuery();
      return (rs.next());
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (null);
  }

  /**
   * Vérifie que le compte existe, permet de se connecter
   * @param email_address
   * @param password
   * @return true si info correctes, false sinon
   */
  @Override
  public boolean checkAccount(String email_address, String password)
  {
    String client_password = null;
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;

    try {
      query = "SELECT * FROM client WHERE email_address = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setString(1, email_address);
      rs = prepStmt.executeQuery();
      if (rs.next()) {
        client_password = rs.getString("password");
      }
      else {
        return (false);
      }
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (Objects.equals(client_password, password));
  }

  /**
   * Permet d'avoir les informations d'un client à partir de son ID
   * @param client_id
   * @return client avec id = client_id
   */
  @Override
  public Client getClientWithId(int client_id)
  {
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;

    try {
      query = "SELECT * FROM `client` WHERE `client_id` = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setInt(1, client_id);
      rs = prepStmt.executeQuery();

      if (rs.next()) {
        return (new Client(rs.getInt("client_id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("date_of_birth"),
                rs.getString("email_address"), rs.getString("password")));
      } else {
        return (null);
      }
    } catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (null);
  }

  /**
   * Permet d'avoir les informations d'un client à partir de son nom complet
   * @param full_name
   * @return client avec prénom = first_name et nom = last_name
   */
  @Override
  public Client getClientWithFullName(String full_name)
  {
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;
    String[] name = full_name.split(" ");

    try {
      query = "SELECT * FROM client WHERE first_name = ? AND last_name = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setString(1, name[0]);
      prepStmt.setString(2, name[1]);
      rs = prepStmt.executeQuery();
      if (rs.next()) {
        return (new Client(rs.getInt("client_id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("date_of_birth"),
                rs.getString("email_address"), rs.getString("password")));
      }
      else {
        return (null);
      }
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (null);
  }

  /**
   * Permet d'avoir les informations d'un client à partir de son email
   * @param email_address
   * @return client avec email = email_address
   */
  @Override
  public Client getClientWithEmailAddress(String email_address)
  {
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;

    try {
      query = "SELECT * FROM client WHERE email_address = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setString(1, email_address);
      rs = prepStmt.executeQuery();
      if (rs.next()) {
        return (new Client(rs.getInt("client_id"), rs.getString("first_name"),
                rs.getString("last_name"), rs.getString("date_of_birth"),
                rs.getString("email_address"), rs.getString("password")));
      }
      else {
        return (null);
      }
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (null);
  }

  @Override
  public ArrayList<Client> getClientList()
  {
    // Variables
    String query;
    PreparedStatement prepStmt;
    ResultSet rs;
    ArrayList<Client> clients = new ArrayList<Client>();
    Client client;

    // Operations
    try {
      query = "SELECT * FROM `client`";
      prepStmt = conn.prepareStatement(query);
      rs = prepStmt.executeQuery();
      while (rs.next()) {
        client = new Client(rs.getInt("client_id"),
                rs.getString("first_name"), rs.getString("last_name"),
                rs.getString("date_of_birth"), rs.getString("email_address"),
                rs.getString("password"));
        clients.add(client);
      }
    } catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
    return (clients);
  }

  // Update functions
  /**
   * Ajoute un client à la bdd
   * @param client
   */
  @Override
  public void addClient(Client client)
  {
    String query;
    PreparedStatement prepStmt;

    try {
        query = "INSERT INTO `client` (`first_name`, `last_name`, `date_of_birth`, "
              + "`email_address`, `password`) VALUES (?, ?, ?, ?, ?)";
        prepStmt = conn.prepareStatement(query);
        prepStmt.setString(1, client.getFirstName());
        prepStmt.setString(2, client.getLastName());
        prepStmt.setString(3, client.getDateOfBirth());
        prepStmt.setString(4, client.getEmailAddress());
        prepStmt.setString(5, client.getPassword());
        prepStmt.executeUpdate();
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
  }

  /**
   * Reserve un rendez-vous avec un medecin
   * @param client_id
   * @param appointment_id
   */
  @Override
  public void bookAppointment(int client_id, int appointment_id)
  {
    String query;
    PreparedStatement prepStmt;

    try {
      query = "UPDATE `appointment` "
            + "SET `client_id` = ? "
            + "WHERE appointment_id = ?";
      prepStmt = conn.prepareStatement(query);
      prepStmt.setInt(1, client_id);
      prepStmt.setInt(2, appointment_id);
      prepStmt.executeUpdate();
    }
    catch (SQLException sqlException) {
      System.err.println(sqlException.getMessage());
    }
  }
}
