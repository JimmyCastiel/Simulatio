/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue.Vehicules;

import Model.Vehicules.Vehicule;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author REBAHK
 */
public class VueVehicule extends JPanel {
    private Vehicule vehiculeModel;

    
    public VueVehicule(Vehicule v){
        this.vehiculeModel = v;
    }
    
    public void paintComponent(Graphics g){
        g.setColor(Color.red);
        g.fillRect(vehiculeModel.getX(),vehiculeModel.getY(),30,30);
    }
    

}
