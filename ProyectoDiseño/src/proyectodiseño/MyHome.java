/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodiseño;

import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Luis
 */
public class MyHome extends Application {
    
    //public static Connection conexionbd;
    public static Scene sc;
    public static Stage ventanaPrincipal = new Stage();
    public static Scene sc1;
    public static Stage ventAdd = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
       // conexion cn = new conexion();
       // conexionbd = cn.getConnection();
      

        Parent root = FXMLLoader.load(getClass().getResource("PantallaPrincipal.fxml"));

        sc = new Scene(root);

        ventanaPrincipal.setScene(sc);
        ventanaPrincipal.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
