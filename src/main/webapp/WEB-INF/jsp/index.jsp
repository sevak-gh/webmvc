<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>spring MVC</title>
</head>
<body>
    <div>
        <spring:message code="label.welcome" />
    </div>
    <p>
        ${message}
    </p>        
    <p>
        ${note}
    </p>        
</body>
</html>
