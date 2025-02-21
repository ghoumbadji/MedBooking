package ViewPkg;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ClientMainViewSearch {
    private final JPanel tab1;
    JPanel scrollablePanel;
    JScrollPane scrollPane;
    private final JTextField infoField;
    private final JTextField beginDateField;
    private final JTextField endDateField;
    private final JButton applyButton;
    private final JComboBox criterionBox;

    /**
     * Constructeur, initialise la vue
     */
    public ClientMainViewSearch()
    {
        JPanel tab1_1, tab1_2;
        JLabel label1, label2, label3, label4;
        String[] s1 = {"recherche générale", "nom du médecin", "spécialité"};

        // Initializations
        tab1 = new JPanel();
        tab1_1 = new JPanel();
        tab1_2 = new JPanel();
        scrollablePanel = new JPanel();
        infoField = new JTextField();
        beginDateField = new JTextField();
        endDateField = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        applyButton = new JButton();
        criterionBox = new JComboBox(s1);

        // Configuration of the tab1_1
        tab1_1.setBounds(0, 0, 1275, 140);
        tab1_1.setLayout(null);
        tab1_1.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_WHITE")));
        // First column
        label1.setBounds(10, 10, 250, 30);
        label1.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label1.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        label1.setText("Critère de recherche");
        criterionBox.setBounds(10, 40, 250, 35);
        criterionBox.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        criterionBox.setBackground(Color.WHITE);
        criterionBox.setBorder(new LineBorder(
                Color.decode(GlobalView.Colors.get("LIGHT_BLUE")),
                1, true));
        // Second column
        label2.setBounds(300, 10, 250, 30);
        label2.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label2.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        label2.setText("Valeur du critère");
        infoField.setBounds(300, 40, 250, 35);
        infoField.setBorder(new LineBorder(
                Color.decode(GlobalView.Colors.get("LIGHT_BLUE")),
                2, true));
        infoField.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        // Third column
        label3.setBounds(600, 10, 250, 30);
        label3.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label3.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        label3.setText("À partir du (date de début)");
        beginDateField.setBounds(600, 40, 250, 35);
        beginDateField.setBorder(new LineBorder(
                Color.decode(GlobalView.Colors.get("LIGHT_BLUE")),
                2, true));
        beginDateField.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        // Fourth column
        label4.setBounds(900, 10, 250, 30);
        label4.setForeground(Color.decode(GlobalView.Colors.get("BLACK")));
        label4.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        label4.setText("Au (date de fin)");
        endDateField.setBounds(900, 40, 250, 35);
        endDateField.setBorder(new LineBorder(
                Color.decode(GlobalView.Colors.get("LIGHT_BLUE")),
                2, true));
        endDateField.setFont(new Font("Ubuntu", Font.PLAIN, 14));
        // Apply button
        applyButton.setBounds(10, 90, 250, 35);
        applyButton.setBackground(Color.decode(GlobalView.Colors.get("LIGHT_BLUE")));
        applyButton.setForeground(Color.WHITE);
        applyButton.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 14));
        applyButton.setText("Appliquer");
        tab1_1.add(label1);
        tab1_1.add(criterionBox);
        tab1_1.add(label2);
        tab1_1.add(infoField);
        tab1_1.add(label3);
        tab1_1.add(beginDateField);
        tab1_1.add(label4);
        tab1_1.add(endDateField);
        tab1_1.add(applyButton);

        // Configuration of the tab1_2
        tab1_2.setBounds(0, 155, 1270, 515);
        tab1_2.setLayout(null);
        scrollablePanel.setBackground(Color.WHITE);
        scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
        scrollablePanel.setMinimumSize(new Dimension(600, 1000));
        scrollablePanel.setPreferredSize(new Dimension(600, 1000));
        scrollPane = new JScrollPane(scrollablePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1270, 505); //modified here
        tab1_2.add(scrollPane);

        // Configuration of the main panel (tab1 here)
        tab1.setLayout(null);
        tab1.setBounds(0, 0, 1275, 680);
        tab1.setBackground(Color.WHITE);
        tab1.add(tab1_1);
        tab1.add(tab1_2);
    }


    /**
     *
     * @return criterionBox
     */
    public JComboBox getCriterionBox() {return (criterionBox);}

    /**
     *
     * @return infoField
     */
    public JTextField getInfoField() {return (infoField);}

    /**
     *
     * @return beginDateField
     */
    public JTextField getBeginDateField() {return (beginDateField);}

    /**
     *
     * @return endDateField
     */
    public JTextField getEndDateField() {return (endDateField);}

    /**
     *
     * @return applyButton
     */
    public JButton getApplyButton() {return (applyButton);}

    /**
     *
     * @return scrollablePanel
     */
    public JPanel getScrollablePanel() {return (scrollablePanel);}

    /**
     *
     * @return tab1
     */
    public JPanel getTab() {return (tab1);}
}