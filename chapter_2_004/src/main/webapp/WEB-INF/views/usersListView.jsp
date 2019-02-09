<%@ page import="servlets.echoservlets.User" %>
<%@ page import="servlets.echoservlets.ValidateService" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <title>crud example</title>
    </head>
    <body>
    <div class="container-fluid">
        <h1>Hello Buddy!</h1>
        <h2>This is a users list</h2>

        <p>Role is <c:out value = "${user.role}"/></p>
        <p>User name is ${user.name}</p>
        <table class="table" border = '1'>
            <th>Id</th>
            <th>Name</th>
            <th>login</th>
            <th>e-mail</th>
            <th>createDate</th>
            <th>role</th>
            <th>country</th>
            <th>town</th>
            <th>action</th>

            <c:forEach var="item" items="${users}">
                <tr>
                    <td> <c:out value="${item.id}"></c:out> </td>
                    <td> <c:out value="${item.name}"></c:out> </td>
                    <td> <c:out value="${item.login}"></c:out> </td>
                    <td> <c:out value="${item.email}"></c:out> </td>
                    <td> <c:out value="${item.createDate}"></c:out> </td>
                    <td> <c:out value="${item.role}"></c:out> </td>
                    <td> <c:out value="${item.country}"></c:out> </td>
                    <td> <c:out value="${item.town}"></c:out> </td>
                    <td>
                        <c:if test="${user.role == 'admin' || user.id == item.id}">
                            <form action ='${pageContext.request.contextPath}/' name ='formDelete' method='post'>
                                <input type = 'hidden' name = 'id' value="${item.id}"/>
                                <input type = 'hidden' name = 'name' value="${item.name}"/>
                                <input type = 'hidden' name = 'login' value="${item.login}"/>
                                <input type = 'hidden' name = 'email' value="${item.email}"/>
                                <input type = 'hidden' name = 'createDate' value="${item.createDate}"/>
                                <input type = 'hidden' name = 'role' value="${item.role}"/>
                                <input type = 'hidden' name = 'password' value="${item.password}"/>
                                <input type = 'hidden' name = 'country' value="${item.country}"/>
                                <input type = 'hidden' name = 'town' value="${item.town}"/>

                                <input type = 'submit' name ='action' value = 'delete' id='<c:out value="${item.id}"></c:out>'/>
                                <input type = 'submit' name ='action' value='edit'/>
                            </form>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <c:if test="${user.role == 'admin' || user.id == item.id}">
            <a href='${pageContext.request.contextPath}/create?name=&login=&email=&createDate=&action=add'/>Add new user</a>
        </c:if>
    </div>
    </body>
</html>
