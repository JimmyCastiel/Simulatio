/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Signalisations.Feu;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class Simulateur extends Thread {

    private List<Signalisation> signalisations;
    private List<Vehicule> vehicules;

    private double valeurSeconde;
    private int densiteVoiture;
    private long vitesseBoucle;
    private int dureeFeux;

    public Simulateur(List<Signalisation> signalisations, List<Vehicule> voitures, int densiteVoiture, long vitesseBoucle, int dureeFeux) {
        this.signalisations = signalisations;
        this.vehicules = voitures;
        this.densiteVoiture = densiteVoiture;
        this.vitesseBoucle = vitesseBoucle;
        this.dureeFeux = dureeFeux;
    }

    public Simulateur() {
        this(new ArrayList<Signalisation>(), new ArrayList<Vehicule>(), 100, 10, 100);
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
        while (true) {
            Date date = new Date();
            SimpleDateFormat dateFormatComp;

            dateFormatComp = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
            System.out.println(dateFormatComp.format(date));

            for (Vehicule v : this.vehicules) {
                v.Avancer(this.valeurSeconde);
            }

            for (Signalisation s : this.signalisations) {
                if (s instanceof Feu) {
                    Feu f = (Feu) s;
                    f.avancer(this.valeurSeconde);
                }
            }
            try {
                this.sleep(this.vitesseBoucle);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ajouterVehicule(Vehicule v) {
        this.vehicules.add(v);
        if (v.getVoiePrecedente() == null) {
            v.prochainDeplacement().ajouterVehicule(v);
        }
    }

    public void ajouterSignalisation(Signalisation s) {
        this.signalisations.add(s);
    }
}
