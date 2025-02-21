package ControllerPkg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

import DaoPkg.ClientDaoImpl;
import DaoPkg.GlobalDao;
import ViewPkg.ClientLoginView;
import ViewPkg.GlobalView;

import javax.swing.*;

public class ClientLoginController {
    // Attributes
    private final ClientLoginView clientLoginView;
    private final ClientDaoImpl clientDaoImpl;

    // Methods

    /**
     * Constructeur
     */
    public ClientLoginController()
    {
        this.clientLoginView = GlobalView.getClientLoginView();
        this.clientDaoImpl = GlobalDao.getClientDaoImpl();
    }

    /**
     * Commence l'affichage
     */
    public void start()
    {
        JTextField emailAddressField = clientLoginView.getEmailAddressField();
        JTextField passwordField = clientLoginView.getPasswordField();
        JTextField[] jTextFields = {emailAddressField, passwordField};
        JButton clientLoginButton = clientLoginView.getClientLoginButton();
        JButton clientGoToSignInButton = clientLoginView.getClientGoToSignInButton();
        JButton employeeGoToLoginButton = clientLoginView.getEmployeeGoToLoginButton();

        for (JTextField jTextField : jTextFields) {
            jTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    if (jTextField.getText().equals("  Adresse e-mail")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Mot de passe")) {
                        jTextField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    if (jTextField.equals(emailAddressField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Adresse e-mail");
                    }
                    else if (jTextField.equals(passwordField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Mot de passe");
                    }
                }
            });
        }

        clientLoginButton.addActionListener(new ActionListener() {
            /**
             * Permet de se connecter en tant que client
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String emailAddress = emailAddressField.getText();
                String password = passwordField.getText();
                if (!Objects.equals(emailAddress, "  Adresse e-mail")
                        && !Objects.equals(password, "  Mot de passe")) {
                    if (clientDaoImpl.checkAccount(emailAddress, password)) {
                        Utils.writeInFile("client_id.txt", String.valueOf(clientDaoImpl.getClientWithEmailAddress(emailAddress).getClientId()));
                        GlobalView.navigateTo("ClientMainView");
                        GlobalController.getClientMainController().start();
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Identifiants incorrects",
                                "Message", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Champs vide(s)",
                            "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clientGoToSignInButton.addActionListener(new ActionListener() {
            /**
             * Affiche l'écran Sign In
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GlobalView.navigateTo("ClientSignInView");
                (GlobalController.getClientSignInController()).start();
            }
        });

        employeeGoToLoginButton.addActionListener(new ActionListener() {
            /**
             * Affiche l'écran client Log In
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GlobalView.navigateTo("EmployeeLoginView");
                (GlobalController.getEmployeeLoginController()).start();
            }
        });

    }
}