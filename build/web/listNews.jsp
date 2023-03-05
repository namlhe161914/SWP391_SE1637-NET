<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/mytaglib.tld"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Theme Made By www.w3schools.com -->
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="news/news.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="home/home.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.js"></script>
        <link rel="stylesheet" href="listnews/css/style.css">
        <link rel="stylesheet" href="listnews/css/responsive.css">
        <link rel="stylesheet" href="listnews/css/lightslider.min.css">
        <link rel="stylesheet" href="listnews/css/lightgallery.min.css">
        <link rel="stylesheet" href="home/home.css">
    </head>

    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

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
                        <li class="nav-item dropdown dropbtn"><a href="HomeListNews?index=1">NEWS</a>
                            <div class="dropdown">
                                <div class="dropdown-content">
                                    <c:forEach items="${requestScope.listInforCate}" var="LIC">
                                        <a href="HomeListInforByCate?id=${LIC.id}&index=1" style="text-decoration: none">${LIC.name}</a>
                                    </c:forEach>
                                </div>
                            </div>
                        </li>
                        
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
                            <a href="CartController">ORDER</a>
                            <!--                            </p>-->
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="jumbotron text-center">
            <h1>News</h1> 
            <p></p> 
            <form>
                <div class="input-group">

                </div>
            </form>
        </div>

        <div style="text-align: center;">
            <ul style="display: inline-block;">
                <c:forEach items="${requestScope.listInforCate}" var="LIC">
                    <li style="display: inline-block; padding-left : 50px; font-size: 20px"><a href="HomeListInforByCate?id=${LIC.id}&index=1">${LIC.name}</a></li>
                    </c:forEach>
            </ul>
        </div>

        <div id="about" class="container-fluid">

            <div class="row">
                <div class="col-sm-8">

                </div>
            </div>
        </div>

        <section class="news">
            <div class="container">
                <h1 class="name h1 left">
                    Tin tức
                </h1>
                <div class="description-culture">

                </div>
                <div class="news-cnt">
                    <c:forEach items="${requestScope.listInfor}" begin="0" end="0" var="LI">
                        <a href="HomeNewsController?iId=${LI.iId}&id=${LI.id}" class="it-news fr">
                            <div class="img">
                                <img src="${LI.coverImgPath}">
                            </div>
                            <div class="txt">
                                <p class="date">
                                    <i class="fa fa-clock-o" aria-hidden="true"></i>${LI.createDate}
                                </p>
                                <h3>${LI.description}</h3>
                            </div>
                        </a>
                    </c:forEach>

                    <c:forEach items="${requestScope.listInfor}" begin="1" end="3" var="LI">
                        <a href="HomeNewsController?iId=${LI.iId}&id=${LI.id}" class="it-news">
                            <div class="img">
                                <img src="${LI.coverImgPath}" alt="">
                            </div>
                            <div class="txt">
                                <p class="date">
                                    <i class="fa fa-clock-o" aria-hidden="true"></i>${LI.createDate}
                                </p>
                                <h3>${LI.description}</h3>

                            </div>
                        </a>
                    </c:forEach>
                </div>
                <div class="news-cnt sc">
                    <c:forEach items="${requestScope.listInfor}" begin="4" end="9" var="LI">
                        <a href="HomeNewsController?iId=${LI.iId}&id=${LI.id}" class="it-news fr">
                            <div class="img">
                                <img src="${LI.coverImgPath}" alt="">
                            </div>
                            <div class="txt">
                                <p class="date">
                                    <i class="fa fa-clock-o" aria-hidden="true"></i> ${LI.createDate}
                                </p>
                                <h3>${LI.description}</h3>
                            </div>
                        </a>
                    </c:forEach>
                </div>

                <div class="page">
                    <c:forEach begin="1" end="${size1}" var="num">
                        <a href="HomeListNews?index=${num}">${num}</a>
                    </c:forEach>
                </div>
            </div>
        </section>



        <!-- Container (About Section) -->

        <!-- Container (Contact Section) -->
        <footer id="contact" class="container-fluid bg-grey">
            <h2 class="text-center">CONTACT</h2>
            <div class="row">
                <div class="col-sm-5">
                    <p>Contact us and we'll get back to you within 24 hours.</p>
                    <p><span class="glyphicon glyphicon-map-marker"></span> Chicago, US</p>
                    <p><span class="glyphicon glyphicon-phone"></span> +00 1515151515</p>
                    <p><span class="glyphicon glyphicon-envelope"></span> myemail@something.com</p>
                </div>
                <div class="col-sm-7 slideanim">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
                        </div>
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
                        </div>
                    </div>
                    <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <button class="btn btn-default pull-right" type="submit">Send</button>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Image of location/map -->
        <!-- <img src="/w3images/map.jpg" class="w3-image w3-greyscale-min" style="width:100%">
        
        <footer class="container-fluid text-center">
          <a href="#myPage" title="To Top">
            <span class="glyphicon glyphicon-chevron-up"></span>
          </a>
          <p>Bootstrap Theme Made By <a href="https://www.w3schools.com" title="Visit w3schools">www.w3schools.com</a></p>
        </footer> -->


        <script src="home/home.js"></script>
        <script src="news/news.js"></script>
        <%@include file="components/utility.jsp" %>
    </body>
</html>
