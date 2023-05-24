package com.example.inscription.Classes;

public class Domaine {
    private int code_domaine;
    private String libelle;

    public Domaine(String libelle) {
        this.libelle = libelle;
    }

    public Domaine(int code_domaine, String libelle) {
        this.code_domaine = code_domaine;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }

    public int getCode_domaine() {
        return code_domaine;
    }

    public void setCode_domaine(int code_domaine) {
        this.code_domaine = code_domaine;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
