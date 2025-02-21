package ViewPkg;
import javax.swing.*;
import java.awt.*;

public class EmployeeLoginView
{
    // Attributes
    private final JPanel mainPanel;
    private final JTextField emailAddressField;
    private final JTextField passwordField;
    private final JButton clientGoToLoginButton;
    private final JButton employeeLoginButton;


    // Methods

    /**
     * Constructeur initialise la vue
     */
    public EmployeeLoginView()
    {
        JPanel panel1, panel2, panel3, line;
        JLabel label1, label2, label3;

        mainPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        line = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        emailAddressField = new JTextField();
        passwordField = new JTextField();
        clientGoToLoginButton = new JButton();
        employeeLoginButton = new JButton();

        // Configuration of the first panel
        panel1.setBounds(0, 0, 1300, 50);
        panel1.setLayout(null);
        panel1.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        label1.setBounds(15, 8, 150, 30);
        label1.setFont(new Font("Ubuntu", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        label1.setText("MedBooking");
        clientGoToLoginButton.setBounds(1100, 8, 150, 30);
        clientGoToLoginButton.setBackground(Color.WHITE);
        clientGoToLoginButton.setForeground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        clientGoToLoginButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        clientGoToLoginButton.setText("Je suis client");
        line.setBounds(0, 48, 1300, 2);
        line.setBackground(Color.WHITE);
        panel1.add(label1);
        panel1.add(clientGoToLoginButton);
        panel1.add(line);

        // Configuration of the second panel
        panel2.setBounds(10, 200, 600, 250);
        panel2.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        panel2.setLayout(null);
        label2.setBounds(110, 100, 400, 50);
        label2.setFont(new Font("Ubuntu", Font.BOLD, 50));
        label2.setForeground(Color.WHITE);
        label2.setText("Portail Employé");
        panel2.add(label2);

        // Configuration of the third panel
        panel3.setBounds(650, 215, 400, 250);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(null);
        label3.setBounds(50, 10, 310, 30);
        label3.setFont(new Font("Ubuntu", Font.BOLD, 15));
        label3.setText("J'ai déjà un compte employé MedBooking");
        emailAddressField.setBounds(30, 50, 350, 40);
        emailAddressField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        emailAddressField.setForeground(Color.GRAY);
        emailAddressField.setText("  Adresse e-mail");
        passwordField.setBounds(30, 100, 350, 40);
        passwordField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("  Mot de passe");
        employeeLoginButton.setBounds(30, 180, 350, 30);
        employeeLoginButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        employeeLoginButton.setForeground(Color.WHITE);
        employeeLoginButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
        employeeLoginButton.setText("SE CONNECTER");
        panel3.add(label3);
        panel3.add(emailAddressField);
        panel3.add(passwordField);
        panel3.add(employeeLoginButton);

        // Configuration of the main panel
        mainPanel.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        mainPanel.setLayout(null);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
    }

    /**
     * Permet d'accéder à l'écran Log In
     * @return clientGoToLoginButton
     */
    public JButton getClientGoToLoginButton() {return (clientGoToLoginButton);}

    /**
     * Retourne l'email tapé
     * @return emailAddressField
     */
    public JTextField getEmailAddressField() {return (emailAddressField);}

    /**
     * Retourne le mot de passe tapé
     * @return passwordField
     */
    public JTextField getPasswordField() {return (passwordField);}

    /**
     * Permet d'accéder à l'écran Log In employé
     * @return
     */
    public JButton getEmployeeLoginButton() {return (employeeLoginButton);}

    /**
     * Affichage
     * @return mainPanel
     */
    public JPanel getMainPanel() {return (mainPanel);}
}