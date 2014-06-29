/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Intersections.Intersection;
import Model.Routes.Route;
import Model.Signalisations.Feu;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import Model.Vehicules.Voiture;
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
    private Carte c;

    private double valeurSeconde;
    private int densiteVoiture;
    private long vitesseBoucle;
    private int dureeFeux;

    public Simulateur(Carte c, List<Signalisation> signalisations, List<Vehicule> voitures, double valeurSeconde, int densiteVoiture, long vitesseBoucle, int dureeFeux) {
        this.c = c;
        this.signalisations = signalisations;
        this.vehicules = voitures;
        this.valeurSeconde = valeurSeconde;
        this.densiteVoiture = densiteVoiture;
        this.vitesseBoucle = vitesseBoucle;
        this.dureeFeux = dureeFeux;
    }

    public Simulateur() {
        this(new Carte(), new ArrayList<Signalisation>(), new ArrayList<Vehicule>(), 1.2, 10, 10, 100);
    }

    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.
        while (true) {
            /*Date date = new Date();
             SimpleDateFormat dateFormatComp;

             dateFormatComp = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
             System.out.println(dateFormatComp.format(date));
             System.out.println(date.getTime());*/

            for (int i = this.vehicules.size(); i < densiteVoiture; i++) {
                try {
                    this.vehicules.add(new Voiture(Itineraire.getItineraire(c, c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size())), c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size()))), 2, 10, 150));
                    this.vehicules.get(i).prochainDeplacement();
                    this.vehicules.get(i).getVoiePrecedente().ajouterVehicule(this.vehicules.get(i));
                } catch (Exception ex) {
                    i = i--;
                    //Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (Vehicule v : this.vehicules) {
                if (!(v.getVoiePrecedente() instanceof Intersection)) {
                    Route r = (Route) v.getVoiePrecedente();
                    r.avancer(v, v.Avancer(this.valeurSeconde));
                } else {
                    while (v.prochainDeplacement() instanceof Intersection) {
                    }
                    Route r = (Route) v.getVoiePrecedente();
                    r.avancer(v, v.Avancer(this.valeurSeconde));
                }
            }

            for (Signalisation s : this.signalisations) {
                if (s instanceof Feu) {
                    Feu f = (Feu) s;
                    f.avancer(this.valeurSeconde);
                }
            }

            for (Route r : this.c.getListeRoutes()) {
                //System.out.println(r.getNomRoute());
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

    public void setCarte(Carte c) {
        this.c = c;
    }
}
