package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Daos.DomainDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class  Add_domaineController {

    @FXML
    TextField LibelleTextField;

    @FXML
    public void Add_domain(ActionEvent event) {

        DomainDao domainDao = new DomainDao();
        if (LibelleTextField.getText().isEmpty()) {
            RoutingClass.alert("Veillez remplir tous les champs ");
        } else {
            if (!domainDao.exists(LibelleTextField.getText().trim())) {
                Domaine domaine = new Domaine(LibelleTextField.getText().trim());
                if (domainDao.create(domaine)) {
                    RoutingClass.success("Domain ajoutée avec succée !");
                } else {
                    RoutingClass.alert("probléme");

                }
            } else {
                RoutingClass.alert("domain deja existant");
            }
        }

    }

}
