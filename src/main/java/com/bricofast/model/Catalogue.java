package com.bricofast.model;


import java.util.List;

public class Catalogue {
    private List<Outil> outils;

    public Catalogue(List<Outil> outils) {
        this.outils = outils;
    }

    public List<Outil> getOutils() {
        return outils;
    }

    public void setOutils(List<Outil> outils) {
        this.outils = outils;
    }

    public Outil getOutilById(int id) {
        if (id < 0 || id >= outils.size()) {
            return null;
        }
        return outils.get(id);
    }

}

