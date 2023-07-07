/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conecta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Connection con;
    public Connection Conexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_carrito","root", "");
            System.out.println("Se Conecto");
        } catch (Exception e) {
            System.out.println("No se conecto");
        }
        return cn;
    }
 public static void main(String[] args) {
        Conexion obj = new  Conexion();
          obj.Conexion();
}
}