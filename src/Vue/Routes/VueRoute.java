/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue.Routes;

import Model.Routes.Route;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author 8460P
 */
public class VueRoute extends JPanel{
    
    private Route routeModele;
    private double x;
    private double y;
    private double longueur;
    private double largeur;
    
    public VueRoute(){
        
    }
    
    public void paintComponent(Graphics g){
       g.setColor(Color.white);
       g.fillRect(0, 0, this.getWidth(), this.getHeight());
      
       /* route  horizontale */
       g.setColor(Color.black);
       g.fillRect(0, 100, 300, 100);
      
       g.setColor(Color.white);
       g.fillRect(10,340,60,20);
      
      

       g.setColor(Color.white);
       g.fillRect(100,340,60,20);
      
       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(190,420, 60,20);
      
       g.setColor(Color.white);
       g.fillRect(190,380,60,20);
      
       g.setColor(Color.white);
       g.fillRect(190,340,60,20);
      
       g.setColor(Color.white);
       g.fillRect(190,300, 60,20);
      
       g.setColor(Color.white);
       g.fillRect(190,260,60,20);
      
       /*FIN PASSAGE*/
      
       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(450,420, 60,20);
      
       g.setColor(Color.white);
       g.fillRect(450,380,60,20);
      
       g.setColor(Color.white);
       g.fillRect(450,340,60,20);
      
       g.setColor(Color.white);
       g.fillRect(450,300, 60,20);
      
       g.setColor(Color.white);
       g.fillRect(450,260,60,20);
      
       /*FIN PASSAGE*/
       g.setColor(Color.white);
       g.fillRect(540,340,60,20);
      
       g.setColor(Color.white);
       g.fillRect(630,340,60,20);
       /*fin route*/
      
       /*route  verticale*/
       g.setColor(Color.black);
       g.fillRect(100,0,100 ,300 );
      
       g.setColor(Color.white);
       g.fillRect(340,10,20,60);
      
      
       g.setColor(Color.white);
       g.fillRect(340,100,20,60);
      

       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(420,190,20,60);
      
       g.setColor(Color.white);
       g.fillRect(380,190,20,60);
      
       g.setColor(Color.white);
       g.fillRect(340,190,20,60);
      
       g.setColor(Color.white);
       g.fillRect(300,190,20,60);
      
       g.setColor(Color.white);
       g.fillRect(260,190,20,60);
      
       /*FIN PASSAGE*/
      
       /* passage du pieton */
       g.setColor(Color.white);
       g.fillRect(420,450,20 ,60);
      
       g.setColor(Color.white);
       g.fillRect(380,450,20,60);
      
       g.setColor(Color.white);
       g.fillRect(340,450,20,60);
      
       g.setColor(Color.white);
       g.fillRect(300,450,20,60);
      
       g.setColor(Color.white);
       g.fillRect(260,450,20,60);
      
       /*FIN PASSAGE*/
       g.setColor(Color.white);
       g.fillRect(340,540,20,60);
      
       g.setColor(Color.white);
       g.fillRect(340,630,20,60);
       /*fin route*/
      

    }
    
    
}
