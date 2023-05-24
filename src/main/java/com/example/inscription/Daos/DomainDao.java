package com.example.inscription.Daos;

import com.example.inscription.Classes.Domaine;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomainDao implements Crud<Domaine> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;


    /*public int findId(String lib) {
        int output = -1;
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  code_domaine FROM domaine where Libelle='" + lib+"'");
            while (resultSet.next()) {
                output = resultSet.getInt("code_domaine");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/
    public List<Domaine> findAll() {
        List<Domaine> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT code_domaine, libelle FROM domaine");

            while (resultSet.next()) {
                Domaine temp = new Domaine(resultSet.getInt("code_domaine"), resultSet.getString("libelle"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

    }

   /* public List<String> findIds()
    {
        List<String> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Libelle FROM domaine");

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
    public boolean create(Domaine domaine) {
        boolean state;

        try {
            //   java.sql.Statement st = c.createStatement();
            PreparedStatement pst = c.prepareStatement("insert into domaine(Libelle) values(?) ");
            pst.setString(1, domaine.getLibelle());
            pst.executeUpdate();
            System.out.println("domain a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean delete(Domaine domaine) {
        boolean state = false;
        try {
            pr = c.prepareStatement("DELETE FROM domaine where code_domaine=" + domaine.getCode_domaine());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }

    @Override
    public boolean exists(Domaine domaine) {
        boolean state = false;
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM domaine where Libelle ='" + domaine.getLibelle()+"'");

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
    public boolean update(Domaine domaine) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE domaine SET libelle=?    where code_domaine=?");
            pr.setString(1, domaine.getLibelle());
            pr.setInt(2, domaine.getCode_domaine());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;

    }
    public boolean exists(String libelle) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from domaine where Libelle  = '" + libelle + "'");
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
}
