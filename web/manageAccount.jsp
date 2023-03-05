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
        <title>Manage Account</title>
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
                        <h1 class="mt-4">Manage Accounts</h1>
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
                        <!-- Admin Account Table -->
                        <div class="card mb-4">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                Admin Accounts Table
                            </div>
                            <div class="card-body">
                                <table id="adminAccountTable">
                                    <thead>
                                        <tr>
                                            <tag:thAccountTable/>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <tag:thAccountTable/>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${sessionScope.listAccounts}" var="LA">
                                            <c:if test="${LA.role eq 0}">
                                                <tr>
                                                    <td>${LA.accId}</td>
                                                    <td>${LA.email}</td>
                                                    <td>${LA.fullName}</td>
                                                    <td>${LA.password}</td>
                                                    <td>${not empty LA.phone ? LA.phone : "Null"}</td>
                                                    <td><span style="color: blue;">Active</span></td>
                                                    <td>Admin</td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- Active User Account Table -->
                        <div class="card mb-4">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                Active User Accounts Table
                                <span class="float-end">
                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#blockBtnXYZC">
                                        <i class="bi bi-plus-square"></i> Add New Account
                                    </button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="blockBtnXYZC" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Account Information</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <form action="InsertAccountController" method="POST">
                                                    <div class="modal-body">
                                                        <input type="hidden" name="pid"/>
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="name3Example">Email <span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="text" id="name3Example" class="form-control form-control-lg"
                                                                   required name="email"/>
                                                        </div>
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="img3Example">Name <span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="text" id="img3Example" class="form-control form-control-lg"
                                                                   required name="fullName"/>
                                                        </div>
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="img3Example">Password <span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="password" id="img3Example" class="form-control form-control-lg"
                                                                   required name="password"/>
                                                        </div>
<!--                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="price3Example">Price <span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="number" min="0" max="999" pattern="^[1-9]\d*$" id="price3Example" class="form-control form-control-lg"
                                                                   required name="price"/>
                                                        </div>-->
<!--                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="descr3Example">Description <span style="color: red; font-weight: bold">*</span></label>
                                                            <textarea type="text" id="descr3Example" class="form-control form-control-lg"
                                                                      required name="description"></textarea>
                                                        </div>-->
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="img3Example">Phone <span style="color: red; font-weight: bold">*</span></label>
                                                            <input type="text" id="img3Example" class="form-control form-control-lg"
                                                                   required name="phone"/>
                                                        </div>
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="status3Example">Status <span style="color: red; font-weight: bold">*</span></label>
                                                            <select name="status" class="form-select form-select-lg" id="status3Example">
                                                                <option value="1">Active</option>
                                                                <option value="0">Block</option>
                                                                
                                                            </select>
                                                        </div>
                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="status3Example">Role <span style="color: red; font-weight: bold">*</span></label>
                                                            <select name="role" class="form-select form-select-lg" id="status3Example">
                                                                
                                                                <option value="1">Manager</option>
                  
                                                                <option value="2">Supporter</option>
                                                            </select>
                                                        </div>
