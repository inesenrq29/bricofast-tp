package com.bricofast.model;

public class Outil {

    private int id;
    private String nom;
    private double prixParJour;
    private boolean disponibilite;


    public Outil(int id, String nom, double prixParJour, boolean disponibilite) {
        this.id = id;
        this.nom = nom;
        this.prixParJour = prixParJour;
        this.disponibilite = disponibilite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

