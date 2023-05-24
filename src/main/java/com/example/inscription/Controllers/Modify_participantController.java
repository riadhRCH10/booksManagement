package com.example.inscription.Controllers;

import com.example.inscription.Classes.Participant;
import com.example.inscription.Classes.Profil;
import com.example.inscription.Controllers.RoutingClass;
import com.example.inscription.Daos.ParticipantDao;
import com.example.inscription.Daos.ProfileDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.Date;

public class Modify_participantController {
    ProfileDao profileDao = new ProfileDao();

    @FXML
    ObservableList<Profil> list = FXCollections.observableArrayList(profileDao.findAll());

    @FXML
    private Button BtnModifierParticipant;

    @FXML
    private ChoiceBox<Profil> CodeprofileChoiceBox;

    @FXML
    private DatePicker DatePicker;

    @FXML
    private TextField NomTextField;

    @FXML
    private TextField PrenomTextField;
    @FXML
    private TextField IDTextField;

    @FXML
    private void initialize() {
        CodeprofileChoiceBox.setItems(list);

    }

    @FXML
    void Modify_participant(ActionEvent event) {
        Boolean updated=false;
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Participant participant = (Participant) stage.getUserData();
        /*Participant participant = new Participant(Integer.parseInt(IDTextField.getText()),NomTextField.getText(),
                PrenomTextField.getText() , Date.from(DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Integer.parseInt(CodeprofileChoiceBox.getValue()));*/
        if (!NomTextField.getText().isEmpty()) {
            participant.setNom(NomTextField.getText().trim());
        }
        if (!PrenomTextField.getText().isEmpty()) {
            participant.setPrenom(PrenomTextField.getText().trim());
        }

        if (DatePicker.getValue()!=null) {
            participant.setDate_naissance(Date.from(DatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        }
        if (CodeprofileChoiceBox.getSelectionModel().getSelectedIndex() > -1) {
            participant.setCode_profil(CodeprofileChoiceBox.getSelectionModel().getSelectedItem().getCode_profil());
        }

       if ( (CodeprofileChoiceBox.getSelectionModel().getSelectedIndex() < 0)&&(DatePicker.getValue()==null)&&(PrenomTextField.getText().isEmpty())&&(NomTextField.getText().isEmpty())){
           RoutingClass.alert("veillez appliquez des modifications");

        }
       else
        {  ParticipantDao participantDao = new ParticipantDao();
            if (participantDao.update(participant)) {
                RoutingClass.success("succés");
            } else {
                RoutingClass.alert("probléme");

            }
        }

    }

}

