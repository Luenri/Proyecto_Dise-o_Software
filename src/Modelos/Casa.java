/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Luis
 */
public class Casa {
    protected double metrosCuadrados;
    protected int numPlantas;
    protected boolean esquinera;
    protected orientacion orientacion;
    protected boolean patioGrande;
    protected int numHabitaciones;
    protected double numBaños;
    protected pisoPorcelanato piso;
    protected griferia griferia;
    protected iluminacion iluminacion;
    protected boolean bañosIsonorizados;
    protected boolean aislanteTermico;

    public Casa(double metrosCuadrados, int numPlantas, boolean esquinera, orientacion orientacion, boolean patioGrande, int numHabitaciones, double numBaños, pisoPorcelanato piso, griferia griferia, iluminacion iluminacion, boolean bañosIsonorizados, boolean aislanteTermico) {
        this.metrosCuadrados = metrosCuadrados;
        this.numPlantas = numPlantas;
        this.esquinera = esquinera;
        this.orientacion = orientacion;
        this.patioGrande = patioGrande;
        this.numHabitaciones = numHabitaciones;
        this.numBaños = numBaños;
        this.piso = piso;
        this.griferia = griferia;
        this.iluminacion = iluminacion;
        this.bañosIsonorizados = bañosIsonorizados;
        this.aislanteTermico = aislanteTermico;
    }

    public Casa() {
    }
    
   
    
   
    
   public void generarPrecio(){
       
   }
   
   public void mostrarEspecificaciones(){
       
   }
   
   public void agregarEspecificaciones(){
       
   }
   
   
   @Override
    public String toString() {
        return "Casa:" + "\nmetrosCuadrados=" + metrosCuadrados + 
                "\nnumPlantas=" + numPlantas + 
                "\nesquinera=" + esquinera + 
                "\norientacion=" + orientacion + 
                "\npatioGrande=" + patioGrande + 
                "\nnumHabitaciones=" + numHabitaciones + 
                "\nnumBaños=" + numBaños + 
                "\npiso=" + piso + 
                "\ngriferia=" + griferia + 
                "\niluminacion=" + iluminacion + 
                "\nbañosIsonorizados=" + bañosIsonorizados + 
                "\naislanteTermico=" + aislanteTermico+
                "\n\n\n\n";
    }
}
