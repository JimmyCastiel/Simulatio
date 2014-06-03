/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.ZoneSpecifiques;

/**
 *
 * @author Benjamin
 */
public class Station {
    
    private String nom;
    private boolean estStationne;
    private double longueurStation;

    public Station(String nom, boolean estStationne, double longueurStation) {
        this.nom = nom;
        this.estStationne = estStationne;
        this.longueurStation = longueurStation;
    }

    public String getNom() {
        return nom;
    }

    public boolean isEstStationne() {
        return estStationne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEstStationne(boolean estStationne) {
        this.estStationne = estStationne;
    }

    public double getLongueurStation() {
        return longueurStation;
    }

    public void setLongueurStation(double longueurStation) {
        this.longueurStation = longueurStation;
    }
    
    
    
    
    
}
