/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class AffichageSimulateur {

    private List<String> messages;

    public AffichageSimulateur(List<String> messages) {
        this.messages = messages;
    }

    public AffichageSimulateur() {
        this(new ArrayList<String>());
    }

    public void ajouterMessage(String msg) {
        //this.quitter = true;
        this.messages.add(msg);
    }

    public void start() {
        for (String string : this.messages) {
            System.out.println(string);
        }
    }
}