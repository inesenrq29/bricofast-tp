package com.bricofast.model;


import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private final List<Outil> outils = new ArrayList<>();

    public Catalogue() {
        outils.add(new Outil(0, "Perceuse", 15.0, true));
        outils.add(new Outil(1, "Ponceuse", 12.5, true));
        outils.add(new Outil(2, "Tondeuse", 25.0, true));
        outils.add(new Outil(3, "Marteau piqueur", 40.0, true));
        outils.add(new Outil(4, "Echelle", 10.0, true));
    }

    public List<Outil> getOutils() {
        return outils;
    }

    public Outil getOutilById(int id) {
        if (id < 0 || id >= outils.size()) {
            return null;
        }
        return outils.get(id);
    }


}

