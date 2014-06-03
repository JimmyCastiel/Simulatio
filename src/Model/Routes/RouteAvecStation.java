/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Routes;

import Model.Intersections.Intersection;
import Model.Signalisations.Signalisation;
import Model.Vehicules.Vehicule;
import Model.ZoneSpecifiques.ArretDeBus;
import Model.ZoneSpecifiques.Station;
import Model.ZoneSpecifiques.StationTaxis;
import Model.ZoneSpecifiques.ZoneARisque;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Benjamin
 */
public class RouteAvecStation extends Route {
    
    private List<Station> stations;
            
    private static final int NOMBRE_MAX_ARRETDEBUS = 2;
    private static final int NOMBRE_MAX_STATIONTAXI = 2;
    
    private int nbArretDeBus;
    private int nbStationTaxi;

    public RouteAvecStation(Intersection depart, Intersection arrivee, double longueur, Map<Vehicule, Double> voie, List<Signalisation> signalisations, List<ZoneARisque> zonesARisque, List<Station> stations) {
        super(depart, arrivee, longueur, voie, signalisations, zonesARisque, stations);
    }

    public List<Station> getListeStations() {
        return stations;
    }

    public void setListeStations(List<Station> stations) {
        this.stations = stations;
    }

    public int getNbArretDeBus() {
        return nbArretDeBus;
    }

    public void setNbArretDeBus(int nbArretDeBus) {
        this.nbArretDeBus = nbArretDeBus;
    }

    public int getNbStationTaxi() {
        return nbStationTaxi;
    }

    public void setNbStationTaxi(int nbStationTaxi) {
        this.nbStationTaxi = nbStationTaxi;
    }
    
    public boolean ajouterStation(Station st){
        if(st instanceof ArretDeBus && this.getNbArretDeBus()<=NOMBRE_MAX_ARRETDEBUS)
            return this.stations.add((ArretDeBus)st);
        else if(st instanceof StationTaxis && this.getNbStationTaxi()<=NOMBRE_MAX_STATIONTAXI)
            return this.stations.add((StationTaxis)st);
        return false;
        
    }

}
