module com.example.inscription {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.jetbrains.annotations;
    requires mysql.connector.java;

    opens com.example.inscription to javafx.fxml;
    exports com.example.inscription;
    exports com.example.inscription.Classes;
    opens com.example.inscription.Classes to javafx.fxml;
    exports com.example.inscription.Controllers;
    opens com.example.inscription.Controllers to javafx.fxml;


    //exports com.example.inscription.Controllers;
    //opens com.example.inscription.Controllers to javafx.fxml;


}