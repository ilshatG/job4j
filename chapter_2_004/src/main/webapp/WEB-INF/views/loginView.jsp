<%--
  Created by IntelliJ IDEA.
  User: Ильшат
  Date: 02.01.2019
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>
<body>
    <div class="container-fluid">
        <h1>Hello Buddy!</h1>


        <p>Use login:admin password:123 to log in as administrator.</p>

        <c:if test="${error != ''}">
            <div style="background-color: red">
                <c:out value="${error}"/>
            </div>
        </c:if>
        <form action="${pageContext.servletContext.contextPath}/signin" method = "post">
            <div class="form-group">
                Login: <input type="text" name="login" value = "${initParam.defaultUser}" class="form-control">
            </div>
            <div class="form-group">
                Password: <input type="password" name="password" value = "123" class="form-control">
            </div>
            <input type="submit" class="btn btn-default">
        </form>
    </div>
</body>
</html>
