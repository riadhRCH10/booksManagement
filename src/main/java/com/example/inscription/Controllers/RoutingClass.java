package com.example.inscription.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.Alert.AlertType.ERROR;
import static javafx.scene.control.Alert.AlertType.INFORMATION;
import static javafx.scene.control.ButtonType.OK;

public class RoutingClass extends Application {
    /*
    fonction d'envoie  avec la specification du stage, le chemain du fxml, le titre de la scene et les dimensions
     */
    public static void goTo(Stage stage, String fileName, String title, float width, float height) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        stage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        Scene scene = new Scene(signUp, width, height);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

    /*
    fonction d'envoie  avec la specification du stage, le chemain du fxml, le titre de la scene et les dimensions  avec evnoi de données entre les stages
     */
    public static void goTo(Stage stage, String fileName, String title, float width, float height, Object data) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene scene = new Scene(signUp, width, height);
        stage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        //This line gets the stage information
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setUserData(data);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }

    /*
fonction d'envoie  avec la creation  du nouveau  stage, le chemain du fxml, le titre de la scene et les dimensions
 */
    public static void goTo(String fileName, String title, float width, float height, Object data) throws IOException {
        Stage SecondStage = new Stage();
        SecondStage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        Pane root = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene sceneX = new Scene(root, width, height);
        sceneX.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        SecondStage.setScene(sceneX);
        SecondStage.setUserData(data);
        SecondStage.setTitle(title);
        SecondStage.setResizable(false);
        SecondStage.show();
    }
    /*
fonction d'envoie  avec la specification du stage, le chemain du fxml, le titre de la scene avec des tailles par defaut
 */

    public static void goTo(Stage stage, String fileName, String title) throws IOException {
        Parent signUp = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene scene = new Scene(signUp, 1500, 870);
        scene.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        //This line gets the stage information
        stage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        stage = (Stage) stage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /*
    fonction d'envoie  avec  creation du nouveau stage, le chemain du fxml, le titre de la scene et les dimensions
     */
    public static void goTo(String fileName, String title, float width, float height) throws IOException {
        Stage SecondStage = new Stage();
        SecondStage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        Pane root = FXMLLoader.load(RoutingClass.class.getResource("/views/" + fileName));
        Scene sceneX = new Scene(root, width, height);
        sceneX.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        SecondStage.setScene(sceneX);
        SecondStage.setTitle(title);
        SecondStage.show();
    }

    /*   public static void MsgErreur(Label label) {
           FadeTransition ft = new FadeTransition(Duration.millis(1000), label);
           ft.setFromValue(0.0);
           ft.setToValue(1);
           ft.play();
       }*/
/*
creation d'un popup  d'erreur avec un texte en parametre
 */
    public static void alert(String alertText) {
        Alert alert = new Alert(ERROR, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
    }

    /*
creation d'un popup  d'infotmation  avec un texte en parametre
 */
    public static void success(String alertText) {
        Alert alert = new Alert(INFORMATION, alertText, OK);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(RoutingClass.class.getResource("/views/login.css").toExternalForm());
        dialogPane.getStyleClass().add("myDialog");
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*
 l'interface de demarrage
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(this.getClass().getResource("/views/login.fxml"));
        Scene sceneX = new Scene(root, 450, 550);
        sceneX.getStylesheets().addAll(this.getClass().getResource("/views/login.css").toExternalForm());
        primaryStage.getIcons().add(new Image(RoutingClass.class.getResourceAsStream("/Images/logo.png")));
        primaryStage.setScene(sceneX);
        primaryStage.setTitle("Sign in");
        primaryStage.setResizable(false);
        primaryStage.show();

    }


}