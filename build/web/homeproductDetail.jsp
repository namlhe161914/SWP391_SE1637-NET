<%-- 
    Document   : homeproductDetail
    Created on : Feb 11, 2023, 6:25:00 PM
    Author     : lenam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/mytaglib.tld"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product Detail</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="home/product.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900|Rubik:300,400,500,700,900');

            * {
                margin: 0;
                padding: 0;
                -webkit-font-smoothing: antialiased;
                -webkit-text-shadow: rgba(0, 0, 0, .01) 0 0 1px;
                text-shadow: rgba(0, 0, 0, .01) 0 0 1px
            }



            div {
                display: block;
                position: relative;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box
            }




            .bbb_viewed {
                padding-top: 51px;
                padding-bottom: 60px;
                background: white;
            }

            .bbb_main_container{
                background-color: #eeeeee;
                padding: 11px;
            }

            .bbb_viewed_title_container {
                border-bottom: solid 1px #dadada
            }

            .bbb_viewed_title {
                margin-bottom: 16px;
                margin-top: 8px;

            }

            .bbb_viewed_nav_container {
                position: absolute;
                right: -5px;
                bottom: 14px
            }

            .bbb_viewed_nav {
                display: inline-block;
                cursor: pointer
            }

            .bbb_viewed_nav i {
                color: #dadada;
                font-size: 18px;
                padding: 5px;
                -webkit-transition: all 200ms ease;
                -moz-transition: all 200ms ease;
                -ms-transition: all 200ms ease;
                -o-transition: all 200ms ease;
                transition: all 200ms ease
            }

            .bbb_viewed_nav:hover i {
                color: #606264
            }

            .bbb_viewed_prev {
                margin-right: 15px
            }

            .bbb_viewed_slider_container {
                padding-top: 13px;
            }

            .bbb_viewed_item {
                width: 100%;
                background: #eeeeee;
                border-radius: 2px;
                padding-top: 25px;
                padding-bottom: 25px;
                padding-left: 30px;
                padding-right: 30px
            }

            .bbb_viewed_image {
                width: 150px;
                height: 150px;
            }

            .bbb_viewed_image img {
                display: block;
                max-width: 100%
            }

            .bbb_viewed_content {
                width: 100%;
                margin-top: 25px
            }

            .bbb_viewed_price {
                font-size: 16px;
                color: #000000;
                font-weight: 500
            }

            .bbb_viewed_item.discount .bbb_viewed_price {
                color: #df3b3b
            }

            .bbb_viewed_price span {
                position: relative;
                font-size: 12px;
                font-weight: 400;
                color: rgba(0, 0, 0, 0.6);
                margin-left: 8px
            }

            .bbb_viewed_price span::after {
                display: block;
                position: absolute;
                top: 6px;
                left: -2px;
                width: calc(100% + 4px);
                height: 1px;
                background: #8d8d8d;
                content: ''
            }

            .bbb_viewed_name {
                margin-top: 3px
            }

            .bbb_viewed_name a {
                font-size: 14px;
                color: #000000;
                -webkit-transition: all 200ms ease;
                -moz-transition: all 200ms ease;
                -ms-transition: all 200ms ease;
                -o-transition: all 200ms ease;
                transition: all 200ms ease
            }

            .bbb_viewed_name a:hover {
                color: #0e8ce4
            }

            .item_marks {
                position: absolute;
                top: 18px;
                left: 18px
            }

            .item_mark {
                display: none;
                width: 36px;
                height: 36px;
                border-radius: 50%;
                color: #FFFFFF;
                font-size: 10px;
                font-weight: 500;
                line-height: 36px;
                text-align: center
            }


            .item_new {
                background: #0e8ce4
            }



            .bbb_viewed_item.is_new .item_new {
                display: inline-block
            }
        </style> 
        <style>

            .autocomplete-items {
                position: absolute;
                border: 1px solid #d4d4d4;
                border-bottom: none;
                border-top: none;
                z-index: 99;
                /*position the autocomplete items to be the same width as the container:*/
                top: 100%;
                left: 0;
                right: 0;
            }
            .autocomplete-items div {
                padding: 10px;
                cursor: pointer;
                background-color: white;
                border-bottom: 1px solid #d4d4d4;
                color: black;
                text-align: start;
            }
            .autocomplete-items div:hover {
                /*when hovering an item:*/
                background-color: #e9e9e9;
            }
            .autocomplete-active {
                /*when navigating through the items using the arrow keys:*/
                background-color: DodgerBlue !important;
                color: black;
            }
        </style>
    </head>
    <div id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

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
                            <!--<p id="bag"><img src="images/cart.png" width="50" height="50"/>-->
                                <a href="CartController">ORDER</a>
