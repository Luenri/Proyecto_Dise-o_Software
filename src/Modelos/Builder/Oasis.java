/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Builder;

import Modelos.Decorator.orientacion;

/**
 *
 * @author Odalys
 */
public class Oasis extends CasaBuilder {
    
     Casa c = new Casa();
    
    @Override
    public void definirDimensiones() {
        
        c.metrosCuadrados = 63;
        c.numPlantas = 1;
        c.esquinera = false;
        c.orientacion = orientacion.SUR ;
    }

    @Override
    public void definirInterior() {
        c.patioGrande = false;
        c.numHabitaciones = 2;
        c.numBaños = 2;
    }
    
}
