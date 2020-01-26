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
public class cliente extends Persona{
    protected String direccionTrabajo;
    protected int numHijos;
    protected String empresa;
    protected Registro registro;
    
    public cliente(String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
    }

    public cliente(Registro registro, String cedula) {
        super(cedula);
        this.registro = registro;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
    
    
    
    
    

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
}
