/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Signalisations;

import Model.Signalisations.Panneau;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VuePanneau extends JPanel{
    private int marge = 5;
    private int diametre = 8;
    private Panneau panneau;

    public VuePanneau(Panneau panneau) {
        this.panneau = panneau;
    }
    public Dimension getPreferredSize() {
        return getMeilleureDimension(diametre);
    }

    private Dimension getMeilleureDimension(int diametre) {
        return new Dimension(diametre + 2 * marge, 4 * marge + 3 * diametre);
    }
    
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
            g.setColor(Color.red);
            g.fillOval(marge, marge, diametre, diametre);
    }
    
}
