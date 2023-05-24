package com.example.inscription.Classes;

public class Organisme {
    private int code_organisme;
    private String libelle;

    public int getCode_organisme() {
        return code_organisme;
    }

    public void setCode_organisme(int code_organisme) {
        this.code_organisme = code_organisme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Organisme(String libelle) {

        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }

    public Organisme(int code_organisme, String libelle) {
        this.code_organisme = code_organisme;
        this.libelle = libelle;
    }
}
