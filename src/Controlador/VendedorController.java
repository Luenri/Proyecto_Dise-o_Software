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
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class VendedorController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Button btnDisenar;
    @FXML
    private Button btnConsultar;
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
    private void consultarDatos(MouseEvent event) throws IOException {
        setearPantalla("/Vista/ConsultDatosVendedor.fxml");
    }

    @FXML
    private void disenarCasa(MouseEvent event) throws IOException {
        setearPantalla("/Vista/DisenarCasas.fxml");
    }

    @FXML
    private void cerrarSesion(MouseEvent event) throws IOException {
        setearPantalla("/Vista/PantallaPrincipal.fxml");
    }

    private void salir(ActionEvent event) throws IOException {
        MyHome.tipoU = null;
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaPrincipal.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
    public void setearPantalla(String ruta) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(ruta));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
        
    }
    
}
