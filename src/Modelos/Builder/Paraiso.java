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
public class Paraiso extends CasaBuilder{
    
     Casa c = new Casa();
    
    @Override
    public void definirDimensiones() {
        
        c.metrosCuadrados = 85;
        c.numPlantas = 1;
        c.esquinera = false;
        c.orientacion = orientacion.ESTE ;
    }

    @Override
    public void definirInterior() {
        c.patioGrande = true;
        c.numHabitaciones = 3;
        c.numBaños = 3;
    }
    
}
