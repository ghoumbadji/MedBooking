package ControllerPkg;

import DaoPkg.AppointmentDaoImpl;
import DaoPkg.ClientDaoImpl;
import DaoPkg.DoctorDaoImpl;
import DaoPkg.GlobalDao;
import ModelPkg.*;
import Reporting.PieChart;
import ViewPkg.*;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeMainController {
    // Attributes
    private final EmployeeMainView employeeMainView;
    private final ClientDaoImpl clientDaoImpl;
    private final DoctorDaoImpl doctorDaoImpl;
    private final AppointmentDaoImpl appointmentDaoImpl;

    // Methods

    /**
     * Constructeur
     */
    public EmployeeMainController()
    {
        this.employeeMainView = GlobalView.getEmployeeMainView();
        this.clientDaoImpl = GlobalDao.getClientDaoImpl();
        this.doctorDaoImpl = GlobalDao.getDoctorDaoImpl();
        this.appointmentDaoImpl = GlobalDao.getAppointmentDaoImpl();
    }

    /**
     * Affiche la barre de recherche
     */
    public void handleSearch()
    {
        EmployeeMainViewSearch employeeMainViewSearch
                = this.employeeMainView.getEmployeeMainViewSearch();
        JLabel label = new JLabel("recherche générale");

        // Get combobox value
        JComboBox criterionBox = employeeMainViewSearch.getCriterionBox();
        criterionBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                label.setText(criterionBox.getSelectedItem() + "");
            }
        });

        // Apply button action
        JButton applyButton = employeeMainViewSearch.getApplyButton();
        JTextField info = employeeMainViewSearch.getInfoField();
        JTextField beginDateField = employeeMainViewSearch.getBeginDateField();
        JTextField endDateField = employeeMainViewSearch.getEndDateField();

        applyButton.addActionListener(new ActionListener() {
            /**
             * Rechercher par critères
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String criterion;
                String criterionValue;
                String beginDate;
                String endDate;

                criterion = label.getText();
                if (criterion.equals("recherche générale"))
                    criterion = "general";
                else if (criterion.equals("nom du médecin"))
                    criterion = "doctor";
                else  if (criterion.equals("spécialité"))
                    criterion = "speciality";
                criterionValue = info.getText();
                beginDate = beginDateField.getText();
                endDate = endDateField.getText();
                ArrayList<Appointment> arr;

                if (!beginDate.isEmpty()) {
                    beginDate = Utils.dateConverter(beginDate, "DD/MM/YYYY");
                }
                if (!endDate.isEmpty()) {
                    endDate = Utils.dateConverter(endDate, "DD/MM/YYYY");
                }
                if (beginDate.isEmpty()) {
                    beginDate = "2000-01-01";
                }
                if (endDate.isEmpty()) {
                    endDate = "2050-01-01";
                }
                arr = appointmentDaoImpl.findByCriterion(criterion, criterionValue,
                        beginDate, endDate);

                JPanel scrollablePanel = employeeMainViewSearch.getScrollablePanel();
                scrollablePanel.removeAll();
                for (int i = 0; i < arr.size(); i++) {
                    AppointmentComponent appPanel = new AppointmentComponent(arr.get(i),
                            doctorDaoImpl.getDoctorWithId(arr.get(i).getDoctorId()));
                    appPanel.setModifyMode();

                    // delete action
                    (appPanel.getDeleteButton()).addActionListener(new ActionListener() {
                        /**
                         * Supprimer un rendez-vous
                         * @param actionEvent the event to be processed
                         */
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            appointmentDaoImpl.deleteAppointment(appPanel.getAppointment().getAppointmentId());
                            applyButton.doClick();
                        }
                    });

                    // update action
                    appPanel.getModifyButton().addActionListener(new ActionListener() {
                        /**
                         * Modifier un rendez-vous
                         * @param actionEvent the event to be processed
                         */
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            JTextField addressField = new JTextField();
                            JTextField dateField = new JTextField();
                            JTextField hourField = new JTextField();
                            JTextField doctorNameField = new JTextField();

                            ArrayList<Doctor> arr = doctorDaoImpl.getDoctorList();
                            String[] s1 = new String[arr.size()+1];

                            for (int i = 0; i < arr.size(); i++) {
                                Doctor doctor = arr.get(i);
                                s1[i] = doctor.getFirstName() + " " + doctor.getLastName();
                            }
                            JComboBox criterionBox = new JComboBox(s1);
                            Object[] message = {
                                    "adresse:", addressField,
                                    "date:", dateField,
                                    "heure:", hourField,
                                    "médecin:", criterionBox,
                            };
                            int option = JOptionPane.showConfirmDialog(null,
                                    message, "Entrez les valeurs", JOptionPane.OK_CANCEL_OPTION);
                            if (option == JOptionPane.OK_OPTION)
                            {
                                Doctor doctor = doctorDaoImpl.getDoctorWithFullName(criterionBox.getSelectedItem() + "");
                                Appointment appointment = new Appointment(-1,
                                        addressField.getText(),
                                        Utils.dateConverter(dateField.getText(), "DD/MM/YYYY"),
                                        hourField.getText(), null, doctor.getDoctorId(), null);
                                appointmentDaoImpl.updateAppointment(appPanel.getAppointment().getAppointmentId(),
                                        appointment);
                                applyButton.doClick();
                            }
                        }
                    });
                    scrollablePanel.add(appPanel);
                }
                scrollablePanel.validate();
            }
        });

    }
    public void handleAppointmentCreation()
    {
        EmployeeMainViewAppointment employeeMainViewAppointment = this.employeeMainView.getEmployeeMainViewAppointment();
        JTextField addressField = employeeMainViewAppointment.getAddressField();
        JTextField dateOfAppointmentField = employeeMainViewAppointment.getDateOfAppointmentField();
        JTextField hourOfAppointmentField = employeeMainViewAppointment.getHourOfAppointmentField();
        JButton createButton = employeeMainViewAppointment.getCreateButton();
        ArrayList<Doctor> doctorList = doctorDaoImpl.getDoctorList();
        JList<String> doctorJList = employeeMainViewAppointment.getDoctorJList();

        String[] tabDocteur = new String[doctorList.size()];
        for (int i = 0; i < doctorList.size(); i++) {
            String FirstName = doctorList.get(i).getFirstName();
            String LastName = doctorList.get(i).getLastName();
            String Specialities = doctorList.get(i).getSpecialities();
            tabDocteur[i] = FirstName + " " + LastName + " " + Specialities;
        }
        doctorJList.setListData(tabDocteur);
        JTextField[] jTextFields = {addressField, dateOfAppointmentField, hourOfAppointmentField};
        for (JTextField jTextField : jTextFields) {
            jTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    if (jTextField.getText().equals(" Rue, adresse postale, ville, etc.")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals(" Date - format (DD/MM/YYYY)")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals(" Heure - format (HH:MM)")) {
                        jTextField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    if (jTextField.equals(addressField) && jTextField.getText().isEmpty()) {
                        jTextField.setText(" Rue, adresse postale, ville, etc.");
                    }
                    else if (jTextField.equals(dateOfAppointmentField) && jTextField.getText().isEmpty()) {
                        jTextField.setText(" Date - format (DD/MM/YYYY)");
                    }
                    else if (jTextField.equals(hourOfAppointmentField) && jTextField.getText().isEmpty()) {
                        jTextField.setText(" Heure - format (HH:MM)");
                    }
                }
            });
        }

        createButton.addActionListener(new ActionListener() {
            /**
             * Valide la reservation
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String address =  addressField.getText();
                String dateOfApp = Utils.dateConverter(dateOfAppointmentField.getText(), "DD/MM/YYYY");
                String hourOfApp = hourOfAppointmentField.getText();
                int doctor_id = doctorJList.getSelectedIndex() + 1;

                if (address.isEmpty() || dateOfApp.isEmpty() || hourOfApp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Champ(s) vide(s)", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    Appointment appointment = new Appointment(-1, address, dateOfApp, hourOfApp, null, doctor_id, null);
                    if (appointmentDaoImpl.checkIfAppointmentExists(appointment)) {
                        JOptionPane.showMessageDialog(null, "Ce rendez-vous existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
                    } else {
                        appointmentDaoImpl.addAppointment(appointment);
                        JOptionPane.showMessageDialog(null, "Le rendez-vous a bien été ajouté", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

    }

    public void handleDoctorCreation()
    {
        EmployeeMainViewDoctor employeeMainViewDoctor
                = this.employeeMainView.getEmployeeMainViewDoctor();
        JTextField firstNameField = employeeMainViewDoctor.getFirstNameField();
        JTextField lastNameField = employeeMainViewDoctor.getLastNameField();
        JTextField emailAddressField = employeeMainViewDoctor.getEmailAddressField();
        JTextField specialitiesField = employeeMainViewDoctor.getSpecialitiesField();
        JButton createDoctorButton = employeeMainViewDoctor.getCreateDoctorButton();

        JTextField[] jTextFields = {firstNameField, lastNameField,
                emailAddressField, specialitiesField};

        for (JTextField jTextField : jTextFields) {
            jTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    if (jTextField.getText().equals("  Prénom")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Nom")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Adresse e-mail")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Spécialités séparées par -")) {
                        jTextField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    if (jTextField.equals(firstNameField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Prénom");
                    }
                    else if (jTextField.equals(lastNameField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Nom");
                    }
                    else if (jTextField.equals(emailAddressField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Adresse e-mail");
                    }
                    else if (jTextField.equals(specialitiesField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Spécialités séparées par -");
                    }
                }
            });
        }


        createDoctorButton.addActionListener(new ActionListener() {
            /**
             * Créer un compte
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstNameText = firstNameField.getText();
                String lastNameText = lastNameField.getText();
                String emailAddressText = emailAddressField.getText();
                String specialitiesText = specialitiesField.getText();

                if (!firstNameText.equals("  Prénom") && !lastNameText.equals("  Nom")
                        && !emailAddressText.equals("  Adresse e-mail")
                        && !specialitiesText.equals("  Mot de passe")) {
                    if (!Utils.emailValidator(emailAddressText)) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Email invalide",
                                "Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        Doctor doctor = new Doctor(-1, firstNameText, lastNameText,
                                emailAddressText, specialitiesText, null);
                        if (!doctorDaoImpl.checkIfDoctorExists(doctor)) {
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Médecin créé",
                                    "Message", JOptionPane.INFORMATION_MESSAGE);
                            doctorDaoImpl.addDoctor(doctor);
                        }
                        else {
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Le médecin existe déjà",
                                    "Message", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Champs vide(s)",
                            "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Gérer clients
     */
    public void handleClientFile()
    {
        EmployeeMainViewClient employeeMainViewClient
                = this.employeeMainView.getEmployeeMainViewClient();

        JButton viewFileButton = employeeMainViewClient.getViewFileButton();
        JTextField clientNameFieldField = employeeMainViewClient.getClientNameField();
        JLabel fullNameLabel = employeeMainViewClient.getFullNameLabel();
        JLabel dateOfBirthLabel = employeeMainViewClient.getDateOfBirthLabel();
        JLabel nbrAppointmentsLabel = employeeMainViewClient.getNbrAppointmentsLabel();
        viewFileButton.addActionListener(new ActionListener() {
            /**
             * Voir fichier contenant la liste de clients
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Client client = clientDaoImpl.getClientWithFullName(clientNameFieldField.getText());
                int client_id = client.getClientId();
                ArrayList<Appointment> arr = appointmentDaoImpl.getAppointmentsByClient(client_id);

                // Changes in the second panel
                fullNameLabel.setText(fullNameLabel.getText()
                        + client.getFirstName() + " " + client.getLastName());
                dateOfBirthLabel.setText(dateOfBirthLabel.getText()
                        + Utils.dateConverter(client.getDateOfBirth(), "YYYY-MM-DD"));
                nbrAppointmentsLabel.setText(nbrAppointmentsLabel.getText()
                        + arr.size());
                // end

                JPanel scrollablePanel = employeeMainViewClient.getScrollablePanel();
                scrollablePanel.removeAll();
                for (int i = 0; i < arr.size(); i++) {
                    AppointmentComponent appPanel = new AppointmentComponent(arr.get(i),
                            doctorDaoImpl.getDoctorWithId(arr.get(i).getDoctorId()));
                    appPanel.setViewMode();
                    (appPanel.getRatingButton()).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            Appointment appointment = appPanel.getAppointment();
                            int rating = Integer.parseInt(appPanel.getRatingField().getText());
                            appointment.setRating(rating);
                            appointmentDaoImpl.updateAppointment(appointment.getAppointmentId(), appointment);
                            viewFileButton.doClick();
                        }
                    });
                    scrollablePanel.add(appPanel);
                }
                scrollablePanel.validate();
            }
        });

    }

    public void handleStatistics()
    {
        EmployeeMainViewStatistics employeeMainViewStatistics = employeeMainView.getEmployeeMainViewStatistics();
        JLabel nbrClientsLabel = employeeMainViewStatistics.getNbrClientsLabel();
        JLabel nbrDoctorsLabel = employeeMainViewStatistics.getNbrDoctorsLabel();
        JLabel nbrAppointmentsLabel = employeeMainViewStatistics.getNbrAppointmentsLabel();
        JButton viewStatisticsButton = employeeMainViewStatistics.getViewStatisticsButton();

        viewStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Client> clientList = clientDaoImpl.getClientList();
                ArrayList<Doctor> doctorList = doctorDaoImpl.getDoctorList();
                ArrayList<Appointment> appointmentList = appointmentDaoImpl.getAppointmentList();
                JPanel tab5 = employeeMainViewStatistics.getTab();
                nbrClientsLabel.setText("Nombre de clients: " + clientList.size());
                nbrDoctorsLabel.setText("Nombre de médecins: " + doctorList.size());
                nbrAppointmentsLabel.setText("Nombre de rendez-vous: " + appointmentList.size());
                PieChart pieChart;
                DefaultPieDataset dataset = new DefaultPieDataset();
                pieChart = new PieChart("Répartition des spécialités des médecins",
                        dataset);
                ArrayList<String> specialities = new ArrayList<>();
                for (int i = 0; i < doctorList.size(); i++) {
                    String[] parts = doctorList.get(i).getSpecialities().split(" - ");
                    for (String part: parts) {
                        specialities.add(part);
                    }
                }
                for (String speciality: specialities) {
                    dataset.setValue(speciality, Collections.frequency(specialities, speciality));
                }
                ChartPanel chartPanel = pieChart.getChartPanel();
                chartPanel.setBounds(350, 150, 600, 500);
                chartPanel.setBackground(Color.WHITE);
                tab5.add(chartPanel);
            }
        });
    }

    public void start()
    {
        handleSearch();
        handleAppointmentCreation();
        handleDoctorCreation();
        handleClientFile();
        handleStatistics();
    }
}