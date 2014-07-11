/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Panel;

import Model.Carte;
import Model.Routes.Route;
import Model.Simulateur;
import Model.Vehicules.Vehicule;
import Vue.Vehicules.VueVehicule;
import VueRoute.VueRoute;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VueCarte extends JPanel{
    
    //private Carte carteModele;
    private Simulateur simuModele;
    private VueRoute vr;
    
    public VueCarte(Simulateur simu){
        super();
        this.simuModele = simu;
    }
    

    public void paintComponent(Graphics g){
       /*****Première intersection****/
        
       //Route horizontale 
       g.setColor(Color.black);
       g.fillRect(0, 100, 300, 100);
       
       //Ligne discontinue
       g.setColor(Color.white);
       g.fillRect(5,137,30,10);
       g.setColor(Color.white);
       g.fillRect(45,137,30,10);
               
       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(85,110, 30,10);
       g.setColor(Color.white);
       g.fillRect(85,137,30,10);
       g.setColor(Color.white);
       g.fillRect(85,170,30,10);
       
       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(185,110, 30,10);
       g.setColor(Color.white);
       g.fillRect(185,137,30,10);
       g.setColor(Color.white);
       g.fillRect(185,170,30,10);
       
       //Ligne discontinue
       g.setColor(Color.white);
       g.fillRect(5,137,30,10);
       g.setColor(Color.white);
       g.fillRect(45,137,30,10);
       
       //Route verticale
       g.setColor(Color.black);
       g.fillRect(100,0,100 ,300);
;
       


           //Deuxième intersection
           g.setColor(Color.black);
           g.fillRect(300, 100, 300, 100);
           g.fillRect(100+100+100+100,0,100 ,300);
           
           //Troisième intersection
           g.fillRect(0, 100+100+100+100, 300, 100);
           g.fillRect(100,300,100 ,300);
           
           
           //Quatrième intersection
           g.fillRect(100+100+100, 100+100+100+100, 300, 100);
           g.fillRect(100+100+100+100,300,100 ,300);
           /*fin route*/
           
           for(Vehicule v : simuModele.getListVehicules()){
             g.setColor(Color.red);
             g.fillRect(v.getX(),v.getY(),10,110);
           }
           
           
           


    }
    
    
    



    
    
}
