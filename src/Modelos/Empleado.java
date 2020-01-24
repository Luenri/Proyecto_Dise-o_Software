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
public class Empleado extends Persona{
    
    protected String cargo;
    protected Registro registro;

    

    public Empleado(String cargo, Registro registro, String cedula) {
        super(cedula);
        this.cargo = cargo;
        this.registro = registro;
    }
    
    
  

    public Empleado(String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
    }

    public Empleado(String cargo, Registro registro, String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
        this.cargo = cargo;
        this.registro = registro;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
