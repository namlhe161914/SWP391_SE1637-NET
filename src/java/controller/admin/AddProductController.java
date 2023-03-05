/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.CategoriesDAO;
import dao.ProductDAO;
import dao.ProductImgDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.util.List;
import model.Categories;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;

import java.io.*;
import java.util.Collection;
import java.util.stream.Collectors;
import model.Products;
import util.DataValidation;

/**
 *
 * @author lenam
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AddProductController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductController at " + request.getContextPath() + "</h1>");
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
        try {
            List<Categories> listCate = new CategoriesDAO().getCategories();
            request.setAttribute("listCate", listCate);
        } catch (Exception e) {
            log("Error at ProductController: " + e.toString());
        } finally {
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
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
        // đẩy file lên server
        ProductImgDAO p = new ProductImgDAO();
        try {
            DataValidation valid = new DataValidation();
            List<Products> listProduct = new ProductDAO().getAllProducts();
            String pName = request.getParameter("pName");
            String imgPath = request.getParameter("imgPath");
            String description = request.getParameter("description");
            int status = Integer.parseInt(request.getParameter("status"));
            int cateId = Integer.parseInt(request.getParameter("cateId"));
            String kichCo = request.getParameter("kichCo");
            String trongLuong = request.getParameter("trongLuong");
            String detailPath = request.getParameter("detailPath");
            String price = request.getParameter("price");

            if (valid.checkProductExist(listProduct, pName)) {
                request.setAttribute("MSG_ERROR", "You have failed to create new product, product name is duplicate");
            } else {
                boolean check2 = new ProductDAO().insertProduct(pName, imgPath, description, status, cateId, kichCo, trongLuong, detailPath, price);

                if (check2) {
                    request.setAttribute("MSG_SUCCESS", "You have successfully created new product!");
                } else {
                    request.setAttribute("MSG_ERROR", "You have failed to create new product!");
                }
                String uploadPath = "C:\\Users\\lenam\\OneDrive\\Desktop\\swp_final\\SWP391_SE1637-NET1\\web\\files";

                // Tạo thư mục upload nếu chưa tồn tại
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                // Lấy tất cả các phần tệp từ yêu cầu tải lên
                Collection<Part> fileParts = request.getParts().stream().filter(part -> "files".equals(part.getName())).collect(Collectors.toList());

                // Lưu trữ các tệp tải lên vào thư mục upload
                for (Part filePart : fileParts) {
                    String fileName = filePart.getSubmittedFileName();
                    String filePath = uploadPath + File.separator + fileName;
                    String newfileName = "files/" + fileName;
                    p.insertProductImg(newfileName);
                    try ( FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
                        InputStream fileContent = filePart.getInputStream();
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = fileContent.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }
                    }
                }

                Collection<Part> fileParts1 = request.getParts().stream().filter(part -> "file".equals(part.getName())).collect(Collectors.toList());

                // Lưu trữ các tệp tải lên vào thư mục upload
                for (Part filePart : fileParts1) {
                    String fileName = filePart.getSubmittedFileName();
                    String filePath = uploadPath + File.separator + fileName;

                    try ( FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
                        InputStream fileContent = filePart.getInputStream();
                        int read = 0;
                        final byte[] bytes = new byte[1024];
                        while ((read = fileContent.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("Error at AdminProductController: " + e.toString());
        } finally {
            request.getRequestDispatcher("AdminProductController").forward(request, response);
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
