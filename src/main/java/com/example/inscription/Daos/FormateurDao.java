package com.example.inscription.Daos;

import com.example.inscription.Classes.Formateur;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormateurDao implements Crud<Formateur> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public boolean create(Formateur formateur) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pr = c.prepareStatement("insert into formateur(Nom,Prenom,Email,Code_organisme,code_domaine,N_tel) values(?,?,?,?,?,?) ");
            pr.setString(1, formateur.getNom());
            pr.setString(2, formateur.getPrenom());
            pr.setString(3, formateur.getEmail());
            pr.setInt(4, formateur.getCode_organisme());
            pr.setInt(5, formateur.getCode_domaine());
            pr.setInt(6,formateur.getN_tel());
            pr.executeUpdate();
            System.out.println("formateur a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean update(Formateur formateur) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE formateur SET Nom=?,Prenom=?,Email=?,N_tel=?,Code_organisme=?,code_domaine=?   where Code_formateur=?");
            pr.setString(1, formateur.getNom());
            pr.setString(2, formateur.getPrenom());
            pr.setString(3, formateur.getEmail());
            pr.setInt(4, formateur.getN_tel());
            pr.setInt(5, formateur.getCode_organisme());
            pr.setInt(6, formateur.getCode_domaine());
            pr.setInt(7, formateur.getCode_formateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }

    @Override
    public boolean delete(Formateur formateur) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM formateur where Code_formateur=" + formateur.getCode_formateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Formateur> findAll() {
        List<Formateur> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM formateur");

            while (resultSet.next()) {
                Formateur temp = new Formateur(resultSet.getInt("code_formateur"), resultSet.getInt("n_tel"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"), resultSet.getInt("Code_organisme"), resultSet.getInt("code_domaine"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

   /* public List<Integer> findIds()
    {
        List<Integer> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Code_formateur FROM formateur");

            while (resultSet.next()) {
              //  int temp = new Formateur(resultSet.getInt("code_formateur"), resultSet.getInt("n_tel"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"), resultSet.getInt("Code_organisme"), resultSet.getInt("code_domaine"));
                output.add(resultSet.getInt("Code_formateur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }
*/
    @Override
    public boolean exists(Formateur formateur) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM formateur where Code_formateur=" + formateur.getCode_formateur());

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
