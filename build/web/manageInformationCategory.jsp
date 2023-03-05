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
        <%@include file="components/adminHeadComponent.jsp" %>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Manage Information</title>
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
                        <h1 class="mt-4">Manage Information</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">All current accounts in system</li>
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
                        <!-- Admin Categories Information Table -->
                        <div class="card mb-4 col-12 col-md-5">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                Information Categories
                                <span class="float-end">
                                    <!-- Button trigger modal -->
                                    <button href="" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#BtnCate">
                                        <i class="bi bi-plus-square"></i> Add New Information Category
                                    </button>
                                    
                                    <!-- Modal -->
                                    <div class="modal fade" id="BtnCate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Information</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <form action="UpdateInforCateController" method="POST">
                                                    <div class="modal-body">
                                                        <input type="hidden" name="accId" value=${sessionScope.account.getAccId()}>
                                                        <input type="hidden" name="id"/>
                                                        
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="img3Example">Name<span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="text" id="name" class="form-control form-control-lg"
                                                                   required name="name"/>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                        <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="insertInforCate">Create</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </span>
                            </div>
                            <div class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
                                <table id="accountsTable" class="datatable-table">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Category name</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        <c:forEach items="${requestScope.listCate}" var="LC">
                                            
                                                <tr>
                                                    <td>${LC.getId()}</td>
                                                    <td>${LC.getName()}</td>
                                                    
                                                    <td>
                                                        <!-- Block btn -->
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button  type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#del${LC.getId()}">
                                                                <i class="material-icons">delete</i>
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="del${LC.getId()}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing delete a categories information 
                                                                        </div>
                                                                        <form action="UpdateInforCateController" method="POST">
                                                                            <input type="hidden" name="id" value="${LC.getId()}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="deleteInforCate">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>
                                                        
                                                        <span>
                                                        <!-- Button trigger modal -->
                                                        <button type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#updateInforCate${LC.id}">
                                                            <i class="material-icons">update</i>
                                                        </button>
                                                        <!-- Modal -->
                                                        <div class="modal fade" id="updateInforCate${LC.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-dialog-centered">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Information</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <form action="UpdateInforCateController" method="POST">
                                                                        <div class="modal-body">
                                                                            <input type="hidden" name="id" value="${LC.id}"/>
                                                                            
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="img3Example">Name<span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="title" class="form-control form-control-lg"
                                                                                       required name="name" value="${LC.name}"/>
                                                                            </div>
                                                                             
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="updateInforCategory">Update</button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </span>
                                                    </td>
                                                    
                                                </tr>
                                            
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- Admin Information Table -->
                        
                        <!-- Active User Account Table -->
                        
                        <!-- Inactive User Account Table -->
                        
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
