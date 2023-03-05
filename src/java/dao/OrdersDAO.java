package dao;

import model.Orders;
import util.DBContext;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Cart;
import model.Customer;
import model.Products;


public class OrdersDAO {
    
    private static final String INSERT_RETURN_ID = "INSERT INTO swp_gr01.order (orderDate, status, phone, cusId) VALUES (?, ?, ?, ?)";
    private static final String GET_ORDERS = "SELECT orderId, orderDate, status, phone \n" +
            "FROM swp_gr01.order WHERE cusId = ?";
    private static final String GET_ALL_ORDERS = "SELECT orderId, orderDate, status, phone, cusId FROM swp_gr01.order";
    private static final String GET_ORDER_BY_ID = "SELECT orderId, orderDate, status, phone, cusId FROM swp_gr01.order WHERE orderId = ?";
    
    
    // Thêm đơn hàng vào cơ sở dữ liệu
//   public void addOrder(Customer u, Cart cart, Orders order) throws SQLException {
//        LocalDate curDate = java.time.LocalDate.now();
//        String date = curDate.toString();
//        try {
//            statement = connection.prepareStatement(CreateOrder);
//            statement.setString(1, date);
//            statement.setInt(2, order.getStatus());
//            statement.setString(3, order.getPhone());
//            statement.setInt(4, u.getCusId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         //lay ra id cua Order vua add
//            statement = connection.prepareStatement(Top1Order);
//            resultSet = statement.executeQuery();
//            //add vao bang Order Detail
//            if (resultSet.next()){
//                int oid = resultSet.getInt(1);
//                for (Item i: cart.getItems()) {
//                    statement = connection.prepareStatement(AddOrderDetail);
//                    statement.setInt(1, oid);
//                    statement.setInt(2, i.getProducts().getpId());
//                    statement.setString(3,i.getProducts().getpName());
//                    statement.executeUpdate();
//                }
//            }
//    }
    
    public Orders getOrderById(int orderId) throws SQLException {
        Orders order = null;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_ORDER_BY_ID);
                psm.setInt(1, orderId);
                rs = psm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderId");
                    String orderDate = rs.getString("orderDate");                    
                    int status = rs.getInt("status");
                    String phone = rs.getString("phone");
                    int cusId = rs.getInt("cusId");
                    order = new Orders(orderID, orderDate, status, phone, cusId);
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
        return order;
    }
    
    
    
    public List<Orders> getAllOrders() throws SQLException {
        List<Orders> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_ALL_ORDERS);
                rs = psm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderId");
                    String orderDate = rs.getString("orderDate");                    
                    int status = rs.getInt("status");
                    String phone = rs.getString("phone");
                    int cusId = rs.getInt("cusId");
                    Orders ord = new Orders(orderID, orderDate, status, phone, cusId);
                    list.add(ord);
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
        return list;
    }
    
    
    public List<Orders> getOrders(int cusId) throws SQLException {
        List<Orders> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_ORDERS);
                psm.setInt(1, cusId);
                rs = psm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderId");
                    String orderDate = rs.getString("orderDate");                    
                    int status = rs.getInt("status");
                    String phone = rs.getString("phone");
                    Orders ord = new Orders(orderID, orderDate, status, phone, cusId);
                    list.add(ord);
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
        return list;
    }
    
   
   public int insertReturnId(int cusId, Orders order) throws SQLException {
        int id = 1;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        java.sql.Date sqlDate = Date.valueOf(LocalDate.now());
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                psm = conn.prepareStatement(INSERT_RETURN_ID, Statement.RETURN_GENERATED_KEYS);
                psm.setDate(1, sqlDate);
                psm.setInt(2, order.getStatus());
                psm.setString(3, order.getPhone());
                psm.setInt(4, order.getCusId());
                psm.executeUpdate();

                rs = psm.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
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
        return id;
    }
   
   
   public int insertOrder(int cusId, Map<Integer, Cart> carts, String name, String phone, String email) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        int orderId = 0;
        try {
            conn = DBContext.getJDBCConnection();
            if (conn != null) {
                int orderid = 1;
                conn.setAutoCommit(false); // Off autocommit


                // Insert new order
                Orders order = new Orders(orderid, email, phone, cusId);
                orderId = new OrdersDAO().insertReturnId(cusId, order);

                // Insert OrderDetail
                new OrderDetailsDAO().saveCart(orderId, carts);
                conn.commit();
                conn.setAutoCommit(true);
                check = true;
            } else {
                System.out.println("Cannot add order!");
            }
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            check = false;
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
        return orderId;
    }
   
   
    public static void main(String[] args) throws SQLException {
        OrdersDAO o = new OrdersDAO();
        Map<Integer, Cart> carts = new HashMap<>();
        Products product = new ProductDAO().getProduct(2);
                carts.put(2, new Cart(product, 2));
        
        Orders rs = new OrdersDAO().getOrderById(14);
        System.out.println("Hello" + rs);
        
        
    }

    
    
}
