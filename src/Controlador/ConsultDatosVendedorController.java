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
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import Modelos.cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TableView<cliente> tbvDatosC;
    @FXML
    private TableColumn<cliente, String> clmCedula;
    @FXML
    private TableColumn<cliente, String> clmNombres;
    @FXML
    private TableColumn<cliente, String> clmApellidos;
    @FXML
    private TableColumn<cliente, String> clmCelular;
    @FXML
    private TableColumn<cliente, String> clmCorreo;
    @FXML
    private TableColumn<cliente, String> clmEstadoC;
    @FXML
    private TableColumn<cliente, String> clmDireccion;
    @FXML
    private Button btnvolver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            
            
            String sql="SELECT * FROM persona p inner join empleado c on p.cedula= c.cedulaEmp ";
            Statement st= conection.createStatement();
            
            
            ResultSet rt=st.executeQuery(sql);
            clmNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            clmApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            clmCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
            clmCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
            clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
            clmEstadoC.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
            clmDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            
            ObservableList<cliente> datos=FXCollections.observableArrayList();
            
            while(rt.next()){
                if (Integer.valueOf(rt.getString("activo"))!=0){
                    String cedula_=rt.getString("cedula");
                String nombre_=rt.getString("nombre");
                String apellido_=rt.getString("apellido");
                String celular_=rt.getString("celular");
                String correo_=rt.getString("correo");
                String estado_=rt.getString("estadoCivil");
                String direccion_=rt.getString("domicilio");
                datos.add(new cliente(nombre_,apellido_,cedula_,correo_,celular_,estado_,direccion_));
                }
                
                
            }
            
            
            tbvDatosC.setItems(datos);
                
            
            //tbvDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultDatosAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void volver(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Vendedor.fxml"));
        Scene sc = new Scene(root);
        MyHome.ventanaPrincipal.setScene(sc);
    }
    
}
