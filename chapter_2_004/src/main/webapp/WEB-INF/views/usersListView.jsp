<%@ page import="servlets.EchoServlets.User" %>
<%@ page import="servlets.EchoServlets.ValidateService" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Ильшат
  Date: 27.12.2018
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>crud example</title>
    </head>
    <body>
        <h1>Hello Buddy!</h1>
        <h2>This fucking beautiful users list powered by postgres:</h2>
        <table border = '1'>
            <th>Id</th>
            <th>Name</th>
            <th>login</th>
            <th>e-mail</th>
            <th>action</th>

            <c:forEach items="${users}" var="user">
                <tr>
                    <td> <c:out value="${user.id}"></c:out> </td>
                    <td> <c:out value="${user.name}"></c:out> </td>
                    <td> <c:out value="${user.login}"></c:out> </td>
                    <td> <c:out value="${user.email}"></c:out> </td>
                    <td>
                        <form action ='${pageContext.request.contextPath}/' name ='form' method='post'>
                            <input type = 'submit' name ='action' value = 'delete id=<c:out value="${user.id}"></c:out>'/>
                            <a href = '${pageContext.request.contextPath}/create?name=<c:out value="${user.name}"></c:out>&login=<c:out value="${user.login}"></c:out>&email=<c:out value="${user.email}"></c:out>&createDate=<c:out value="${user.createDate}"></c:out>&id=<c:out value="${user.id}"></c:out>&action=update'>
                                <input type = 'button' name ='action' value='edit'/>
                            </a>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <%// } %>
        </table>
        <br>
        <a href='${pageContext.request.contextPath}/create?name=&login=&email=&createDate=&action=add'/>Add new user</a>
    </body>
</html>
