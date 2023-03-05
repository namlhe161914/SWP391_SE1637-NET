/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author lenam
 */
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {

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
            String action = request.getParameter("actionUpdateProductStatus");
            int pId = Integer.parseInt(request.getParameter("pId"));
            if (action != null) {
                switch (action) {
                    case "blockProduct":

                        boolean check = new ProductDAO().updateProductStatus(pId, 0);
                        if (check) {
                            request.setAttribute("MSG_SUCCESS", "You have successfully blocked the product!");
                        } else {
                            request.setAttribute("MSG_ERROR", "An error occurred! Block product failed!");
                        }
                        break;
                    case "unblockProduct":
                        boolean check1 = new ProductDAO().updateProductStatus(pId, 1);
                        if (check1) {
                            request.setAttribute("MSG_SUCCESS", "You have successfully unblocked the product!");
                        } else {
                            request.setAttribute("MSG_ERROR", "An error occurred! Unblock product failed!");
                        }

                        break;
                }
            } else {
                request.setAttribute("MSG_ERROR", "Oops, something went wrong! Please try later!");
            }
        } catch (Exception e) {
            log("Error at AdminProductController: " + e.toString());
        } finally {
            //request.getRequestDispatcher("AdminAccountController").forward(request, response);
            response.sendRedirect("AdminProductController");
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
