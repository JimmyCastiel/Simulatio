/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Routes;

import Model.Intersections.Intersection;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import Model.VoieDeCirculation;
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

    private Map<Vehicule, Double> voie;
    private List<Signalisation> signalisations;

    private boolean routePleine;

    public Route(Intersection depart, Intersection arrivee, Map<Vehicule, Double> voie, List<Signalisation> signalisations) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.voie = voie;
        this.signalisations = signalisations;
        this.routePleine = false;
    }

    
}
