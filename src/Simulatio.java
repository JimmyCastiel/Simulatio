
import Model.Carte;
import Model.Intersections.Croisement;
import Model.Intersections.Intersection;
import Model.Routes.Route;
import Model.Signalisations.Signalisation;
import Model.Simulateur;
import Model.Vehicules.Vehicule;
import Model.Vehicules.Voiture;
import Model.VoieDeCirculation;
import Model.ZoneSpecifiques.ArretDeBus;
import Model.ZoneSpecifiques.Station;
import Model.ZoneSpecifiques.ZoneARisque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Benjamin
 */
public class Simulatio {

    public static void main(String[] args) {
        Carte c = new Carte();
        List<Intersection> inter = new ArrayList<Intersection>();
        List<Route> routes = new ArrayList<Route>();

        Intersection i = new Croisement(new ArrayList<Route>(), 2);
        Intersection i1 = new Croisement(new ArrayList<Route>(), 2);
        Route r = new Route("route1", i, i1, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r1 = new Route("route2", i1, i, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());

        inter.add(i);
        routes.add(r);

        c.setListeRoutes(routes);
        c.setListeDesIntersections(inter);

        Simulateur s = new Simulateur();
        s.setCarte(c);
        s.start();
    }
}
