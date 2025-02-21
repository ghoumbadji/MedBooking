package ViewPkg;

import Reporting.PieChart;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class EmployeeMainViewStatistics {
    private final JPanel tab5;
    private final JLabel nbrDoctorsLabel;
    private final JLabel nbrClientsLabel;
    private final JLabel nbrAppointmentsLabel;
    private final JButton viewStatisticsButton;

    /**
     * Constructeur
     */
    public EmployeeMainViewStatistics()
    {
        // Initializations
        tab5 = new JPanel();
        nbrClientsLabel = new JLabel();
        nbrDoctorsLabel = new JLabel();
        nbrAppointmentsLabel = new JLabel();
        viewStatisticsButton = new JButton();

        // Configurations of the components
        nbrClientsLabel.setBounds(510, 30, 1270, 30);
        nbrClientsLabel.setForeground(Color.BLACK);
        nbrClientsLabel.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 18));
        nbrClientsLabel.setText("Nombre de clients: ");
        nbrDoctorsLabel.setBounds(510, 65, 1270, 30);
        nbrDoctorsLabel.setForeground(Color.BLACK);
        nbrDoctorsLabel.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 18));
        nbrDoctorsLabel.setText("Nombre de médecins: ");
        nbrAppointmentsLabel.setBounds(510, 100, 1270, 30);
        nbrAppointmentsLabel.setForeground(Color.BLACK);
        nbrAppointmentsLabel.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 18));
        nbrAppointmentsLabel.setText("Nombre de rendez-vous: ");
        viewStatisticsButton.setBounds(1100, 20, 160, 30);
        viewStatisticsButton.setBackground(Color.decode(GlobalView.Colors.get("ORANGE")));
        viewStatisticsButton.setFont(new Font("Ubuntu", Font.BOLD, 16));
        viewStatisticsButton.setText("RAFRAÎCHIR");
        tab5.setLayout(null);
        tab5.setBounds(0, 0, 1275, 680);
        tab5.setBackground(Color.WHITE);
        tab5.add(nbrClientsLabel);
        tab5.add(nbrDoctorsLabel);
        tab5.add(nbrAppointmentsLabel);
        tab5.add(viewStatisticsButton);
    }

    public JLabel getNbrClientsLabel()
    {
        return (nbrClientsLabel);
    }

    public JLabel getNbrDoctorsLabel()
    {
        return (nbrDoctorsLabel);
    }

    public JLabel getNbrAppointmentsLabel()
    {
        return (nbrAppointmentsLabel);
    }

    public JButton getViewStatisticsButton()
    {
        return (viewStatisticsButton);
    }

    /**
     * Affiche un tableau
     * @return tab5
     */
    public JPanel getTab()
    {
        return (tab5);
    }
}
