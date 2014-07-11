/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author 8460P
 */
public class AffichageSimulateurFenetre extends AffichageSimulateur{
    
    private JFrame f;
    private JTextArea jt;
    
    public AffichageSimulateurFenetre(){
        super();
        f = new JFrame();
        jt = new JTextArea();
        f.add(jt);
    }
}
