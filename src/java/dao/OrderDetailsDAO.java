package dao;

import model.OrderDetails;
import util.DBContext;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Orders;

public class OrderDetailsDAO {
   

    

    //
    private static final String SAVE_CART = "INSERT INTO swp_gr01.orderdetail (orderId, pId, pName, cateId) VALUES (?, ?, ?, ?)";
    private static final String GET_LIST_ORDERS_DETAIL = "SELECT orderdetailId, orderId, pId, pName, cateId FROM swp_gr01.orderdetail WHERE orderId = ?";
    
    public List<OrderDetails> getListOrdersDetail(int orderId) throws SQLException {
        List<OrderDetails> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_LIST_ORDERS_DETAIL);
                psm.setInt(1, orderId);
                rs = psm.executeQuery();
                while (rs.next()) {
                    int OrderdetailId = rs.getInt("orderdetailId");
                    int OrderId = rs.getInt("orderId");
                    int PId = rs.getInt("pId");
                    
                    int CateId = rs.getInt("cateId");
                    String PName = rs.getString("pName");
                    list.add(new OrderDetails(OrderdetailId, OrderId, PId, CateId, PName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (psm != null) psm.close();
            if (conn != null) conn.close();
        }
        return list;
    }

    public void saveCart(int orderId, Map<Integer, Cart> carts) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(SAVE_CART);
                psm.setInt(1, orderId);
                for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
                    Integer pid = entry.getKey();
                    Cart cart = entry.getValue();
                    psm.setInt(2, pid);
                    psm.setString(3, cart.getProduct().getpName());
                    psm.setInt(4, cart.getProduct().getCateId());
                    psm.executeUpdate();
                }
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
    }
    
       
    
    public static void main(String[] args) throws SQLException {
       
        OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();
        List<OrderDetails> orders = orderDetailsDAO.getListOrdersDetail(40);
        for (OrderDetails order : orders) {
            System.out.println(order);
        }
    }
}
