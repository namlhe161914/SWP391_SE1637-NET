/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import util.DBContext;
import model.Customer;
/**
 *
 * @author Admin
 */
public class CustomerDAO {
    private static final String GET_AN_CUSTOMER_BY_ID = "SELECT cusId, email, cusName, phone, createdDate FROM swp_gr01.customer WHERE cusId = ?";
    private static final String GET_AN_CUSTOMER_BY_Token = "SELECT cusId, email, cusName, phone, createdDate FROM swp_gr01.customer WHERE token = ?";
    private static final String INSERT_AN_CUSTOMER = "INSERT INTO swp_gr01.customer (cusName, email, phone, createdDate, token) VALUES (?, ?, ?, ?, ?)";
    
    public static int usingThreadLocalClass() {      
            int ranNum = ThreadLocalRandom.current().nextInt(1000,10000);   
            return ranNum;
    }
    
    
    public  Customer getCustomerByToken (int token) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Customer cus = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_CUSTOMER_BY_Token);
                stm.setInt(1, token);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int CusId = rs.getInt("cusId");
                    String Email = rs.getString("email");
                    
                    String cusName = rs.getString("cusName");
                    String Phone = rs.getString("phone");
                    Date createdDate = rs.getDate("createdDate");
                    cus = new Customer(CusId, cusName, Email, Phone, createdDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return cus;
    }
    
    
    public  boolean insertCustomer(String newCusName, String newEmail, String newPhone , int token) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        java.sql.Date sqlDate = Date.valueOf(LocalDate.now());
        //int token = usingThreadLocalClass();
        
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_AN_CUSTOMER);
                stm.setString(1, newCusName);
                stm.setString(2, newEmail);
                stm.setString(3, newPhone);            
                stm.setDate(4, sqlDate);
                stm.setInt(5, token);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    
    public Customer getCustomer (int cusId) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Customer cus = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_CUSTOMER_BY_ID);
                stm.setInt(1, cusId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int CusId = rs.getInt("cusId");
                    String Email = rs.getString("email");
                    
                    String cusName = rs.getString("cusName");
                    String Phone = rs.getString("phone");
                    Date createdDate = rs.getDate("createdDate");
                    cus = new Customer(CusId, cusName, Email, Phone, createdDate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return cus;
    }
    
}
