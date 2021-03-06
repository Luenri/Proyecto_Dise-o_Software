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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import Modelos.MyHome;
import static Modelos.MyHome.conection;
import Modelos.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Odalys
 */
public class ConsultDatosAdminController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private ComboBox<String> cbbConsulta;
    @FXML
    private TableView<Persona> tbvDatos;
    @FXML
    private Button btnVolver;
    @FXML
    private TableColumn<Persona,String> clmCedula;
    @FXML
    private TableColumn<Persona,String> clmNombres;
    @FXML
    private TableColumn<Persona,String> clmApellidos;
    @FXML
    private TableColumn<Persona,String> clmCelular;
    @FXML
    private TableColumn<Persona,String> clmCorreo;
    @FXML
    private TableColumn<Persona,String> clmEstadoC;
    @FXML
    private TableColumn<Persona,String> clmDireccion;
    @FXML
    private MenuItem opcDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            ObservableList<String> opciones=FXCollections.observableArrayList();
            opciones.addAll("Vendedor","Administrador");
            cbbConsulta.setItems(opciones);
            
            cbbConsulta.setOnAction(e->{
                String cbb=cbbConsulta.getValue();
                if (cbb.equalsIgnoreCase("Vendedor")){
                    mostrarDatos("vendedor");
                }else{
                    mostrarDatos("Administrador");
                }
                
            });
          
    }   
    
     @FXML
    private void volver(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Vista/Administrador.fxml"));
            Scene sc = new Scene(root);
            MyHome.ventanaPrincipal.setScene(sc);
        } catch (IOException ex) {
            Logger.getLogger(ConsultDatosAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void mostrarDatos(String cadena){
        try {
            String sql="SELECT cedula,nombre,apellido,celular,correo,estadoCivil,domicilio,e.cargo,activo"
                    + " FROM persona p inner join empleado e on p.cedula= e.cedulaEmp ";
            Statement st= conection.createStatement();
            
            
            ObservableList<Persona> datos;
            try (ResultSet rt = st.executeQuery(sql)) {
                clmNombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                clmApellidos.setCellValueFactory(new PropertyValueFactory<>("apellido"));
                clmCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
                clmCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
                clmCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
                clmEstadoC.setCellValueFactory(new PropertyValueFactory<>("estadoCivil"));
                clmDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
                datos = FXCollections.observableArrayList();
                while(rt.next()){
                    
                    if (Integer.valueOf(rt.getString("activo"))!=0 && rt.getString("cargo").equalsIgnoreCase(cadena)){
                        String cedula_=rt.getString("cedula");
                        String nombre_=rt.getString("nombre");
                        String apellido_=rt.getString("apellido");
                        String celular_=rt.getString("celular");
                        String correo_=rt.getString("correo");
                        String estado_=rt.getString("estadoCivil");
                        String direccion_=rt.getString("domicilio");
                        datos.add(new Persona(nombre_,apellido_,cedula_,correo_,celular_,estado_,direccion_));
                    }
                    
                    
                }
            }
            
            tbvDatos.setItems(datos);
            tbvDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultDatosAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eliminar(ActionEvent event)  {
        
        try {
            Persona p=tbvDatos.getSelectionModel().getSelectedItem();
            String query="Update persona Set activo='0' Where cedula='"+p.getCedula()+"';";
            Statement st= conection.createStatement();
            st.execute(query);
            String cbb=cbbConsulta.getValue();
            if (cbb.equalsIgnoreCase("Vendedor")){
                mostrarDatos("vendedor");
            }else{
                mostrarDatos("Administrador");     
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultDatosAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
