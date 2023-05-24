package com.example.inscription.Controllers;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.OrganismeDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Add_OrganismeController {


    @FXML
    private TextField LibelleTextField;

    @FXML
    void Add_organisme(ActionEvent event) {
        OrganismeDao organismeDao = new OrganismeDao();
        if (LibelleTextField.getText().isEmpty()) {
            RoutingClass.alert("Veillez remplir tous les champs ");
        } else {
            if (!organismeDao.exists(LibelleTextField.getText().trim())) {
                Organisme organisme = new Organisme(LibelleTextField.getText().trim());
                if (organismeDao.create(organisme)) {
                    RoutingClass.success("Organisme ajouté avec succée!");
                } else {
                    RoutingClass.alert("probléme");
                }
            } else {
                RoutingClass.alert("organisme déja éxistant ");
            }
        }
    }

}



