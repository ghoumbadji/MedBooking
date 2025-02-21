package ViewPkg;

import javax.swing.*;
import java.awt.*;

public class ClientMainView {
    // Attributes
    private final JPanel mainPanel;
    private final JLabel full_name;
    private final JButton deconnectButton;
    private final ClientMainViewSearch clientMainViewSearch;
    private final ClientMainViewHistory clientMainViewHistory;

    // Methods

    /**
     *
     */
    public ClientMainView()
    {
        JPanel tab1, tab2;
        JTabbedPane tabbedPane;

        // Initializations
        clientMainViewSearch = new ClientMainViewSearch();
        clientMainViewHistory = new ClientMainViewHistory();
        mainPanel = new JPanel();
        tabbedPane = new JTabbedPane();
        deconnectButton = new JButton();
        full_name = new JLabel();

        // Configuration of the main profile
        full_name.setBounds(480, 5, 420, 25);
        full_name.setFont(new Font("Ubuntu", Font.PLAIN | Font.ITALIC, 15));
        full_name.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));

        // Configuration of deconnect button
        deconnectButton.setBounds(1110,6, 170, 25);
        deconnectButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        deconnectButton.setForeground(Color.WHITE);
        deconnectButton.setFont(new Font("Ubuntu", Font.BOLD, 15));
        deconnectButton.setText("SE DECONNECTER");

        // Configuration of the tabbed panel
        tabbedPane.setBounds(10, 10, 1275, 685);
        tabbedPane.setFont(new Font("Ubuntu", Font.BOLD, 16));
        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setForeground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        tab1 = clientMainViewSearch.getTab();
        tab2 = clientMainViewHistory.getTab();
        tabbedPane.add("Chercher un rendez-vous", tab1);
        tabbedPane.add("Historique", tab2);

        // Configuration of the main panel
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(null);
        mainPanel.add(tabbedPane);
        mainPanel.add(full_name);
        mainPanel.add(deconnectButton);
    }

    /**
     *
     * @return clientMainViewSearch
     */
    public ClientMainViewSearch getClientMainViewSearch()
    {
        return (clientMainViewSearch);
    }

    /**
     *
     * @return clientMainViewHistory
     */
    public ClientMainViewHistory getClientMainViewHistory()
    {
        return (clientMainViewHistory);
    }

    /**
     *
     * @return full_name
     */
    public JLabel getFullName()
    {
        return (full_name);
    }

    /**
     *
     * @return deconnectButton
     */
    public JButton getDeconnectButton()
    {
        return (deconnectButton);
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
