/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Odalys
 */
public class clienteRegistrado extends Persona{
    
ArrayList<Casa> casasDisenadas;

    public clienteRegistrado(String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
    }

    
}
