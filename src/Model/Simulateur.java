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
        this(new Carte(), new ArrayList<Signalisation>(), new ArrayList<Vehicule>(), 1000, 10, 10, 100);
    }

    @Override
    public synchronized void start() {
        List<Vehicule> vehiculesASupprimer = new ArrayList<Vehicule>();
        super.start(); //To change body of generated methods, choose Tools | Templates.
        while (true) {
            /*Date date = new Date();
             SimpleDateFormat dateFormatComp;

             dateFormatComp = new SimpleDateFormat("dd MMM yyyy hh:mm:ss a");
             System.out.println(dateFormatComp.format(date));
             System.out.println(date.getTime());*/

            for (int i = this.vehicules.size(); i < densiteVoiture; i++) {
                try {
                    //this.vehicules.add(new Voiture(Itineraire.getItineraire(c, c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size())), c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size()))), 2, 50, 150));
                    this.vehicules.add(new Voiture(Itineraire.getItineraire(c, c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size())), c.getListeRoutes().get((int) (Math.random() * c.getListeRoutes().size()))), 2, (int) (Math.random() * 50)+1, (int) (Math.random() * 150)));
                    System.out.println("[+] Création de voiture réussie : " + this.vehicules.get(this.vehicules.size()) + ", vitesse : " + this.vehicules.get(this.vehicules.size()).getVitesse());
                } catch (Exception ex) {
                    //Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("[!] " + ex.getMessage());
                }
            }

            for (Vehicule v : this.vehicules) {
                //if (!(v.getVoiePrecedente() instanceof Intersection)) {
                Route r = (Route) v.getVoiePrecedente();
                if (r != null) {
                    double distanceParcourue = v.Avancer(this.valeurSeconde);
                    r.avancer(v, distanceParcourue);
                } else {
                    vehiculesASupprimer.add(v);
                    System.out.println("[+] Ajout d'un véhicule à supprimer : " + v);
                }
                /*} else {
                 while (v.prochainDeplacement() instanceof Intersection) {
                 }
                 Route r = (Route) v.getVoiePrecedente();
                 r.avancer(v, v.Avancer(this.valeurSeconde));
                 }*/
            }

            for (Vehicule vehicule : vehiculesASupprimer) {
                this.vehicules.remove(vehicule);
                System.out.println("[-] Vehicule supprimé : " + vehicule);
            }

            vehiculesASupprimer.clear();

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
