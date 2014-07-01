
import Model.Carte;
import Model.Intersections.Croisement;
import Model.Intersections.Intersection;
import Model.Itineraire;
import Model.Routes.Route;
import Model.Routes.RueImpasse;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Intersection i2 = new Croisement(new ArrayList<Route>(), 2);
        Intersection i3 = new Croisement(new ArrayList<Route>(), 2);
        Intersection i4 = new Croisement(new ArrayList<Route>(), 2);
        Intersection i5 = new Croisement(new ArrayList<Route>(), 2);
        Intersection i6 = new Croisement(new ArrayList<Route>(), 2);
        Intersection i7 = new Croisement(new ArrayList<Route>(), 2);
        Route r = new Route("route1", i, i1, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r1 = new Route("route1[INV]", i1, i, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r2 = new Route("route2", i1, i2, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r3 = new Route("route2[INV]", i2, i1, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r4 = new Route("route3", i2, i4, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r5 = new Route("route4", i4, i7, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r6 = new Route("route4[INV]", i7, i4, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r7 = new Route("route5", i7, i6, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r8 = new Route("route6", i6, i5, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r9 = new Route("route6[INV]", i5, i6, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r10 = new Route("route7", i5, i3, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r11 = new Route("route8", i2, i3, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r12 = new Route("route7[INV]", i3, i5, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        Route r13 = new Route("route8[INV]", i3, i2, 200, new HashMap<Vehicule, Double>(), new ArrayList<Signalisation>(), new ArrayList<ZoneARisque>(), new ArrayList<Station>());
        /*i.addRoute(r);
         i1.addRoute(r1);
         i1.addRoute(r2);*/

        inter.add(i);
        inter.add(i1);
        inter.add(i2);
        inter.add(i3);
        inter.add(i4);
        inter.add(i5);
        inter.add(i6);
        inter.add(i7);
        routes.add(r);
        routes.add(r1);
        routes.add(r2);
        routes.add(r3);
        routes.add(r4);
        routes.add(r5);
        routes.add(r6);
        routes.add(r7);
        routes.add(r8);
        routes.add(r9);
        routes.add(r10);
        routes.add(r11);
        routes.add(r12);
        routes.add(r13);

        c.setListeRoutes(routes);
        c.setListeDesIntersections(inter);

        /*Itineraire it;
         try {
         it = Itineraire.getItineraire(c, r, r3);
         System.out.println(it.getParcours());
         } catch (Exception ex) {
         Logger.getLogger(Simulatio.class.getName()).log(Level.SEVERE, null, ex);
         }*/
        Simulateur s = new Simulateur();
        s.setCarte(c);
        s.start();
    }
}
