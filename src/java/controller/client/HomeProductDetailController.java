/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.client;

import dao.CategoriesDAO;
import dao.InformationCategoriesDAO;
import dao.ProductDAO;
import dao.ProductImgDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Categories;
import model.InformationCategories;
import model.ProductImg;
import model.Products;

/**
 *
 * @author lenam
 */
@WebServlet(name = "HomeProductDetailController", urlPatterns = {"/HomeProductDetailController"})
public class HomeProductDetailController extends HttpServlet {

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
        int pId = Integer.parseInt(request.getParameter("pId"));
        try {
            ProductDAO productdao = new ProductDAO();
            Products p = productdao.getProduct(pId);
            List<Categories> listCate = new CategoriesDAO().getCategories();
            List<Products> listProducts = new ProductDAO().getAllProducts();
            List<ProductImg> listProImg = new ProductImgDAO().getAllProductsImg();
            List<InformationCategories> listInforCate = new InformationCategoriesDAO().getAllInforCate();
            request.setAttribute("listInforCate", listInforCate);
            request.setAttribute("listProducts", listProducts);
            request.setAttribute("listCate", listCate);
            request.setAttribute("detail", p);
            request.setAttribute("listProImg", listProImg);
            List<Products> listProductsSearch = new ProductDAO().getAllProducts();
            request.setAttribute("listProductsSearch", listProductsSearch);
        } catch (Exception e) {
            log("Error at ProductController: " + e.toString());
        } finally {
            request.getRequestDispatcher("homeproductDetail.jsp").forward(request, response);
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
    }
}
