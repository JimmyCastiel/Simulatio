package Model.Vehicules;

import Model.Itineraire;

public class Bus extends Vehicule {

    /**
     *
     */
    
    public Bus(Itineraire intineraire, double longueur, double vitesse, double vitesseMax) throws Exception {
        super(intineraire, longueur, vitesse, vitesseMax);
    }
}