<!--                                                        <div class="form-outline mb-3">
                                                            <label class="form-label" for="cate3Example">Category <span style="color: red; font-weight: bold">*</span></label>
                                                            <select name="cateId" class="form-select form-select-lg" id="cate3Example">
                                                            <%--    <c:forEach items="${sessionScope.listCategories}" var="LC">
                                                                    <option value="${LC.key}">${LC.value}</option>
                                                                </c:forEach>
                                                            --%>
                                                            </select>
                                                        </div>-->
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                        <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action1" value="createAccount">Create</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </span>
                            </div>
                            <div class="card-body">
                                <table id="activeUserAccountTable">
                                    <thead>
                                        <tr>
                                            <tag:thAccountTable/>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <tag:thAccountTable/>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${sessionScope.listAccounts}" var="LA">
                                            <c:if test="${LA.status eq 1 and (LA.role eq 1 or LA.role eq 2) }">
                                                <tr>
                                                    <td>${LA.accId}</td>
                                                    <td>${LA.email}</td>
                                                    <td>${LA.fullName}</td>
                                                    <td>${LA.password}</td>
                                                    <td>${LA.phone}</td>
                                                    <td><span style="color: blue;">Active</span></td>
                                                    <c:if test="${LA.role eq 1}">
                                                    <td>Manager</td>
                                                    </c:if>
                                                    <c:if test="${LA.role eq 2}">
                                                    <td>Supporter</td>
                                                    </c:if>
                                                    <td>
                                                        <!-- Block btn -->
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-danger w-100" data-bs-toggle="modal" data-bs-target="#blockBtn${LA.accId}">
                                                                Block
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="blockBtn${LA.accId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are blocking a user named "<span class="text-dark">${LA.fullName}</span>" whose email is "<span class="text-dark">${LA.email}</span>"
                                                                        </div>
                                                                        <form action="UpdateAccountController" method="POST">
                                                                            <input type="hidden" name="email" value="${LA.email}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="blockAccount">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                                            
                                                        </span>                    
                                                                            
                                                                            
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-danger w-100" data-bs-toggle="modal" data-bs-target="#delete${LA.accId}">
                                                                Delete
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="delete${LA.accId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing delete a user named "<span class="text-dark">${LA.fullName}</span>" with email as "<span class="text-dark">${LA.email}</span>"
                                                                        </div>
                                                                        <form action="InsertAccountController" method="POST">
                                                                            <input type="hidden" name="accId" value="${LA.accId}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action1" value="deleteAccount">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>                    
                                                            
                                                               
                                                                            
                                                                            
                                                                            
                                                        
                                                                            
                                                                            
                                                                            <%-- Nút Update--%>                   
                                                        

                                                        

                                                        <span>
                                                        <!-- Button trigger modal -->
                                                        <button type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#updateAccountBnt${LA.accId}">
                                                            Update
                                                        </button>
                                                        <!-- Modal -->
                                                        <div class="modal fade" id="updateAccountBnt${LA.accId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog modal-dialog-centered">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Account Information</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <form action="InsertAccountController" method="POST">
                                                                        <div class="modal-body">
                                                                            <input type="hidden" name="accId" value="${LA.accId}"/>
                                                                            
                                                                            <div class="form-outline mb-3">
                                                                                <input type="hidden" id="email" class="form-control form-control-lg"
                                                                                       required name="email" value="${LA.email}"/>
                                                                            </div>
                                                                            
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="img3Example">Password <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="password" id="password" class="form-control form-control-lg"
                                                                                       required name="password" value="${LA.password}"/>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="name3Example">Name <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="fullName" class="form-control form-control-lg"
                                                                                       required name="fullName" value="${LA.fullName}"/>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="img3Example">Phone <span style="color: red; font-weight: bold">*</span></label>
                                                                                <input type="text" id="phone" class="form-control form-control-lg"
                                                                                       required name="phone" value="${LA.phone}"/>
                                                                            </div>
                                                                            <div class="form-outline mb-3">
                                                                                <label class="form-label" for="status3Example">Role <span style="color: red; font-weight: bold">*</span></label>
                                                                                <select name="role" class="form-select form-select-lg" id="role">
                                                                                    
                                                                                    <option ${LA.role eq 1 ? "selected" : ""} value="1">Manager</option>
                                                                                    <option ${LA.role eq 2 ? "selected" : ""} value="2">Supporter</option>
                                                                                </select>
                                                                            </div>
                                                                                
                                                                            
                                                                            
                                                                        </div>
                                                                        <div class="modal-footer">
<!--                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <button id="update-profile-btn" type="submit" class="btn btn-danger" name="" value="">Update</button>-->
                                                                            
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                                            <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action1" value="updateAccount">Update</button>
                                                                        </div>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </span>



                                                          
                                                                            
                                                                            
                                                                            
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- Inactive User Account Table -->
                        <div class="card mb-4">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                Inactive User Accounts Table
                            </div>
                            <div class="card-body">
                                <table id="inactiveUserAccountTable">
                                    <thead>
                                        <tr>
                                            <tag:thAccountTable/>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <tag:thAccountTable/>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${sessionScope.listAccounts}" var="LA">
                                            <c:if test="${LA.status eq 0 and (LA.role eq 1 or LA.role eq 2)}">
                                                <tr>
                                                    <td>${LA.accId}</td>
                                                    <td>${LA.email}</td>
                                                    <td>${LA.fullName}</td>
                                                    <td>${LA.password}</td>
                                                    <td>${LA.phone}</td>
                                                    <td><span style="color: red;">Blocked</span></td>
                                                    <c:if test="${LA.role eq 1}">
                                                    <td>Manager</td>
                                                    </c:if>
                                                    <c:if test="${LA.role eq 2}">
                                                    <td>Supporter</td>
                                                    </c:if>
                                                    <td>
                                                        <!-- Block btn -->
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-success w-100" data-bs-toggle="modal" data-bs-target="#blockBtn${LA.accId}">
                                                                Unblock
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="blockBtn${LA.accId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing unblocking a user named "<span class="text-dark">${LA.fullName}</span>" with email as "<span class="text-dark">${LA.email}</span>"
                                                                        </div>
                                                                        <form action="UpdateAccountController" method="POST">
                                                                            <input type="hidden" name="email" value="${LA.email}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action" value="unblockAccount">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>
                                                        
                                                        <span>
                                                            <!-- Button trigger modal -->
                                                            <button type="button" class="btn btn-outline-danger w-100" data-bs-toggle="modal" data-bs-target="#delete${LA.accId}">
                                                                Delete
                                                            </button>
                                                            <!-- Modal -->
                                                            <div class="modal fade" id="delete${LA.accId}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog modal-dialog-centered">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="p-4 text-center fs-3"
                                                                             style="color: red;">
                                                                            You are doing delete a user named "<span class="text-dark">${LA.fullName}</span>" with email as "<span class="text-dark">${LA.email}</span>"
                                                                        </div>
                                                                        <form action="InsertAccountController" method="POST">
                                                                            <input type="hidden" name="accId" value="${LA.accId}"/>
                                                                            <div class="modal-footer">
                                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                                                                                <button id="update-profile-btn" type="submit" class="btn btn-danger" name="action1" value="deleteAccount">Yes</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </span>                    
                                                                            
                                                    </td>
                                                </tr>
                                            </c:if>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        
        <script src="js/my-user.js"></script>
    </body>
</html>
