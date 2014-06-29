/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Vehicules.Vehicule;

/**
 *
 * @author Benjamin
 */
public abstract class VoieDeCirculation {

    public abstract boolean ajouterVehicule(Vehicule v);
    public abstract boolean supprimerVehicule(Vehicule v);

}
