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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class PerfilClienteController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Label lblnombres;
    @FXML
    private Label lblapellidos;
    @FXML
    private Label lblcedula;
    @FXML
    private Label lblCorreo;
    @FXML
    private Label lblcelular;
    @FXML
    private Label lblEstadoC;
     @FXML
    private Button salir;
    @FXML
    private TableView<?> tbvCasas;
    @FXML
    private TableColumn<?, ?> clmMetros;
    @FXML
    private TableColumn<?, ?> clmPlantas;
    @FXML
    private TableColumn<?, ?> clmEsquinera;
    @FXML
    private TableColumn<?, ?> clmOrientacion;
    @FXML
    private TableColumn<?, ?> clmPatio;
    @FXML
    private TableColumn<?, ?> clmHabitacion;
    @FXML
    private TableColumn<?, ?> clmBanos;
    @FXML
    private TableColumn<?, ?> clmPisos;
    @FXML
    private TableColumn<?, ?> clmgriferia;
    @FXML
    private TableColumn<?, ?> clmIluminacion;
    @FXML
    private TableColumn<?, ?> clmBanosI;
    @FXML
    private TableColumn<?, ?> clmAislante;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     @FXML
    private void salir(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/ConsultDatosVendedor.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
    
}
