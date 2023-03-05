<%-- 
    Document   : manageProduct
    Created on : Oct 8, 2022, 4:48:20 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/mytaglib.tld"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/adminHeadComponent.jsp" %>
        <title>Manage Product</title>
    </head>
    <body class="sb-nav-fixed">
        <!-- Admin navbar -->
        <%@include file="components/adminNavBarComponent.jsp" %>
        <div id="layoutSidenav">
            <!-- Admin Slidenav -->
            <%@include file="components/adminSlideNavComponent.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">All current products in system</li>
                        </ol>
                        <c:choose>
                            <c:when test="${not empty requestScope.MSG_SUCCESS}">
                                <div class="alert alert-success fs-3" role="alert">
                                    ${requestScope.MSG_SUCCESS}
                                </div>
                            </c:when>
                            <c:when test="${not empty requestScope.MSG_ERROR}">
                                <div class="alert alert-danger fs-3" role="alert">
                                    ${requestScope.MSG_ERROR}
                                </div>
                            </c:when>
                        </c:choose>

                        <!-- Active User Account Table -->
                        <div class="card mb-4">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                Product Table
                                <span class="float-end">
                                    <!-- Button trigger modal -->
                                    <a  href="AddProductController" class="btn btn-primary"  >
                                        <i class="bi bi-plus-square"></i> Add New Prodcut
                                    </a>

                                </span>
                                <!--                                 <span class="float-end">
                                                                     Button trigger modal 
                                                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#blockBtnXYZC">
                                                                        <i class="bi bi-plus-square"></i> Add New Product
                                                                    </button>
                                                                     Modal 
                                                                    <div class="modal fade" id="blockBtnXYZC" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                        <div class="modal-dialog modal-dialog-centered modal-lg" style="width:  100%;">
                                                                            <div class="modal-content" >
                                                                                <div class="modal-header" style="width: 100%">
                                                                                    <h5 class="modal-title" id="exampleModalLabel">Product Information</h5>
                                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                </div>
                                                                                <form action="AddProductController" method="post">
                                                                                    <div class="modal-body">
                                
                                
                                                                                        <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="img3Example">Product Name <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <input type="text" id="pName" class="form-control form-control-lg"
                                                                                                   required name="pName" />
                                                                                        </div>
                                
                                                                                        <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="img3Example"> Image Path <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <input type="text" id="imgPath" class="form-control form-control-lg"
                                                                                                   required name="imgPath"/>
                                                                                        </div>
                                                                                        <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="name3Example">Description <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <textarea type="" id="description" class="form-control form-control-lg" 
                                                                                                      required name="description" /></textarea>
                                
                                                                                        </div>
                                                                                        <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="status3Example">Status <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <select name="status" class="form-select form-select-lg" id="status3Example">
                                                                                                <option value="1">Active</option>
                                                                                                <option value="0">Block</option>                                  
                                                                                            </select>
                                                                                        </div>
                                                                                        <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="status3Example">Category <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <select name="cateId" class="form-select form-select-lg" id="status3Example">
                                <c:forEach items="${sessionScope.listCategories}" var="LC">  
                                    <option value="${LC.cateId}">${LC.cateName}</option>
                                </c:forEach>                              
                            </select>

                        </div>
                        <div class="form-outline mb-3">
                            <label class="form-label" for="img3Example">Kích Cỡ <span style="color: red; font-weight: bold">*</span></label>
                            <input type="text" id="kichCo" class="form-control form-control-lg"
                                   required name="kichCo" />
                        </div>  
                        <div class="form-outline mb-3">
                            <label class="form-label" for="img3Example">Trọng Lượng</label>
                            <input type="text" id="trongLuong" class="form-control form-control-lg"
                                   name="trongLuong" />
                        </div>  
                        <div class="form-outline mb-3">
                            <label class="form-label" for="img3Example">Chi tiết <span style="color: red; font-weight: bold">*</span></label>
                            <input type="text" id="detailPath" class="form-control form-control-lg"
                                   required name="detailPath" />
                        </div>  
                        <div class="form-outline mb-3">
                            <label class="form-label" for="price3Example">Price <span style="color: red; font-weight: bold">*</span></label>
                            <input type="number" min="0" max="9999" pattern="^[1-9]\d*$" id="price3Example" class="form-control form-control-lg"
                                   required name="price" />
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a  href="AdminProductController" class="btn btn-secondary" >Close</a>
                        <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="createProduct">Create</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</span>-->
                            </div>
                            <div class="card-body">
                                <table id="activeUserAccountTable">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Product Name</th>
                                            <th> Image </th>
                                            <th>Description</th>
                                            <th>Thể loại</th>
                                            <th>Trọng Lượng</th>
                                            <th>Chi tiết</th>
                                            <th>Giá</th>
                                            <th>Status</th>
                                            <th>Hành động</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach items="${requestScope.listProducts}" var="LP">

                                            <tr>
                                                <td>${LP.pId}</td>
                                                <td style="width: 180px">${LP.pName}</td>
                                                <td><img src="${LP.imgPath}" width="100" height="50" alt=""></td>
                                                <td style="width: 250px">${LP.description}</td>
                                                <c:forEach items="${sessionScope.listCategories}" var="LC">  
                                                    <c:if test="${LC.cateId eq LP.cateId}"><td>${LC.cateName}</td></c:if>
                                                </c:forEach>
                                                <td>${LP.trongLuong}</td>
                                                <td>
                                                    <form action="DownloadFileController" method="get">
                                                        <input  value="${LP.detailPath}" name="detailPath" hidden="">
                                                        <button type="submit" class="like btn btn-default" style="color: blue;">Catologue</button>
                                                    </form></td>
                                                <td>${LP.price}</td>
                                                <c:if test="${LP.status eq 1}"><td><span style="color: blue;">Active</span></td></c:if>
                                                <c:if test="${LP.status eq 0}"><td><span style="color: red;">Block</span></td></c:if>

                                                <c:if test="${LP.status eq 1}">
                                                    <td>
                                                        <!-- Block btn -->
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#del${LP.pId}">
                                                                Block
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="del${LP.pId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing block a this product
                                                                        </div>
                                                                        <form action="UpdateProductController" method="POST">
                                                                            <input type="hidden" name="pId" value="${LP.pId}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="actionUpdateProductStatus" value="blockProduct">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>              
                                                    </c:if>   


                                                    <c:if test="${LP.status eq 0}">
                                                    <td>
                                                        <!-- UnBlock btn -->
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#del${LP.pId}" style="color: red">
                                                                Unblock
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="del${LP.pId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing unblock a this product
                                                                        </div>
                                                                        <form action="UpdateProductController" method="POST">
                                                                            <input type="hidden" name="pId" value="${LP.pId}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="actionUpdateProductStatus" value="unblockProduct">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>              
                                                    </c:if>                                                       





                                                    <%-- Nút Update--%>                   




                                                    <span>
                                                        <!-- Button trigger modal -->
                                                        <a  href="EditProductController?pId=${LP.pId}" class="btn btn-outline-success w-100">
                                                            Update
                                                        </a>

                                                        <!-- Modal 
                                                        <div class="modal fade" id="updateProductBnt${LP.pId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-dialog-centered">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Information</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <form action="ManagerProductController" method="POST">
                                                                        <div class="modal-body">
                                                                            <input type="hidden" name="pId" value="${LP.pId}"/>

                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="img3Example">Product Name <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="pName" class="form-control form-control-lg"
                                                                                       required name="pName" value="${LP.pName}"/>
                                                                            </div>

                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="img3Example"> Image Path <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="imgPath" class="form-control form-control-lg"
                                                                                       required name="imgPath" value="${LP.imgPath}"/>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="name3Example">Description <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="description" class="form-control form-control-lg"
                                                                                       required name="description" value="${LP.description}"/>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="status3Example">Status <span style="color: red; font-weight: bold">*</span></label>
                                                                                <select name="status" class="form-select form-select-lg" id="status3Example">
                                                                                    <option value="1">Active</option>
                                                                                    <option value="0">Block</option>                                  
                                                                                </select>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="status3Example">Category <span style="color: red; font-weight: bold">*</span></label>
                                                                                <select name="cateId" class="form-select form-select-lg" id="status3Example">

                                                        <c:forEach items="${sessionScope.listCategories}" var="LC">  
                                                            <c:if test="${LC.cateId eq LP.cateId}"><option hidden="" value ="${LP.cateId}">${LC.cateName}</option></c:if>
                                                        </c:forEach>
                                                        <c:forEach items="${sessionScope.listCategories}" var="LC">  
                                                            <option value="${LC.cateId}">${LC.cateName}</option>
                                                        </c:forEach>                              
                                                    </select>
                                                </div>
                                                <div class="form-outline mb-3">
                                                    <label class="form-label" for="img3Example">Kích Cỡ </label>
                                                    <input type="text" id="kichCo" class="form-control form-control-lg"
                                                           name="kichCo" value="${LP.kichCo}"/>
                                                </div>  
                                                <div class="form-outline mb-3">
                                                    <label class="form-label" for="img3Example">Trọng Lượng</label>
                                                    <input type="text" id="trongLuong" class="form-control form-control-lg"
                                                           name="trongLuong" value="${LP.trongLuong}"/>
                                                </div>  
                                                <div class="form-outline mb-3">
                                                    <label class="form-label" for="img3Example">Chi tiết <span style="color: red; font-weight: bold">*</span></label>
                                                    <input type="text" id="detailPath" class="form-control form-control-lg"
                                                           required name="detailPath" value="${LP.detailPath}"/>
                                                </div>  
                                                <div class="form-outline mb-3">
                                                    <label class="form-label" for="price3Example">Price <span style="color: red; font-weight: bold">*</span></label>
                                                    <input type="number" min="0" max="9999" pattern="^[1-9]\d*$" id="price3Example" class="form-control form-control-lg"
                                                           required name="price" value="${LP.price}"/>
                                                </div>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="updateProduct">Update</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                                                        -->
                                                    </span>


                                                </td>
                                            </tr>

                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </main>
                <!-- Footer -->
                <jsp:include page="components/adminFooter.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
