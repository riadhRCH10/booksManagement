package com.example.inscription.Daos;

import com.example.inscription.Classes.Formation;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormationDao implements Crud<Formation> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    @Override
    public boolean create(Formation formation) {
        boolean state;

        try {
            PreparedStatement pr = c.prepareStatement("insert into formation(nombre_jour,annee,mois,nombre_participant,intitule,Code_formateur,code_domaine) values(?,?,?,?,?,?,?) ");
            pr.setInt(1, formation.getNombre_jours());
            pr.setInt(2, formation.getAnnee());
            pr.setInt(3, formation.getMois());
            pr.setInt(4, formation.getNombre_participants());
            pr.setString(5, formation.getIntitule());
            pr.setInt(6, formation.getCode_formateur());
            pr.setInt(7, formation.getCode_domaine());
            pr.executeUpdate();
            System.out.println("formation a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean update(Formation formation) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE formation set intitule =?, nombre_jour=? ,annee=?,mois=?,nombre_participant=?,Code_formateur=?,code_domaine=? where  code_formation=?");
            pr.setString(1, formation.getIntitule());
            pr.setInt(2, formation.getNombre_jours());
            pr.setInt(3, formation.getAnnee());
            pr.setInt(4, formation.getMois());
            pr.setInt(5, formation.getNombre_participants());
            pr.setInt(6, formation.getCode_formateur());
            pr.setInt(7, formation.getCode_domaine());
            pr.setInt(8, formation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;
    }

    @Override
    public boolean delete(Formation formation) {
        boolean state = false;
        try {
            pr = c.prepareStatement("DELETE FROM formation where code_formation=" + formation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Formation> findAll() {
        List<Formation> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM formation ");

            while (resultSet.next()) {
                Formation temp = new Formation(resultSet.getInt("code_formation"), resultSet.getInt("nombre_jour"), resultSet.getInt("annee"),
                        resultSet.getInt("mois"), resultSet.getInt("nombre_participant"), resultSet.getString("intitule"), resultSet.getInt("Code_formateur"), resultSet.getInt("code_domaine"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;

    }

    @Override
    public boolean exists(Formation formation) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM formation where code_formation=" + formation.getCode_formation());

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
