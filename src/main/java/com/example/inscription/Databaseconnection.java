package com.example.inscription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Databaseconnection {


    public static Connection getConnection() {
        Connection databaselink = null;
        String url = "jdbc:mysql://localhost/db_formation";
        String user = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaselink = DriverManager.getConnection(url, user, password);
            System.out.println("connexion établie.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erreur de connexion !");
            e.printStackTrace();
            e.getCause();
        }
        return databaselink;
    }


}




