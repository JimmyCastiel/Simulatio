/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Intersections;

import Model.Routes.Route;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public abstract class Intersection {

    private List<Route> routes;
    private int nbMinRoutes;

    public Intersection(List<Route> routes, int nbMinRoutes) {
        this.routes = routes;
        this.nbMinRoutes = nbMinRoutes;
    }

    public void addRoute(Route r) {
        this.routes.add(r);
    }
}
