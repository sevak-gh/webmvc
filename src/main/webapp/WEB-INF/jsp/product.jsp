<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <label> name: </label>
                        <form:input path="name" />
                    </div>
                    <div>
                        <label> price: </label>
                        <form:input path="price" />
                    </div>
                    <div>
                        <label> description: </label>
                        <form:textarea path="description" />
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
