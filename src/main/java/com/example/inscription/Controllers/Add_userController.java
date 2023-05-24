package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Add_userController {
    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("Admin", "User");
    @FXML
    Label successLabel;

    @FXML
    TextField emailTextField, passwordTextField;
    @FXML
    ChoiceBox roleChoiceBox;


    @FXML
    private void initialize() {
        roleChoiceBox.setItems(list);
        roleChoiceBox.setValue("Role");
        successLabel.setText("");
    }


    public void Ajouter_user(ActionEvent event) {


        User user = new User(emailTextField.getText().trim(), passwordTextField.getText().trim(), roleChoiceBox.getSelectionModel().getSelectedItem().toString());
        UserDao userDao = new UserDao();
        if ((emailTextField.getText().isEmpty()) || (passwordTextField.getText().isEmpty()) || (roleChoiceBox.getSelectionModel().getSelectedIndex() < 0)) {
            RoutingClass.alert("Veillez remplir tous les champs ");
        } else {
            if (!(userDao.exists(emailTextField.getText().trim()))) {
                if (userDao.create(user)) {
                    //successLabel.setText("success");
                    RoutingClass.success("l'utilisateur  ajouté avec succée!");
                } else {
                    successLabel.setText("probléme");

                }
            } else {
                RoutingClass.alert("Username éxistant ");

            }
        }
    }
}
