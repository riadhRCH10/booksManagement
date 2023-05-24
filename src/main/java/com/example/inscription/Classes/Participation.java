package com.example.inscription.Classes;

public class Participation {
    private int matricule, code_formation;
    private String nom, intitule;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getCode_formation() {
        return code_formation;
    }

    public void setCode_formation(int code_formation) {
        this.code_formation = code_formation;
    }

    public Participation(int matricule, String nom, int code_formation, String intitule) {
        this.matricule = matricule;
        this.code_formation = code_formation;
        this.nom = nom;
        this.intitule = intitule;
    }

    public Participation(int matricule, int code_formation) {
        this.matricule = matricule;
        this.code_formation = code_formation;
    }
}
