/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.sync;

import dao.AccountsDAO;
import model.Accounts;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import util.SercurityUtil;
/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

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
        try {
            String email = request.getParameter("email"); //lay email ve
            String password = SercurityUtil.hashMd5(request.getParameter("password")); //
           // String password = request.getParameter("password");
            Accounts acc = new AccountsDAO().getAccount(email, password);
                      
            if(acc == null){
                request.setAttribute("mess", "Account do not exist !!! ");
                request.getRequestDispatcher("login.jsp").forward(request, response);
//                response.sendRedirect("login.jsp");
            }
            else if(acc != null && acc.getStatus() == 0) {
                request.setAttribute("mess", "Account is blocked !!! ");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            else{
                int role = acc.getRole();
                HttpSession session = request.getSession();
                session.setAttribute("account", acc);
                switch (role) {
                    case 0:
                        response.sendRedirect("AdminHomeController");
                        break;
                    case 1:
                        response.sendRedirect("AdminHomeController");
                        break;
                    case 2:
                        response.sendRedirect("SupporterHomeController");
                        break;
                }
            }
    
        }catch (Exception e) {
            log("Error at LoginController: " + e.toString());
        }
        
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
        processRequest(request, response);
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
