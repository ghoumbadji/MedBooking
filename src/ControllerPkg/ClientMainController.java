package ControllerPkg;

import DaoPkg.AppointmentDaoImpl;
import DaoPkg.ClientDaoImpl;
import DaoPkg.DoctorDaoImpl;
import DaoPkg.GlobalDao;
import ModelPkg.*;
import ViewPkg.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ClientMainController {
    private final ClientMainView clientMainView;
    private final ClientDaoImpl clientDaoImpl;
    private final DoctorDaoImpl doctorDaoImpl;
    private final AppointmentDaoImpl appointmentDaoImpl;

    /**
     * Constructeur
     */
    public ClientMainController()
    {
        this.clientMainView = GlobalView.getClientMainView();
        this.clientDaoImpl = GlobalDao.getClientDaoImpl();
        this.doctorDaoImpl = GlobalDao.getDoctorDaoImpl();
        this.appointmentDaoImpl = GlobalDao.getAppointmentDaoImpl();
    }

    /**
     * Affiche le profile client
     */
    public void handleProfile()
    {
        JLabel fullName = clientMainView.getFullName();
        JButton deconnectButton = clientMainView.getDeconnectButton();
        int client_id
                = Integer.parseInt(Utils.readFromFile("client_id.txt"));
        Client client = clientDaoImpl.getClientWithId(client_id);

        fullName.setText("Bienvenue " + client.getFirstName() + " " + client.getLastName());
        deconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GlobalView.navigateTo("ClientLoginView");
                (GlobalController.getClientLoginController()).start();
            }
        });
    }

    /**
     * Affiche la barre de recherche
     */
    public void handleSearch()
    {
        ClientMainViewSearch clientMainViewSearch
                = this.clientMainView.getClientMainViewSearch();
        JLabel label = new JLabel("recherche générale");

        // Get combobox value
        JComboBox criterionBox = clientMainViewSearch.getCriterionBox();
        criterionBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                label.setText(criterionBox.getSelectedItem() + "");
            }
        });

        // Apply button action
        JButton applyButton = clientMainViewSearch.getApplyButton();
        JTextField info = clientMainViewSearch.getInfoField();
        JTextField beginDateField = clientMainViewSearch.getBeginDateField();
        JTextField endDateField = clientMainViewSearch.getEndDateField();

        applyButton.addActionListener(new ActionListener() {
            /**
             * Chercher docteur par critères
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
                    endDate = "2060-12-31";
                }
                arr = appointmentDaoImpl.findByCriterion(criterion, criterionValue,
                        beginDate, endDate);

                JPanel scrollablePanel = clientMainViewSearch.getScrollablePanel();
                scrollablePanel.removeAll();
                for (int i = 0; i < arr.size(); i++) {
                    AppointmentComponent appPanel = new AppointmentComponent(arr.get(i),
                            doctorDaoImpl.getDoctorWithId(arr.get(i).getDoctorId()));
                    appPanel.setAddMode();

                    (appPanel.getAddButton()).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            int client_id
                                    = Integer.parseInt(Utils.readFromFile("client_id.txt"));
                            int appointment_id = appPanel.getAppointment().getAppointmentId();
                            clientDaoImpl.bookAppointment(client_id, appointment_id);
                            applyButton.doClick();
                        }
                    });
                    scrollablePanel.add(appPanel);
                }
                scrollablePanel.validate();
            }
        });
    }

    /**
     * Affiche l'historique
     */
    public void handleHistory()
    {
        ClientMainViewHistory clientMainViewHistory
                = this.clientMainView.getClientMainViewHistory();

        JButton appointmentButton = clientMainViewHistory.getAppointmentButton();
        appointmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Appointment> arr;
                int client_id
                        = Integer.parseInt(Utils.readFromFile("client_id.txt"));

                arr = appointmentDaoImpl.getAppointmentsByClient(client_id);
                JPanel scrollablePanel = clientMainViewHistory.getScrollablePanel();
                scrollablePanel.removeAll();
                for (int i = 0; i < arr.size(); i++) {
                    AppointmentComponent appPanel = new AppointmentComponent(arr.get(i),
                            doctorDaoImpl.getDoctorWithId(arr.get(i).getDoctorId()));
                    appPanel.setViewMode();
                    (appPanel.getRatingButton()).addActionListener(new ActionListener() {
                        /**
                         * Affiche les notes
                         * @param actionEvent the event to be processed
                         */
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            Appointment appointment = appPanel.getAppointment();
                            int rating = Integer.parseInt(appPanel.getRatingField().getText());
                            appointment.setRating(rating);
                            appointmentDaoImpl.updateAppointment(appointment.getAppointmentId(), appointment);
                            appointmentButton.doClick();
                        }
                    });
                    scrollablePanel.add(appPanel);
                }
                scrollablePanel.repaint();
                scrollablePanel.revalidate();
            }
        });
    }

    public void start()
    {
        handleProfile();
        handleSearch();
        handleHistory();
    }
}
