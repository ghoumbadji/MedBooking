package ViewPkg;
import javax.swing.*;
import java.awt.*;

public class ClientLoginView {
    private final JPanel mainPanel;
    private final JTextField emailAddressField;
    private final JTextField passwordField;
    private final JButton clientLoginButton;
    private final JButton clientGoToSignInButton;
    private final JButton employeeGoToLoginButton;

    /**
     * Constructeur initialise la vue
     */
    public ClientLoginView()
    {
        // Data definitions
        JLabel label1, label2, label3;
        JPanel panel1, panel2, panel3;

        // Initialisations
        mainPanel = new JPanel();
        emailAddressField = new JTextField();
        passwordField = new JTextField();
        clientLoginButton = new JButton();
        clientGoToSignInButton = new JButton();
        employeeGoToLoginButton = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        // Configuration of the first panel and its components
        panel1.setBounds(0, 0, 1300, 50);
        panel1.setLayout(null);
        panel1.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        label1.setBounds(15, 8, 150, 30);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Ubuntu", Font.BOLD, 20));
        label1.setText("MedBooking");
        employeeGoToLoginButton.setBounds(1100, 8, 150, 30);
        employeeGoToLoginButton.setBackground(Color.WHITE);
        employeeGoToLoginButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        employeeGoToLoginButton.setText("Je suis employé");
        panel1.add(label1);
        panel1.add(employeeGoToLoginButton);

        // Configuration of  the second panel and its components
        panel2.setBounds(450, 150, 400, 250);
        panel2.setBackground(Color.WHITE);
        panel2.setLayout(null);
        label2.setBounds(50, 10, 300, 30);
        label2.setFont(new Font("Ubuntu", Font.BOLD, 15));
        label2.setText("J'ai déjà un compte client MedBooking");
        emailAddressField.setBounds(30, 50, 350, 40);
        emailAddressField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        emailAddressField.setForeground(Color.GRAY);
        emailAddressField.setText("  Adresse e-mail");
        passwordField.setBounds(30, 100, 350, 40);
        passwordField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        passwordField.setForeground(Color.GRAY);
        passwordField.setText("  Mot de passe");
        clientLoginButton.setBounds(30, 180, 350, 30);
        clientLoginButton.setBackground(Color.decode(GlobalView.Colors.get("ORANGE")));
        clientLoginButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
        clientLoginButton.setText("SE CONNECTER");
        panel2.add(label2);
        panel2.add(emailAddressField);
        panel2.add(passwordField);
        panel2.add(clientLoginButton);

        // Configuration of the third panel and its components
        panel3.setBounds(450, 500, 400, 120);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(null);
        label3.setBounds(100, 10, 350, 30);
        label3.setFont(new Font("Ubuntu", Font.BOLD, 16));
        label3.setText("Nouveau sur MedBooking ?");
        clientGoToSignInButton.setBounds(30, 50, 350, 30);
        clientGoToSignInButton.setBackground(Color.WHITE);
        clientGoToSignInButton.setForeground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        clientGoToSignInButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
        clientGoToSignInButton.setText("S'INSCRIRE");
        panel3.add(label3);
        panel3.add(clientGoToSignInButton);

        // Configuration of the main panel
        mainPanel.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        mainPanel.setLayout(null);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
    }

    /**
     *
     * @return emailAddressField
     */
    public JTextField getEmailAddressField()
    {
        return (emailAddressField);
    }

    /**
     *
     * @return passwordField
     */
    public JTextField getPasswordField()
    {
        return (passwordField);
    }

    /**
     *
     * @return clientLoginButton
     */
    public JButton getClientLoginButton()
    {
        return (clientLoginButton);
    }

    /**
     *
     * @return clientGoToSignInButton
     */
    public JButton getClientGoToSignInButton()
    {
        return (clientGoToSignInButton);
    }

    /**
     *
     * @return employeeGoToLoginButton
     */
    public JButton getEmployeeGoToLoginButton()
    {
        return (employeeGoToLoginButton);
    }

    /**
     *
     * @return mainPanel
     */
    public JPanel getMainPanel()
    {
        return (mainPanel);
    }
}