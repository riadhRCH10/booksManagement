package com.example.inscription.Daos;

import com.example.inscription.Classes.Participant;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDao implements Crud<Participant> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Participant> findAll() {
        List<Participant> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM participant");

            while (resultSet.next()) {
                Participant temp = new Participant(resultSet.getInt("matricule"), resultSet.getString("nom"),
                        resultSet.getString("prenom"), resultSet.getDate("date_naissance"),
                        resultSet.getInt("Code_profil"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;


    }


    @Override
    public boolean update(Participant participant) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE participant SET nom=?,prenom=?,date_naissance=?,Code_profil=? where matricule=?");
            pr.setString(1, participant.getNom());
            pr.setString(2, participant.getPrenom());
            java.sql.Date datenais = new java.sql.Date(participant.getDate_naissance().getTime());
            pr.setDate(3, datenais);
            pr.setInt(4, participant.getCode_profil());
            pr.setInt(5, participant.getMatricule());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }

    @Override
    public boolean create(Participant participant) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into participant(nom,prenom,date_naissance,Code_profil) values(?,?,?,?) ");

            pr.setString(1, participant.getNom());
            pr.setString(2, participant.getPrenom());
            java.sql.Date datenais = new java.sql.Date(participant.getDate_naissance().getTime());
            pr.setDate(3, datenais);
            pr.setInt(4, participant.getCode_profil());
            pr.executeUpdate();
            System.out.println("participant a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Participant participant) {
        boolean state = false;
        try {


            pr = c.prepareStatement("DELETE FROM participant where matricule=" + participant.getMatricule());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }


    @Override
    public boolean exists(Participant participant) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM participant where matricule=" + participant.getMatricule());

            if (resultSet.next()) {
                state = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }
}
