package com.example.inscription.Daos;

import com.example.inscription.Classes.Participation;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipationDao implements Crud<Participation> {
    Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

   /* public List<Integer> findparticipantIds() {
        List<Integer> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Matricule FROM participant");

            while (resultSet.next()) {
                output.add(resultSet.getInt("Matricule"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

 /*   public String find_intitule(int id) {
        String output = "intitule invalide";

        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  intitule FROM formation where code_formation=" + id);
            while (resultSet.next()) {
                output = resultSet.getString("intitule");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

    /*public String find_nom(int id) {
        String output = "nom invalide";

        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  Nom FROM participant where Matricule=" + id);
            while (resultSet.next()) {
                output = resultSet.getString("Nom");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }*/

    /* public List<Integer> findformationIds() {
         List<Integer> output = new ArrayList<>();
         try {
             Statement st = c.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT  code_formation FROM formation");

             while (resultSet.next()) {
                 output.add(resultSet.getInt("code_formation"));
             }
         } catch (SQLException e) {
             e.printStackTrace();
             e.getCause();

         }
         return output;
     }
 */
    @Override
    public boolean create(Participation participation) {
        boolean state;

        try {
            PreparedStatement pr = c.prepareStatement("insert into participation(Matricule, code_formation,Nom,intitule) values(?,?,?,?) ");
            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.setString(3, participation.getNom());
            pr.setString(4, participation.getIntitule());
            pr.executeUpdate();
            System.out.println("participantion a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;

    }

    @Override
    public boolean update(Participation participation) {


        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("UPDATE participation SET Matricule=?,code_formation=? where Matricule=?and code_formation=?");

            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.setInt(3, participation.getMatricule());
            pr.setInt(4, participation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public boolean delete(Participation participation) {
        boolean state = false;
        try {
            pr = c.prepareStatement("DELETE FROM participation where Matricule=? and  code_formation=?");
            pr.setInt(1, participation.getMatricule());
            pr.setInt(2, participation.getCode_formation());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return state;
    }

    @Override
    public List<Participation> findAll() {
        List<Participation> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  p.Matricule,p.Nom,f.code_formation,f.intitule FROM participation pa ,formation f,participant p where  p.Matricule=pa.Matricule and f.code_formation=pa.code_formation");

            while (resultSet.next()) {
                Participation temp = new Participation(resultSet.getInt("matricule"), resultSet.getString("nom"), resultSet.getInt("code_formation"), resultSet.getString("intitule"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

    @Override
    public boolean exists(Participation participation) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            ResultSet resultSet = st.executeQuery("SELECT  * FROM participation where Matricule=" + participation.getMatricule() + " and  code_formation=" + participation.getCode_formation() + " and  Nom='" + participation.getNom() + "' and intitule='" + participation.getIntitule() + "' ");
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