<!--                            </p>-->
                        </li>
                        <!--        <li><a href="/SWP391_SE1637-NET/login.jsp">LOGIN</a></li>-->
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron text-center">
            <h1>Products</h1> 
            <p>We sell this</p> 
            <form autocomplete="off" action="SearchProductController" style="width: 50%; margin-left : 25%">
                <div class="input-group" >
                    <input  class="form-control" size="50" placeholder="Product"  id="myInput" type="text" name="txt">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-danger">Search</button>
                    </div> 
                </div> 
            </form>
        </div>
        <!-- <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
              </button>
              <a class="navbar-brand" href="#">Logo</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Products</a></li>
                <li><a href="#">Deals</a></li>
                <li><a href="#">Stores</a></li>
                <li><a href="#">Contact</a></li>
              </ul>
              <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
              </ul>
            </div>
          </div>
        </nav> -->


        <div class="container">
            <div class="card">
                <div class="container-fliud">
                    <div class="wrapper row">
                        <div class="preview col-md-6">

                            <div class="preview-pic tab-content">
                                <div class="tab-pane active" id="pic-1"><img src="${detail.imgPath}" /></div>
                                    <c:forEach items="${requestScope.listProImg}" var="LPI"> 

                                    <c:if test="${LPI.pId eq detail.pId}">
                                        <div class="tab-pane" id="pic"><img src="${LPI.imgPath}" /></div>
                                        </c:if>
                                    </c:forEach> 
                            </div>
                            <ul class="preview-thumbnail nav nav-tabs">
                                
                                <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="${detail.imgPath}" /></a></li>
                                        <c:forEach items="${requestScope.listProImg}" var="LPI"> 
                                            <c:if test="${LPI.pId eq detail.pId}">
                                        <li><a data-target="#pic" data-toggle="tab"><img src="${LPI.imgPath}" /></a></li> 
                                            </c:if>
                                        </c:forEach> 
                            </ul>

                        </div>
                        <div class="details col-md-6">
                            <h3 class="product-title">${detail.pName}</h3>
                            <!-- <div class="rating">
                                <div class="stars">
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star"></span>
                                    <span class="fa fa-star"></span>
                                </div>
                                <span class="review-no">41 reviews</span>
                            </div> -->
                            <p class="product-description">${detail.description}</p>
                            <!-- <h4 class="price">current price: <span>$180</span></h4>
                             <p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p> -->
                            <h5 class="sizes">Category:
                                <c:forEach items="${requestScope.listCate}" var="LC">  
                                    <c:if test="${LC.cateId eq detail.cateId}"> <a href="HomeCategoryController?cateId=${detail.cateId}">${LC.cateName}</a></c:if>
                                </c:forEach>

                            </h5>
                            <h5 class="kichCo">Size:
                                <span>${detail.kichCo}</span>
                                <!-- <span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
                                <span class="color green"></span>
                                <span class="color blue"></span> -->
                            </h5>
                            <h5 class="trongLuong">Weight:
                                <span>${detail.trongLuong}</span>
                            </h5>   

                            <div class="action" style="display:flex; gap: 1%">
                                <a onclick="addToCartAsync(${LP.pId})" class="btn btn-outline-dark mt-auto w-50 like btn btn-default">Add To Cart</a>
                                <form action="DownloadFileController" method="get">
                                    <input  value="${detail.detailPath}" name="detailPath" hidden="">
                                    <button type="submit" class="like btn btn-default">Catologue</button>
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <br><br><br>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.js"></script>
        <div class="bbb_viewed">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="bbb_main_container">
                            <div class="bbb_viewed_title_container">
                                <h3 class="bbb_viewed_title">Sản phẩm tương tự</h3>
                                <div class="bbb_viewed_nav_container">
                                    <div class="bbb_viewed_nav bbb_viewed_prev"><</div>
                                    <div class="bbb_viewed_nav bbb_viewed_next">>   </div>
                                </div>
                            </div>
                            <div class="bbb_viewed_slider_container">
                                <div class="owl-carousel owl-theme bbb_viewed_slider">
                                    <c:forEach items="${requestScope.listProducts}" var="LP">
                                        <c:if test="${LP.cateId eq detail.cateId and (LP.status eq 1) and !(LP.pName eq detail.pName)}">
                                            <div class="owl-item">
                                                <div class="bbb_viewed_item discount d-flex flex-column align-items-center justify-content-center text-center">
                                                    <div class="bbb_viewed_image"><a href="HomeProductDetailController?pId=${LP.pId}" class="normal-font"><img src="${LP.imgPath}"  class="img-responsive" ></a></div>
                                                    <div class="bbb_viewed_content text-center">

                                                        <div class="bbb_viewed_name"><a href="#">${LP.pName}</a></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </c:forEach>



                                </div>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>



        <footer id="contact" class="container-fluid bg-grey">
            <h2 class="text-center">CONTACT</h2>
            <div class="row">
                <div class="col-sm-5">
                    <p>Contact us and we'll get back to you within 24 hours.</p>
                    <p><span class="glyphicon glyphicon-map-marker"></span> Chicago, US</p>
                    <p><span class="glyphicon glyphicon-phone"></span> +00 1515151515</p>
                    <p><span class="glyphicon glyphicon-envelope"></span> myemail@something.com</p>
                </div>
                <div class="col-sm-4 slideanim">
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
        <%@include file="components/utility.jsp" %>
    </body>
    <script src="home/product.js"></script>
    <script>
        function autocomplete(inp, arr) {
            /*the autocomplete function takes two arguments,
             the text field element and an array of possible autocompleted values:*/
            var currentFocus;
            /*execute a function when someone writes in the text field:*/
            inp.addEventListener("input", function (e) {
                var a, b, i, val = this.value;
                /*close any already open lists of autocompleted values*/
                closeAllLists();
                if (!val) {
                    return false;
                }
                currentFocus = -1;
                /*create a DIV element that will contain the items (values):*/
                a = document.createElement("DIV");
                a.setAttribute("id", this.id + "autocomplete-list");
                a.setAttribute("class", "autocomplete-items");
                /*append the DIV element as a child of the autocomplete container:*/
                this.parentNode.appendChild(a);
                /*for each item in the array...*/
                for (i = 0; i < arr.length; i++) {
                    /*check if the item starts with the same letters as the text field value:*/
                    if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                        /*create a DIV element for each matching element:*/
                        b = document.createElement("DIV");
                        /*make the matching letters bold:*/
                        b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                        b.innerHTML += arr[i].substr(val.length);
                        /*insert a input field that will hold the current array item's value:*/
                        b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                        /*execute a function when someone clicks on the item value (DIV element):*/
                        b.addEventListener("click", function (e) {
                            /*insert the value for the autocomplete text field:*/
                            inp.value = this.getElementsByTagName("input")[0].value;
                            /*close the list of autocompleted values,
                             (or any other open lists of autocompleted values:*/
                            closeAllLists();
                        });
                        a.appendChild(b);
                    }
                }
            });
            /*execute a function presses a key on the keyboard:*/
            inp.addEventListener("keydown", function (e) {
                var x = document.getElementById(this.id + "autocomplete-list");
                if (x)
                    x = x.getElementsByTagName("div");
                if (e.keyCode == 40) {
                    /*If the arrow DOWN key is pressed,
                     increase the currentFocus variable:*/
                    currentFocus++;
                    /*and and make the current item more visible:*/
                    addActive(x);
                } else if (e.keyCode == 38) { //up
                    /*If the arrow UP key is pressed,
                     decrease the currentFocus variable:*/
                    currentFocus--;
                    /*and and make the current item more visible:*/
                    addActive(x);
                } else if (e.keyCode == 13) {
                    /*If the ENTER key is pressed, prevent the form from being submitted,*/
                    e.preventDefault();
                    if (currentFocus > -1) {
                        /*and simulate a click on the "active" item:*/
                        if (x)
                            x[currentFocus].click();
                    }
                }
            });
            function addActive(x) {
                /*a function to classify an item as "active":*/
                if (!x)
                    return false;
                /*start by removing the "active" class on all items:*/
                removeActive(x);
                if (currentFocus >= x.length)
                    currentFocus = 0;
                if (currentFocus < 0)
                    currentFocus = (x.length - 1);
                /*add class "autocomplete-active":*/
                x[currentFocus].classList.add("autocomplete-active");
            }
            function removeActive(x) {
                /*a function to remove the "active" class from all autocomplete items:*/
                for (var i = 0; i < x.length; i++) {
                    x[i].classList.remove("autocomplete-active");
                }
            }
            function closeAllLists(elmnt) {
                /*close all autocomplete lists in the document,
                 except the one passed as an argument:*/
                var x = document.getElementsByClassName("autocomplete-items");
                for (var i = 0; i < x.length; i++) {
                    if (elmnt != x[i] && elmnt != inp) {
                        x[i].parentNode.removeChild(x[i]);
                    }
                }
            }
            /*execute a function when someone clicks in the document:*/
            document.addEventListener("click", function (e) {
                closeAllLists(e.target);
            });
        }

        var countries = [
        <c:forEach items="${requestScope.listProductsSearch}" var="LPS" varStatus="status">
            <c:if test="${LPS.status eq 1}">
        "${LPS.pName}"${not status.last ? ',' : ''}
            </c:if>
        </c:forEach>
        ];
        /*initiate the autocomplete function on the "myInput" element, and pass along the countries array as possible autocomplete values:*/
        autocomplete(document.getElementById("myInput"), countries);
    </script>
    <script>
        $(document).ready(function ()
        {


            if ($('.bbb_viewed_slider').length)
            {
                var viewedSlider = $('.bbb_viewed_slider');

                viewedSlider.owlCarousel(
                        {
                            loop: true,
                            margin: 30,
                            autoplay: true,
                            autoplayTimeout: 6000,
                            nav: false,
                            dots: false,
                            responsive:
                                    {
                                        0: {items: 1},
                                        575: {items: 2},
                                        768: {items: 3},
                                        991: {items: 4},
                                        1199: {items: 6}
                                    }
                        });

                if ($('.bbb_viewed_prev').length)
                {
                    var prev = $('.bbb_viewed_prev');
                    prev.on('click', function ()
                    {
                        viewedSlider.trigger('prev.owl.carousel');
                    });
                }

                if ($('.bbb_viewed_next').length)
                {
                    var next = $('.bbb_viewed_next');
                    next.on('click', function ()
                    {
                        viewedSlider.trigger('next.owl.carousel');
                    });
                }
            }


        });
    </script>
    <script>
        const tabContent = document.querySelector('.preview-pic.tab-content');
        const tabPanes = tabContent.querySelectorAll('.tab-pane');
        const tabThumbnails = document.querySelectorAll('.preview-thumbnail.nav-tabs li a');

