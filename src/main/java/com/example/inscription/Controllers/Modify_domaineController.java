package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Modify_domaineController {
    boolean updated = false;
    @FXML
    private TextField LibelleTextField;

    @FXML
    public void Update_domaine(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Domaine domaine = (Domaine) stage.getUserData();
        if ((!LibelleTextField.getText().isEmpty()) && (!domaine.getLibelle().equalsIgnoreCase(LibelleTextField.getText().trim()))) {
            domaine.setLibelle(LibelleTextField.getText().trim());
            updated = true;
        }

        DomainDao domaineDao = new DomainDao();
        if (updated) {
            if (!domaineDao.exists(domaine)) {
                if (domaineDao.update(domaine)) {
                    RoutingClass.success("succés");

                } else {
                    RoutingClass.alert("probléme");

                }
            } else {
                RoutingClass.alert("domaine déja éxistant");
            }
        } else {
            RoutingClass.alert("aucun changement détéctée");
        }

    }
}
