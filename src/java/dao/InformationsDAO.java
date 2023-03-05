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
import model.Informations;
import util.DBContext;
import java.time.LocalDateTime;    
import java.text.SimpleDateFormat;  
import java.time.LocalDate;
import java.sql.Date;  
import java.time.format.DateTimeFormatter;

/**
 *
 * @author nguye
 */

public class InformationsDAO {
    private static final String GET_INFOR_ALL = "select * from swp_gr01.informations";
    private static final String GET_INFOR_BY_ID = "select * from swp_gr01.informations WHERE iId = ?";
    private static final String GET_INFOR_BY_CATEID = "select * from swp_gr01.informations WHERE id = ?";
    private static final String UPDATE_INFOR_BY_ID = "Update swp_gr01.informations set title=?,coverImgPath=?,description=?,content=?,id=? WHERE iId = ?";
    private static final String DELETE_INFOR_BY_ID = "Delete from swp_gr01.informations WHERE iId = ?";
    private static final String INSERT_INFOR = "INSERT INTO swp_gr01.informations (title, coverImgPath, description,content, createdDate, accId, id) VALUES (?, ?, ?, ?, ?, ?, ?)";  
    private static final String GET_INFOR_PAGING = "SELECT * FROM swp_gr01.informations order by createdDate desc LIMIT 10 OFFSET ?";
    private static final String GET_INFOR_BY_CATEID_PAGING = "SELECT * FROM swp_gr01.informations where id = ? order by createdDate desc LIMIT 10 OFFSET ?";
    
    public Informations getInforByID(int inforID) throws SQLException {
        List<Informations> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Informations infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFOR_BY_ID);
                stm.setInt(1, inforID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int iId = rs.getInt("iId");
                    String title = rs.getString("title");
                    String coverImgPath = rs.getString("coverImgPath");
                    String description = rs.getString("description");
                    String content = rs.getString("content");
                    Date createdDate = rs.getDate("createdDate");
                    int accId = rs.getInt("accId");
                    int id = rs.getInt("id");
                    infor = new Informations(iId,title ,coverImgPath,description,content,createdDate, accId,id);
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
        return infor;
    }
    
    public List<Informations> getInforByCateId(int idcate) throws SQLException {
        List<Informations> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Informations infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFOR_BY_CATEID);
                stm.setInt(1, idcate);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int iId = rs.getInt("iId");
                    String title = rs.getString("title");
                    String coverImgPath = rs.getString("coverImgPath");
                    String description = rs.getString("description");
                    String content = rs.getString("content");
                    Date createdDate = rs.getDate("createdDate");
                    int accId = rs.getInt("accId");
                    int id = rs.getInt("id");
                    infor = new Informations(iId,title ,coverImgPath, description, content, createdDate, accId, id);
                    list.add(infor);
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
    
    public List<Informations> getAllInfor() throws SQLException {
        List<Informations> listInfor = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Informations infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFOR_ALL);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int iId = rs.getInt("iId");
                    String title = rs.getString("title");
                    String coverImgPath = rs.getString("coverImgPath");
                    String description = rs.getString("description");
                    Date createdDate = rs.getDate("createdDate");
                    String content = rs.getString("content");
                    int accId = rs.getInt("accId");
                    int id = rs.getInt("id");
                    listInfor.add(new Informations(iId, title, coverImgPath, description, content, createdDate, accId, id));
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
        return listInfor;
    }
    
    public List<Informations> getInforByPage(int index) throws SQLException {
        List<Informations> listInfor = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Informations infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFOR_PAGING);
                stm.setInt(1, (index-1)*10);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int iId = rs.getInt("iId");
                    String title = rs.getString("title");
                    String coverImgPath = rs.getString("coverImgPath");
                    String description = rs.getString("description");
                    Date createdDate = rs.getDate("createdDate");
                    String content = rs.getString("content");
                    int accId = rs.getInt("accId");
                    int id = rs.getInt("id");
                    listInfor.add(new Informations(iId, title, coverImgPath, description, content, createdDate, accId, id));
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
        return listInfor;
    }
    
    public List<Informations> getInforCateByPage(int ids, int index) throws SQLException {
        List<Informations> listInfor = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Informations infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFOR_BY_CATEID_PAGING);
                stm.setInt(1, ids);
                stm.setInt(2, (index-1)*10);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int iId = rs.getInt("iId");
                    String title = rs.getString("title");
                    String coverImgPath = rs.getString("coverImgPath");
                    String description = rs.getString("description");
                    Date createdDate = rs.getDate("createdDate");
                    String content = rs.getString("content");
                    int accId = rs.getInt("accId");
                    int id = rs.getInt("id");
                    listInfor.add(new Informations(iId, title, coverImgPath, description, content, createdDate, accId, id));
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
        return listInfor;
    }
    
    public boolean updateInfor(String title, String coverImgPath, String detail,String content ,int id, int iId) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_INFOR_BY_ID);
                stm.setString(1, title);
                stm.setString(2, coverImgPath);
                stm.setString(3, detail);
                stm.setString(4, content);
                stm.setInt(5, id);
                stm.setInt(6 , iId);
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
    
    public boolean deleteInfor(int inforID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_INFOR_BY_ID);
                stm.setInt(1, inforID);      
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
    
    public boolean insertInfor(String title, String coverImgPath, String description,String content,int accId, int id) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        java.sql.Date sqlDate = Date.valueOf(LocalDate.now());
        
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_INFOR);
                stm.setString(1, title);
                stm.setString(2, coverImgPath);
                stm.setString(3, description);
                stm.setString(4, content);
                stm.setDate(5, sqlDate);
                stm.setInt(6, accId);
                stm.setInt(7, id);
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
    
    public static void main(String[] args) throws SQLException {
//        List<Informations> arr = new List<>();
        InformationsDAO infor = new InformationsDAO();
        int check = infor.getInforCateByPage(8, 1).size();
        System.out.println(check);
//        for(Informations in : infor.getInforCateByPage(8, 1)) {
//            System.out.println(in);
//        }
        
//        infor.getInforByID(2);
//        arr = infor.getAllInfor();
 //       infor.updateInfor("1", "2", "3", "4", 1, 2);
//        for(Informations infor1 : infor.getAllInfor()) {
//            System.out.println(infor1);
//        }
//        System.out.println(infor.getInforByID(2));
//        infor.getInfor(1);
    }
}
