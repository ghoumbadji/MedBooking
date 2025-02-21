package ViewPkg;

import DaoPkg.DoctorDaoImpl;
import ModelPkg.Doctor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class EmployeeMainViewAppointment {
    private final JPanel tab2;
    private final JTextField addressField;
    private final JTextField dateOfAppointmentField;
    private final JTextField hourOfAppointmentField;
    private final JList<String> doctorJList;
  //  private final ArrayList<Doctor> doctorList;
    public final JButton createButton;

    /**
     * Constructeur
     */
    public EmployeeMainViewAppointment() {
        JLabel label1, label2, label3, label4, label5;
        //Initialisation
        tab2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        addressField = new JTextField();
        dateOfAppointmentField = new JTextField();
        hourOfAppointmentField = new JTextField();
        createButton = new JButton();
        doctorJList = new JList<String>();

        // Configuration of the various elements
        label1.setBounds(450, 20, 450, 40);
        label1.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label1.setFont(new Font("Ubuntu", Font.BOLD, 20));
        label1.setText("Remplissez les champs suivants");
        // Address line
        label2.setBounds(350, 90, 220, 30);
        label2.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label2.setFont(new Font("Ubuntu", Font.BOLD, 16));
        label2.setText("Adresse");
        addressField.setBounds(600, 90, 300, 35);
        addressField.setLayout(null);
        addressField.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        addressField.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 13));
        addressField.setText(" Rue, adresse postale, ville, etc.");
        addressField.setBorder(new LineBorder(Color.decode(GlobalView.Colors.get("BLACK")), 2));
        // Date line
        label3.setBounds(350, 160, 220, 30);
        label3.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label3.setFont(new Font("Ubuntu", Font.BOLD, 16));
        label3.setText("Date du rendez-vous");
        dateOfAppointmentField.setBounds(600, 160, 300, 35);
        dateOfAppointmentField.setLayout(null);
        dateOfAppointmentField.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        dateOfAppointmentField.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 13));
        dateOfAppointmentField.setText(" Date - format (DD/MM/YYYY)");
        dateOfAppointmentField.setBorder(new LineBorder(Color.decode(GlobalView.Colors.get("BLACK")), 2));
        // Hour line
        label4.setBounds(350, 230, 300, 30);
        label4.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label4.setFont(new Font("Ubuntu", Font.BOLD, 15));
        label4.setText("Heure de rendez-vous");
        hourOfAppointmentField.setBounds(600, 230, 300, 35);
        hourOfAppointmentField.setLayout(null);
        hourOfAppointmentField.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        hourOfAppointmentField.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 13));
        hourOfAppointmentField.setText(" Heure - format (HH:MM)");
        hourOfAppointmentField.setBorder(new LineBorder(Color.decode(GlobalView.Colors.get("BLACK")), 2));

        // Doctor line
        label5.setBounds(350, 300, 220, 30);
        label5.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label5.setFont(new Font("Ubuntu", Font.BOLD, 15));
        label5.setText("Médecin traitant");

        doctorJList.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 12));
        doctorJList.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        JScrollPane list = new JScrollPane(doctorJList);
        list.setBounds(600, 300, 300, 200);
        list.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        list.setBorder(new LineBorder(Color.decode(GlobalView.Colors.get("BLACK")), 2));
        // Create button line
        createButton.setBounds(520, 550, 200, 35);
        createButton.setLayout(null);
        createButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        createButton.setForeground(Color.WHITE);
        createButton.setFont(new Font("Ubuntu", Font.BOLD, 15));
        createButton.setText("Créer le rendez-vous");

        //Ajout des pages de création à la fenêtre principale
        tab2.setLayout(null);
        tab2.setBackground(Color.WHITE);
        tab2.add(label1);
        tab2.add(label2);
        tab2.add(addressField);
        tab2.add(label3);
        tab2.add(dateOfAppointmentField);
        tab2.add(label4);
        tab2.add(hourOfAppointmentField);
        tab2.add(label5);
        tab2.add(list);
        tab2.add(createButton);
    }

    public JTextField getAddressField()
    {
        return (addressField);
    }

    public JTextField getDateOfAppointmentField()
    {
        return (dateOfAppointmentField);
    }

    public JTextField getHourOfAppointmentField() {
        return (hourOfAppointmentField);
    }

    public JButton getCreateButton()
    {
        return (createButton);
    }

    public JList<String> getDoctorJList()
    {
        return (doctorJList);
    }

    /**
     * Retourne un panel
     *
     * @return tab2
     */
    public JPanel getTab() {
        return (tab2);
    }
}
