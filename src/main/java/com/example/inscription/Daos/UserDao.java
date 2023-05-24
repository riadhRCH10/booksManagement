package com.example.inscription.Daos;

import com.example.inscription.Classes.User;
import com.example.inscription.Databaseconnection;
import com.example.inscription.Interfaces.Crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Crud<User> {
  public   Connection c = Databaseconnection.getConnection();
    PreparedStatement pr = null;

    public boolean login(User user) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where login = '" + user.getLogin() + "' and password = '" + user.getPassword() + "'");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                state = rs.getInt(1) == 1;
            }


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return state;
        //  return con.login(c, user);
    }


    @Override
    public boolean create(User user) {
        boolean state;
        try {
            //statement.executeUpdate("INSERT INTO utilisateur (login,password,full_name,role) VALUES ('" + user.getLogin() + "','" + user.getPassword() + "','" + user.getFullname() + "','" + user.getRole() + "')");
            pr = c.prepareStatement("insert into utilisateur (login,password,role) values(?,?,?)");
            // pr.setInt(1, eid);
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());
            pr.executeUpdate();
            System.out.println("L'utilisateur a été ajouté avec succès.");
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            state = false;
        }
        return state;
    }

    @Override
    public boolean update(User user) {
        boolean state = false;
        try {
            pr = c.prepareStatement("UPDATE utilisateur SET login=?,password=?,role=? where code_utilisateur=? ");
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            pr.setString(3, user.getRole());
            pr.setInt(4, user.getCodeutilisateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;


    }

    @Override
    public boolean delete(User user) {
        boolean state = false;
        try {
            java.sql.Statement st = c.createStatement();

            pr = c.prepareStatement("DELETE FROM utilisateur where code_utilisateur=" + user.getCodeutilisateur());
            pr.executeUpdate();
            state = true;
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
        return state;
    }

    @Override
    public List<User> findAll() {
        List<User> output = new ArrayList<>();
        try {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT  * FROM utilisateur");

            while (resultSet.next()) {
                User temp = new User(resultSet.getInt("code_utilisateur"), resultSet.getString("login"), resultSet.getString("password"), resultSet.getString("role"));
                output.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
        return output;
    }

    //Badalet fi condition raditha code_utilisateur
    @Override
    public boolean exists(User user) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where code_utilisateur = '" + user.getCodeutilisateur() + "'");
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

    public boolean exists(String login) {
        boolean state = false;
        try {
            pr = c.prepareStatement("select count(1) from utilisateur where login = '" + login + "'");
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
    public   boolean isAdmin(User user)
    { boolean state = false;
        try {
            pr = c.prepareStatement("select role from utilisateur where login = ? and password=?");
            pr.setString(1, user.getLogin());
            pr.setString(2, user.getPassword());
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                state = rs.getString(1).equalsIgnoreCase("admin");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }

        return state;

    }
}
