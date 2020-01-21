/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
      

        Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaPrincipal.fxml"));

        sc = new Scene(root);
        ventanaPrincipal.setTitle("MY HOME S.A.");

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
