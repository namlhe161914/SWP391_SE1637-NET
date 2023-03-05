<%-- 
    Document   : manageAccount
    Created on : Oct 8, 2022, 4:48:20 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/mytaglib.tld"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home Product</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="home/product.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!-- <style>
          /* Remove the navbar's default rounded borders and increase the bottom margin */ 
          .navbar {
            margin-bottom: 50px;
            border-radius: 0;
          }
          
          /* Remove the jumbotron's default bottom margin */ 
           .jumbotron {
            margin-bottom: 0;
          }
         
          /* Add a gray background color and some padding to the footer */
          footer {
            background-color: #f2f2f2;
            padding: 25px;
          }
        </style> -->
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
                            </p>
                        </li>
                        <!--                        <li><a href="">ORDER</a></li>-->
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
        
        <div class="container">    
            <ol class="breadcrumb">
                <li><a href="home">Home</a></li>
                <li class="active">Categories</li>
                <li class="active">${listCategoriesById.cateName}</li>
            </ol>
            <div class="row">
                <c:forEach items="${requestScope.listProducts}" var="LP">
                    <c:if test="${LP.status eq 1}">
                        <div class="col-sm-4">
                            <div class="panel panel-primary">


                                <div class="panel-heading" style="text-align: center ;"><a href="HomeProductDetailController?pId=${LP.pId}" class="normal-font" style="text-decoration: none; color: white">${LP.pName}</a> </div>
                                <div class="panel-body" style="    border-bottom-left-radius: 5px;
                                     border-bottom-right-radius: 5px;"><a href="HomeProductDetailController?pId=${LP.pId}" class="normal-font"><img src="${LP.imgPath}"  class="img-responsive" style="width: 320px;height: 220px;" alt="Image"></a></div>
                                <form name="f" action="" method="post">
                                    <div class="panel-body" style="text-align: center">
                                        <a onclick="addToCartAsync(${LP.pId})" class="btn btn-outline-dark mt-auto w-50 like btn btn-default">Add To Cart</a>
                                        <!--                                <a href="CartController" class="like btn btn-default" type="button">Cart</a>-->
                                        <a href="HomeProductDetailController?pId=${LP.pId}" class="like btn btn-default" type="button">Details</a> 
                                    </div>                            
                                </form> 
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div><br>



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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
                                            $(document).ready(function () {
                                                $("#searchInput").on("keyup", function () {
                                                    var keyword = $(this).val();
                                                    if (keyword.length >= 2) {
                                                        $.ajax({
                                                            url: "search",
                                                            method: "GET",
                                                            data: {keyword: keyword},
                                                            dataType: "json",
                                                            success: function (data) {
                                                                var results = "";
                                                                for (var i = 0; i < data.length; i++) {
                                                                    results += "<div>" + data[i] + "</div>";
                                                                }
                                                                $("#searchResults").html(results);
                                                            },
                                                            error: function (jqXHR, textStatus, errorThrown) {
                                                                console.log(textStatus, errorThrown);
                                                            }
                                                        });
                                                    } else {
                                                        $("#searchResults").html("");
                                                    }
                                                });
                                            });
    </script>
    <script type="text/javascript">
        function buy(pId) {
            document.f.action = "buy?pId=" + pId;
            document.f.submit();
        }
    </script>
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
