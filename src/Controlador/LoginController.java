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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void limpiar(MouseEvent event) {
        txtuser.setText("");
        txtcontra.setText("");
    }
    
    @FXML
    private void cancelar(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaPrincipal.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }

    @FXML
    private void ingresar(ActionEvent event) throws IOException, SQLException {
        
        String cadena="SELECT nombre,apellido,cedula,c.cargo,usuario,contrasena "
                + "FROM persona p inner join empleado c on p.cedula= c.cedulaEmp inner join registro r on p.cedula=r.propietario;";
        Statement st= conection.createStatement();
        ResultSet rs=st.executeQuery(cadena);
        String usuario=txtuser.getText();
        String contra=txtcontra.getText();
        Registro reg=new Registro(usuario,contra);
       
        LinkedList<Empleado> empleados=new LinkedList<>();
        while(rs.next()){
            String cedula=rs.getString("cedula");
            String usr=rs.getString("usuario");
            String cont=rs.getString("contrasena");
            String carg=rs.getString("cargo");
            empleados.add(new Empleado(carg,new Registro(usr,cont),cedula));
        }
        boolean ingresar=false;
        String cargo="ninguno";
        for(Empleado e:empleados){
            Registro r=e.getRegistro();
            if(reg.equals(r)){
                ingresar=true;
                cargo=e.getCargo();
                
                System.out.println(e.getRegistro().getUsuario());
                System.out.println(e.getRegistro().getContrasena());
                System.out.println(cargo);
            }
        }
        
        if (ingresar && cargo.equalsIgnoreCase("Administrador") ){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Administrador.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        }else if (ingresar && cargo.equalsIgnoreCase("Vendedor")){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        }else if (ingresar && cargo.equalsIgnoreCase("Cliente")){
             Parent root = FXMLLoader.load(getClass().getResource("/Vista/Cliente.fxml"));
             Scene sc = new Scene(root);
             MyHome.ventanaPrincipal.setScene(sc);
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error de ingreso");
            alert.setHeaderText(null);
            alert.setContentText("El usuario o la contraseña son Incorrectos");

            alert.showAndWait();
        }
        
    }
    
}
