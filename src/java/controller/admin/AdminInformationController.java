/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;


import dao.InformationCategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Informations;
import dao.InformationsDAO;
import model.InformationCategories;

/**
 *
 * @author nguye
 */
@WebServlet(name="AdminInformationController", urlPatterns={"/AdminInformationController"})
public class AdminInformationController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // get data from DAO/InformationDAO.java
            //int id = Integer.parseInt(request.getParameter("id"));
            List<Informations> listInfor = new InformationsDAO().getAllInfor();
            List<InformationCategories> cate = new InformationCategoriesDAO().getAllInforCate();
            //Informations listInforById = new InformationsDAO().getInforByID(id);
            // set data to managerInformation.jsp
            request.setAttribute("listInfor", listInfor);
            request.setAttribute("listCate", cate);
//            request.setAttribute("cate", cate);
//            request.setAttribute("destPage", "manageInformation");
            
            
           
        }catch (Exception e) {
            log("Error at AdminInformationController: " + e.toString());
        } finally {
            request.getRequestDispatcher("manageInformation.jsp").forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
