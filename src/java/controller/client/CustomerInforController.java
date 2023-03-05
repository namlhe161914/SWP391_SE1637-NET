/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.client;

import dao.CustomerDAO;
import dao.OrdersDAO;
import model.Customer;
import model.Cart;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import model.Orders;
import util.DataValidation;

/**
 *
 * @author Admin
 */
@WebServlet(name="CustomerInforController", urlPatterns={"/CustomerInforController"})
public class CustomerInforController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // lưu thong tin cưstomer ve database
        try {
            HttpSession session = request.getSession();
            String cusInfor = request.getParameter("action");
            CustomerDAO cus = new CustomerDAO();
            DataValidation valid = new DataValidation();

            int token = ThreadLocalRandom.current().nextInt(1000, 10000);  // genarate token 

            if (cusInfor != null) {

                if (cusInfor.equals("CusInfor")) {

                    String cusName = request.getParameter("cusName");
                    String email = request.getParameter("email");
                    String phone = request.getParameter("phone");

                    if (!valid.checkInputName(cusName)) {
                        request.setAttribute("MSG_ERROR", "You have failed to insert information, Name not valid (to long or empty)!");
                    } else if (!valid.isValidEmailAddress(email)) {
                        request.setAttribute("MSG_ERROR", "You have failed to insert information, Email not valid (wrong email type or empty)!");
                    } else if (!valid.isValidVietNamesePhoneNumber(phone)) {
                        request.setAttribute("MSG_ERROR", "You have failed to insert information, Phone not valid (wrong type of VietNamese Phone Number or empty)!");
                    } else {
                        boolean check = cus.insertCustomer(cusName, email, phone, token);
                        log("Iam dump2 CustomerInforController !");
                        if (check) {
                            //List<Accounts> listAccounts = acc.getAccounts();
                            //session.setAttribute("listAccounts", listAccounts);
                            request.setAttribute("MSG_SUCCESS", "You have successfully Submit your Information!");

                            Customer customer = cus.getCustomerByToken(token);   // get customer by token
                            session.setAttribute("customer", customer);
                            Map<Integer, Cart> carts = (Map<Integer, Cart>) session.getAttribute("carts");

                            if (carts != null && !carts.isEmpty()) {
                                //    request.getRequestDispatcher("exportExcel.jsp").forward(request, response);// chuyển đến màn hình export

//                                for (Map.Entry<Integer, Cart> entry : carts.entrySet()) {
//                                    Object key = entry.getKey();
//                                    Object val = entry.getValue();
//                                    log("da co cart trong session",(Throwable) key);
//                                    
//                                }
                                Customer cusSession = (Customer) session.getAttribute("customer");

                                // Save all cart to database (order/orderdetail)
                                if (carts != null && !carts.isEmpty()) { // Cart is not empty 
                                    if (cusSession != null) { // orderId = 0 is default ~ insert false
                                        int orderId = new OrdersDAO().insertOrder(cusSession.getCusId(), carts, cusName, phone, email);
                                        
                                         
                                        if (orderId != 0) {
                                            session.removeAttribute("carts");
                                            log("1");

                                            request.setAttribute("MSG_SUCCESS", "Your order has been successfully placed!");
                                            //request.getRequestDispatcher("cart.jsp").forward(request, response);
                                            // response.sendRedirect("ExportToExcelController_orderdetailview"); ///// send đen trang tai
                                            
                                            // day orderId thanh session sau do get o trang export, sau do xoa session.
                                            Orders o = new OrdersDAO().getOrderById(orderId);
                                            session.setAttribute("orderId", o);
                                            
                                            
                                            request.getRequestDispatcher("ExportToExcelController_orderdetailview").forward(request, response);
                                            log("2");
                                        } else {
                                            log("3");
                                            request.setAttribute("MSG_ERROR", "These products are out of stock!");
                                            request.getRequestDispatcher("cart.jsp").forward(request, response);
                                            log("4");
                                        }
                                    } else {
                                        log("5");
                                        response.sendRedirect("cart.jsp");
                                        log("6");
                                    }
                                }// debug đến dây
                                else {
                                    log("7");
                                    response.sendRedirect("homeproduct");// chuyển đến trang product nếu chưa có gì trong cart
                                    log("8");
                                }

                            } else {
                                log("9");
                                response.sendRedirect("homeproduct");// chuyển đến trang product nếu chưa có gì trong cart
                                log("10");
                            }

                            log("Tui ngu" + customer);
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to Submit your Information !");
                            response.sendRedirect("cart.jsp");
                        }

                    }

                }

            } else {
                request.setAttribute("MSG_ERROR", "Oops, something went wrong(In database/server)! Try later!");
            }
        } catch (Exception e) {
            log("Error at CustomerInforController: " + e.toString());
        }
//        finally {
//            //request.getRequestDispatcher("cart.jsp").forward(request, response);
//           response.sendRedirect("cart.jsp");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
