/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import controller.admin.AdminHomeController;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Accounts;

/**
 *
 * @author nguye
 */
public class AccessFilter implements Filter {

    private static List<String> adminList;
    private static List<String> managerList;
    private static List<String> supporterList;
    private static List<String> guestList;

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AccessFilter() {
        adminList = new ArrayList<>();

        adminList.add("homeproduct");
        adminList.add("HomeProductDetailController");
        adminList.add("HomeInforController");
        adminList.add("HomeProductController");
        adminList.add("HomeCategoryController");
        adminList.add("HomeNewsController");
        adminList.add("SearchProductController");
        adminList.add("HomeListNews");
        adminList.add("HomeListInforByCate");

        adminList.add("AdminHomeController");
        adminList.add("AdminAccountController");
        adminList.add("InsertAccountController");
        adminList.add("UpdateAccountController");
        adminList.add("AdminCategoryController");
        
        adminList.add("AdminProductController");
        adminList.add("InsertProductController");
        adminList.add("AddProductController");
        adminList.add("EditProductController");
        adminList.add("UpdateProductController");

        adminList.add("UpdateCategoryController");
        adminList.add("UpdateInforCateController");
        adminList.add("UpdateInforController");
        adminList.add("AdminInformationCategoryController");
        adminList.add("AdminInformationController");
        adminList.add("DeleteInforController");
        adminList.add("InsertInforController");
        adminList.add("HomeCategoryController");

        adminList.add("AdminOrderController");
        adminList.add("ChangeUserInfo");
        adminList.add("LoginController");
        adminList.add("LogoutController");
        adminList.add("DownloadFileController");
        adminList.add("UploadFileServlet");

        managerList = new ArrayList<>();

        managerList.add("homeproduct");
        managerList.add("HomeProductDetailController");
        managerList.add("HomeInforController");
        managerList.add("HomeCategoryController");

        managerList.add("AdminProductController");
        managerList.add("InsertProductController");
        managerList.add("AddProductController");
        managerList.add("EditProductController");
        managerList.add("UpdateProductController");
        managerList.add("SearchProductController");

        managerList.add("AdminCategoryController");
        managerList.add("UpdateCategoryController");
        managerList.add("UpdateInforCateController");
        managerList.add("UpdateInforController1");
        managerList.add("AdminInformationCategoryController");
        managerList.add("AdminInformationController");
        managerList.add("DeleteInforController");
        managerList.add("InsertInforController");

        managerList.add("AdminOrderController");
        managerList.add("ChangeUserInfo");
        managerList.add("LoginController");
        managerList.add("LogoutController");
        managerList.add("DownloadFileController");
        managerList.add("UploadFileServlet");
//        supporterList = new ArrayList<>();
//        supporterList.add("AdminOrderController");
//        supporterList.add("");
//        supporterList.add("supporter.jsp");

        guestList = new ArrayList<>();
        guestList.add("HomeListNews");
        guestList.add("ExportProductsOrderDetail");
        guestList.add("homeproduct");
        guestList.add("HomeProductDetailController");
        guestList.add("HomeCategoryController");
        guestList.add("HomeInforController");
        guestList.add("HomeNewsController");
        guestList.add("LoginController");
        guestList.add("LogoutController");
        guestList.add("utility.jsp");
        guestList.add("SearchProductController");
        guestList.add("CartController");
        guestList.add("RemoveItem");
        guestList.add("CartController");
        guestList.add("DownloadFileController");
        guestList.add("CartController");
        guestList.add("exportProducts");
        guestList.add("HomeListInforByCate");
        guestList.add("AddToCartController");
        guestList.add("CustomerInforController");
        guestList.add("ExportToExcelController_orderdetailview");
        supporterList = new ArrayList<>();

        supporterList.add("homeproduct");
        supporterList.add("HomeProductDetailController");
        supporterList.add("HomeInforController");
        supporterList.add("HomeCategoryController");

        supporterList.add("SupporterHomeController");
        supporterList.add("AdminOrderController");
        supporterList.add("inforEdit.jsp");
        supporterList.add("LoginController");
        supporterList.add("LogoutController");
        supporterList.add("DownloadFileController");

    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AccessFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("AccessFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();
        HttpSession session = httpRequest.getSession();
        Accounts acc = (Accounts) session.getAttribute("account");
        if (uri.contains(".jpg") || uri.contains(".png") || uri.contains(".jpeg") || uri.contains(".css") || uri.contains(".js") || uri.contains("fonts")) {
            chain.doFilter(request, response);
            return;
        }

        int index = uri.lastIndexOf("/");
        String resource = uri.substring(index + 1);
        if (resource.isEmpty() || resource.equals("")) {
//            httpResponse.sendRedirect("login.jsp");
            httpRequest.getRequestDispatcher("HomeInforController").forward(request, response);
            return;
        } else {
            if (acc != null && session != null) {
                if (acc.getRole() == 0) {
                    if (adminList.contains(resource)) {
                        chain.doFilter(request, response);
                    } else {
                        httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else if (acc.getRole() == 1) {
                    if (managerList.contains(resource)) {
                        chain.doFilter(request, response);
                    } else {
                        httpResponse.sendRedirect("AdminProductController");
                        //httpRequest.getRequestDispatcher("AdminProductController").forward(request, response);
                    }
                } else if (acc.getRole() == 2) {
                    if (supporterList.contains(resource)) {
                        chain.doFilter(request, response);
                    } else {
                        httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else {
                    httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } 
            else {
                if (guestList.contains(resource)) {
                    chain.doFilter(request, response);
                } else {
                    //httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
                    //httpRequest.getRequestDispatcher("HomeInforController").forward(request, response);
                    httpResponse.sendRedirect("HomeInforController");
                }
                //          httpRequest.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        if (debug) {
            log("AccessFilter:doFilter()");
        }

//        doBeforeProcessing(request, response);
//
//        Throwable problem = null;
//        try {
//            chain.doFilter(request, response);
//        } catch (Throwable t) {
//            // If an exception is thrown somewhere down the filter chain,
//            // we still want to execute our after processing, and then
//            // rethrow the problem after that.
//            problem = t;
//            t.printStackTrace();
//        }

//        doAfterProcessing(request, response);
//
//        // If there was a problem, we want to rethrow it if it is
//        // a known type, otherwise log it.
//        if (problem != null) {
//            if (problem instanceof ServletException) {
//                throw (ServletException) problem;
//            }
//            if (problem instanceof IOException) {
//                throw (IOException) problem;
//            }
//            sendProcessingError(problem, response);
//        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AccessFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AccessFilter()");
        }
        StringBuffer sb = new StringBuffer("AccessFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
