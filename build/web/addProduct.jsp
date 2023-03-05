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
        <title>Manage Product</title>
        <style>
            .container {
                display: flex;
                flex-wrap: wrap;
            }
            .image-wrapper {
                position: relative;
                margin-right: 10px;
                margin-bottom: 10px;
                width: 150px;
                height: 150px;
                overflow: hidden;
                /*                border: 1px solid #ccc;*/
            }

            .image {
                display: block;
                max-width: 100%;
                max-height: 100%;
                object-fit: cover;
            }

            .delete-btn {
                position: absolute;
                top: 5px;
                right: 5px;
                width: 20px;
                height: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: rgba(0, 0, 0, 0.5);
                color: #fff;
                font-size: 14px;
                border: none;
                cursor: pointer;
                opacity: 0;
                transition: opacity 0.3s ease;
            }

            .image-wrapper:hover .delete-btn {
                opacity: 1;
            }

        </style>

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

                        <!-- Button trigger modal -->

                        <!-- Modal -->

                        <div class="modal-content">
                            <div class="modal-header" style="width: 100%">
                                <h5 class="modal-title" id="exampleModalLabel">Add Product Information</h5>
                                <a  href="AdminProductController" class="btn-close"></a>
                            </div>

                            <form action="AddProductController" method="post"  enctype="multipart/form-data" >
                                <div class="modal-body">
                                    <div class="form-outline mb-3">
                                        <label class="form-label" for="img3Example"> Image <span style="color: red; font-weight: bold">*</span></label>

                                        <input type="file" name="file" id="myFile" accept="image/*" >

                                        <input type="text" id="imgPath" class="form-control form-control-lg"
                                               name="imgPath" hidden=""/>
                                        <img id="preview" width="300px" height="190px">

                                    </div>

                                    <div class="form-outline mb-3">
                                        <label class="form-label" for="img3Example">Product Name <span style="color: red; font-weight: bold">*</span></label>
                                        <input type="text" id="pName" class="form-control form-control-lg"
                                               required name="pName" />
                                    </div>

                                    <div class="form-outline mb-3">
                                        <label class="form-label" for="img3Example"> Image thư viện <span style="color: red; font-weight: bold">*</span></label>

                                        <!--                                        <input type="file" name="files" id="myFile2" multiple="" >-->

                                        <input type="file" name="files" id="myFile2" multiple="" accept="image/*">
                                        <div class="container" id="image-container"></div>
                                        <script>
                                            const inputElement = document.getElementById("myFile2");
                                            const containerElement = document.getElementById("image-container");

                                            inputElement.addEventListener("change", handleFiles, false);

                                            function handleFiles() {
                                                const imageWrappers = document.querySelectorAll(".image-wrapper");
                                                imageWrappers.forEach(wrapper => {
                                                    wrapper.parentNode.removeChild(wrapper);
                                                });
                                                const fileList = this.files;
                                                for (let i = 0; i < fileList.length; i++) {
                                                    const file = fileList[i];
                                                    const reader = new FileReader();
                                                    reader.readAsDataURL(file);
                                                    reader.onload = function () {
                                                        const imageWrapper = document.createElement("div");
                                                        imageWrapper.classList.add("image-wrapper");
                                                        const image = document.createElement("img");
                                                        image.classList.add("image");
                                                        image.src = this.result;
                                                        imageWrapper.appendChild(image);
                                                        const deleteBtn = document.createElement("button");
                                                        deleteBtn.classList.add("delete-btn");
                                                        deleteBtn.innerHTML = "X";
                                                        deleteBtn.addEventListener("click", function () {
                                                            containerElement.removeChild(imageWrapper);
                                                        });
                                                        imageWrapper.appendChild(deleteBtn);
                                                        containerElement.appendChild(imageWrapper);
                                                    };
                                                }
                                            }
                                        </script>


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

                                            <c:forEach items="${requestScope.listCate}" var="LC">  
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
                                        <label class="form-label" for="img3Example">Catalogue <span style="color: red; font-weight: bold">*</span></label>

                                        <input type="file" name="file" id="myFile1" >

                                        <input type="text" id="detailPath" class="form-control form-control-lg"
                                               name="detailPath" hidden=""/>
                                    </div>  

                                    <div class="form-outline mb-3">
                                        <label class="form-label" for="price3Example">Price <span style="color: red; font-weight: bold">*</span></label>
                                        <input oninput="formatInput()" id="myInput"  input type="text" pattern="[0-9\.]*$" id="price3Example" class="form-control form-control-lg"
                                               required name="price" />
                                    </div>




                                </div>
                                <div class="modal-footer">
                                    <a  href="AdminProductController" class="btn btn-secondary" >Close</a>
                                    <button id="update-profile-btn" type="submit" class="btn btn-danger">Create</button>

                                </div>
                            </form> 
                        </div>


                    </div>

                </main>
                <!-- Footer -->
                <jsp:include page="components/adminFooter.jsp"></jsp:include>
            </div>
        </div>
        <!--        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
                <script src="js/datatables-simple-demo.js"></script>-->
        <script>
            var input = document.getElementById('myFile');
            var fileName = document.getElementById('imgPath');
            input.addEventListener('change', function () {
                fileName.value = "files\\" + input.files[0].name;
            });
        </script>
        <script>
            var input1 = document.getElementById('myFile1');
            var fileName1 = document.getElementById('detailPath');
            input1.addEventListener('change', function () {
                fileName1.value = input1.files[0].name;
            });
        </script>
        <script>
            var input3 = document.getElementById('myFile2');
            var fileName3 = document.getElementById('imgPath1');
            input3.addEventListener('change', function () {
                fileName3.value = "files\\" + input3.files[0].name;
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
        <script>
            function formatInput() {
                var input = document.getElementById("myInput");
                var number = parseFloat(input.value.replace(/\D/g, '').replace(/,/g, '.'));
                input.value = number.toLocaleString('de-DE'); //dung dau "."
//                input.value = number.toLocaleString('en-US'); dung dau ','
                if (input.value === "NaN") {
                    input.value = ""; // đặt giá trị mặc định là 0
                }

            }

        </script>

    </body>

</html>
