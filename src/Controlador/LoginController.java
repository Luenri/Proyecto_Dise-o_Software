/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelos.Empleado;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import Modelos.Registro;
import Modelos.clienteRegistrado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import static Modelos.MyHome.usuario;
import static Modelos.MyHome.contra;
import static Modelos.MyHome.mostrarAlerta;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class LoginController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private PasswordField txtcontra;
    @FXML
    private TextField txtuser;
    @FXML
    private Button btningresar;
    @FXML
    private Button btncancelar;
    @FXML
    private Font x2;
    @FXML
    private Button btnLimpiar;
    
    
    
    
    protected boolean ingresar;
    protected String cargo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
      
    }    

    @FXML
    private void limpiar(MouseEvent event) {
        txtuser.setText("");
        txtcontra.setText("");
    }
    
    @FXML
    private void cancelar(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaPrincipal.fxml"));
            Scene sc = new Scene(root);
            MyHome.ventanaPrincipal.setScene(sc);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ingresar(ActionEvent event) {
        
        try {
            String cadena="SELECT nombre,apellido,cedula,c.cargo,usuario,contrasena "
                    + "FROM persona p inner join empleado c on p.cedula= c.cedulaEmp inner join registro r on p.cedula=r.propietario;";
            String cadena2="Select nombre,apellido,cedula,usuario,contrasena from persona p inner join cliente c on p.cedula=c.cedulaClient inner join registro r on p.cedula=r.propietario;";
            
            usuario=txtuser.getText();
            contra=txtcontra.getText();
            
            Registro reg=new Registro(MyHome.usuario,MyHome.contra);
            
            
            
            verificarLoginEmpleado(cadena,reg);
            verificarLoginCliente(cadena2,reg);
            
            if(!txtuser.getText().isEmpty() && !txtcontra.getText().isEmpty()){
                if (ingresar && cargo!=null &&cargo.equalsIgnoreCase("Administrador") ){
                    MyHome.tipoU = "Administrador";
                    Parent root = FXMLLoader.load(getClass().getResource("/Vista/Administrador.fxml"));
                    Scene sc = new Scene(root);
                    MyHome.ventanaPrincipal.setScene(sc);
                }else if (ingresar && cargo!=null && cargo.equalsIgnoreCase("Vendedor")){
                    MyHome.tipoU = "Vendedor";
                    Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
                    Scene sc = new Scene(root);
                    MyHome.ventanaPrincipal.setScene(sc);
                }else if (ingresar){
                    Parent root = FXMLLoader.load(getClass().getResource("/Vista/Cliente.fxml"));
                    MyHome.tipoU = "Cliente";
                    Scene sc = new Scene(root);
                    MyHome.ventanaPrincipal.setScene(sc);
                }else{
                   
                    mostrarAlerta("Error de ingreso","El usuario o la contraseña son Incorrectos",AlertType.ERROR);
                }
            }else{
                
                mostrarAlerta("Error de ingreso","Los campos de texto no pueden estar Vacios",AlertType.ERROR);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void verificarLoginEmpleado(String queryEmp,Registro registro){
        try {
            Statement st= conection.createStatement();
            LinkedList<Empleado> empleados;
            try (ResultSet rs1 = st.executeQuery(queryEmp)) {
                empleados = new LinkedList<>();
                while(rs1.next()){
                    String cedula=rs1.getString("cedula");
                    String usr=rs1.getString("usuario");
                    String cont=rs1.getString("contrasena");
                    String carg=rs1.getString("cargo");
                    empleados.add(new Empleado(carg,new Registro(usr,cont),cedula));
                }
            }
            empleados.forEach((e) -> { 
                Registro r=e.getRegistro();
                if (registro.equals(r)) {
                    ingresar=true;
                    cargo=e.getCargo();
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void verificarLoginCliente(String queryClt,Registro registro){
        try {
            Statement st= conection.createStatement();
            LinkedList<clienteRegistrado> clientes=new LinkedList<>();
            try (ResultSet rs2 = st.executeQuery(queryClt)) {
                while(rs2.next()){
                    String cedula=rs2.getString("cedula");
                    String usr=rs2.getString("usuario");
                    String cont=rs2.getString("contrasena");
                    clientes.add(new clienteRegistrado(new Registro(usr,cont),cedula));
                }
            }
            
            clientes.stream().map((c) -> c.getRegistro()).filter((r) -> (registro.equals(r))).forEachOrdered((_item) -> {
                ingresar=true;
            });
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
