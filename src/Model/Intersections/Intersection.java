/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Intersections;

import Model.Routes.Route;
import Model.Vehicules.Vehicule;
import Model.VoieDeCirculation;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Benjamin
 */
public abstract class Intersection extends VoieDeCirculation {

    private List<Route> routes;
    private int nbMinRoutes;

    public Intersection(List<Route> routes, int nbMinRoutes) {
        this.routes = routes;
        this.nbMinRoutes = nbMinRoutes;
    }

    public void addRoute(Route r) {
        this.routes.add(r);
    }

    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public boolean ajouterVehicule(Vehicule v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return v.prochainDeplacement().ajouterVehicule(v);
    }

    @Override
    public boolean supprimerVehicule(Vehicule v) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.routes);
        hash = 17 * hash + this.nbMinRoutes;
        return hash;
    }

    public boolean equals(Intersection i) {
        if (i == null) {
            return false;
        }
        final Intersection other = (Intersection) i;
        if (!Objects.equals(this.routes, other.routes)) {
            return false;
        }
        if (this.nbMinRoutes != other.nbMinRoutes) {
            return false;
        }
        return true;
    }

}
