package ViewPkg;

import javax.swing.*;
import java.awt.*;

public class EmployeeMainViewDoctor {
    private final JPanel tab3;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField emailAddressField;
    private final JTextField specialitiesField;
    private final JButton createDoctorButton;

    /**
     * Constructeur
     */
    public EmployeeMainViewDoctor()
    {
        JLabel title;

        // Initializations
        tab3 = new JPanel();
        title = new JLabel();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        emailAddressField = new JTextField();
        specialitiesField = new JTextField();
        createDoctorButton= new JButton();

        //Configurations of the various elements
        title.setBounds(450, 50, 450, 40);
        title.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        title.setFont(new Font("Ubuntu", Font.BOLD, 20));
        title.setText("Entrez les informations du médecin");

        firstNameField.setBounds(450, 110, 350, 40);
        firstNameField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        firstNameField.setForeground(Color.GRAY);
        firstNameField.setText("  Prénom");
        lastNameField.setBounds(450, 170, 350, 40);
        lastNameField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        lastNameField.setForeground(Color.GRAY);
        lastNameField.setText("  Nom");
        emailAddressField.setBounds(450, 230, 350, 40);
        emailAddressField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        emailAddressField.setForeground(Color.GRAY);
        emailAddressField.setText("  Adresse e-mail");
        specialitiesField.setBounds(450, 290, 350, 40);
        specialitiesField.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        specialitiesField.setForeground(Color.GRAY);
        specialitiesField.setText("  Spécialités séparées par -");
        createDoctorButton.setBounds(450, 350, 350, 40);
        createDoctorButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
        createDoctorButton.setText("CRÉER LE MÉDECIN");
        createDoctorButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        createDoctorButton.setForeground(Color.WHITE);

        tab3.setLayout(null);
        tab3.setBounds(0, 0, 1275, 680);
        tab3.setBackground(Color.WHITE);
        tab3.add(title);
        tab3.add(firstNameField);
        tab3.add(lastNameField);
        tab3.add(emailAddressField);
        tab3.add(specialitiesField);
        tab3.add(createDoctorButton);
    }

    public JTextField getFirstNameField()
    {
        return (firstNameField);
    }

    public JTextField getLastNameField()
    {
        return (lastNameField);
    }

    public JTextField getEmailAddressField()
    {
        return emailAddressField;
    }

    public JTextField getSpecialitiesField()
    {
        return specialitiesField;
    }

    public JButton getCreateDoctorButton()
    {
        return (createDoctorButton);
    }

    /**
     * Retourne un panel de contenu
     * @return tab3
     */
    public JPanel getTab()
    {
        return (tab3);
    }
}
