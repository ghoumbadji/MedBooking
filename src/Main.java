import ControllerPkg.GlobalController;
import ViewPkg.GlobalView;

public class Main {
    /**
     * Fonction principale
     * @param args
     */
    public static void main(String[] args)
    {
        GlobalView.run();

        GlobalController.getClientLoginController().start();
    }
}