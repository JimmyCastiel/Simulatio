/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Intersections.Intersection;
import Model.Routes.Route;
import Model.Routes.RueImpasse;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Itineraire {

    private List<VoieDeCirculation> parcours;
    private List<VoieDeCirculation> voiesPrecedentes;

    private Itineraire(Carte c, VoieDeCirculation depart, VoieDeCirculation arrivee) {
        this.parcours = new ArrayList<VoieDeCirculation>();
        this.voiesPrecedentes = new ArrayList<VoieDeCirculation>();
        //this.calculerItineraire(c, depart, arrivee);
    }

    /**
     * Fonction "prochainDeplacement". Fonction permettant d'obtenir la
     * prochaine route de l'itinéraire.
     *
     * @return VoieDeCirculation, prochaine voie de circulation à parcourir.
     */
    public VoieDeCirculation prochainDeplacement() {
        VoieDeCirculation voie = null;

        if (!this.parcours.isEmpty()) {
            voie = this.parcours.get(0);
            this.parcours.remove(voie);
        }
        this.voiesPrecedentes.add(voie);

        return voie;
    }

    /**
     * Fonction "getVoiePrecedente". Fonction permettant de récupère la dernière
     * parcourue ou qui est en train d'être parcourue.
     *
     * @return VoieDeCirculation, dernière voie parcourue ou voie en train
     * d'âtre parcourue.
     */
    public VoieDeCirculation getVoiePrecedente() {
        VoieDeCirculation voie = null;

        if (!this.voiesPrecedentes.isEmpty() && !this.parcours.isEmpty()) {
            voie = this.voiesPrecedentes.get(this.voiesPrecedentes.size() - 1);
        }

        return voie;
    }

    public void setParcours(List<VoieDeCirculation> parcours) {
        this.parcours = parcours;
    }

    public List<VoieDeCirculation> getParcours() {
        return parcours;
    }

    public static Itineraire getItineraire(Carte c, Route depart, Route arrivee) throws Exception {
        Itineraire i = new Itineraire(c, depart, arrivee);
        List<VoieDeCirculation> l;
        l = calculerItineraire(depart, arrivee);
        //l = calculerItineraire2(c, depart, arrivee);
        if (l != null) {
            i.setParcours(l);
        } else {
            throw new Exception("Probleme lors de la génération de l'itinéraire entre les route : " + depart.getNomRoute() + " et " + arrivee.getNomRoute() + "!");
        }
        return i;
    }

    private static List<VoieDeCirculation> calculerItineraire(Route depart, Route arrivee) {
        List<VoieDeCirculation> chemin = new ArrayList<VoieDeCirculation>();
        List<VoieDeCirculation> tmp = parcoursGraphe(null, depart.getArrivee(), arrivee.getDepart());

        if (tmp == null) {
            return null;
        }

        chemin.add(depart);
        chemin.addAll(tmp);
        chemin.add(arrivee);
        return chemin;
    }

    private static List<VoieDeCirculation> parcoursGraphe(Intersection intersectionPrecendente, Intersection depart, Intersection arrivee) {
        List<VoieDeCirculation> parcours = new ArrayList<VoieDeCirculation>();
        parcours.add(depart);
        for (Route r : depart.getRoutes()) {
            List<VoieDeCirculation> tmp = null;
            //if (!(r instanceof RueImpasse)) {
            if (r.getArrivee().equals(arrivee)) {
                parcours.add(r);
                parcours.add(r.getArrivee());
                return (parcours);
            } else if (intersectionPrecendente != null) {
                if (!intersectionPrecendente.equals(r.getArrivee())) {
                    tmp = parcoursGraphe(depart, r.getArrivee(), arrivee);
                }
            } else if (intersectionPrecendente == null) {
                tmp = parcoursGraphe(depart, r.getArrivee(), arrivee);
            }
            if (tmp != null) {
                parcours.add(r);
                parcours.addAll(tmp);
                return (parcours);
            }
            //}
        }

        return null;
    }

    private static List<VoieDeCirculation> calculerItineraire2(Carte c, Route depart, Route arrivee) {
        List<VoieDeCirculation> chemin = new ArrayList<VoieDeCirculation>();
        List<List<VoieDeCirculation>> tmp = new ArrayList<List<VoieDeCirculation>>();
        List<VoieDeCirculation> best = new ArrayList<VoieDeCirculation>();
        int taille = c.getListeDesIntersections().size() + c.getListeRoutes().size();

        for (Route r : depart.getArrivee().getRoutes()) {
            tmp.add(parcoursGraphe2(r.getArrivee(), arrivee.getDepart()));
        }

        if (tmp == null) {
            return null;
        }

        chemin.add(depart);
        chemin.add(depart.getArrivee());
        for (List<VoieDeCirculation> liste : tmp) {
            if (liste != null) {
                if (liste.size() <= taille && !liste.isEmpty()) {
                    best = liste;
                    taille = best.size();
                }
            }
        }
        if (!best.isEmpty()) {
            chemin.addAll(best);
            chemin.add(arrivee);
        } else {
            chemin = null;
        }
        return chemin;
    }

    private static List<VoieDeCirculation> parcoursGraphe2(Intersection depart, Intersection arrivee) {
        List<VoieDeCirculation> parcours = new ArrayList<VoieDeCirculation>();
        parcours.add(depart);
        for (Route r : depart.getRoutes()) {
            List<VoieDeCirculation> tmp = null;
            //if (!(r instanceof RueImpasse)) {
            if (r.getArrivee().equals(arrivee)) {
                parcours.add(r);
                parcours.add(r.getArrivee());
                return (parcours);
            } else {
                tmp = parcoursGraphe(depart, r.getArrivee(), arrivee);
            }
            if (tmp != null) {
                parcours.add(r);
                parcours.addAll(tmp);
                return (parcours);
            }
            //}
        }

        return null;
    }
}
