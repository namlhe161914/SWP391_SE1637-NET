/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.InformationsDAO;
import dao.InformationCategoriesDAO;
import dao.ProductDAO;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import model.InformationCategories;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import model.Informations;
import model.Products;
import util.DataValidation;

/**
 *
 * @author nguye
 */
@WebServlet(name = "InsertInforController", urlPatterns = {"/InsertInforController"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class InsertInforController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertInforClone</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertInforClone at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        try {
            List<InformationCategories> listCate = new InformationCategoriesDAO().getAllInforCate();
            request.setAttribute("listCate", listCate);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("insertInfor.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a   servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DataValidation valid = new DataValidation();
            List<Informations> listInfor = new InformationsDAO().getAllInfor();
                        String uploadPath = "D:\\Study\\5\\SWP391_SE1637-NET1\\web\\img";

            // Tạo thư mục upload nếu chưa tồn tại
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Lấy tất cả các phần tệp từ yêu cầu tải lên
            Collection<Part> fileParts = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

            // Lưu trữ các tệp tải lên vào thư mục upload
            for (Part filePart : fileParts) {
                String fileName = filePart.getSubmittedFileName();
                String filePath = uploadPath + File.separator + fileName;
                String newfileName = "files/" + fileName;

                try ( FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    InputStream fileContent = filePart.getInputStream();
                    int read = 0;
                    final byte[] bytes = new byte[1024];
                    while ((read = fileContent.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                }
            }


            String title = request.getParameter("title");
            String coverImgPath = request.getParameter("coverImgPath");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            int id = Integer.parseInt(request.getParameter("id"));
            int accId = Integer.parseInt(request.getParameter("accId"));
            InformationsDAO inforDAO = new InformationsDAO();
//            if (valid.checkInformationExist(listInfor, title)) {
//                request.setAttribute("MSG_ERROR", "You have failed to create new information");
//            } else {
                boolean check = inforDAO.insertInfor(title, coverImgPath, description, content, accId, id);
//                if (check) {
//                    request.setAttribute("MSG_SUCCESS", "You have successfully created new information!");
//                } else {
//                    request.setAttribute("MSG_ERROR", "You have failed to create new information!");
//                }
//            }
        } catch (Exception e) {
            log("Error at InsertInforController.java" + e.toString());
        } 
        response.sendRedirect("AdminInformationController");
        //processRequest(request, response);
        

        
        //processRequest(request, response);
        
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
