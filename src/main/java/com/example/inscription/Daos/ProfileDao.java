package com.example.inscription.Daos;

import com.example.inscription.Classes.Profil;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao implements Crud<Profil> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Profil> findAll() {
        List<Profil> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM profil");

            while (resultSet.next()) {
                Profil temp = new Profil(resultSet.getInt("code_profil"), resultSet.getString("libelle"));
                output.add(temp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

    }

 /*   public int findId(String lib) {
        int output = -1;
        try {

            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Code_profil FROM profil where Libelle='" + lib + "'");
            while (resultSet.next()) {
                output = resultSet.getInt("Code_profil");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

/*    public List<String> findIds() {
        List<String> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Libelle FROM profil");

            while (resultSet.next()) {
                output.add(resultSet.getString("Libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

    public boolean exists(String libelle) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from profil where Libelle  = '" + libelle + "'");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                state = rs.getInt(1) == 1;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }

        return state;
    }


    @Override
    public boolean create(Profil profil) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into profil(libelle) values(?) ");
            pr.setString(1, profil.getLibelle());
            pr.executeUpdate();
            System.out.println("profile a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM profil where code_profil=" + profil.getCode_profil());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }

    @Override
    public boolean exists(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM profil where  Libelle='" + profil.getLibelle() + "'");
            if (resultSet.next()) {
                state = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }


    @Override
    public boolean update(Profil profil) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE profil SET libelle=? where code_profil=? ");
            pr.setString(1, profil.getLibelle());
            pr.setInt(2, profil.getCode_profil());

            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }
}
