<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/17/2023
  Time: 2:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Iron Thep</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="cart/css/cart.css" />
        <link rel="stylesheet" href="cart/css/content.css" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <link href="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
        <script src="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>



        




    </head>

    <body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">
        <!-- <div class="jumbotron">
        <div class="container text-center">
        <h1>Online Store</h1>
        <p>Mission, Vission & Values</p>
        </div>
        </div> -->
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
                        <li><a href="/SWP391_SE1637-NET/homeproduct">PRODUCT</a></li>
                        <li><a href="">ORDER</a></li>
                        <!--                <li>
                        <c:set var="size" value="${sessionScope.size}"/>
                        <p id="bag"><img src="/images/cart.png" width="50" height="50"/>
                            <a href="MyEcart.jsp">Mybag (${size}) items</a>
                        </p>
                    </li>-->
                        <li><a href="">LOGIN</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron text-center">
            <h1>Products</h1>
            <p>We sell this</p>
            <form>

            </form>
        </div>


        <div class="container-fluid">

            <div class="row">
                <div class="col-lg-2"></div>
                <aside class="col-lg-5">
                    <div class="card">
                        <div class="table-responsive">

                            <table class="table table-borderless table-shopping-cart">
                                <thead class="text-muted">
                                    <tr class="small text-uppercase">
                                        <th scope="col">Product</th>
                                        <th scope="col" class="text-right d-none d-md-block" width="200"></th>
                                    </tr>
                                </thead>
                                <c:if test="${mess!=null && isRemove == true}">
                                    <div class="alert alert-success" role="alert">
                                        ${mess}
                                    </div>
                                </c:if>
                                <c:if test="${mess!=null && isRemove == false}">
                                    <div class="alert alert-danger" role="alert">
                                        ${mess}
                                    </div>
                                </c:if>

                                <c:choose>
                                    <c:when test="${sessionScope.carts == null || sessionScope.carts.size() == 0}">
                                        <h1>Cart is empty!</h1>
                                    </c:when>
                                    <c:otherwise>

                                        <c:forEach items="${carts}" var="p">
                                            <tr>
                                                <td>
                                                    <figure class="itemside align-items-center">
                                                        <div class="aside"><img src="${p.value.product.imgPath}" class="img-sm" /></div>
                                                        <figcaption class="info">
                                                            <a href="HomeProductDetailController?pId=${p.value.product.pId}" class="title text-dark" data-abc="true">${p.value.product.pName}</a>

                                                            <p class="text-muted small">
                                                                ${p.value.product.kichCo} <br>
                                                            </p>
                                                        </figcaption>
                                                    </figure>
                                                </td>


                                                <td class="text-right d-none d-md-block">
                                                    <a href="RemoveItem?pId=${p.value.product.pId}" class="btn btn-light" data-abc="true">
                                                        Remove
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>

                                    </c:otherwise>
                                </c:choose>
                            </table>
                        </div>
                    </div>
                </aside>

                <aside class="col-lg-3">

                    <div class="card mb-3">
                        <div class="card-body">
                            <form>
                                <label>Search Order</label>
                                <div class="form-group">

                                    <div class="input-group">
                                        <input type="text" class="form-control coupon" name="" placeholder="Search Order" />
                                        <div><button class="btn btn-primary btn-apply coupon">
                                                Search
                                            </button></div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <%-- <c:forEach items="${listOrder}" var="p1">
                     <tr>
                         <td>
                             <figure class="itemside align-items-center">
                                 <div class="aside"><img src="${p1.imgPath}" class="img-sm" /></div>
                                 <figcaption class="info">
                                     <a href="#" class="title text-dark" data-abc="true">${p1.pName}</a>

                            <p class="text-muted small">
                                    ${p1.kichCo} <br>
                            </p>
                        </figcaption>
                    </figure>
                </td>
           <tr>
            </c:forEach> --%>
                    <div class="card">
                        <div class="card-body">

                            <hr />
                            <!--                            <button href="#" class="" data-abc="true">
                                                            Export Price Quotation
                                                        </button>-->


                            <button type="button" class="btn btn-out btn-primary btn-square btn-main" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Export Price Quotation</button>


                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <hr />
                                            <%-- Modal --%>
                                            <h3 class="modal-title" id="exampleModalLabel">Customer Informations</h3>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">×</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form action="CustomerInforController" method="post">
                                                <div class="form-group">
                                                    <label for="recipient-name" class="form-control-label">Full Name:</label>
                                                    <input type="text" class="form-control" id="recipient-name" name="cusName">
                                                </div>

                                                <div class="form-group">
                                                    <label for="recipient-name" class="form-control-label">Email:</label>
                                                    <input type="text" class="form-control" id="recipient-name" name="email">
                                                </div>

                                                <div class="form-group">
                                                    <label for="recipient-name" class="form-control-label">Phone:</label>
                                                    <input type="text" class="form-control" id="recipient-name" name="phone">
                                                </div>

                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>


                                                    <button   type="submit" class="btn btn-primary trigger-btn" name="action" value="CusInfor">Submit</button>

                                                    

                                                </div>

                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>



                        </div>
                    </div>
                </aside>

                <div class="col-lg-2"></div>
            </div>
        </div>

        <br /><br />

        <footer id="contact" class="container-fluid bg-grey">
            <h2 class="text-center">CONTACT</h2>
            <div class="row">
                <div class="col-sm-5">
                    <p>Contact us and we'll get back to you within 24 hours.</p>
                    <p>
                        <span class="glyphicon glyphicon-map-marker"></span> Chicago, US
                    </p>
                    <p><span class="glyphicon glyphicon-phone"></span> +00 1515151515</p>
                    <p>
                        <span class="glyphicon glyphicon-envelope"></span> myemail@something.com
                    </p>
                </div>
                <div class="col-sm-4 slideanim">
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="name" name="name" placeholder="Name" type="text" required />
                        </div>
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="email" name="email" placeholder="Email" type="email" required />
                        </div>
                    </div>
                    <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea
                    ><br />
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <button class="btn btn-default pull-right" type="submit">
                                Send
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </body>



    <script src="js/product.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="js/my-user.js"></script>
</html>