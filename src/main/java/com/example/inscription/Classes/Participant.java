package com.example.inscription.Classes;

import java.util.Date;

public class Participant {
    private int matricule, Code_profil;

    private String nom, prenom;
    private Date date_naissance;

    @Override
    public String toString() {
        return nom + "  " + prenom;
    }


    public Participant(int matricule, String nom, String prenom, Date date_naissance, int code_profil) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.Code_profil = code_profil;
    }

    public Participant(String nom, String prenom, Date date_naissance, int code_profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.Code_profil = code_profil;
        this.date_naissance = date_naissance;
    }

    public Participant(int matricule) {
        this.matricule = matricule;

    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getCode_profil() {
        return Code_profil;
    }

    public void setCode_profil(int code_profil) {
        Code_profil = code_profil;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }


}
