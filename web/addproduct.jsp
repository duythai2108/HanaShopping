<%-- 
    Document   : addproduct
    Created on : Oct 14, 2020, 11:43:21 AM
    Author     : Duy Thai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add product Page</title>
        <link rel="shortcut icon" href="img/fav-logo.jpg" type="image/jpg">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <h2 style="text-align: center; margin: 20px 0 50px 0 ">Add product form</h2>
        <div class="container">
            <div class="col-5 m-auto">
                <h6 style="color: red;text-align: center">${requestScope.messageProduct}</h6>
                <form action="MainController" method="POST" enctype="multipart/form-data"  >

                    ProductID<input class="form-control" type="text" name="txtProductID" value="${param.txtProductID}" required="required"/>
                    <div style="color: red">
                        <h6 style="color: red;margin-left: 10px;font-size: 15px">${requestScope.PRODUCT_ERROR.productIDError}</h6>
                    </div></br>
                    ProductName<input class="form-control" type="text" name="txtProductName" required="required"/>
                    <div style="color: red">

                    </div></br>

                    image<input type="file" id="image" class="form-control" accept="image/*" name="txtImage"> <br/>

                    Description<input class="form-control" type="text" name="txtDescription"/>
                    <div style="color: red">

                    </div></br>
                    Price($)<input class="form-control" type="number" name="txtPrice" min="1" required="required"/>
                    <div style="color: red">

                    </div></br>

                    Quantity<input class="form-control" type="number" name="txtQuantity" min="1" required="required"/>
                    <div style="color: red">

                    </div></br>

                    Create Date<input class="form-control" type="date" name="txtCreateDate" required="required"/>
                    <div style="color: red">

                    </div></br>

                    Categories 
                    <select name="txtCate" class="form-control">
                        <c:forEach var="list" items="${requestScope.LIST_CATE}">
                            <option value="${list.cateID}">${list.nameCateg}</option>
                        </c:forEach>
                    </select><br/><br/>

                    <input class="btn btn-danger" type="submit" name="btnAction" value="Create Product"/></br>
                    <br/><a href="MainController?btnAction=Search&txtSearch=">Back to Home Page</a><br/><br/><br/>

                </form>
            </div>
        </div>
    </body>
</html>
