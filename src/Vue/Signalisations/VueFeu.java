/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Signalisations;

import Model.Signalisations.CouleurFeu;
import Model.Signalisations.Feu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VueFeu extends JPanel{
    
    private int marge = 5;
    private int diametre = 8;
    private Feu feuModel;

    public VueFeu(Feu feuModel) {
        this.feuModel = feuModel;
        this.setBackground(Color.black);
    }
    
    public Dimension getPreferredSize() {
        return getMeilleureDimension(diametre);
    }

    private Dimension getMeilleureDimension(int diametre) {
        return new Dimension(diametre + 2 * marge, 4 * marge + 3 * diametre);
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, diametre + (2 * marge), (3 * diametre) + (4 * marge));
        CouleurFeu couleurFeu = this.feuModel.getCouleurFeu();
        if (couleurFeu.equals(CouleurFeu.ROUGE)) {
            g.setColor(Color.red);
            g.fillOval(marge, marge, diametre, diametre);
        } else if (couleurFeu.equals(CouleurFeu.ORANGE)) {
            g.setColor(Color.orange);
            g.fillOval(marge, diametre + (2 * marge), diametre, diametre);
        } else if (couleurFeu.equals(CouleurFeu.VERT)) {
            g.setColor(Color.green);
            g.fillOval(marge, (2 * diametre) + (3 * marge), diametre, diametre);
        }
    }


    public void feuModifie() {
        repaint();
    }
}
