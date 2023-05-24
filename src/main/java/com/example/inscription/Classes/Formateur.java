package com.example.inscription.Classes;

public class Formateur {
    private  int code_formateur,n_tel,Code_organisme,code_domaine;
    private String nom,prenom,email;

    public int getCode_formateur() {
        return code_formateur;
    }

    public void setCode_formateur(int code_formateur) {
        this.code_formateur = code_formateur;
    }

    public int getN_tel() {
        return n_tel;
    }

    public void setN_tel(int n_tel) {
        this.n_tel = n_tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCode_organisme() {
        return Code_organisme;
    }

    @Override
    public String toString() {
        return nom + "  " + prenom;
    }

    public void setCode_organisme(int code_organisme) {
        Code_organisme = code_organisme;
    }

    public int getCode_domaine() {
        return code_domaine;
    }

    public void setCode_domaine(int code_domaine) {
        this.code_domaine = code_domaine;
    }

    public Formateur(int n_tel, String nom, String prenom, String email,int code_organisme, int code_domaine) {
        this.n_tel = n_tel;
        Code_organisme = code_organisme;
        this.code_domaine = code_domaine;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Formateur(int code_formateur, int n_tel, String nom, String prenom, String email, int code_organisme, int code_domaine) {
        this.code_formateur = code_formateur;
        this.n_tel = n_tel;
        Code_organisme = code_organisme;
        this.code_domaine = code_domaine;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }
    public Formateur(int code_formateur)
    {        this.code_formateur = code_formateur;


    }
}
