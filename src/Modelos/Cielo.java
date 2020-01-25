/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Odalys
 */
public class Cielo extends CasaBuilder {
    
    Casa c = new Casa();
    
    @Override
    public void definirDimensiones() {
        
        c.metrosCuadrados = 130;
        c.numPlantas = 2;
        c.esquinera = true;
        orientacion o = null;
        c.orientacion = o.NORTE ;
    }

    @Override
    public void definirInterior() {
        c.patioGrande = true;
        c.numHabitaciones = 4;
        c.numBaños = 3;
    }

}
