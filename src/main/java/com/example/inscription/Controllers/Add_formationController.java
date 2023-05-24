package com.example.inscription.Controllers;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Classes.Formateur;
import com.example.inscription.Classes.Formation;
import com.example.inscription.Daos.DomainDao;
import com.example.inscription.Daos.FormateurDao;
import com.example.inscription.Daos.FormationDao;
import com.mysql.cj.util.StringUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Add_formationController {
    FormateurDao formateurDao = new FormateurDao();
    DomainDao domainDao = new DomainDao();

    @FXML
    ObservableList<Formateur> list = FXCollections.observableArrayList(formateurDao.findAll());
    @FXML
    ObservableList<Domaine> list1 = FXCollections.observableArrayList(domainDao.findAll());

    @FXML
    private ChoiceBox<Domaine> CodedomaineChoiceBox;

    @FXML
    private ChoiceBox<Formateur> CodeformateurChoiceBox;

    @FXML
    private TextField NbParticipantTextField;

    @FXML
    private TextField NbjourTextField;

    @FXML
    private TextField anneeTextField;

    @FXML
    private TextField intituleTextField;

    @FXML
    private TextField moisTextField;

    @FXML
    private void initialize() {
        CodeformateurChoiceBox.setItems(list);
        CodedomaineChoiceBox.setItems(list1);

    }

    @FXML
    void Add_Formation(ActionEvent event) {
        String nbjours = NbjourTextField.getText();
        String annee = anneeTextField.getText();
        String mois = moisTextField.getText();
        String nbpart = NbParticipantTextField.getText();
        String intitule = intituleTextField.getText();
        Formateur codeF = CodeformateurChoiceBox.getValue();
        Domaine codeD = CodedomaineChoiceBox.getValue();
        if ((nbjours.isEmpty()) || (annee.isEmpty()) || (mois.isEmpty()) || (nbpart.isEmpty()) || (intitule.isEmpty())) {
            RoutingClass.alert("veillez remplir toutes les champs ");


        } else {
            if ((!StringUtils.isStrictlyNumeric(nbjours)) || (!StringUtils.isStrictlyNumeric(annee)) || (!StringUtils.isStrictlyNumeric(mois)) || (!StringUtils.isStrictlyNumeric(nbpart)) || (CodedomaineChoiceBox.getValue() == null) || (CodeformateurChoiceBox.getValue() == null)) {
                RoutingClass.alert("le nombre jours/annee/mois/nombre participants doit strictement contient un nombre ");

            } else {
                if (annee.length() != 4) {
                    RoutingClass.alert("le champs annee de etre de taille 4");
                } else {
                    if ((Integer.parseInt(mois) > 12) || (Integer.parseInt(mois) < 1)) {
                        RoutingClass.alert("le mois doit entre entre 1 et 12 ");
                    } else {
                        if (Integer.parseInt(nbpart) < 4) {
                            RoutingClass.alert("la formation doit contenir au minimum 4 participant ");
                        } else {
                            Formation formation = new Formation(Integer.parseInt(nbjours), Integer.parseInt(annee), Integer.parseInt(mois), Integer.parseInt(nbpart), intitule, codeF.getCode_formateur(), codeD.getCode_domaine());
                            FormationDao formationDao = new FormationDao();
                            if (formationDao.create(formation)) {
                                RoutingClass.success("Formation ajouté avec succée!");
                            } else {
                                RoutingClass.alert("probléme");


                            }
                        }
                    }
                }
            }

        }


    }
}
