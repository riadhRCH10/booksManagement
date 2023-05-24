package com.example.inscription.Controllers;

import com.example.inscription.Classes.User;
import com.example.inscription.Daos.UserDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_userController {

    @FXML
    ObservableList<String> list = FXCollections.observableArrayList("Admin", "User");
    @FXML
    ChoiceBox roleChoiceBox;
    @FXML
    TextField EmaillTextField, passwordTextField;

    @FXML
    Label successLabel;

    @FXML
    private void initialize() {
        roleChoiceBox.setItems(list);
        roleChoiceBox.setValue("Role");
        successLabel.setText("");
    }


    public void Update_user(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        User user = (User) stage.getUserData();
        if (!EmaillTextField.getText().isEmpty()) {
            user.setLogin(EmaillTextField.getText().trim());
        }
        if (!passwordTextField.getText().isEmpty()) {
            user.setPassword(passwordTextField.getText().trim());
        }
        if (roleChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            user.setRole(roleChoiceBox.getSelectionModel().getSelectedItem().toString());
        }
        if ((EmaillTextField.getText().isEmpty()) && (passwordTextField.getText().isEmpty()) && (roleChoiceBox.getSelectionModel().getSelectedIndex() < 0)) {
            RoutingClass.alert("veillez appliquez des modifications");
        } else {
            UserDao userDao = new UserDao();
            if (userDao.update(user)) {
              RoutingClass.success("succés");

            } else {
                successLabel.setText("probléme");
            }
        }

    }
}
