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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import proyectodiseño.MyHome;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ConsultDatosVendedorController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField txtBusC;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<?> tbvDatosC;
    @FXML
    private TableColumn<?, ?> clmCedula;
    @FXML
    private TableColumn<?, ?> clmNombres;
    @FXML
    private TableColumn<?, ?> clmApellidos;
    @FXML
    private TableColumn<?, ?> clmCelular;
    @FXML
    private TableColumn<?, ?> clmCorreo;
    @FXML
    private TableColumn<?, ?> clmEstadoC;
    @FXML
    private TableColumn<?, ?> clmDireccion;
    @FXML
    private Button btnvolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void volver(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
