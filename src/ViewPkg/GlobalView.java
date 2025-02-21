package ViewPkg;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GlobalView {
    // Colors in a map
    static HashMap<String, String> Colors = new HashMap<String, String>();
    static {
        Colors.put("LIGHT_WHITE", "#F2FAFD"); // generally used for the background
        Colors.put("LIGHT_BLUE", "#107ACA");
        Colors.put("BLAND_BLUE", "#C9F3FF");
        Colors.put("DARK_BLUE", "#00264C");
        Colors.put("ORANGE", "#F3BE41");
        Colors.put("BLACK", "#00264C");
    }

    // Graphic main elements (frame, layout and container)
    private static final JFrame frame = new JFrame("MedBooking");
    private static final CardLayout cardLayout = new CardLayout();
    private static final Container container = frame.getContentPane();


    // Private static final instances of all the views
    private static final ClientLoginView clientLoginView = new ClientLoginView();
    private static final ClientSignInView clientSignInView = new ClientSignInView();
    private static final ClientMainView clientMainView = new ClientMainView();
    private static final EmployeeLoginView employeeLoginView = new EmployeeLoginView();
    private static final EmployeeMainView employeeMainView = new EmployeeMainView();


    static {
        // Main container settings
        container.setLayout(cardLayout);

        // Add all views to the main container
        container.add("ClientLoginView", clientLoginView.getMainPanel());
        container.add("ClientSignInView", clientSignInView.getMainPanel());
        container.add("ClientMainView", clientMainView.getMainPanel());
        container.add("EmployeeLoginView", employeeLoginView.getMainPanel());
        container.add("EmployeeMainView", employeeMainView.getMainPanel());
    }

    // Getters of all views

    /**
     * Retourne clientLoginView
     * @return clientLoginView
     */
    public static ClientLoginView getClientLoginView()
    {
        return (clientLoginView);
    }

    /**
     * Retourne clientSignInView
     * @return clientSignInView
     */
    public static ClientSignInView getClientSignInView()
    {
        return (clientSignInView);
    }

    /**
     * Retourne clientMainView
     * @return clientMainView
     */
    public static ClientMainView getClientMainView()
    {
        return (clientMainView);
    }

    /**
     * Retourne employeeLoginView
     * @return employeeLoginView
     */
    public static EmployeeLoginView getEmployeeLoginView()
    {
        return (employeeLoginView);
    }

    /**
     * Retourne employeeMainView
     * @return employeeMainView
     */
    public static EmployeeMainView getEmployeeMainView()
    {
        return (employeeMainView);
    }

    /**
     * Permet de naviguer entre les écrans
     */
    public static void navigateTo(String viewName)
    {
        cardLayout.show(container, viewName);
    }

    /**
     * Affichage principal
     */
    public static void run()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setSize(1300, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}