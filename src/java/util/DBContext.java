/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DBContext {
    public static Connection getJDBCConnection() throws InstantiationException{
        String url = "jdbc:mysql://localhost:3306/SWP_GR01";
        String user = "root";
        String password = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
          
            
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    public static void main(String[] args) {
        try {
            Connection con = new DBContext().getJDBCConnection();
            System.out.println("Ket noi thang cong");
        } catch (Exception e) {
            System.out.println("Ket noi that bai " + e.getMessage());
        }
    }
}
