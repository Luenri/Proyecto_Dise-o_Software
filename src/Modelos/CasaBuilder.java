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
public abstract class CasaBuilder {
    
    private Casa casaBase;

    public Casa getCasaBase() {
        return casaBase;
    }
    
    public abstract void definirDimensiones(); 
    public abstract void definirInterior();
    
    
    
}
