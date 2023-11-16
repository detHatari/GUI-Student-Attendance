package com.example.attendancesystem.login;

import com.example.attendancesystem.LoginFormApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;


import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class logincontroller {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessagelabel;

    @FXML
    private MenuButton menuButton;

    public void onLoginAs(ActionEvent event) {
        String selectedRole = menuButton.getText();

        if (selectedRole.equals("Teacher")) {
            // Handle Teacher login
        } else if (selectedRole.equals("Student")) {
            // Load StudentView.fxml for Student login
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/attendancesystem/student/StudentView.fxml"));
                Parent root = loader.load();

                // Get the controller if needed
                // StudentController studentController = loader.getController();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("Student Interface");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void onLogin(ActionEvent event) throws IOException {
        String adminUsername = "Admin";
        String adminPassword = "admin123";

        String enterUsername = usernameTextField.getText();
        String enterPassword = passwordField.getText();
        if (!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
            if (enterUsername.equals(adminUsername) && enterPassword.equals(adminPassword)) {
                loginMessagelabel.setText("You are trying to login");
                Parent root = FXMLLoader.load(LoginFormApp.class.getResource("hello-view.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("View");
                stage.setWidth(stage.getWidth());
                stage.setHeight(stage.getHeight());
                stage.setScene(scene);
                stage.show();
            } else {
                loginMessagelabel.setText("Incorrect username and password");
            }
        } else {
            loginMessagelabel.setText("Please enter username and password");
        }
    }


    public void onResgister(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/attendancesystem/login/RegistrationView.fxml"));
//        Parent root = loader.load();
//
//        // Get the controller for the registration form
//        RegistrationController registrationController = loader.getController();
//
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setTitle("User Registration");
//        stage.setScene(scene);
//        stage.show();
//    }


    }
}
