package com.example.inscription.Controllers;

import com.example.inscription.Classes.Formation;
import com.example.inscription.Classes.Participant;
import com.example.inscription.Classes.Participation;
import com.example.inscription.Daos.ParticipantDao;
import com.example.inscription.Daos.ParticipationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Add_participationController {
    ParticipantDao participantDao = new ParticipantDao();

    @FXML
    ObservableList<Participant> list1 = FXCollections.observableArrayList(participantDao.findAll());

    @FXML
    private ChoiceBox<Participant> listIdParticipant;


    @FXML
    private void initialize() {
        listIdParticipant.setItems(list1);

    }

    @FXML
    void Add_participation(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Formation formation = (Formation) stage.getUserData();
        if (listIdParticipant.getSelectionModel().getSelectedIndex() < 0) {
            RoutingClass.alert("Veillez choisir un participant");
        } else {
            Participation participation = new Participation(listIdParticipant.getValue().getMatricule(), listIdParticipant.getValue().getNom(),
                    formation.getCode_formation(), formation.getIntitule());
            ParticipationDao participationDao = new ParticipationDao();

            if (!participationDao.exists(participation)) {
                if (participationDao.create(participation)) {
                    RoutingClass.success("une participation ajouté avec succée!");
                } else {
                    RoutingClass.alert("probléme!");
                }
            } else {
                RoutingClass.alert("Participant déja affecter!");

            }
        }

    }

}
