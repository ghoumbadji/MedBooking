package ViewPkg;

import javax.swing.*;
import java.awt.*;

public class ClientSignInView {
    private final JPanel mainPanel;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField emailAddressField;
    private final JTextField passwordField;
    private final JTextField dateOfBirthField;
    private final JButton clientSignInButton;
    private final JButton clientGoToLoginButton;

    /**
     * Constructeur, initialise la vue
     */
    public ClientSignInView()
    {
      // Data definitions
      JLabel label1, label2, label3;
      JPanel panel1, panel2;

      // Initialisations
      mainPanel = new JPanel();
      panel1 = new JPanel();
      panel2 = new JPanel();
      label1 = new JLabel();
      label2 = new JLabel();
      label3 = new JLabel();
      firstNameField = new JTextField();
      lastNameField = new JTextField();
      emailAddressField = new JTextField();
      passwordField = new JTextField();
      dateOfBirthField = new JTextField();
      clientSignInButton = new JButton();
      clientGoToLoginButton = new JButton();

      // Configuration of the components of the first panel
      panel1.setBounds(450, 40, 400, 120);
      panel1.setBackground(Color.WHITE);
      panel1.setLayout(null);
      label1.setBounds(80, 10, 350, 30);
      label1.setFont(new Font("Ubuntu", Font.BOLD, 16));
      label1.setText("J'ai déjà un compte MedBooking");
      clientGoToLoginButton.setBounds(20, 50, 350, 30);
      clientGoToLoginButton.setBackground(Color.WHITE);
      clientGoToLoginButton.setForeground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
      clientGoToLoginButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
      clientGoToLoginButton.setText("SE CONNECTER");
      panel1.add(label1);
      panel1.add(clientGoToLoginButton);

      // Configuration of the components of the second panel
      panel2.setBounds(450, 200, 400, 450);
      panel2.setBackground(Color.WHITE);
      panel2.setLayout(null);
      label2.setBounds(90, 10, 250, 30);
      label2.setFont(new Font("Ubuntu", Font.BOLD, 16));
      label2.setText("Nouveau sur MedBooking ?");
      label3.setBounds(50, 55, 300, 30);
      label3.setFont(new Font("Ubuntu", Font.PLAIN, 15));
      label3.setText("Saisissez vos informations pour continuer.");
      firstNameField.setBounds(30, 95, 350, 40);
      firstNameField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
      firstNameField.setForeground(Color.GRAY);
      firstNameField.setText("  Prénom");
      lastNameField.setBounds(30, 145, 350, 40);
      lastNameField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
      lastNameField.setForeground(Color.GRAY);
      lastNameField.setText("  Nom");
      dateOfBirthField.setBounds(30, 195, 350, 40);
      dateOfBirthField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
      dateOfBirthField.setForeground(Color.GRAY);
      dateOfBirthField.setText("  Date de naissance (JJ/MM/AAAA)");
      emailAddressField.setBounds(30, 245, 350, 40);
      emailAddressField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
      emailAddressField.setForeground(Color.GRAY);
      emailAddressField.setText("  Adresse e-mail");
      passwordField.setBounds(30, 295, 350, 40);
      passwordField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
      passwordField.setForeground(Color.GRAY);
      passwordField.setText("  Mot de passe");
      clientSignInButton.setBounds(30, 375, 350, 40);
      clientSignInButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
      clientSignInButton.setText("S'INSCRIRE");
      clientSignInButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
      clientSignInButton.setForeground(Color.WHITE);
      panel2.add(label2);
      panel2.add(label3);
      panel2.add(firstNameField);
      panel2.add(lastNameField);
      panel2.add(emailAddressField);
      panel2.add(dateOfBirthField);
      panel2.add(passwordField);
      panel2.add(clientSignInButton);

      // Configuration of the main panel
      mainPanel.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
      mainPanel.setLayout(null);
      mainPanel.add(panel1);
      mainPanel.add(panel2);
    }

    /**
     * Affiche l'écran Log In client
     * @return clientGoToLoginButton
     */
    public JButton getClientGoToLoginButton()
    {
        return (clientGoToLoginButton);
    }

    /**
     * Retourne le nom complet
     * @return firstNameField
     */
    public JTextField getFirstNameField()
    {
        return (firstNameField);
    }

    /**
     * Retourne le nom de famille
     * @return lastNameField
     */
    public JTextField getLastNameField()
    {
        return (lastNameField);
    }

    /**
     * Retourne l'adresse mail
     * @return emailAddressField
     */
    public JTextField getEmailAddressField()
    {
        return (emailAddressField);
    }

    /**
     * Retourne la date de naissance
     * @return dateOfBirthField
     */
    public JTextField getDateOfBirthField()
    {
        return (dateOfBirthField);
    }

    /**
     * Retourne le mot de passe
     * @return passwordField
     */
    public JTextField getPasswordField()
    {
        return (passwordField);
    }

    /**
     * Afficher l'écran client Sign In
     * @return clientSignInButton
     */
    public JButton getClientSignInButton()
    {
        return (clientSignInButton);
    }

    /**
     * Affichage
     * @return mainPanel
     */
    public JPanel getMainPanel()
    {
      return (mainPanel);
    }
}