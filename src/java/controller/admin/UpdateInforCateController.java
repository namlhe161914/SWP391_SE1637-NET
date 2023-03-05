/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dao.InformationCategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import util.DataValidation;
import model.InformationCategories;

/**
 *
 * @author nguye
 */
public class UpdateInforCateController extends HttpServlet {
   
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
            DataValidation valid = new DataValidation();
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            InformationCategoriesDAO cateDAO = new InformationCategoriesDAO();
            List<InformationCategories> list = cateDAO.getAllInforCate();
//            DataValidation valid = new DataValidation();
            if (action != null) {
                if (action.equals("insertInforCate")) {
                    String inforCate = request.getParameter("name");
                    if (valid.checkInformationCateExist(list,inforCate)) {
                        request.setAttribute("MSG_ERROR", "You have failed to create new category, Category Name not valid!");
                    } else {
                        boolean check1 = cateDAO.insertInforCate(inforCate);
                        if (check1) {
                            List<InformationCategories> listCategories = cateDAO.getAllInforCate();
                            session.setAttribute("listCategories", listCategories);
                            request.setAttribute("MSG_SUCCESS", "You have successfully create new category!");
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to create new category!");
                        }
                    }
                } else if (action.equals("updateInforCategory")) {
                    
                        int cateId = Integer.parseInt(request.getParameter("id"));
                        String cateName = request.getParameter("name");
                        List<InformationCategories> listCategories = cateDAO.getAllInforCate();
                        boolean check1 = cateDAO.updateInforCate(cateName, cateId);
                        if (check1) {
                            session.setAttribute("listCategories", listCategories);
                            request.setAttribute("MSG_SUCCESS", "You have successfully updated the category information!");
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to update category information!");
                        }
                    }
                 else if (action.equals("deleteInforCate")) {
                    int cateId = Integer.parseInt(request.getParameter("id"));
                    boolean check1 = cateDAO.deleteInforCate(cateId);
                    if (check1) {
                        List<InformationCategories> listCategories = cateDAO.getAllInforCate();
                        session.setAttribute("listCategories", listCategories);
                        request.setAttribute("MSG_SUCCESS", "You have successfully updated the category information!");
                    } else {
                        request.setAttribute("MSG_ERROR", "You have failed to delete category information!");
                    }
                } 
            } else {    
                request.setAttribute("MSG_ERROR", "Oops, something went wrong! Try later!");
            }
        } catch (Exception e) {
            log("Error at UpdateCategoryController: " + e.toString());
        } finally {
            response.sendRedirect("AdminInformationCategoryController");
            //request.getRequestDispatcher("AdminInformationController").forward(request, response);
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
