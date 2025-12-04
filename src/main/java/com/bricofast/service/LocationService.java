package com.bricofast.service;

import com.bricofast.exception.LocationException;
import com.bricofast.model.Catalogue;
import com.bricofast.model.Outil;

public class LocationService {
    public Catalogue catalogue;

    public LocationService(Catalogue catalogue){
        this.catalogue = catalogue;
    }

    public double rentOutil(int id, int nbrJour) throws LocationException {
        // on récupère les informations de l'outil
        final Outil outil = catalogue.getOutilById(id);

        //on vérifie si l'outil est disponible, sinon on renvoie une erreur
        if (!outil.isDisponible()) {
            throw new LocationException("L'outil n'est pas disponible");
        }

        //on vérifie si l'utilisateur a saisi un nbr de jour positif sinon on renvoie une erreur
        if (nbrJour <= 0) {
            throw new LocationException("Veuillez saisir un nombre de jour de location");
        }

        //on met l'outil disponible à false le rendant indispo
        outil.setDisponibilite(false);
        //on calcule le prix total
        final double totalPrice = nbrJour * outil.getPrixParJour();

        //on retourne le prix total
        return totalPrice;
    }

    public void returnOutil(int id) throws LocationException{
        // on récupère les informations de l'outil
        final Outil outil = catalogue.getOutilById(id);

        //on vérifie si l'outil n'est pas déjà disponible
        if (outil.isDisponible()) {
            throw new LocationException("L'outil est déjà disponible");
        }

        //on remet la disponibilite à true pour rendre l'outil disponible à nouveau
        outil.setDisponibilite(true);
    }

}
