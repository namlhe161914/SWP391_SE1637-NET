/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;
import util.DBContext;

/**
 *
 * @author Admin
 */
public class AccountsDAO {
    private static final String GET_AN_ACCOUNT_BY_ID = "SELECT accId, email, password, fullName, phone, status, role FROM swp_gr01.accounts WHERE accId = ?";
    private static final String GET_AN_ACCOUNT_BY_EMAIL = "SELECT accId, email, password, fullName, phone, status, role FROM swp_gr01.accounts WHERE email = ?";
    private static final String GET_AN_ACCOUNT = "SELECT accId, email, password, fullName, phone, status, role FROM swp_gr01.accounts WHERE email = ? and password = ?";
    private static final String GET_ACCOUNTS = "SELECT accId, email, password, fullName, phone, status, role FROM swp_gr01.accounts";
    private static final String GET_ACCOUNT_BY_TOKEN = "SELECT accId, email, password, fullName, phone, status, role FROM swp_gr01.accounts WHERE token = ?";
    private static final String GET_ROLE_ACCOUNT_BY_TOKEN = "SELECT role FROM swp_gr01.accounts WHERE token = ?";
    private static final String UPDATE_ACCOUNT_STATUS = "UPDATE swp_gr01.accounts Set status = ? WHERE email = ?";
    private static final String UPDATE_ACCOUNT = "UPDATE swp_gr01.accounts Set  fullName = ?, phone = ?, password = ?, role = ?  WHERE email = ?";
    private static final String UPDATE_PASSWORD = "UPDATE swp_gr01.accounts Set password = ? WHERE accId = ?";
    private static final String UPDATE_ACCOUNT_INFO = "UPDATE swp_gr01.accounts SET fullName = ?, phone = ? WHERE email = ?";
    private static final String UPDATE_TOKEN = "UPDATE swp_gr01.accounts Set token = ? WHERE email = ?";
    private static final String INSERT_ACCOUNT = "INSERT INTO swp_gr01.accounts (email, password, fullName, phone, status, role) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String CHECK_OLD_PASSWORD = "SELECT password FROM swp_gr01.accounts WHERE accId = ?";
    private static final String VALID_TOKEN = "SELECT accId, email, password, fullName, phone, status, Role FROM swp_gr01.accounts WHERE token = ?";
    private static final String DELETE_AN_ACCOUNT = "DELETE FROM swp_gr01.accounts WHERE accId = ?";
    //optional
    private static final String INSERT_OR_UPDATE_ACCOUNT_IF_DUPLICATE = "INSERT INTO swp_gr01.accounts  (accId, email, password, fullName, phone, status, role) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE password=?, fullName=?, phone=?, status = ?, role=?";
    
    
    
