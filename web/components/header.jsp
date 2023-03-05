<%-- 
    Document   : header
    Created on : Mar 2, 2023, 3:29:39 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="#myPage">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/SWP391_SE1637-NET/HomeInforController">ABOUT</a></li>
                <li><a href="HomeListNews?index=1">NEWS</a></li>
                <li class="nav-item dropdown dropbtn"><a href="/SWP391_SE1637-NET/homeproduct">PRODUCT</a>
                    <div class="dropdown">
                        <div class="dropdown-content">
                            <c:forEach items="${requestScope.listCate}" var="LC">
                                <a href="HomeCategoryController?cateId=${LC.cateId}" style="text-decoration: none">${LC.cateName}</a>
                            </c:forEach>
                        </div>
                    </div>
                </li>
                <li>
                <c:set var="size" value="${sessionScope.size}"/>
                <!--<p id="bag"><img src="images/cart.png" width="50" height="50"/>-->
                <a href="CartController">ORDER</a>
                <!--                            </p>-->
                </li>
            </ul>
        </div>
    </div>
</nav>
