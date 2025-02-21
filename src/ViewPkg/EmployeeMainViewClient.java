package ViewPkg;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EmployeeMainViewClient {
    private final JPanel tab4;
    JPanel scrollablePanel;
    JScrollPane scrollPane;
    private final JTextField clientNameField;
    private final JButton viewFileButton;
    private final JLabel fullNameLabel;
    private final JLabel dateOfBirthLabel;
    private final JLabel nbrAppointmentsLabel;

    /**
     * Constructeur, initialise l'affichage
     */
    public EmployeeMainViewClient()
    {
        JPanel tab4_1, tab4_2, tab4_3;
        JLabel label1;

        // Initializations
        tab4 = new JPanel();
        tab4_1 = new JPanel();
        tab4_2 = new JPanel();
        tab4_3 = new JPanel();
        scrollablePanel = new JPanel();
        clientNameField = new JTextField();
        label1 = new JLabel();
        fullNameLabel = new JLabel();
        dateOfBirthLabel = new JLabel();
        nbrAppointmentsLabel = new JLabel();
        viewFileButton = new JButton();

        // Configuration of the tab4_1
        tab4_1.setBounds(0, 0, 1275, 140);
        tab4_1.setLayout(null);
        tab4_1.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        label1.setBounds(10, 10, 250, 30);
        label1.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label1.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        label1.setText("Prénom et nom du client");
        clientNameField.setBounds(10, 40, 250, 35);
        clientNameField.setBorder(new LineBorder(
                Color.decode(GlobalView.Colors.get("LIGHT_BLUE")),
                2, true));
        clientNameField.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        // Apply button
        viewFileButton.setBounds(10, 90, 250, 35);
        viewFileButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        viewFileButton.setForeground(Color.WHITE);
        viewFileButton.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        viewFileButton.setText("Voir le fichier du client");
        tab4_1.add(label1);
        tab4_1.add(clientNameField);
        tab4_1.add(viewFileButton);

        // Configuration of the tab4_2
        tab4_2.setBounds(0, 155, 1270, 110);
        tab4_2.setLayout(null);
        fullNameLabel.setBounds(5, 5, 1270, 30);
        fullNameLabel.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        fullNameLabel.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        fullNameLabel.setText("Nom du patient: ");
        dateOfBirthLabel.setBounds(5, 30, 1270, 30);
        dateOfBirthLabel.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        dateOfBirthLabel.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        dateOfBirthLabel.setText("Date de naissance: ");
        nbrAppointmentsLabel.setBounds(5, 60, 1270, 30);
        nbrAppointmentsLabel.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        nbrAppointmentsLabel.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        nbrAppointmentsLabel.setText("Nombre de rendez-vous: ");
        tab4_2.setBackground(Color.WHITE);
        tab4_2.add(fullNameLabel);
        tab4_2.add(dateOfBirthLabel);
        tab4_2.add(nbrAppointmentsLabel);


        // Configuration of the tab4_3
        tab4_3.setBounds(0, 270, 1270, 400);
        tab4_3.setLayout(null);
        scrollablePanel.setBackground(Color.WHITE);
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setMinimumSize(new Dimension(600, 1000));
        scrollablePanel.setPreferredSize(new Dimension(600, 1000));
        scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1270, 390); //modified here
        tab4_3.add(scrollPane);

        // Configuration of the main panel (tab4 here)
        tab4.setLayout(null);
        tab4.setBounds(0, 0, 1275, 680);
        tab4.setBackground(Color.WHITE);
        tab4.add(tab4_1);
        tab4.add(tab4_2);
        tab4.add(tab4_3);
    }

    /**
     * Retorune les noms des clients
     * @return clientNameField
     */
    public JTextField getClientNameField() {return (clientNameField);}

    /**
     * Retourne le nom complet des clients
     * @return fullNameLabel
     */
    public JLabel getFullNameLabel() {return (fullNameLabel);}

    /**
     * Retourne la date de naissance des clients
     * @return dateOfBirthLabel
     */
    public JLabel getDateOfBirthLabel() {return (dateOfBirthLabel);}

    /**
     * Retourne le nombre de rendez-vous
     * @return nbrAppointmentsLabel
     */
    public JLabel getNbrAppointmentsLabel() {return (nbrAppointmentsLabel);}

    /**
     * Permet d'avoir une fenêtre scrollable
     * @return scrollablePanel
     */
    public JPanel getScrollablePanel() {return (scrollablePanel);}

    /**
     * Permet de vérifier la liste des clients
     * @return viewFileButton
     */
    public JButton getViewFileButton() {return (viewFileButton);}

    /**
     * Retourne un tableau
     * @return tab4
     */
    public JPanel getTab() {return (tab4);}
}