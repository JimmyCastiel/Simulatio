package Model.Signalisations;

import java.awt.Color;

public class Feu extends Signalisation {

    private int idFeu;
    private int duree;
    private CouleurFeu couleurFeu;

    public Feu(int idFeu, int duree) {
        this.idFeu = idFeu;
        this.duree = duree;
        this.couleurFeu = CouleurFeu.ROUGE;
    }

    public int getIdFeu() {
        return idFeu;
    }

    public void setIdFeu(int idFeu) {
        this.idFeu = idFeu;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public CouleurFeu getCouleurFeu() {
        return couleurFeu;
    }

    public void setCouleurFeu(CouleurFeu couleurFeu) {
        this.couleurFeu = couleurFeu;
    }

    public void suivant() {
        this.setCouleurFeu(couleurFeu.suivant());
    }

    public void avancer(double valeurSeconde) {

    }
}
