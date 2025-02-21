package ViewPkg;

import ControllerPkg.Utils;
import ModelPkg.Appointment;
import ModelPkg.Doctor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AppointmentComponent extends JPanel {
    private final Appointment appointment;
    private final Doctor doctor;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton modifyButton;
    private final JTextField ratingField;
    private final JButton ratingButton;
    private final JLabel ratingLabel;

    /**
     * Constructeur, initialise un rendez-vous
     * @param appointment
     * @param doctor
     */
    public AppointmentComponent(Appointment appointment, Doctor doctor)
    {
        JLabel date, hour, address, doctorFullNameLabel, doctorSpecialitiesLabel;

        // Initializations
        this.appointment = appointment;
        this.doctor = doctor;
        date = new JLabel();
        hour = new JLabel();
        address = new JLabel();
        doctorFullNameLabel = new JLabel();
        doctorSpecialitiesLabel = new JLabel();
        ratingField = new JTextField();
        addButton = new JButton();
        deleteButton = new JButton();
        modifyButton = new JButton();
        ratingButton = new JButton();
        ratingLabel = new JLabel();

        // Configurations
        // date
        date.setBounds(5, 5, 100, 15);
        date.setFont(new Font("Ubuntu", Font.BOLD, 13));
        date.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        date.setText(Utils.dateConverter(appointment.getDate(), "YYYY-MM-DD"));
        // hour
        hour.setBounds(5, 26, 50, 15);
        hour.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        hour.setText(appointment.getHour());
        // address
        address.setBounds(58, 26, 400, 15);
        address.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        address.setText("| " + appointment.getAddress());
        // doctor name
        doctorFullNameLabel.setBounds(5, 45, 400, 15);
        doctorFullNameLabel.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        doctorFullNameLabel.setText("Médecin traitant: " + doctor.getFirstName()
                + " " + doctor.getLastName());
        // doctor specialities
        doctorSpecialitiesLabel.setBounds(5, 65, 400, 15);
        doctorSpecialitiesLabel.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        doctorSpecialitiesLabel.setText("Spécialités: " + doctor.getSpecialities());

        // main panel settings
        this.setLayout(null);
        this.setSize(600, 150);
        this.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        this.setBorder(new LineBorder(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")), 1));
        this.add(date);
        this.add(hour);
        this.add(address);
        this.add(doctorFullNameLabel);
        this.add(doctorSpecialitiesLabel);
        this.add(addButton);
        this.add(deleteButton);
        this.add(modifyButton);
        this.add(ratingField);
        this.add(ratingButton);
        this.add(ratingLabel);
    }

    /**
     * Bouton prendre rendez-vous
     */
    public void setAddMode()
    {
        // appointment button
        addButton.setBounds(550, 40, 170, 25);
        addButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        addButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        addButton.setForeground(Color.WHITE);
        addButton.setText("Prendre rdv");
    }

    /**
     * Bouton modifier rendez-vous
     */
    public void setModifyMode()
    {
        // delete appointment button
        deleteButton.setBounds(550, 20, 170, 25);
        deleteButton.setBackground(Color.RED);
        deleteButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setText("Supprimer rdv");
        // modify appointment button
        // delete appointment button
        modifyButton.setBounds(550, 60, 170, 25);
        modifyButton.setBackground(Color.decode(GlobalView.Colors.get("BLACK")));
        modifyButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
        modifyButton.setForeground(Color.WHITE);
        modifyButton.setText("Modifier rdv");

    }

    /**
     * Affichage
     */
    public void setViewMode()
    {
        Integer rating = appointment.getRating();

        if (rating == null || rating == 0) {
            ratingField.setBounds(550, 35, 30, 25);
            ratingField.setFont(new Font("Ubuntu", Font.BOLD, 14));
            ratingButton.setBounds(590, 35, 80, 25);
            ratingButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
            ratingButton.setFont(new Font("Ubuntu", Font.BOLD, 14));
            ratingButton.setForeground(Color.WHITE);
            ratingButton.setText("Noter");
        }
        else {
            ratingLabel.setBounds(300, 35, 70, 25);
            ratingLabel.setFont(new Font("Ubuntu", Font.BOLD, 14));
            ratingLabel.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
            ratingLabel.setText("Note: " + rating);
        }
    }

    /**
     *
     * @return appointment
     */
    public Appointment getAppointment() {return (appointment);}

    /**
     *
     * @return doctor
     */
    public Doctor getDoctor() {return (doctor);}

    /**
     *
     * @return addButton
     */
    public JButton getAddButton() {return (addButton);}

    /**
     *
     * @return deleteButton
     */
    public JButton getDeleteButton() {return (deleteButton);}

    /**
     *
     * @return modifyButton
     */
    public JButton getModifyButton() {return (modifyButton);}

    /**
     *
     * @return ratingButton
     */
    public JButton getRatingButton() {return (ratingButton);}

    /**
     *
     * @return ratingField
     */
    public JTextField getRatingField() {return (ratingField);}
}
