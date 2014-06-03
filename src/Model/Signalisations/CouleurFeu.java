/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Signalisations;

import java.awt.Color;

/**
 *
 * @author 8460P
 */
public enum CouleurFeu {
    
    VERT(Color.GREEN), ORANGE(Color.ORANGE), ROUGE(Color.RED);

    private final Color color;

    private CouleurFeu(Color color) {
        this.color = color;
    }

    /**
     * Renvoie la couleur suivante dans l'ordre d'allumage.
     * @return 
     */
    public CouleurFeu suivant() {
        // on choisit ici un algo très basique (je l'avais d'abord fait
        // en utisant la liste des valeurs, mais ça n'est pas très lisible.
        switch (this) {
            case VERT:
                return ORANGE;
            case ORANGE:
                return ROUGE;
            case ROUGE:
                return VERT;
            default:
                throw new RuntimeException("couleur inconnue ?? (impossible normalement)");
        }
    }

    /**
     * Retourne la couleur d'affichage.
     * @return 
     */
    public Color getColor() {
        return color;
    }
    
}
