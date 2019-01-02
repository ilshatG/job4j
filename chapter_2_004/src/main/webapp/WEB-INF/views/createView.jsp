<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Ильшат
  Date: 28.12.2018
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create another new motherfucker</title>
</head>
<body>
    <h2>Fill this form to add another person to users list</h2>
    <form action ='${pageContext.request.contextPath}/' name='addUser' method='post'>
        <label>Name:</label>
        <input type='text' name='user' value='<c:out value="${param.name}"/>'/><br><br>
        <label>Login:</label>
        <input type='text' name='login' value='<c:out value="${param.login}"/>'/><br><br>
        <label>email:</label>
        <input type='text' name='email' value='<c:out value="${param.email}"/>'/><br><br>
        <label>date:</label>
        <input type='text' name='createDate' value='<c:out value="${param.createDate}"/>'/><br><br>

        <c:set var = "action" scope = "session" value = "add"/>
        <c:if test = "${param.action == 'update'}">
            <c:set var = "action" scope = "session" value = "update id=${param.id}"/>
        </c:if>
        <input type='submit' name='action' value='<c:out value="${action}"/>'/>
        &nbsp
        <input type='submit' name='action' value='cancel'/>
    </form>
</body>
</html>
