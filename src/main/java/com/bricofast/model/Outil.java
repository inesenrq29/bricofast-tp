package com.bricofast.model;

public class Outil {

    private int id;
    private String nom;
    private double prixParJour;
    private boolean disponibilite;


    public Outil(final int id, final String nom, final double prixParJour, final boolean disponibilite) {
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

    public boolean isDisponible() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public double getPrixParJour() {
        return prixParJour;
    }

    public String getNom() {
        return nom;
    }
}

