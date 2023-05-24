package com.example.inscription.Controllers;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Daos.ProfileDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_profilController {


    @FXML
    private TextField LibelleTextField;

    private boolean updated = false;

    @FXML
    void Update_domaine(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Profil profil = (Profil) stage.getUserData();
        if (!LibelleTextField.getText().isEmpty()) {
            profil.setLibelle(LibelleTextField.getText().trim());
            updated = true;
        }
        ProfileDao profileDao = new ProfileDao();
        if (updated) {
            if (!profileDao.exists(profil)) {
                if (profileDao.update(profil)) {
                    RoutingClass.success("succés");
                } else {
                    RoutingClass.alert("probléme");

                }
            } else {
                RoutingClass.alert("profil deja existant ");
            }
        } else {
            RoutingClass.alert("aucun changement détéctée");
        }

    }

}











