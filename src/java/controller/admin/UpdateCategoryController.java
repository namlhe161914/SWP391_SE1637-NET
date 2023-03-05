package controller.admin;

import dao.CategoriesDAO;
import java.io.IOException;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Categories;
import util.DataValidation;

/**
 *
 * @author Admin
 */
public class UpdateCategoryController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            CategoriesDAO cateDAO = new CategoriesDAO();
            
            DataValidation valid = new DataValidation();
            if (action != null) {
                if (action.equals("createCategory")) {
                    String cateName = request.getParameter("cateName");
                    int status = Integer.parseInt(request.getParameter("status"));
                    String cateCode = request.getParameter("cateCode");
                    List<Categories> listCategories = cateDAO.getCategories();
                    if (!valid.checkInputName(cateName)) {
                        request.setAttribute("MSG_ERROR", "You have failed to create new category, Category Name not valid (to long)!");
                    } else if(valid.checkCategoryExist2(listCategories, cateCode)){
                        request.setAttribute("MSG_ERROR", "You have failed to create new category, Category Exist (Category Code Exist)!");
                    }
                    else {
                        boolean check1 = cateDAO.insertNewCategory(cateName, status, cateCode);
                        if (check1) {
                            
                            session.setAttribute("listCategories", listCategories);
                            request.setAttribute("MSG_SUCCESS", "You have successfully create new category!");
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to create new category!");
                        }
                    }
                } else if (action.equals("updateCategory")) {
                    int cateId = Integer.parseInt(request.getParameter("cateId"));
                    String cateCode = request.getParameter("cateCode");
                    String cateName = request.getParameter("cateName");
                    
                    List<Categories> listCategories = cateDAO.getCategories();
                    if (!valid.checkInputName(cateName)) {
                        request.setAttribute("MSG_ERROR", "You have failed to create new category, Category Name not valid (to long)!");

                   }// else if(valid.checkCategoryExist2(listCategories, cateCode)){
//                        request.setAttribute("MSG_ERROR", "You have failed to create new category, Category Exist (Category Code Exist)!");
//                    }
                    else {
                        boolean check1 = cateDAO.updateCategoryInfo(cateId, cateName);
                        if (check1) {
                            
                            session.setAttribute("listCategories", listCategories);
                            request.setAttribute("MSG_SUCCESS", "You have successfully updated the category information!");
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to update category information!");
                        }
                    }
                } else if (action.equals("blockCategory")) {
                    int cateId = Integer.parseInt(request.getParameter("cateId"));

                    boolean check1 = cateDAO.updateCategoryStatus(cateId, 0);
                    if (check1) {
                        List<Categories> listCategories = cateDAO.getCategories();
                        session.setAttribute("listCategories", listCategories);
                        request.setAttribute("MSG_SUCCESS", "You have successfully block the category information!");
                    } else {
                        request.setAttribute("MSG_ERROR", "You have failed to update category information!");
                    }
                } else if (action.equals("activeCategory")) {
                    int cateId = Integer.parseInt(request.getParameter("cateId"));

                    boolean check1 = cateDAO.updateCategoryStatus(cateId, 1);
                    if (check1) {
                        List<Categories> listCategories = cateDAO.getCategories();
                        session.setAttribute("listCategories", listCategories);
                        request.setAttribute("MSG_SUCCESS", "You have successfully active the category information!");
                    } else {
                        request.setAttribute("MSG_ERROR", "You have failed to update category information!");
                    }
                }else if (action.equals("deleteCategory")) {
                    int cateId = Integer.parseInt(request.getParameter("cateId"));

                    boolean check1 = cateDAO.deleteCategory(cateId);
                    if (check1) {
                        List<Categories> listCategories = cateDAO.getCategories();
                        session.setAttribute("listCategories", listCategories);
                        request.setAttribute("MSG_SUCCESS", "You have successfully delete the category information!");
                    } else {
                        request.setAttribute("MSG_ERROR", "You have failed to update category information!");
                    }
                }
            } else {
                request.setAttribute("MSG_ERROR", "Oops, something went wrong! Try later!");
            }
        } catch (Exception e) {
            log("Error at UpdateCategoryController: " + e.toString());
        } finally {
            request.getRequestDispatcher("AdminCategoryController").forward(request, response);
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
