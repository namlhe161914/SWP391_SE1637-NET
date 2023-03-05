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
import java.util.ArrayList;
import java.util.List;
import model.Informations;
import model.InformationCategories;
import util.DBContext;


/**
 *
 * @author nguye
 */
public class InformationCategoriesDAO {
    private static final String GET_INFORCATE_ALL = "SELECT * FROM swp_gr01.informationcategories;";
    private static final String GET_INFORCATE_BY_ID = "select * from swp_gr01.informationcategories WHERE id = ?";
    private static final String INSERT_INFORCATE = "insert into swp_gr01.informationcategories (name) values (?)";
    private static final String UPDATE_INFORCATE = "update swp_gr01.informationcategories set name=? where id = ?";
    private static final String DELETE_INFOCATE = "Delete from swp_gr01.informationcategories WHERE id = ?";
    public InformationCategories getInforCateByID(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        InformationCategories infor = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFORCATE_BY_ID);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    infor = new InformationCategories(id,name);
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
    
    public List<InformationCategories> getAllInforCate() throws SQLException{
        List<InformationCategories> listCate = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(GET_INFORCATE_ALL);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    listCate.add(new InformationCategories(id,name));
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
        return listCate;
    }
    
    public boolean insertInforCate(String name) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_INFORCATE);
                stm.setString(1, name);
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
    
    public boolean updateInforCate(String name, int id) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_INFORCATE);
                stm.setString(1, name);
                stm.setInt(2, id);
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
    
    public boolean deleteInforCate(int id) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_INFOCATE);
                stm.setInt(1, id);
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
    
    public static void main(String[] args) {
        try {
            InformationCategoriesDAO dao = new InformationCategoriesDAO();
            dao.updateInforCate("Tin tức",9);
            List<InformationCategories> list = dao.getAllInforCate();
            for(InformationCategories c : list) {
                System.out.println(c);
            }
        } catch (Exception e) {
            
        }
        
    }
}
