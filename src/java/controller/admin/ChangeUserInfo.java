package controller.admin;

import dao.AccountsDAO;
import model.Accounts;
import util.SercurityUtil;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.DataValidation;

/**
 *
 * @author Admin
 */
public class ChangeUserInfo extends HttpServlet {
    
    private static final String ADMIN_PAGE = "admininfo.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.sendRedirect(ADMIN_PAGE);
        } catch (Exception e) {
            log("Error at AdminInfo: " + e.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Accounts acc = (Accounts) session.getAttribute("account");
            AccountsDAO accDAO = new AccountsDAO();
            DataValidation valid = new DataValidation();
            if (acc != null) {
                String action = request.getParameter("action");
                if (action != null) {
                    switch (action) {
                        case "updateInfo":
                            String name = request.getParameter("name");
                            String phone = request.getParameter("phone");
                            if(!valid.checkInputName(name)){
                                request.setAttribute("MSG_ERROR", "Oops! Something went wrong! User name not valid (To Long) Try later!");
                            }else if(!valid.isValidVietNamesePhoneNumber(phone)){
                                request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Phone not valid (Wrong Format) Try later!");
                            }else{
                                boolean check = accDAO.changeAccount(acc.getEmail(), name, phone);
                                if (check) {
                                acc = accDAO.getAccountInforByEmail(acc.getEmail());
                                session.setAttribute("account", acc);
                                request.setAttribute("MSG_SUCCESS", "Update profile information successfully!");
                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
                                } else {
                                request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
                                }   
                            }
                            
                            
                            break;
                        case "changePassword":
                            String oldPassword = SercurityUtil.hashMd5(request.getParameter("oldPassword"));
                                String rePassword = SercurityUtil.hashMd5(request.getParameter("rePassword"));
                            boolean checkOldPsw = accDAO.checkOldPassword(acc.getAccId(), oldPassword);
                                boolean checkRePsw = valid.checkRepeatPassword(oldPassword, rePassword);
                            
                            if (!checkOldPsw) {
                                
                                
                                request.setAttribute("MSG_ERROR", "You entered the wrong old password! Please try again!");
                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
                            } else if (!checkRePsw){
                                request.setAttribute("MSG_ERROR", "You entered new password and re password not match! Please try again!");
                                request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
                            }else {
                                String newPasword = SercurityUtil.hashMd5(request.getParameter("newPassword"));
                                boolean checkNewPsw = accDAO.updateAccountPassword(acc.getAccId(), newPasword);
                                if (checkNewPsw) {
                                    request.setAttribute("MSG_SUCCESS", "Change password successfully!");
                                    request.getRequestDispatcher("login.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
                                    request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
                                }
                                
                            }
                            break;
                    }
                } else {
                    request.setAttribute("MSG_ERROR", "Oops! Something went wrong! Try later!");
                    request.getRequestDispatcher("invalid.jsp").forward(request, response);
                }
            } else {
            }
        } catch (Exception e) {
            log("Error at AdminInfoController: " + e.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
