/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Vehicules;

import Model.Vehicules.Bus;
import java.awt.Graphics;
import javafx.scene.paint.Color;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VueBus extends JPanel{
    
    private double x;
    private double y;
    private double longueur;
    private double largeur;
    private final Color color = Color.GREEN;
    
    private Bus bus;

    public VueBus(double x, double y, double longueur, double largeur, Bus bus) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
        this.bus = bus;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public Color getColor() {
        return color;
    }


    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public double getAbs() {
        return x;
    }

    public void setAbs(double x) {
        this.x = x;
    }

    public double getOrd() {
        return y;
    }

    public void setOrd(double y) {
        this.y = y;
    }
    
//    protected void paintComponent(Graphics g){
//        super.paintComponent(g);
//            g.setColor(java.awt.Color.GREEN);
////            g.fillRect(this.x, this.y, largeur, longueur);
//    }
    

    
    
    
}
