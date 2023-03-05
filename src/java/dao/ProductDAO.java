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
import java.util.List;
import util.DBContext;
import model.Products;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class ProductDAO {

    private static final String GET_ALL_PRODUCTS = "SELECT pId, pName, imgPath, description, status, cateID, kichCo, trongLuong,detailPath,price   FROM swp_gr01.products";
    private static final String GET_AN_PRODUCT = "SELECT pId, pName, imgPath, description, status, cateID, kichCo, trongLuong,detailPath,price FROM swp_gr01.products WHERE pId = ?";
    private static final String INSERT_PRODUCT = "INSERT INTO swp_gr01.products Set  pName = ?, imgPath = ?, description = ?, status = ?,cateID = ?,kichCo=?,trongLuong=?,detailPath=?,price=?";
    private static final String UPDATE_PRODUCT = "UPDATE swp_gr01.products Set pName = ?, imgPath = ?, description = ?, status = ?,cateID = ?,kichCo=?,trongLuong=?,detailPath=?,price=? WHERE pId = ?";
    private static final String DELETE_PRODUCT = "DELETE FROM swp_gr01.products WHERE pId = ?";
    private static final String SEARCH_PRODUCT = "SELECT pId, pName, imgPath, description, status, cateID, kichCo, trongLuong,detailPath,price FROM swp_gr01.products WHERE pName like ?";
    private static final String UPDATE_PRODUCT_STATUS = "UPDATE swp_gr01.products Set status = ? WHERE pId = ?";
    private static final String GET_A_PRODUCT_BYCID = "SELECT pId, pName, imgPath, description, status, cateID, kichCo, trongLuong,detailPath,price FROM swp_gr01.products WHERE cateId = ?";

    
    
    
    public List<Products> getAllProducts() throws SQLException {
        List<Products> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_ALL_PRODUCTS);
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                         int pId = rs.getInt("pId");
                        String pName = rs.getString("pName");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateId = rs.getInt("cateID");
                        String kichCo = rs.getString("kichCo");
                        String trongLuong = rs.getString("trongLuong");
                        String detailPath = rs.getString("detailPath");
                        String price = rs.getString("price");

                        Products product = new Products(pId, pName, imgPath, description, status, cateId, kichCo, trongLuong, detailPath, price);
                        list.add(product);
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


    public Products getProduct(int pid) throws SQLException {
        Products product = null;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_AN_PRODUCT);
                psm.setInt(1, pid);
                rs = psm.executeQuery();
                if (rs.next()) {
                    int pId = rs.getInt("pId");
                    String pName = rs.getString("pName");
                    String imgPath = rs.getString("imgPath");
                    String description = rs.getString("description");
                    int status = rs.getInt("status");
                    int cateId = rs.getInt("cateID");
                    String kichCo = rs.getString("kichCo");
                    String trongLuong = rs.getString("trongLuong");
                    String detailPath = rs.getString("detailPath");
                    String price = rs.getString("price");

                    product = new Products(pId, pName, imgPath, description, status, cateId, kichCo, trongLuong, detailPath, price);
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
        return product;
    }

    public boolean insertProduct(String pName, String imgPath, String description, int status, int cateId, String kichCo, String trongLuong, String detailPath, String price) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_PRODUCT);
                stm.setString(1, pName);
                stm.setString(2, imgPath);
                stm.setString(3, description);
                stm.setInt(4, status);
                stm.setInt(5, cateId);
                stm.setString(6, kichCo);
                stm.setString(7, trongLuong);
                stm.setString(8, detailPath);
                stm.setString(9, price);

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

    public boolean updateProduct(String pName, String imgPath, String description, int status, int cateId, String kichCo, String trongLuong, String detailPath, String price, int pId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_PRODUCT);
                stm.setString(1, pName);
                stm.setString(2, imgPath);
                stm.setString(3, description);
                stm.setInt(4, status);
                stm.setInt(5, cateId);
                stm.setString(6, kichCo);
                stm.setString(7, trongLuong);
                stm.setString(8, detailPath);
                stm.setString(9, price);
                stm.setInt(10, pId);
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

    public boolean deleteProduct(int pId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_PRODUCT);
                stm.setInt(1, pId);
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

    public List<Products> SearchByName(String txtSearch) throws SQLException {
        List<Products> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(SEARCH_PRODUCT);
                psm.setString(1, "%" + txtSearch + "%");
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int pId = rs.getInt("pId");
                        String pName = rs.getString("pName");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateId = rs.getInt("cateID");
                        String kichCo = rs.getString("kichCo");
                        String trongLuong = rs.getString("trongLuong");
                        String detailPath = rs.getString("detailPath");
                        String price = rs.getString("price");

                        Products product = new Products(pId, pName, imgPath, description, status, cateId, kichCo, trongLuong, detailPath, price);
                        list.add(product);
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

    public boolean updateProductStatus(int pId, int status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_PRODUCT_STATUS);
                stm.setInt(1, status);
                stm.setInt(2, pId);
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
    
     public List<Products> getProductByCid(int cid) throws SQLException {
        List<Products> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_A_PRODUCT_BYCID);
                psm.setInt(1, cid);
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int pId = rs.getInt("pId");
                        String pName = rs.getString("pName");
                        String imgPath = rs.getString("imgPath");
                        String description = rs.getString("description");
                        int status = rs.getInt("status");
                        int cateId = rs.getInt("cateID");
                        String kichCo = rs.getString("kichCo");
                        String trongLuong = rs.getString("trongLuong");
                        String detailPath = rs.getString("detailPath");
                        String price = rs.getString("price");

                        Products product = new Products(pId, pName, imgPath, description, status, cateId, kichCo, trongLuong, detailPath, price);
                        list.add(product);
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
     

    
}

//class t2 {
//
//    public static void main(String[] args) throws SQLException {
//        // test getAllProducts 
////        ProductDAO d = new ProductDAO();
////        for (Products s : d.getAllProducts()) {
////            System.out.println(s);
////        }
//
//        // test getProduct
//            ProductDAO p = new ProductDAO();
//            List<Products> listProducts = p.SearchByName("test");
//
//
//            List<String> pNameList = new ArrayList<>();
//            for (Products product : listProducts) {
//                String pName = product.getpName();
//                pNameList.add(pName);
//            }
//            System.out.println(pNameList);
//            
////        System.out.println(d.getProduct(2));
////        List<Products> list = d.getProductByCid(1);
////        for (String o : pNameList) {
////            System.out.println(o);
////        }
////        d.insertProduct("test1245y7", "rehgfn", "t4rg", 0, 3, "gsd", "dfs", "gsfd", "10");
////            d.updateProduct("sup166f", "log", "log", 1,1,"log","log","log","15",12);
////        d.updateProductStatus(1, 2);
////        Products l = new ProductDAO().getProduct(3);
////         System.out.println(l);
////        d.deleteProduct(31);
//    }
//}