    public boolean insertAccountOrUpdateIfDuplicate(String newEmail, String newPassword, String newFullname, String newPhone, int newStatus, int newRole) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_OR_UPDATE_ACCOUNT_IF_DUPLICATE);
                stm.setString(1, newEmail);
                stm.setString(2, newPassword);
                stm.setString(3, newFullname);
                stm.setString(4, newPhone);
                stm.setInt(5, newStatus);
                stm.setInt(6, newRole);
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
    
    
    public boolean deleteAccount(int accId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_AN_ACCOUNT);
                stm.setInt(1, accId);      
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
    
    public boolean checkOldPassword(int accId, String oldPassword) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CHECK_OLD_PASSWORD);
                psm.setInt(1, accId);
                rs = psm.executeQuery();
                if (rs.next()) {
                    String accPsw = rs.getString("password");
                    if (accPsw.equalsIgnoreCase(oldPassword)) {
                        check = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public int getRoleAccountByToken(String token) throws SQLException {
        int role = 0;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_ROLE_ACCOUNT_BY_TOKEN);
                stm.setString(1, token);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getInt("role");
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
        return role;
    }
    
    public boolean validToken(String token) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(VALID_TOKEN);
                psm.setString(1, token);
                rs = psm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateToken(String token, String email) throws SQLException {
        boolean check = true;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_TOKEN);
                psm.setString(1, token);
                psm.setString(2, email);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean changeAccount(String email, String newFullname, String newPhone) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_ACCOUNT_INFO);
                stm.setString(1, newFullname);
                stm.setString(2, newPhone);
                stm.setString(3, email);
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
    
    public boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newStatus, int newRole) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_ACCOUNT);
                stm.setString(1, newEmail);
                stm.setString(2, newPassword);
                stm.setString(3, newFullname);
                stm.setString(4, newPhone);
                stm.setInt(5, newStatus);
                stm.setInt(6, newRole);
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
    
    
    
    //UPDATE swp_gr01.accounts Set  fullName = ?, phone = ?, password = ?, role = ?  WHERE email = ?
    public boolean updateAccount(String email, String newPassword, String newFullname, String newPhone, int role) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_ACCOUNT);
                stm.setString(1, newFullname);
                stm.setString(2, newPhone);
                stm.setString(3, newPassword);
                stm.setInt(4, role);
                stm.setString(5, email);
                
                
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
    
        public List<Accounts> getAccounts() throws SQLException {
        List<Accounts> list = new ArrayList<>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.createStatement();
                rs = stm.executeQuery(GET_ACCOUNTS);
                while (rs.next()) {
                    int AccId = rs.getInt("AccID");
                    String Email = rs.getString("Email");
                    String Password = rs.getString("Password");
                    String FullName = rs.getString("FullName");
                    String Phone = rs.getString("Phone");
                    int Status = rs.getInt("Status");
                    int Role = rs.getInt("Role");
                    Accounts acc = new Accounts(AccId, Email, Password, FullName, Phone, Status, Role);
                    list.add(acc);
                }
            }
        } catch (Exception e) {
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
        return list;
    }
   
    
        public Accounts getAccount(String email, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts acc = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_ACCOUNT);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int accId = rs.getInt("accId");
                    String Email = rs.getString("email");
                    String fullName = rs.getString("fullName");
                    String phone = rs.getString("phone");
                    int status = rs.getInt("status");
                    int role = rs.getInt("role");
                    acc = new Accounts(accId, Email, "******", fullName, phone, status, role);
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
        return acc;
    }
    
    
    public boolean getAccountByEmail(String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_ACCOUNT_BY_EMAIL);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }
    
    
    
    public Accounts getAccount(int accId) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts acc = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_ACCOUNT_BY_ID);
                stm.setInt(1, accId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int AccId = rs.getInt("accId");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String FullName = rs.getString("fullName");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Accounts(AccId, Email, Password, FullName, Phone, Status, Role);
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
        return acc;
    }
    
    public Accounts getAccountInforByEmail(String email) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts acc = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_AN_ACCOUNT_BY_EMAIL);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int AccId = rs.getInt("accId");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String FullName = rs.getString("fullName");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Accounts(AccId, Email, Password, FullName, Phone, Status, Role);
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
        return acc;
    }
    
    public Accounts getAccount(String token) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Accounts acc = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_ACCOUNT_BY_TOKEN);
                stm.setString(1, token);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int AccId = rs.getInt("accId");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String FullName = rs.getString("fullName");
                    String Phone = rs.getString("phone");
                    int Status = rs.getInt("status");
                    int Role = rs.getInt("role");
                    acc = new Accounts(AccId, Email, Password, FullName, Phone, Status, Role);
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
        return acc;
    }
    
    public boolean updateAccountStatus(String email, int status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_ACCOUNT_STATUS);
                stm.setInt(1, status);
                stm.setString(2, email);
                check = stm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
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
    
    public boolean updateAccountPassword(int accId, String newPassword) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_PASSWORD);
                psm.setString(1, newPassword);
                psm.setInt(2, accId);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}

class t2{
    
    public static void main(String[] args) throws SQLException {
       // test getAllProducts 
//        AccountsDAO d = new AccountsDAO();
//        for (Accounts s : d.getAccounts()) {
//            System.out.println(s);
//        }

        // test getProduct
//            ProductDAO d = new ProductDAO();
//            System.out.println(d.getProduct(1));
            
        // test upđateAccount
            AccountsDAO d = new AccountsDAO();
            d.updateAccount("suppoter05@swp.com", "0000001", "L.Mess", "12345901", 2);
            
    }
}

