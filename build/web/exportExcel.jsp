<%-- 
    Document   : exportExcel
    Created on : Feb 28, 2023, 11:29:43 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="/WEB-INF/tlds/mytaglib.tld"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <title>Export</title>

        <script src="js/table2excel.js"></script> 

    </head>


    <body>

        <button id="downloadexcel">
            Export to excel
        </button>



        <table id="customerCartTable">
            <thead>
                <tr>
                    <th>Tên sản Phẩm</th>
                    <th>Tên danh mục sản phẩm</th>
                    <th>Mô tả</th>
                    <th>Kích cỡ</th>
                    <th>Trọng Lượng</th>                                           
                    <th>Giá</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${requestScope.listProductOrder}" var="LPO">
                    <c:set var="categoryDisplayed" value="false" />
                    <tr>
                        <td>${LPO.pName}</td>
                        <c:forEach items="${requestScope.listCategories}" var="LC">
                            <c:if test="${LC.cateId eq LPO.cateId}">
                                <c:if test="${categoryDisplayed eq false}">
                                    <td>${LC.cateName}</td>
                                    <c:set var="categoryDisplayed" value="true" />
                                </c:if>
                            </c:if>
                        </c:forEach>
                        <td>${LPO.description}</td>
                        <td>${LPO.kichCo}</td>
                        <td>${LPO.trongLuong}</td>
                        <td>${LPO.price}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script>
            document.getElementById('downloadexcel').addEventListener('click', function () {//id button

                var table2excel = new Table2Excel();
                table2excel.export(document.querySelectorAll("#customerCartTable")); // #+id table
            });

        </script>



    </body>
    <!--        <script> // click and open new tab
            $(document).on('click', '#download', function(){
                window.open('http://www.linkhere.com');
            });

        </script>-->
</html>
