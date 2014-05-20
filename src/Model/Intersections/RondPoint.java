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
public class RondPoint extends Intersection {

    public RondPoint(List<Route> routes, int nbMinRoutes) {
        super(routes, nbMinRoutes);
    }

}
