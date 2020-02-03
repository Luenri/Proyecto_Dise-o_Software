/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import static Modelos.MyHome.mostrarAlerta;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class RegistrarController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField txtnombres;
    @FXML
    private TextField txtapellidos;
    @FXML
    private TextField txtcedula;
    @FXML
    private TextField txtcorreo;
    @FXML
    private TextField txtcelular;
    @FXML
    private Button btnregistrar;
    @FXML
    private Button btncancelar;
    @FXML
    private Font x2;
    @FXML
    private Button btnlimpiar;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtcontra;
    @FXML
    private TextField txtdirecciondom;
    @FXML
    private TextField txtdirecciontrab;
    @FXML
    private Font x11;
    @FXML
    private TextField txtcargo;
    @FXML
    private TextField txttelefonotrab;
    @FXML
    private TextField txtempresa;
    @FXML
    private Font x12;
    @FXML
    private TextField txtestadoc;
    @FXML
    private TextField txtnhijos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void registrar(ActionEvent event) throws SQLException {
        
        if(!verificarCampos()){
            String linea1="insert into persona values"
                + "('"+txtnombres.getText()+"', '"+txtapellidos.getText()+"', '"+txtcedula.getText()+"','"+txtcelular.getText()+"','"+txtcorreo.getText()+"','"+txtdirecciondom.getText()+"','"+txttelefonotrab.getText()+"','"+txtestadoc.getText()+"','"+txtcargo.getText()+"',1);";
        String linea2="insert into cliente values('"+txtdirecciontrab.getText()+"','"+txtempresa.getText()+"',"+txtnhijos.getText()+",'"+txtcedula.getText()+"');";
        String linea3="insert into registro values('"+txtuser.getText()+"','"+txtcontra.getText()+"','"+txtcedula.getText()+"');";
        
        System.out.println(linea1);
        System.out.println(linea2);
        System.out.println(linea3);
        
        Statement st= conection.createStatement();
        st.execute(linea1);
        st.execute(linea2);
        st.execute(linea3);
        
            
        mostrarAlerta("Registro","El registro se ha completado con exito",AlertType.CONFIRMATION);
        limpiarDatos();
        
        }else{
            mostrarAlerta("Registro","Todos los campos deben estar llenos",AlertType.ERROR);
            
        }
         
    }

    @FXML
    private void limpiar(ActionEvent event) {
        limpiarDatos();
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Usuario.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }  
    
    public  void limpiarDatos(){
        txtnombres.setText("");
        txtapellidos.setText("");
        txtcedula.setText("");
        txtcorreo.setText("");
        txtcelular.setText("");
        txtestadoc.setText("");
        txtuser.setText("");
        txtcontra.setText("");
        txtdirecciondom.setText("");
        txtdirecciontrab.setText("");
        txtcargo.setText("");
        txttelefonotrab.setText("");
        txtempresa.setText("");
        txtnhijos.setText("");
    }
    
    private boolean verificarCampos(){
        boolean ver=(txtnombres.getText().isEmpty()&&
        txtapellidos.getText().isEmpty()&&
        txtcedula.getText().isEmpty()&&
        txtcorreo.getText().isEmpty()&&
        txtcelular.getText().isEmpty()&&
        txtestadoc.getText().isEmpty()&&
        txtuser.getText().isEmpty()&&
        txtcontra.getText().isEmpty()&&
        txtdirecciondom.getText().isEmpty()&&
        txtdirecciontrab.getText().isEmpty()&&
        txtcargo.getText().isEmpty()&&
        txttelefonotrab.getText().isEmpty()&&
        txtempresa.getText().isEmpty()&&
        txtnhijos.getText().isEmpty());
        return ver;
    }
}