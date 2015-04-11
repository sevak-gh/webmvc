<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    <td><a href="${pageContext.request.contextPath}/products/${product.id}">${product.name}</a></td>
                    <td>${product.price}</td>
                    <td>${product.description}</td>
                </tr>
            </c:forEach>  
        </table>
    </div>
</body>
</html>
