package Model.Vehicules;

public class Taxi extends Voiture{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3874481864732561997L;
	
	public Taxi(double longueur, double vitesse, double vitesseMax, double distance_restante_a_parcourir) {
		super(longueur, vitesse, vitesseMax, distance_restante_a_parcourir);
	}
}
