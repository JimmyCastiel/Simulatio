/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Routes;

import Model.Intersections.Intersection;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import Model.ZoneSpecifiques.Station;
import Model.ZoneSpecifiques.ZoneARisque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class RueImpasse extends Route {

    public RueImpasse(Intersection depart, Intersection arrivee, double longueur, Map<Vehicule, Double> voie, List<Signalisation> signalisations, List<ZoneARisque> zonesARisque, List<Station> stations) {
        super(depart, arrivee, longueur, voie, signalisations, zonesARisque, stations);
    }

}
