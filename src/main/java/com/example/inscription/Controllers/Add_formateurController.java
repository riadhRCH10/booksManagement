package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Organisme;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.OrganismeDao;
import com.mysql.cj.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_formateurController {
    OrganismeDao organismeDao = new OrganismeDao();
    DomainDao domainDao = new DomainDao();

    @FXML
    ObservableList<Organisme> list = FXCollections.observableArrayList(organismeDao.findAll());
    @FXML
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());


    @FXML
    private ChoiceBox<Domaine> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Organisme> CodeorganismeChoiceBox;

    @FXML
    private TextField EmailTextField;

    @FXML
    private TextField NomTextField;

    @FXML
    private TextField NumtelTextField;

    @FXML
    private TextField PrenomTextField;

    @FXML
    private void initialize() {
        CodeorganismeChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }

    @FXML
    void Add_Formateur(ActionEvent event) {
        /*  */
        if ((EmailTextField.getText().isEmpty()) || (PrenomTextField.getText().isEmpty()) || (NomTextField.getText().isEmpty()) || (NumtelTextField.getText().isEmpty()) || (CodedomaineChoiceBox.getSelectionModel().getSelectedIndex() < 0) || (CodeorganismeChoiceBox.getSelectionModel().getSelectedIndex() < 0)) {

            RoutingClass.alert("veillez remplir toutes les champs ");
        } else {
            if (!StringUtils.isStrictlyNumeric(NumtelTextField.getText())) {
                RoutingClass.alert("le numero de tel doit strictement contient un nombre ");
            } else {
                if (NumtelTextField.getText().length() != 8) {
                    RoutingClass.alert("le numero de tel doit de taille 8 ");
                } else {
                    Formateur formateur = new Formateur(Integer.parseInt(NumtelTextField.getText()), NomTextField.getText(),
                            PrenomTextField.getText(), EmailTextField.getText(), CodeorganismeChoiceBox.getValue().getCode_organisme(),
                            CodedomaineChoiceBox.getValue().getCode_domaine());
                    FormateurDao formateurDao = new FormateurDao();
                    if (formateurDao.create(formateur)) {
                        RoutingClass.success("Formateur ajouté avec succée!");
                    } else {
                        RoutingClass.alert("probléme");


                    }

                }
            }
        }


    }

}
