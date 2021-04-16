<%-- 
    Document   : update
    Created on : Oct 14, 2020, 10:24:26 PM
    Author     : Duy Thai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="shortcut icon" href="img/fav-logo.jpg" type="image/jpg">
    </head>
    <body>
        <h2 style="text-align: center; margin: 20px 0 50px 0 ">Update product form</h2>
        <div class="container">
            <div class="col-5 m-auto">
                <h6 style="color: red;text-align: center">${requestScope.messageUpdate}</h6>
                <form action="MainController" method="POST" enctype="multipart/form-data" >

                    ProductID<input class="form-control" type="text" name="txtProductID" value="${param.txtProductID}" readonly="true" required="required"/>
                    <div style="color: red">
                        <h6 style="color: red;margin-left: 10px;font-size: 15px">${requestScope.PRODUCT_ERROR.productIDError}</h6>
                    </div></br>
                    ProductName<input class="form-control" type="text" name="txtProductName"  value="${param.txtProductName}" required="required"/>
                    <div style="color: red">

                    </div></br>
                    <img style="width: 276px; height: 183px" src="img/product/${param.txtImage}">
                    <input type="file" id="image" class="form-control" accept="image/*" value="${param.txtImage}" name="txtImage"> <br/>
                    <input type="hidden" name="txtImages" value="${param.txtImage}">
                    Description<input class="form-control" type="text" name="txtDescription" value="${param.txtDescription}"/>
                    <div style="color: red">

                    </div></br>
                    Price($)<input class="form-control" type="number" name="txtPrice" value="${param.txtPrice}" min="1" required="required" />
                    <div style="color: red">

                    </div></br>

                    Quantity<input class="form-control" type="number" name="txtQuantity" value="${param.txtQuantity}" min="1" required="required"/>
                    <div style="color: red">

                    </div></br>
                    
                    Create Date<input class="form-control" type="date" name="txtCreateDate" value="${param.txtCreateDate}" required="required"/>
                    <div style="color: red">

                    </div></br>

                    Status
                    <select name="txtStatus" class="form-control">
                        <option value="Active">Active</option>
                        <option value="DeActive">DeActive</option>
                    </select><br/>

                    Categories 
                    <select name="txtCagID" class="form-control">

                        <c:forEach var="dto" items="${requestScope.LIST_CATE}">
                            <option value="${dto.cateID}" 
                                    <c:if test="${param.txtCagID == dto.cateID}">
                                        selected
                                    </c:if>
                                    >${dto.nameCateg}</option>
                        </c:forEach>
                    </select><br/><br/>

                    <input class="btn btn-danger" type="submit" name="btnAction" value="Update Product"/></br>
                    <br/><a href="MainController?btnAction=Search&txtSearch=">Back to Home Page</a><br/><br/><br/>

                </form>
            </div>
        </div>
    </body>
</html>
