package Model.Vehicules;

import Model.Intineraire;

public class Voiture extends Vehicule {

    /**
     *
     */

    public Voiture(Intineraire intineraire, double longueur, double vitesse, double vitesseMax) {
        super(intineraire, longueur, vitesse, vitesseMax);
    }
}
