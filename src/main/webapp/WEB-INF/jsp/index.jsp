<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>spring MVC</title>
</head>
<body>
    <div>
        <a href=?language=en>English</a>|<a href="?language=fr">French</a>
    </div>    
    <div>
        վհպրբսեզքշբը
    </div>
    <div class="container">
        <c:if test="${pageContext.request.remoteUser != null}">
            <p class="pull-right">
                <span> Hello: ${pageContext.request.remoteUser} </span> |
                <form action="<c:url value="/logout"></c:url>" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <input type="submit" value="Sign Out" class="btn btn-link" style="display:inline" />
                </form> 
            </p>
        </c:if>
             <p>
                <sec:authorize access="isRememberMe()">
                    <h3># This user is login by "Remember Me Cookies".</h3>
                </sec:authorize> 
                <sec:authorize access="isFullyAuthenticated()">
                    <h3># This user is login by username / password.</h3>
                </sec:authorize>
            </p>
   </div>
    <div dir="rtl">
        سلام بر تمام مهندسین نرم افزار
    </div>
    <div>
        <spring:message code="label.welcome" />
    </div>
    <p>
        ${message}
    </p>        
    <p>
        ${note}
    </p>  
    <p>
        ${id}
    </p>     
    <form method="POST" enctype="multipart/form-data">
        <input type="text" name="info" />
        <input type="file" name="image" />
        <input type="submit" value="save" />
    </form> 
    <div>
        <a href="<c:url value="/products" />">products list</a>
    </div>
</body>
</html>
