<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>spring MVC</title>
</head>
<body>
    <div>
        <a href=?language=en>English</a>|<a href="?language=fr">French</a>
    </div>
    <div>
        վհպրբսեզքշբը
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
    <form method="POST" enctype="multipart/form-data">
        <input type="text" name="info" />
        <input type="file" name="image" />
        <input type="submit" value="save" />
    </form> 
</body>
</html>
