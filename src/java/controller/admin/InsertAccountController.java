/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.admin;

import dao.AccountsDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import javax.swing.JOptionPane;
import model.Accounts;
import util.DataValidation;
import util.SercurityUtil;
/**
 *
 * @author Admin
 */
public class InsertAccountController extends HttpServlet {

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
            HttpSession session = request.getSession();
            String action = request.getParameter("action1");
            AccountsDAO acc = new AccountsDAO();
            DataValidation valid = new DataValidation();
            if (action != null) {
                if  (action.equals("createAccount")) {
                
                String passwordRaw = request.getParameter("password");
                if(!valid.checkLimitCharactor(passwordRaw)){
                    request.setAttribute("MSG_ERROR", "You have failed to create new account, Password not valid (password must have more than 6 and less than 50 charactors)!");
               
                }else{
                    String email = request.getParameter("email");
                    String password = SercurityUtil.hashMd5(request.getParameter("password"));               
                    String fullname = request.getParameter("fullName");
                    String phone = request.getParameter("phone");
                    int status = Integer.parseInt(request.getParameter("status"));
                    int role = Integer.parseInt(request.getParameter("role"));
                    List<Accounts> listAccounts = acc.getAccounts();               
                    if(!valid.checkInputName(fullname)){
                        request.setAttribute("MSG_ERROR", "You have failed to create new account, Username not valid (to long)!");
                    }else if(valid.checkAccountExist(listAccounts, email, phone)){
                        request.setAttribute("MSG_ERROR", "You have failed to create new account, Email or Phone Exist!");
                    }else if(!valid.isValidEmailAddress(email)){
                        request.setAttribute("MSG_ERROR", "You have failed to create new account, Email not valid (wrong email type)!");
                    }else if(!valid.isValidVietNamesePhoneNumber(phone)){
                        request.setAttribute("MSG_ERROR", "You have failed to create new account, Phone not valid (wrong type of VietNamese Phone Number)!");
                    }else{
                        boolean check1 = acc.insertAccount(email, password, fullname, phone, status, role);
                        if (check1) {
                            //List<Accounts> listAccounts = acc.getAccounts();
                            session.setAttribute("listAccounts", listAccounts);
                            request.setAttribute("MSG_SUCCESS", "You have successfully create new account!");
                        } else {
                            request.setAttribute("MSG_ERROR", "You have failed to create new account!");
                        }

                    }
                
                 }   
                    
                } else if (action.equals("updateAccount")) {
                    String passwordRaw = request.getParameter("password");
                if(!valid.checkLimitCharactor(passwordRaw)){
                    request.setAttribute("MSG_ERROR", "You have failed to create new account, Password not valid (password must have more than 6 and less than 50 charactors)!");
               
                }else{
                        String email = request.getParameter("email");
                        String password = SercurityUtil.hashMd5(request.getParameter("password"));   
                        String fullname = request.getParameter("fullName");
                        String phone = request.getParameter("phone");                    
                        int role = Integer.parseInt(request.getParameter("role"));
                        List<Accounts> listAccounts = acc.getAccounts();

                        if(!valid.checkInputName(fullname)){
                            request.setAttribute("MSG_ERROR", "You have failed to update new account, Username not valid!");

                        }else if(!valid.isValidVietNamesePhoneNumber(phone)){
                            request.setAttribute("MSG_ERROR", "You have failed to update new account, Phone not valid!");
                        }else{
                            boolean check1 = acc.updateAccount(email, password, fullname, phone, role);
                            if (check1) {                        
                                session.setAttribute("listAccounts", listAccounts);
                                request.setAttribute("MSG_SUCCESS", "You have successfully updated the account information!");
                            } else {
                                request.setAttribute("MSG_ERROR", "You have failed to update account information!");
                            }
                        }
                    }
                }
                else if (action.equals("deleteAccount")) {
                    int accId = Integer.parseInt(request.getParameter("accId"));

                    boolean check1 = acc.deleteAccount(accId);
                    if (check1) {
                        List<Accounts> listAccount = acc.getAccounts();
                        session.setAttribute("listAccount", listAccount);
                        request.setAttribute("MSG_SUCCESS", "You have successfully delete the account information!");
                    } else {
                        request.setAttribute("MSG_ERROR", "You have failed to update account information!");
                    }
                }
            } else {
                request.setAttribute("MSG_ERROR", "Oops, something went wrong! Try later!");
            }
        } catch (Exception e) {
            log("Error at InsertAccountController: " + e.toString());
        } finally {
            request.getRequestDispatcher("AdminAccountController").forward(request, response);
            //response.sendRedirect("AdminAccountController");
        }
           
        
    }
//    public static String password ;
//    public static void main(String[] args) {
//        
//        System.out.println(password);
//    }
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
