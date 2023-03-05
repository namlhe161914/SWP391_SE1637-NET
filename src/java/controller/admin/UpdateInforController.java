/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.AccountsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.InformationsDAO;
import model.InformationCategories;
import dao.InformationCategoriesDAO;
import dao.ProductDAO;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Informations;

/**
 *
 * @author nguye
 */
@WebServlet(name = "UpdateInforController", urlPatterns = {"/UpdateInforController"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpdateInforController extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */

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
        try {
            int iId = Integer.parseInt(request.getParameter("iId"));
            Informations infor = new InformationsDAO().getInforByID(iId);
            List<InformationCategories> inforCate = new InformationCategoriesDAO().getAllInforCate();
            request.setAttribute("infor", infor);
            request.setAttribute("listCate", inforCate);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("updateInfor.jsp").forward(request, response);
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
        //processRequest(request, response);
        try {
            String fileName1 = request.getParameter("file");
            if (fileName1 == null || fileName1.trim().equals("")) {}
            else{
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            String filePath = "D:\\Study\\5\\SWP391_SE1637-NET1\\web\\img" + fileName;

            try ( FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
                InputStream fileContent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            }}
            int iId = Integer.parseInt(request.getParameter("iId"));
            String content = request.getParameter("content");
            String title = request.getParameter("title");
            String img = request.getParameter("coverImgPath");
            String desc = request.getParameter("description");
            int id = Integer.parseInt(request.getParameter("id"));
            InformationsDAO dao = new InformationsDAO();
        
            dao.updateInfor(title, img, desc, content, id, iId);
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertInforController.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("AdminInformationController");
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
