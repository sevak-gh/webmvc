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
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }

    th,td {
        padding: 15px;
    }

    .error {
        color: #ff0000;
        font-style: italic;
        font-weight: bold;
    }
</style>
</head>
<body>
    <div class="container">
        signle product view
    </div>
    <div class="container">
        <c:choose>
            <c:when test="${readonly}">
                <div>
                    name: ${product.name}
                </div>
                <div>
                    price: ${product.price}
                </div>
                <div>
                    description: ${product.description}
                </div>
            </c:when>
            <c:otherwise>
                    <form:form modelAttribute="product" enctype="multipart/form-data" class="form-horizontal">
                        <%--<form:hidden path="id" />--%>
                        <fieldset>
                            <legend>add new product</legend>
                            <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                            <div class="form-group">
                                <label class="control-label col-sm-2">name: </label>
                                <div class="col-sm-10">
                                   <form:input path="name" class="form-control" />
                                    <form:errors path="name" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">price: </label>
                                <div class="col-sm-10">
                                    <form:input path="price" class="form-control"/>
                                    <form:errors path="price" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">description: </label>
                                <div class="col-sm-10">
                                    <form:textarea path="description" class="form-control"/>
                                    <form:errors path="description" cssClass="text-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">image: </label>
                                <div class="col-sm-10">
                                    <input type="file" name="image" class="form:input-small"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2">
                                    <input  type="submit" value="submit" class="btn" />
                                </div>
                            </div>
                    </fieldset>
                </form:form>
           </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
