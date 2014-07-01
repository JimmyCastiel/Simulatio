package Model.Signalisations;

import java.awt.Color;
import java.util.Date;

public class Feu extends Signalisation {

    private int idFeu;
    private int duree;
    private CouleurFeu couleurFeu;
    private Date dernierAppel;

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
        if (this.dernierAppel == null) {
            this.dernierAppel = new Date();
        } else {
            Date appel = new Date();
            long espaceEntreAppels = (appel.getTime() - this.dernierAppel.getTime()) * 1000;
            if (espaceEntreAppels >= (this.duree * 1000)) {
                this.dernierAppel = appel;
                this.couleurFeu = this.couleurFeu.suivant();
            }
        }

    }
}
