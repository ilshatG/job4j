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
        <h2>This is a users list</h2>

        <p>Role is <c:out value = "${user.role}"/></p>
        <table border = '1'>
            <th>Id</th>
            <th>Name</th>
            <th>login</th>
            <th>e-mail</th>
            <th>createDate</th>
            <th>role</th>
            <th>action</th>

            <c:forEach items="${users}" var="item">
                <tr>
                    <td> <c:out value="${item.id}"></c:out> </td>
                    <td> <c:out value="${item.name}"></c:out> </td>
                    <td> <c:out value="${item.login}"></c:out> </td>
                    <td> <c:out value="${item.email}"></c:out> </td>
                    <td> <c:out value="${item.createDate}"></c:out> </td>
                    <td> <c:out value="${item.role}"></c:out> </td>
                    <td>
                        <c:if test="${user.role == 'admin' || user.id == item.id}">
                            <form action ='${pageContext.request.contextPath}/' name ='form' method='post'>
                                <input type = 'submit' name ='action' value = 'delete id=<c:out value="${item.id}"></c:out>'/>
                                <a href = '${pageContext.request.contextPath}/create?name=<c:out value="${item.name}"></c:out>&login=<c:out value="${item.login}"></c:out>&email=<c:out value="${item.email}"></c:out>&createDate=<c:out value="${item.createDate}"></c:out>&role=<c:out value="${item.role}"></c:out>&id=<c:out value="${item.id}"></c:out>&action=update'>
                                    <input type = 'button' name ='action' value='edit'/>
                                </a>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            <%// } %>
        </table>
        <br>
        <c:if test="${user.role == 'admin' || user.id == item.id}">
            <a href='${pageContext.request.contextPath}/create?name=&login=&email=&createDate=&action=add'/>Add new user</a>
        </c:if>
    </body>
</html>
