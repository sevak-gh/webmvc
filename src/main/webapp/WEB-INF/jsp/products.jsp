<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
        <spring:message code="label.welcome" />
    </div>
    <div>
        All products list
    </div>
    <div>
        <table>
            <tr>
                <th>name</th>
                <th>price</th>
                <th>description</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <%--<td><a href="${pageContext.request.contextPath}/products/${product.id}">${product.name}</a></td>--%>
                    <td><a href="<spring:url value="/products/${product.id}" />">${product.name}</a></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                    <td><img src="<c:url value="/images/${product.imageFileName}"></c:url>"/></td>
                    <td>
                        <form:form action="${pageContext.request.contextPath}/products/delete/${product.id}" method="post">
                            <input type="submit" value="delete"/>
                        </form:form>
                    </td>
                </tr>
            </c:forEach>  
        </table>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/products/create">add new product</a>    
    </div>
</body>
</html>
