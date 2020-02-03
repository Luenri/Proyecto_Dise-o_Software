/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Builder.Casa;
import static Modelos.MyHome.conection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Odalys
 */
public class clienteRegistrado extends Persona{
    protected String direccionTrabajo;
    protected int numHijos;
    protected String empresa;
    protected Registro registro;
    ArrayList<Casa> casasDisenadas;
    
    public clienteRegistrado(String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
        casasDisenadas=new ArrayList<>();
    }

    public clienteRegistrado(String direccionTrabajo, int numHijos, String empresa, Registro registro,String nombre, String apellido, String cedula, String correo, String celular, String estadoCivil, String direccion) {
        super(nombre, apellido, cedula, correo, celular, estadoCivil, direccion);
        this.direccionTrabajo = direccionTrabajo;
        this.numHijos = numHijos;
        this.empresa = empresa;
        this.registro = registro;
        casasDisenadas=new ArrayList<>();
    }
    
    
    
    public clienteRegistrado(Registro registro, String cedula) {
        super(cedula);
        this.registro = registro;
        casasDisenadas=new ArrayList<>();
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }
    
    public static clienteRegistrado obtenerCliente(String usuario,String contrasena) {
        try {
            
            String query="select * from persona p inner join cliente c on p.cedula=c.cedulaClient "
                    + "inner join registro r on r.propietario= p.cedula;";
            Statement st=conection.createStatement();
            try (ResultSet rs = st.executeQuery(query)) {
                boolean opt=false;
                while(rs.next()){
                    if(rs.getString("usuario").equalsIgnoreCase(usuario) && rs.getString("contrasena").equalsIgnoreCase(contrasena)){
                        String dir=rs.getString("direccionTrabajo");
                        Integer num=Integer.valueOf(rs.getString("numhijos"));
                        String emp=rs.getString("empresa");
                        Registro reg=new Registro(rs.getString("usuario"),rs.getString("contrasena"));
                        String nom=rs.getString("nombre");
                        String ape=rs.getString("apellido");
                        String ced=rs.getString("cedula");
                        String cor=rs.getString("correo");
                        String cel=rs.getString("celular");
                        String est=rs.getString("estadoCivil");
                        String dir2=rs.getString("domicilio");
                        return new clienteRegistrado(dir,num,emp,reg,nom,ape,ced,cel,cor,est,dir2);
                    }
                    
                }
            }
            return null;            
        } catch (SQLException ex) {
            Logger.getLogger(clienteRegistrado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public ArrayList<Casa> getCasasDisenadas() {
        return casasDisenadas;
    }

    public void setCasasDisenadas(ArrayList<Casa> casasDisenadas) {
        this.casasDisenadas = casasDisenadas;
    }
    
    

    

    
}
