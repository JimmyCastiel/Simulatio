/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Routes;

import Model.Intersections.Intersection;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class RouteAvecStation extends Route {

    public RouteAvecStation(Intersection depart, Intersection arrivee, Map<Vehicule, Double> voie, List<Signalisation> signalisations) {
        super(depart, arrivee, voie, signalisations);
    }
    
}
