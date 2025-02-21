package ViewPkg;

import javax.swing.*;
import java.awt.*;

public class ClientMainViewHistory {
    private final JPanel tab2;
    private final JPanel scrollablePanel;
    private final JButton appointmentButton;

    /**
     * Constructeur, initilise la vue
     */
    public ClientMainViewHistory()
    {
        JPanel tab2_1, tab2_2;
        JScrollPane scrollPane;

        // Initializations
        tab2 = new JPanel();
        tab2_1 = new JPanel();
        tab2_2 = new JPanel();
        scrollablePanel = new JPanel();
        appointmentButton = new JButton();

        // Configurations for tab2_1
        appointmentButton.setBounds(400, 10, 400, 20);
        appointmentButton.setFont(new Font("Ubuntu",
                Font.BOLD | Font.ITALIC, 15));
        appointmentButton.setText("VOIR MES RENDEZ-VOUS PASSÉS");
        appointmentButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        appointmentButton.setForeground(Color.WHITE);
        tab2_1.setBounds(0, 0, 1275, 100);
        tab2_1.setLayout(new BorderLayout());
        tab2_1.setBackground(Color.WHITE);
        tab2_1.add(appointmentButton);

        // Configurations for tab2_2
        tab2_2.setBounds(0, 170, 1270, 500);
        tab2_2.setLayout(null);
        scrollablePanel.setBackground(Color.WHITE);
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setMinimumSize(new Dimension(600, 1000));
        scrollablePanel.setPreferredSize(new Dimension(600, 1000));
        scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1270, 490);
        tab2_2.add(scrollPane);

        // Configurations of the main panel
        tab2.setLayout(null);
        tab2.setBackground(Color.WHITE);
        tab2.add(tab2_1);
        tab2.add(tab2_2);
    }

    /**
     *
     * @return appointmentButton
     */
    public JButton getAppointmentButton() {return (appointmentButton);}

    /**
     *
     * @return scrollablePanel
     */
    public JPanel getScrollablePanel() {return (scrollablePanel);}

    /**
     *
     * @return tab2
     */
    public JPanel getTab() {return (tab2);}
}
