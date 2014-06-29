package Model.Vehicules;

import Model.Itineraire;

public class Voiture extends Vehicule {

    /**
     *
     */

    public Voiture(Itineraire intineraire, double longueur, double vitesse, double vitesseMax) {
        super(intineraire, longueur, vitesse, vitesseMax);
    }
}
