<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
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
    <div>
        signle product view
    </div>
    <div>
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
                    <form:form modelAttribute="product" enctype="multipart/form-data">
                    <div>
                        <form:errors path="*" cssClass="error" />
                    </div>                        
                    <div>
                        <label> name: </label>
                        <form:input path="name" />
                        <form:errors path="name" cssClass="error"/>
                    </div>
                    <div>
                        <label> price: </label>
                        <form:input path="price" />
                        <form:errors path="price" cssClass="error"/>
                    </div>
                    <div>
                        <label> description: </label>
                        <form:textarea path="description" />
                        <form:errors path="description" cssClass="error"/>
                    </div>
                    <div>
                        <input type="file" name="image" />
                    </div>
                    <form:hidden path="id" />
                    <input  type="submit" value="submit" />
                </form:form>
           </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
