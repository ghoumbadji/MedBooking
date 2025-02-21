package ControllerPkg;

public class GlobalController {
    private static final ClientLoginController clientLoginController = new ClientLoginController();
    private static final ClientSignInController clientSignInController = new ClientSignInController();
    private static final ClientMainController clientMainController = new ClientMainController();
    private static final EmployeeLoginController employeeLoginController = new EmployeeLoginController();
    private static final EmployeeMainController employeeMainController = new EmployeeMainController();


    // Getters

    /**
     * Retourne clientLoginController
     * @return clientLoginController
     */
    public static ClientLoginController getClientLoginController()
    {
        return (clientLoginController);
    }

    /**
     * Retourne clientSignInController
     * @return clientSignInController
     */
    public static ClientSignInController getClientSignInController()
    {
        return (clientSignInController);
    }

    /**
     * Retourne clientMainController
     * @return clientMainController
     */
    public static ClientMainController getClientMainController()
    {
        return (clientMainController);
    }

    /**
     * Retourne employeeLoginController
     * @return employeeLoginController
     */
    public static EmployeeLoginController getEmployeeLoginController()
    {
        return (employeeLoginController);
    }

    /**
     * Retourne employeeMainController
     * @return employeeMainController
     */
    public static EmployeeMainController getEmployeeMainController() {return (employeeMainController);}
}