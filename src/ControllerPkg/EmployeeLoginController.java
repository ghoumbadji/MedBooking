package ControllerPkg;

import DaoPkg.EmployeeDaoImpl;
import DaoPkg.GlobalDao;
import ViewPkg.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class EmployeeLoginController
{
    // Attributes
    private final EmployeeLoginView employeeLoginView;
    private final EmployeeDaoImpl employeeDaoImpl;

    // Methods

    /**
     * Constructeur
     */
    public EmployeeLoginController()
    {
        this.employeeLoginView = GlobalView.getEmployeeLoginView();
        this.employeeDaoImpl = GlobalDao.getEmployeeDaoImpl();
    }

    /**
     * Commence l'affichage
     */
    void start()
    {
        JButton clientGoLoginButton = employeeLoginView.getClientGoToLoginButton();
        JTextField emailAddressField = employeeLoginView.getEmailAddressField();
        JTextField passwordField = employeeLoginView.getPasswordField();
        JTextField[] jTextFields = {emailAddressField, passwordField};
        JButton employeeLoginButton = employeeLoginView.getEmployeeLoginButton();

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

        clientGoLoginButton.addActionListener(new ActionListener() {
            /**
             * Affiche la page employé Log In
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GlobalView.navigateTo("ClientLoginView");
                GlobalController.getClientLoginController().start();
            }
        });

        employeeLoginButton.addActionListener(new ActionListener() {
            /**
             * Permet de se connecter en tant qu'employé
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String emailAddress = emailAddressField.getText();
                String password = passwordField.getText();
                if (!Objects.equals(emailAddress, "  Adresse e-mail")
                        && !Objects.equals(password, "  Mot de passe")) {
                    if (employeeDaoImpl.checkAccount(emailAddress, password)) {
                        GlobalView.navigateTo("EmployeeMainView");
                        GlobalController.getEmployeeMainController().start();
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
    }
}
