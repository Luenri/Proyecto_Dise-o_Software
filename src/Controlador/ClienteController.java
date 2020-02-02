/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static Controlador.ConsultDatosVendedorController.mostrarDatosCasa;
import static Controlador.ConsultDatosVendedorController.ventanaSecundaria;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import static Modelos.MyHome.contra;
import static Modelos.MyHome.usuario;
import Modelos.clienteRegistrado;
import static Modelos.clienteRegistrado.obtenerCliente;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ClienteController implements Initializable {

    @FXML
    private Button btnConsultarCasas;
    @FXML
    private Font x1;
    @FXML
    private Button btnDisenarCasas;
    @FXML
    private Button btncerrarsesion;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void disenarCasas(MouseEvent event) throws IOException {
        setearPantalla("/Vista/DisenarCasas.fxml");
        /*Parent root = FXMLLoader.load(getClass().getResource("/Vista/DisenarCasas.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);*/
    }
    
     @FXML
    private void cerrarsesion(MouseEvent event) throws IOException {
        MyHome.tipoU = null;
        setearPantalla("/Vista/PantallaPrincipal.fxml");
        /*Parent root = FXMLLoader.load(getClass().getResource());
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);*/
    }
    
    public void setearPantalla(String ruta) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(ruta));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
        
    }

    @FXML
    private void consultar(ActionEvent event) throws SQLException, IOException {
        clienteRegistrado cliente=obtenerCliente(usuario,contra);
        mostrarDatosCasa(cliente.getCedula());
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/verCasas.fxml"));
        Scene sc = new Scene(root);
        ventanaSecundaria=new Stage();
        ventanaSecundaria.setScene(sc);
        ventanaSecundaria.show();
        
    }
}
