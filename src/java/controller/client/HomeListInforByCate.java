/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.client;

import dao.CategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Informations;
import model.InformationCategories;
import dao.InformationsDAO;
import dao.InformationCategoriesDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categories;

/**
 *
 * @author nguye
 */
public class HomeListInforByCate extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeListInforByCate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeListInforByCate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            int id = Integer.parseInt(request.getParameter("id"));
            int index = Integer.parseInt(request.getParameter("index"));
            int size;

            try {
                List<Informations> listInfor = new InformationsDAO().getInforCateByPage(id, index);
                List<InformationCategories> listCate = new InformationCategoriesDAO().getAllInforCate();
                List<Categories> productCate = new CategoriesDAO().getCategories();

                int check = listInfor.size();
                log("abc " + check);
                size = check / 10;
                if (check % 10 != 0) {
                    size++;
                }
                request.setAttribute("listInforCate", listCate);
                request.setAttribute("listInfor", listInfor);
                request.setAttribute("listCate", productCate);
                request.setAttribute("size1", size);
                request.setAttribute("ids", id);
            } catch (SQLException ex) {
                Logger.getLogger(HomeListInforByCate.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("listNewsCate.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeListInforByCate.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeListInforByCate.class.getName()).log(Level.SEVERE, null, ex);
        }
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
