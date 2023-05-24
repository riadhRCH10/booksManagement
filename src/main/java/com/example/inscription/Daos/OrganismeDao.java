package com.example.inscription.Daos;

import com.example.inscription.Classes.Organisme;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganismeDao implements Crud<Organisme> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public List<Organisme> findAll() {
        List<Organisme> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM organisme");

            while (resultSet.next()) {
                Organisme temp = new Organisme(resultSet.getInt("code_organisme"), resultSet.getString("libelle"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

    }

   /* public List<String> findIds() {
        List<String> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Libelle FROM organisme");

            while (resultSet.next()) {
                output.add(resultSet.getString("Libelle"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

    @Override
    public boolean create(Organisme organisme) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into organisme(Libelle) values(?) ");
            pr.setString(1, organisme.getLibelle());
            pr.executeUpdate();
            System.out.println("organisme a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Organisme organisme) {
        boolean state = false;
        try {

            pr = c.prepareStatement("DELETE FROM organisme where code_Organisme='" + organisme.getCode_organisme() + "'");
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }

    /*public int findId(String lib) {
        int output = -1;
        try {

            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT Code_organisme   FROM organisme where Libelle='" + lib + "'");
            while (resultSet.next()) {
                output = resultSet.getInt("Code_profil");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }
*/
    public boolean exists(String libelle) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from organisme where Libelle  = '" + libelle + "'");
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
    public boolean exists(Organisme organisme) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM Organisme where Libelle ='" + organisme.getLibelle() +"'");

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
    public boolean update(Organisme organisme) {
        boolean state = false;
        try {

            pr = c.prepareStatement("UPDATE organisme set Libelle=? where code_organisme=?");
            pr.setString(1, organisme.getLibelle());
            pr.setInt(2, organisme.getCode_organisme());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;

    }

}
