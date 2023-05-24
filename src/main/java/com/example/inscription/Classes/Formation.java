package com.example.inscription.Classes;

public class Formation {
    private int code_formation, nombre_jours, annee, mois, nombre_participants, Code_formateur, code_domaine;
    private String intitule;

    public int getCode_formation() {
        return code_formation;
    }

    public void setCode_formation(int code_formation) {
        this.code_formation = code_formation;
    }

    public int getNombre_jours() {
        return nombre_jours;
    }

    public void setNombre_jours(int nombre_jours) {
        this.nombre_jours = nombre_jours;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getNombre_participants() {
        return nombre_participants;
    }

    public void setNombre_participants(int nombre_participants) {
        this.nombre_participants = nombre_participants;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCode_formateur() {
        return Code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        Code_formateur = code_formateur;
    }

    public int getCode_domaine() {
        return code_domaine;
    }

    public void setCode_domaine(int code_domaine) {
        this.code_domaine = code_domaine;
    }

    @Override
    public String toString() {
        return intitule;

    }

    public Formation(int nombre_jours, int annee, int mois, int nombre_participants, String intitule, int Code_formateur, int code_domaine) {
        this.nombre_jours = nombre_jours;
        this.annee = annee;
        this.mois = mois;
        this.nombre_participants = nombre_participants;
        this.intitule = intitule;
        this.Code_formateur = Code_formateur;
        this.code_domaine = code_domaine;
    }

    public Formation(int code_formation, int nombre_jours, int annee, int mois, int nombre_participants, String intitule, int Code_formateur, int code_domaine) {
        this.code_formation = code_formation;
        this.nombre_jours = nombre_jours;
        this.annee = annee;
        this.mois = mois;
        this.nombre_participants = nombre_participants;
        this.intitule = intitule;
        this.Code_formateur = Code_formateur;
        this.code_domaine = code_domaine;
    }

    public Formation(int code_formation) {
        this.code_formation = code_formation;


    }
}