// Đặt thuộc tính id cho mỗi tab-pane
        tabPanes.forEach((pane, index) => {
            pane.id = `pic-${index + 1}`;
        });

// Đặt thuộc tính data-target cho mỗi tab thumbnail
        tabThumbnails.forEach((thumbnail, index) => {
            thumbnail.dataset.target = `#pic-${index + 1}`;
        });

        const tabThumbnails = document.querySelectorAll('.preview-thumbnail.nav-tabs li a');

// Lặp qua các tab thumbnail và đăng ký sự kiện click
        tabThumbnails.forEach(thumbnail => {
            thumbnail.addEventListener('click', function (event) {
                event.preventDefault();

                // Lấy data-target của tab thumbnail được click
                const targetId = this.dataset.target;

                // Lấy tab-pane tương ứng với data-target và thêm lớp active
                const targetPane = document.querySelector(targetId);
                targetPane.classList.add('active');

                // Loại bỏ lớp active khỏi tất cả các tab-pane khác
                const otherPanes = Array.from(document.querySelectorAll('.tab-pane')).filter(pane => pane.id !== targetPane.id);
                otherPanes.forEach(pane => {
                    pane.classList.remove('active');
                });

                // Loại bỏ lớp active khỏi tất cả các tab thumbnail khác
                const otherThumbnails = Array.from(document.querySelectorAll('.preview-thumbnail.nav-tabs li')).filter(thumbnail => thumbnail.querySelector('a').dataset.target !== targetId);
                otherThumbnails.forEach(thumbnail => {
                    thumbnail.classList.remove('active');
                });

                // Thêm lớp active cho tab thumbnail được click
                this.parentElement.classList.add('active');
            });
        });

    </script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="js/toast-alert.js"></script>
    <script>

        function addToCartAsync(pId) {
            axios.get('AddToCartController', {
                params: {
                    pId: pId
                },
                responseType: 'json'
            },
                    toast({
                        title: 'Success',
                        message: 'Add product to cart successfully',
                        type: 'success',
                        duration: 3000
                    })
                    );


        }

    </script>
</html>

