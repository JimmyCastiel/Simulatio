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
public class AffichageSimulateurFenetre extends AffichageSimulateur {

    private JFrame f;
    private JTextArea jt;

    public AffichageSimulateurFenetre() {
        super();
        this.f = new JFrame();
        this.jt = new JTextArea();
        this.jt.setEnabled(false);
        this.f.add(this.jt);
        this.f.setSize(1000, 700);
        this.f.setVisible(true);
        this.jt.setText("");
    }

    @Override
    public void start(String type) {
        String tmp = "";
        /*String tmp = "";
         for (int i = this.messages.size() - 1; i >= 0; i--) {
         if (type.contains("[*]")) {
         tmp += this.messages.get(i) + "\r\n";
         } else {
         if (this.messages.contains(type)) {
         tmp += this.messages.get(i) + "\r\n";
         }
         System.out.println(this.messages.get(i));
         }
         }
         if (!tmp.equals("\r\n")) {
         this.jt.append(tmp + this.jt.getText());
         }
         this.messages.clear();*/
        for (String string : this.messages) {
            if (type.contains("[*]")) {
                tmp += string + "\r\n";
            } else {
                if (string.contains(type)) {
                    tmp += string + "\r\n";
                }
            }
        }
        if (!tmp.equals("") && !tmp.equals("\r\n")) {
            this.jt.setText(tmp);
            super.start(type);
        }
        this.messages.clear();
    }
}
