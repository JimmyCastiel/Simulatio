package Model.Signalisations;

public abstract class Panneau extends Signalisation {
	
	private String nom;
	
	public Panneau(String nom){
		this.nom = nom;
	}
}
