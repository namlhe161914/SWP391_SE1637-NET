/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.DBContext;
import model.Categories;

/**
 *
 * @author Admin
 */
public class CategoriesDAO {
    private static final String GET_CATEGORIES = "SELECT cateId, cateName ,status , cateCode FROM swp_gr01.categories";
    private static final String UPDATE_CATEGORY_INFO = "UPDATE swp_gr01.categories SET cateName = ? WHERE cateId = ?";
    private static final String INSERT_NEW_CATEGORY = "INSERT INTO swp_gr01.categories (cateName, status, cateCode) VALUES (?, ?, ?)";
    private static final String UPDATE_CATEGORY_STATUS = "UPDATE swp_gr01.categories Set status = ? WHERE cateId = ?";
    private static final String DELETE_AN_CATEGORY = "DELETE FROM swp_gr01.categories WHERE cateId = ?";
    private static final String GET_A_CATEGORIES = "SELECT cateId, cateName , status FROM swp_gr01.categories WHERE cateId = ?";
    
    public boolean deleteCategory(int cateId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_AN_CATEGORY);
                stm.setInt(1, cateId);      
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
    
    public boolean updateCategoryStatus(int cateId, int status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_CATEGORY_STATUS);
                stm.setInt(1, status);
                stm.setInt(2, cateId);
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
    
    
    
    public List<Categories> getCategories() throws SQLException {
        List<Categories> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_CATEGORIES);
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cateId = rs.getInt("cateId");
                        String cateName = rs.getString("cateName");
                        int status = rs.getInt("status");
                        String cateCode = rs.getString("cateCode");
                        list.add(new Categories(cateId, cateName, status, cateCode));
                    }
                }
            }
        } catch (Exception e) {
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
        return list;
    }
    
    public boolean insertNewCategory(String cateName, int status, String cateCode) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(INSERT_NEW_CATEGORY);
                psm.setString(1, cateName);
                psm.setInt(2, status);
                psm.setString(3, cateCode);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
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

    public boolean updateCategoryInfo(int cateId, String cateName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_CATEGORY_INFO);
                psm.setString(1, cateName);
                psm.setInt(2, cateId);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
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
    
    public Categories getCategoryById(int cateid) throws SQLException {
        Categories category = null;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_A_CATEGORIES);
                psm.setInt(1, cateid);
                rs = psm.executeQuery();
                if (rs.next()) {
                    int cateId = rs.getInt("cateId");
                    String cateName = rs.getString("cateName");
                    int status = rs.getInt("status");

                    category = new Categories(cateId, cateName, status);
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
        return category;
    }
    
    public static void main(String[] args) throws SQLException {
        CategoriesDAO d = new CategoriesDAO();
//        System.out.println(d.getProduct(2));
        List<Categories> list= d.getCategories();
        for (Categories o : list) {
            System.out.println(o);
        }
        
        Categories cate = d.getCategoryById(1);
        System.out.println("haha " + cate);
    }
    
}
