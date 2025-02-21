package DaoPkg;

import ModelPkg.Client;

import java.util.ArrayList;

public interface ClientDao {
  /**
   * Vérifie que le client existe, permet de ne pas faire le même compte deux fois
   * @param client
   * @return true si client existe, false sinon
   */
  public Boolean checkIfClientExists(Client client);

  /**
   * Vérifie que le compte existe, permet de se connecter
   * @param email_address
   * @param password
   * @return true si info correctes, false sinon
   */
  public boolean checkAccount(String email_address, String password);

  /**
   * Permet d'avoir les informations d'un client à partir de son ID
   * @param client_id
   * @return client avec id = client_id
   */
  public Client getClientWithId(int client_id);

  /**
   * Permet d'avoir les informations d'un client à partir de son nom complet
   * @param full_name
   * @return client avec prénom = first_name et nom = last_name
   */
  public Client getClientWithFullName(String full_name);

  /**
   * Permet d'avoir les informations d'un client à partir de son email
   * @param email_address
   * @return client avec email = email_address
   */
  public Client getClientWithEmailAddress(String email_address);

  public ArrayList<Client> getClientList();

  /**
   * Ajoute un client à la bdd
   * @param client
   */
  public void addClient(Client client);

  /**
   * Reserve un rendez-vous avec un medecin
   * @param client_id
   * @param appointment_id
   */
  public void bookAppointment(int client_id, int appointment_id);
}
