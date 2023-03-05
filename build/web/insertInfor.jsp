<%-- 
    Document   : admin
    Created on : Oct 5, 2022, 6:58:11 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/adminHeadComponent.jsp" %>
        <title>Admin - Information edition</title>
        <link rel="stylesheet" href="error/error.css"/>
        <script src="https://cdn.tiny.cloud/1/krf38abovdk2zdkujebbjme2i39ok8dfg2eo7nunsnhvekk2/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <meta
            name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
            />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" href="jodit/app.css" />
        <link rel="stylesheet" href="jodit/jodit.min.css" />

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
                        <h1 class="mt-4">Edit</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>

                        <!-- Account Table -->
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="bi bi-table"></i>
                                Information edition
                            </div>
                            <div class="card-body">
                                <div id="wrapper">
                                    <form action="InsertInforController" method="POST" enctype="multipart/form-data">
                                        <div class="modal-body">
                                            <input type="hidden" name="accId" value=${sessionScope.account.getAccId()}>
                                            <div class="form-outline mb-3">
                                                <label class="form-label" for="name3Example">Titles <span style="color: red; font-weight: bold">*</span></label>
                                                <input type="text" id="title" class="form-control form-control-lg"
                                                       required name="title"/>
                                            </div>
                                            <!--                                            <div class="form-outline mb-3">
                                                                                            <label class="form-label" for="img3Example">Cover Image Path <span style="color: red; font-weight: bold">*</span></label>
                                                                                            <input type="text" id="coverImgPath" class="form-control form-control-lg"
                                                                                                   required name="coverImgPath"/>
                                                                                        </div>-->
                                            <div class="form-outline mb-3">
                                                <label class="form-label" for="img3Example">Cover Image Path <span style="color: red; font-weight: bold">*</span></label>

                                                <input type="file" name="file" id="myFile">

                                                <input type="text" id="coverImgPath" class="form-control form-control-lg"
                                                       name="coverImgPath" hidden=""/>
                                                <img id="preview" width="300px" height="190px">
                                            </div>
                                            <div class="form-outline mb-3">
                                                <label class="form-label" for="img3Example">Description <span style="color: red; font-weight: bold">*</span></label>
                                                <input type="text" id="description" class="form-control form-control-lg"
                                                       required name="description"/>
                                            </div>
                                            <div class="form-outline mb-3">
                                                <label class="form-label" for="status3Example">Information Category<span style="color: red; font-weight: bold">*</span></label>
                                                <select name="id" class="form-select form-select-lg" id="cate3Example">
                                                    <c:forEach items="${requestScope.listCate}" var="LC">  
                                                        <option value="${LC.id}">${LC.name}</option>
                                                    </c:forEach>
                                                </select>
                                                <!--                                                <input type="text" id="inforcate" class="form-control form-control-lg"
                                                                                                       required name="id"/>-->
                                            </div>
                                        </div>
                                        <div>
                                            <textarea id="editor" cols="30" rows="30" name="content"></textarea>
                                        </div>

                                        <div class="modal-footer">
                                            <button id="update-profile-btn" type="submit">Create</button>
                                        </div>

                                    </form>
                                </div>
                            </div>


                        </div>


                    </div>
                </main>
                <!-- Footer -->
                <jsp:include page="components/adminFooter.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="demo/chart-area-demo.js"></script>
        <script src="demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="js/scripts.js"></script>
        <script src="js/my-user.js"></script>
        <script src="error/error.j"></script>
        <script src="jodit/jodit.js"></script>
        <script type="text/javascript" src="tinymce/tinymce.min.js"></script>
        <script>
            var input = document.getElementById('myFile');
            var fileName = document.getElementById('coverImgPath');

            input.addEventListener('change', function () {
                fileName.value = "img\\" + input.files[0].name;
            });

        </script>
        <script>
            const editor = Jodit.make('#editor', {
                uploader: {
                    url: 'https://xdsoft.net/jodit/finder/?action=fileUpload'
                },
                filebrowser: {
                    ajax: {
                        url: 'https://xdsoft.net/jodit/finder/'
                    }
                }
            });
        </script>
        <script>
            const fileInput = document.getElementById('myFile');
            const preview = document.getElementById('preview');

            fileInput.addEventListener('change', function () {
                const file = fileInput.files[0];
                const reader = new FileReader();

                reader.addEventListener('load', function () {
                    preview.src = reader.result;
                }, false);

                if (file) {
                    reader.readAsDataURL(file);
                }
            });

        </script>
    </body>
</html>
