package Model.Vehicules;
import java.io.Serializable;


public class Vehicule implements Serializable {
	
	private double longueur;
	private double vitesse;
	private double vitesseMax;
	private double distance_restante_a_parcourir;

	public Vehicule(double longueur, double vitesse, double vitesseMax, double distance_restante_a_parcourir){
		this.setLongueur(longueur);
		this.setVitesse(vitesse);
		this.setVitesseMax(vitesseMax);
		this.setDistance_restante_a_parcourir(distance_restante_a_parcourir);
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

	public double getDistance_restante_a_parcourir() {
		return distance_restante_a_parcourir;
	}

	public void setDistance_restante_a_parcourir(
			double distance_restante_a_parcourir) {
		this.distance_restante_a_parcourir = distance_restante_a_parcourir;
	}
	
	
	
}
