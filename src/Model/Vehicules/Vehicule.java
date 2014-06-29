package Model.Vehicules;

import Model.Itineraire;
import Model.VoieDeCirculation;
import java.io.Serializable;
import java.util.Date;

public abstract class Vehicule {

    private Itineraire intineraire;

    private double longueur;
    private double vitesse;
    private double vitesseMax;

    private Date dateDAppelPrecedente;

    public Vehicule(Itineraire intineraire, double longueur, double vitesse, double vitesseMax) {
        this.intineraire = intineraire;
        this.longueur = longueur;
        this.vitesse = vitesse;
        this.vitesseMax = vitesseMax;
        this.dateDAppelPrecedente = new Date();
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

    public void setIntineraire(Itineraire intineraire) {
        this.intineraire = intineraire;
    }

    public Itineraire getIntineraire() {
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
    public double Avancer(double valeurSeconde) {
        double distanceparcourue;
        Date date = new Date();

        distanceparcourue = (this.vitesse / 1000) * ((date.getTime() - this.dateDAppelPrecedente.getTime()) * valeurSeconde);
        this.dateDAppelPrecedente = date;

        return distanceparcourue;
    }
}
