package ControllerPkg;

import DaoPkg.GlobalDao;
import ModelPkg.Client;
import DaoPkg.ClientDaoImpl;
import ViewPkg.ClientSignInView;
import ViewPkg.GlobalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ClientSignInController {

    private final ClientSignInView clientSignInView;
    private final ClientDaoImpl clientDaoImpl;

    /**
     * Constructeur
     */
    public ClientSignInController()
    {
        this.clientSignInView = GlobalView.getClientSignInView();
        this.clientDaoImpl = GlobalDao.getClientDaoImpl();
    }

    /**
     * Commence l'affichage
     */
    void start()
    {
        JTextField firstNameField = clientSignInView.getFirstNameField();
        JTextField lastNameField = clientSignInView.getLastNameField();
        JTextField dateOfBirthField = clientSignInView.getDateOfBirthField();
        JTextField emailAddressField = clientSignInView.getEmailAddressField();
        JTextField passwordField = clientSignInView.getPasswordField();
        JTextField[] jTextFields = {firstNameField, lastNameField, dateOfBirthField,
                                    emailAddressField, passwordField};
        JButton clientGoToLoginButton = clientSignInView.getClientGoToLoginButton();
        JButton clientSignInButton = clientSignInView.getClientSignInButton();

        for (JTextField jTextField : jTextFields) {
            jTextField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent focusEvent) {
                    if (jTextField.getText().equals("  Prénom")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Nom")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Date de naissance (JJ/MM/AAAA)")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Adresse e-mail")) {
                        jTextField.setText("");
                    }
                    else if (jTextField.getText().equals("  Mot de passe")) {
                        jTextField.setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent focusEvent) {
                    if (jTextField.equals(firstNameField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Prénom");
                    }
                    else if (jTextField.equals(lastNameField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Nom");
                    }
                    else if (jTextField.equals(dateOfBirthField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Date de naissance (JJ/MM/AAAA)");
                    }
                    else if (jTextField.equals(emailAddressField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Adresse e-mail");
                    }
                    else if (jTextField.equals(passwordField) && jTextField.getText().isEmpty()) {
                        jTextField.setText("  Mot de passe");
                    }
                }
            });
        }

        clientGoToLoginButton.addActionListener(new ActionListener() {
            /**
             * Affiche l'écran Log In
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GlobalView.navigateTo("ClientLoginView");
                (GlobalController.getClientLoginController()).start();
            }
        });

        clientSignInButton.addActionListener(new ActionListener() {
            /**
             * Créer un compte
             * @param actionEvent the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstNameText = firstNameField.getText();
                String lastNameText = lastNameField.getText();
                String dateOfBirthText = dateOfBirthField.getText();
                String emailAddressText = emailAddressField.getText();
                String passwordText = passwordField.getText();

                if (!firstNameText.equals("  Prénom") && !lastNameText.equals("  Nom")
                        && !dateOfBirthText.equals("  Date de naissance")
                        && !emailAddressText.equals("  Adresse e-mail")
                        && !passwordText.equals("  Mot de passe")) {
                    if (!Utils.dateValidator(dateOfBirthText)) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Format de date invalide",
                                "Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (!Utils.emailValidator(emailAddressText)) {
                        JOptionPane.showMessageDialog(new JFrame(),
                                "Email invalide",
                                "Message", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        dateOfBirthText = Utils.dateConverter(dateOfBirthText, "DD/MM/YYYY");
                        Client client = new Client(-1, firstNameText, lastNameText,
                                dateOfBirthText, emailAddressText, passwordText);
                        if (!clientDaoImpl.checkIfClientExists(client)) {
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Compte créé",
                                    "Succès", JOptionPane.INFORMATION_MESSAGE);
                            clientDaoImpl.addClient(client);
                            GlobalView.navigateTo("ClientLoginView");
                            GlobalController.getClientLoginController().start();
                        }
                        else {
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Le client existe déjà",
                                    "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "Champs vide(s)",
                            "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
