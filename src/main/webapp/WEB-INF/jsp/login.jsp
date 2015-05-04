<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"  href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Products</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Products</h1>
                <p>Add products</p>
            </div>
        </div>
    </section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        <spring:message code="login.badCredentials"/><br />
                    </div>
                </c:if>
                <c:if test="${not empty logout}">
                    <div class="alert alert-danger">
                        <spring:message code="login.logout"/><br />
                    </div>
                </c:if>
                <c:if test="${passwordOnly}">
                    <c:set var="readonly" value="readonly"/>
                </c:if>
                <c:if test="${rememberMe}">
                    <c:set var="rememberMeValue" value="checked"/>
                </c:if>
                   <form action="<c:url value="/login?targetUrl=${targetUrl}"></c:url>" method="post" class="form-horizontal">
                        <fieldset>
                        <div class="form-group">
                           <label class="control-label col-sm-2" ${readonly}>username: </label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="username" type="text" value="${username}" ${readonly}>
                                </div>
                        </div>
                        <div class="form-group">
                           <label class="control-label col-sm-2">password: </label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="password" type="password">
                                </div>
                        </div>
                        <div class="form-group">
                           <label class="control-label col-sm-2" ${readonly}>remember me: </label>
                                <div class="col-sm-10">
                                    <input class="form-control" name="remember-me-param" type="checkbox" ${rememberMeValue} ${readonly}>
                                </div>
                       </div>
                       <div class="form-group">
                            <div class="col-sm-offset-2">
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
