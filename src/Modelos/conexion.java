/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Estudiante
 */
public class conexion {
    
    public Connection getConnection()
    {
        Connection con = null;
       String url = "jdbc:mysql://localhost/myhome?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       
        String user = "root";
        String pass = "Luis1403";
        try {
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
}
