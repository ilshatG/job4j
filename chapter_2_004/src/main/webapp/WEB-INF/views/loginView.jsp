<%--
  Created by IntelliJ IDEA.
  User: Ильшат
  Date: 02.01.2019
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signis" method = "post">
        Login: <input type="text" name="login"><br/>
        Password: <input type="password" name="password"><br/>
        <input type="submit">
    </form>
</body>
</html>
