/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Routes;

import Model.Intersections.Intersection;
import Model.Signalisations.Panneau;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import Model.VoieDeCirculation;
import Model.ZoneSpecifiques.Station;
import Model.ZoneSpecifiques.ZoneARisque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class Route extends VoieDeCirculation {

    private Intersection depart;
    private Intersection arrivee;
    
    private double longueur;
    
    // HashMap de vehicules avec leur distance à parcourir
    private Map<Vehicule, Double> voie;
    private List<Signalisation> signalisations;
    private List<ZoneARisque> zonesARisque;
    private List<Station> stations;
    
    private boolean routePleine;
    
    private static final double PAS = 2;

    public Route(Intersection depart, Intersection arrivee, double longueur, Map<Vehicule, Double> voie, List<Signalisation> signalisations, List<ZoneARisque> zonesARisque, List<Station> stations) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.longueur = longueur;
        this.voie = voie;
        this.signalisations = signalisations;
        this.zonesARisque = zonesARisque;
        this.stations = stations;
    }

    public boolean ajouterSignalisation(Signalisation s) {
        return signalisations.add(s);
    }

    public boolean ajouterStation(Station st) {
        return stations.add(st);
    }

    public boolean ajouterZoneARisque(ZoneARisque zar) {
        return zonesARisque.add(zar);
    }

    public boolean ajouterVehicule(Vehicule v) {
        if (!this.voie.values().contains(this.longueur)) {
            for (Map.Entry<Vehicule, Double> entry : this.voie.entrySet()) {
                Vehicule vehicule = entry.getKey();
                Double double1 = entry.getValue();
                if(double1 + vehicule.getLongueur() + Route.PAS >= this.longueur){
                    return false;
                }
            }
            this.voie.put(v,this.longueur);
            return true;
        }
        return false;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public void setRoutePleine(boolean routePleine) {
        this.routePleine = routePleine;
    }

    public double getLongueur() {
        return longueur;
    }

    public boolean isRoutePleine() {
        return routePleine;
    }
}
