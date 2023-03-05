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
import model.ProductImg;

/**
 *
 * @author lenam
 */
public class ProductImgDAO {

    private static final String GET_ALL_PRODUCTS_IMG = "SELECT imgId ,pId, imgPath  FROM swp_gr01.product_img";
    private static final String INSERT_PRODUCT_IMG = "INSERT INTO swp_gr01.product_img Set  pId = (SELECT MAX(pId) FROM swp_gr01.products), imgPath = ?";
    private static final String UPDATE_PRODUCT_IMG = "UPDATE swp_gr01.product_img Set pId = ?, imgPath = ? WHERE imgId = ?";
    private static final String DELETE_PRODUCT_IMG = "DELETE FROM swp_gr01.product_img WHERE pId = ?";
    private static final String GET_MAX_pId = "SELECT MAX(pId) FROM swp_gr01.product;";

    public List<ProductImg> getAllProductsImg() throws SQLException {
        List<ProductImg> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_ALL_PRODUCTS_IMG);
                rs = psm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int imgId = rs.getInt("imgId");
                        int pId = rs.getInt("pId");
                        String imgPath = rs.getString("imgPath");

                        ProductImg productimg = new ProductImg(imgId, pId, imgPath);
                        list.add(productimg);
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

    public void insertProductImg(String imgPath) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(INSERT_PRODUCT_IMG);
//                stm.setInt(1, pId);
                stm.setString(1, imgPath);
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
    }

    public void updateProductImg(int imgId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(UPDATE_PRODUCT_IMG);
                stm.setInt(1, imgId);
//                stm.setString(1, imgPath);
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
    }

    public void deleteProductImg(int pId) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                stm = conn.prepareStatement(DELETE_PRODUCT_IMG);
                stm.setInt(1, pId);
//                stm.setString(1, imgPath);
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
    }

}

class t1 {

    public static void main(String[] args) throws SQLException {
        // test getAllProducts 
//        ProductImgDAO d = new ProductImgDAO();
//        for (ProductImg s : d.getAllProductsImg()) {
//            System.out.println(s);
//        }

        // test getProduct
        ProductImgDAO p = new ProductImgDAO();
        p.deleteProductImg(123);

//            List<ProductImg> listProducts = p.insertProductImg("test");
//        p.insertProductImg("hìahi");
//            p.insertProductImg("files\\5b0c58es-960.jpg");
//            p.insertProductImg("files\\5b0c58es-960.jpg");
//            p.insertProductImg("img\\2021-09-04 (2).png");
//            List<String> pNameList = new ArrayList<>();
//            for (Products product : listProducts) {
//                String pName = product.getpName();
//                pNameList.add(pName);
//            }
//            System.out.println(pNameList);
//        System.out.println(d.getProduct(2));
//        List<Products> list = d.getProductByCid(1);
//        for (String o : pNameList) {
//            System.out.println(o);
//        }
//        d.insertProduct("test1245y7", "rehgfn", "t4rg", 0, 3, "gsd", "dfs", "gsfd", "10");
//            d.updateProduct("sup166f", "log", "log", 1,1,"log","log","log","15",12);
//        d.updateProductStatus(1, 2);
//        Products l = new ProductDAO().getProduct(3);
//         System.out.println(l);
//        d.deleteProduct(31);
    }
}
