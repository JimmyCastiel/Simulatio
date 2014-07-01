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

    private AffichageSimulateur affichage;
    private List<Signalisation> signalisations;
    private List<Vehicule> vehicules;
    private Carte c;

    private double valeurSeconde;
    private int densiteVoiture;
    private long vitesseBoucle;
    private int dureeFeux;

    public Simulateur(Carte c, List<Signalisation> signalisations, List<Vehicule> voitures, double valeurSeconde, int densiteVoiture, long vitesseBoucle, int dureeFeux) {
        this.affichage = new AffichageSimulateur();

        this.c = c;
        this.signalisations = signalisations;
        this.vehicules = voitures;
        this.valeurSeconde = valeurSeconde;
        this.densiteVoiture = densiteVoiture;
        this.vitesseBoucle = vitesseBoucle;
        this.dureeFeux = dureeFeux;
    }

    public Simulateur() {
        this(new Carte(), new ArrayList<Signalisation>(), new ArrayList<Vehicule>(), 1000, 100, 10, 100);
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
            int nbVoituresCrees = 0;

            for (int i = this.vehicules.size(); i < densiteVoiture; i++) {
                try {
                    int route1, route2;
                    route1 = (int) (Math.random() * (c.getListeRoutes().size() - 1));
                    route2 = (int) (Math.random() * (c.getListeRoutes().size() - 1));

                    this.vehicules.add(new Voiture(Itineraire.getItineraire(c, c.getListeRoutes().get(route1), c.getListeRoutes().get(route2)), 2, (int) (Math.random() * 50) + 1, (int) (Math.random() * 150) + 51));
                    this.affichage.ajouterMessage(("[+] Création de voiture réussie : " + this.vehicules.get(this.vehicules.size() - 1) + ", vitesse : " + this.vehicules.get(this.vehicules.size() - 1).getVitesse()));

                    nbVoituresCrees++;
                } catch (Exception ex) {
                    this.affichage.ajouterMessage("[!] " + ex.toString());
                }
            }

            if (nbVoituresCrees > 0) {
                this.affichage.ajouterMessage("[?] Nombre de véhicules créés : " + nbVoituresCrees);
            }

            for (Vehicule v : this.vehicules) {
                Route r = (Route) v.getVoiePrecedente();
                if (r != null) {
                    double distanceParcourue = v.Avancer(this.valeurSeconde);
                    r.avancer(v, distanceParcourue);
                } else {
                    vehiculesASupprimer.add(v);
                    this.affichage.ajouterMessage("[+] Ajout d'un véhicule à supprimer : " + v);
                }
            }

            for (Vehicule vehicule : vehiculesASupprimer) {
                this.vehicules.remove(vehicule);
                this.affichage.ajouterMessage("[-] Vehicule supprimé : " + vehicule);
            }

            if (!vehiculesASupprimer.isEmpty()) {
                this.affichage.ajouterMessage("[?] Nombre de véhicules supprimés : " + vehiculesASupprimer.size());
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
                //Logger.getLogger(Simulateur.class.getName()).log(Level.SEVERE, null, ex);
                this.affichage.ajouterMessage(ex.toString());
            }

            this.affichage.start("[*]");
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
