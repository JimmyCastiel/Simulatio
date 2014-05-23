/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Intersections.Croisement;
import Model.Intersections.Intersection;
import Model.Routes.Route;
import Model.Signalisations.Panneau;
import Model.Signalisations.Signalisation;
import Model.ZoneSpecifiques.ZoneARisque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class Carte {

    private List<Route> listeRoutes;
    private List<Signalisation> listeSignalisations;
    private List<Intersection> listeDesIntersections;
    private List<ZoneARisque> listeZonesARisques;
    private Map<String, List<Signalisation>> mapRouteSignalisation;

    public List<Route> getListeRoutes() {
        return listeRoutes;
    }

    public List<Signalisation> getListeSignalisations() {
        return listeSignalisations;
    }

    public List<Intersection> getListeDesIntersections() {
        return listeDesIntersections;
    }

    public List<ZoneARisque> getListeZonesARisques() {
        return listeZonesARisques;
    }

    public void setListeRoutes(List<Route> listeRoutes) {
        this.listeRoutes = listeRoutes;
    }

    public void setListeSignalisations(List<Signalisation> listeSignalisations) {
        this.listeSignalisations = listeSignalisations;
    }

    public void setListeDesIntersections(List<Intersection> listeDesIntersections) {
        this.listeDesIntersections = listeDesIntersections;
    }

    public void setListeZonesARisques(List<ZoneARisque> listeZonesARisques) {
        this.listeZonesARisques = listeZonesARisques;
    }

    public boolean addSignalisation(String nomR, Signalisation s){
        if (mapRouteSignalisation.containsKey(nomR)) {
            int index = 0;
            boolean b = false;
            for(int i = 0; i < this.listeRoutes.size(); i++) {
                if(this.listeRoutes.get(i).getNomRoute().equals(nomR))
                    index = i;
            }
            if(listeRoutes.get(index).ajouterSignalisation(s)){
                List<Signalisation> signalisations = mapRouteSignalisation.get(nomR);
                signalisations.add(s);
                mapRouteSignalisation.put(nomR, signalisations);
                return true;
            }
        }
        return false;
    }
    
    
}
