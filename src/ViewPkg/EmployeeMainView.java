package ViewPkg;

import javax.swing.*;
import java.awt.*;

public class EmployeeMainView {
    private final JPanel mainPanel;
    private final EmployeeMainViewSearch employeeMainViewSearch;
    private final EmployeeMainViewAppointment employeeMainViewAppointment;
    private final EmployeeMainViewDoctor employeeMainViewDoctor;
    private final EmployeeMainViewClient employeeMainViewClient;
    private final EmployeeMainViewStatistics employeeMainViewStatistics;

    /**
     * Constructeur initialise la vue
     */
    public EmployeeMainView()
    {
        JTabbedPane tabbedPane;

        // Initializations
        mainPanel = new JPanel();
        employeeMainViewSearch = new EmployeeMainViewSearch();
        employeeMainViewAppointment = new EmployeeMainViewAppointment();
        employeeMainViewDoctor = new EmployeeMainViewDoctor();
        employeeMainViewClient = new EmployeeMainViewClient();
        employeeMainViewStatistics = new EmployeeMainViewStatistics();
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(10, 10, 1275, 685);
        tabbedPane.setFont(new Font("Ubuntu", Font.BOLD, 16));
        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setForeground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        // Add the five tabs here
        tabbedPane.add("Modifier un rendez-vous", employeeMainViewSearch.getTab());
        tabbedPane.add("Créer un rendez-vous", employeeMainViewAppointment.getTab());
        tabbedPane.add("Créer un docteur", employeeMainViewDoctor.getTab());
        tabbedPane.add("Consulter dossier", employeeMainViewClient.getTab());
        tabbedPane.add("Statistiques (à la dernière connexion)", employeeMainViewStatistics.getTab());

        // Configurations of the main panel
        mainPanel.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        mainPanel.setLayout(null);
        mainPanel.add(tabbedPane);
    }

    /**
     * Permet de faire des recherches
     * @return employeeMainViewSearch
     */
    public EmployeeMainViewSearch getEmployeeMainViewSearch()
    {
        return (employeeMainViewSearch);
    }

    /**
     * Permet de voir les rendez-vous
     * @return employeeMainViewAppointment
     */
    public EmployeeMainViewAppointment getEmployeeMainViewAppointment()
    {
        return (employeeMainViewAppointment);
    }

    /**
     * Permet de voir les docteurs
     * @return employeeMainViewDoctor
     */
    public EmployeeMainViewDoctor getEmployeeMainViewDoctor()
    {
        return (employeeMainViewDoctor);
    }

    /**
     * Permet de voir les clients
     * @return employeeMainViewClient
     */
    public EmployeeMainViewClient getEmployeeMainViewClient()
    {
        return (employeeMainViewClient);
    }

    /**
     * Permet de voir les statistiques
     * @return employeeMainViewStatistics
     */
    public EmployeeMainViewStatistics getEmployeeMainViewStatistics()
    {
        return (employeeMainViewStatistics);
    }

    /**
     * Affichage principal employé
     * @return mainPanel
     */
    public JPanel getMainPanel()
    {
        return (mainPanel);
    }
}
