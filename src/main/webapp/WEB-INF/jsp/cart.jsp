<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet"  href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>spring MVC</title>
</head>
<body>
    <div class="container">
    <table class="table-condensed table-bordered">
        <tr>
            <th>product</th>
            <th>price</th>
            <th>quantity</th>
            <th>total price</th>
        </tr>
        <c:forEach items="${cart.items}" var="item">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.totalPrice}</td>
            </tr>
        </c:forEach>
        <tr>
            <th></th>
            <th></th>
            <th>Grand Total</th>
            <th>${cart.totalPrice}</th>
        </tr>
   </table>
    </div>
</body>
</html>
