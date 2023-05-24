package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button sign_in;

    User user;



    public void loginButtonOnAction(ActionEvent event) throws IOException {

        if (username.getText().isBlank() || password.getText().isBlank()) {
            RoutingClass.alert("Les champs sont vides");


        } else {
            user = new User(username.getText().trim(), password.getText());
            UserDao userDao = new UserDao();
          if(userDao.c!=null)  {
                if (userDao.login(user)) {
                    if (userDao.isAdmin(user)) {
                        RoutingClass.goTo((Stage) sign_in.getScene().getWindow(), "MenuAdmin.fxml", "Menuadmin ", 736, 568);
                    } else {
                        RoutingClass.goTo((Stage) sign_in.getScene().getWindow(), "MenuUser.fxml", "MenuUser ", 770, 568);
                    }

                } else {
                    RoutingClass.alert("Login ou  mot de passe incorrect!");

                }
            }
          else {
              RoutingClass.alert("erreur de connexion à la base de données");
          }

        }
    }
}










