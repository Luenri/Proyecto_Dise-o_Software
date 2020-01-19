/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ConsultDatosAdminController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private ComboBox<?> cbbConsulta;
    @FXML
    private TextField txtBusqCedula;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableView<?> tbvDatos;
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
    private Button btnMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
