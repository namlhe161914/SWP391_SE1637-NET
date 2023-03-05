<%-- 
    Document   : adminSlideNavComponent
    Created on : Mar 8, 2022, 11:52:14 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <c:if test="${sessionScope.account.role==0}">
                    <div class="sb-sidenav-menu-heading">Core</div>
                    <a class="nav-link ${requestScope.destPage eq "dashboard" ? "active" : ""}" href="AdminHomeController">
                        <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                        Dashboard
                    </a>
                </c:if>
                
                <div class="sb-sidenav-menu-heading">Manage</div>
                <c:if test="${sessionScope.account.role==0}">
                    <a class="nav-link ${requestScope.destPage eq "manageAccount" ? "active" : ""}" href="AdminAccountController">
                        <i class="bi bi-person-lines-fill sb-nav-link-icon"></i>
                        Accounts
                    </a>
                </c:if>
                 
                <%--   <c:if test="${sessionScope.session.role == 0}">
                    <a class="nav-link ${requestScope.destPage eq "manageAccount" ? "active" : ""}" href="AdminAccountController">
                        <i class="bi bi-person-lines-fill sb-nav-link-icon"></i>
                        Accounts
                    </a>
                </c:if> 
                --%>
                <c:if test="${sessionScope.account.role==0 or sessionScope.account.role==1}">
                    <a class="nav-link ${requestScope.destPage eq "manageProduct" ? "active" : ""}" href="AdminProductController">
                        <i class="bi bi-tree sb-nav-link-icon"></i>
                        Products
                    </a>
                    <a class="nav-link ${requestScope.destPage eq "manageCategory" ? "active" : ""}" href="AdminCategoryController">
                        <i class="bi bi-tags sb-nav-link-icon"></i>
                        Products Categories
                    </a>
                    <a class="nav-link ${requestScope.destPage eq "manageCategory" ? "active" : ""}" href="AdminInformationController">
                        <i class="bi bi-tags sb-nav-link-icon"></i>
                        Information
                    </a>
                    <a class="nav-link ${requestScope.destPage eq "manageCategory" ? "active" : ""}" href="AdminInformationCategoryController">
                        <i class="bi bi-tags sb-nav-link-icon"></i>
                        Information Categories
                    </a>
                </c:if>
                <c:if test="${sessionScope.account.role==2 or sessionScope.account.role==1 or sessionScope.account.role==0}">
                    <a class="nav-link ${requestScope.destPage eq "manageOrder" ? "active" : ""}" href="AdminOrderController">
                        <i class="bi bi-basket sb-nav-link-icon"></i>
                        Orders
                    </a>

                    <a class="nav-link ${requestScope.destPage eq "supporter" ? "active" : ""}" href="supporter.jsp">
                        <i class="bi bi-basket sb-nav-link-icon"></i>
                        Supporter
                    </a>
                </c:if>
               
<!--                <div class="sb-sidenav-menu-heading">Addons</div>
                <a class="nav-link" href="#!">
                    <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                    Charts
                </a>-->
<!--                <div class="sb-sidenav-menu-heading">Utils</div>
                <a class="nav-link $requestScope.destPage eq "sendMail" ? "active" : ""}" href="SendEmailController?action=pageDirect">
                    <div class="sb-nav-link-icon"><i class="bi bi-envelope"></i></div>
                    Send mail
                </a>-->
            </div>
        </div>
        <div class="sb-sidenav-footer">
            <div class="small">Logged in as:</div>
            <c:if test="${sessionScope.account.role==0}">
                <h5>Admin</h5>
            </c:if>
            <c:if test="${sessionScope.account.role==1}">
                <h5>Manager</h5>
            </c:if>
            <c:if test="${sessionScope.account.role==2}">
                <h5>Supporter</h5>
            </c:if>
        </div>
    </nav>
</div>