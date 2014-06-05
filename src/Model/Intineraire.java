/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Intineraire {

    private List<VoieDeCirculation> parcours;
    private List<VoieDeCirculation> voiesPrecedentes;

    public Intineraire(Carte c, VoieDeCirculation depart, VoieDeCirculation arrivee) {
        this.parcours = new ArrayList<VoieDeCirculation>();
        this.voiesPrecedentes = new ArrayList<VoieDeCirculation>();
        this.calculerItineraire(c, depart, arrivee);
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
            this.voiesPrecedentes.add(voie);
            this.parcours.remove(voie);
        }

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

        if (!this.parcours.isEmpty()) {
            voie = this.voiesPrecedentes.get(this.voiesPrecedentes.size() - 1);
        }

        return voie;
    }

    private void calculerItineraire(Carte c, VoieDeCirculation depart, VoieDeCirculation arrivee) {
        
    }
}
