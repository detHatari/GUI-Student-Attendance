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
import java.util.List;


public class logincontroller {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label loginMessagelabel;


    public void onLogin(ActionEvent event) throws IOException {
        String adminUsername = "Admin";
        String adminPassword = "admin123";
        List<User> users = Userdata.loadUsers();

        String enterUsername = usernameTextField.getText();
        String enterPassword = passwordField.getText();

        if (enterUsername.isBlank() || enterPassword.isBlank()) {
            loginMessagelabel.setText("Please enter both username and password");
        } else if (enterUsername.equals(adminUsername) && enterPassword.equals(adminPassword)) {
            // Admin login
            loginMessagelabel.setText("Admin login successful");
            openMainView(event);
        } else if (users != null) {
            // User login
            boolean userAuthenticated = false;
            for (User user : users) {
                if (user.getUsername().equals(enterUsername) && user.getPassword().equals(enterPassword)) {
                    userAuthenticated = true;
                    break;
                }
            }

            if (userAuthenticated) {
                loginMessagelabel.setText("User login successful");
                openMainView(event);
            } else {
                loginMessagelabel.setText("Incorrect username or password");
            }
        }
    }
//
    private void openMainView(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("View");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();
    }


    public void onResgister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(LoginFormApp.class.getResource("RegisterView.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Register View");
        stage.setWidth(stage.getWidth());
        stage.setHeight(stage.getHeight());
        stage.setScene(scene);
        stage.show();




    }
}


