package Model.Vehicules;
import java.io.Serializable;


public class Vehicule {
	
	private double longueur;
	private double vitesse;
	private double vitesseMax;

	public Vehicule(double longueur, double vitesse, double vitesseMax){
		this.setLongueur(longueur);
		this.setVitesse(vitesse);
		this.setVitesseMax(vitesseMax);
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
}
