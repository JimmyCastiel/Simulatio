package Model.Vehicules;

import Model.Itineraire;
import Model.Routes.Route;
import Model.VoieDeCirculation;
import java.io.Serializable;
import java.util.Date;

public abstract class Vehicule {

    private Itineraire intineraire;

    private double longueur;
    private double vitesse;
    private double vitesseMax;

    private Date dateDAppelPrecedente;

    public Vehicule(Itineraire intineraire, double longueur, double vitesse, double vitesseMax) throws Exception {
        this.intineraire = intineraire;
        this.longueur = longueur;
        this.vitesse = vitesse;
        this.vitesseMax = vitesseMax;
        this.dateDAppelPrecedente = new Date();

        if (!this.intineraire.prochainDeplacement().ajouterVehicule(this)) {
            throw new Exception("N'a pas pu s'ajouter à la route !");
        }
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
        if (this.intineraire.getVoiePrecedente() != null) {
            this.intineraire.getVoiePrecedente().supprimerVehicule(this);
        }
        this.intineraire.prochainDeplacement().ajouterVehicule(this);
        return this.intineraire.getVoiePrecedente();
    }

    /**
     * Methode "Avancer". Méthode permettant de faire avancer la voiture dans la
     * simulation.
     */
    public double Avancer(double valeurSeconde) {
        double distanceParcourue;
        Date date = new Date();

        distanceParcourue = (this.vitesse / 1000) * (((date.getTime() - this.dateDAppelPrecedente.getTime()) * valeurSeconde) / 1000);
        this.dateDAppelPrecedente = date;

        if (this.getVoiePrecedente() == null) {
            System.out.println("Arrivé");
        }
        return distanceParcourue;
    }
}
