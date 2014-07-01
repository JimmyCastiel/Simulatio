/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Panel;

import Model.Carte;
import Model.Routes.Route;
import VueRoute.VueRoute;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VueCarte extends JPanel{
    
    private Carte carteModele;
    private VueRoute vr;
    
    public VueCarte(Carte cm){
        super();
        this.carteModele = cm;
    }
    

    public void paintComponent(Graphics g){
           //Première intersection
           g.setColor(Color.white);
           g.fillRect(0, 0, this.getWidth(), this.getHeight());

           /* route  horizontale */
           g.setColor(Color.black);
           g.fillRect(0, 100, 300, 100);
           g.fillRect(100,0,100 ,300);

           //Deuxième intersection
           g.fillRect(300, 100, 300, 100);
           g.fillRect(100+100+100+100,0,100 ,300);
           
           //Troisième intersection
           g.fillRect(0, 100+100+100+100, 300, 100);
           g.fillRect(100,300,100 ,300);
           
           
           //Quatrième intersection
           g.fillRect(100+100+100, 100+100+100+100, 300, 100);
           g.fillRect(100+100+100+100,300,100 ,300);
           /*fin route*/

           


    }
    
    
    



    
    
}
