package Model.Vehicules;

import Model.Intineraire;
import Model.VoieDeCirculation;
import java.io.Serializable;

public abstract class Vehicule {

    private Intineraire intineraire;

    private double longueur;
    private double vitesse;
    private double vitesseMax;

    public Vehicule(Intineraire intineraire, double longueur, double vitesse, double vitesseMax) {
        this.intineraire = intineraire;
        this.longueur = longueur;
        this.vitesse = vitesse;
        this.vitesseMax = vitesseMax;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    public double getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(double vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public void setIntineraire(Intineraire intineraire) {
        this.intineraire = intineraire;
    }

    public Intineraire getIntineraire() {
        return intineraire;
    }

    public VoieDeCirculation getVoiePrecedente() {
        return this.intineraire.getVoiePrecedente();
    }

    public VoieDeCirculation prochainDeplacement() {
        return this.intineraire.prochainDeplacement();
    }

    /**
     * Methode "Avancer". Méthode permettant de faire avancer la voiture dans la
     * simulation.
     */
    public void Avancer(double valeurSeconde) {
        
    }
}
