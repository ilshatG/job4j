<%@ page import="servlets.EchoServlets.User" %>
<%@ page import="servlets.EchoServlets.ValidateService" %><%--
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
        <h2>This is a fucking beautiful users list:</h2>
        <table border = '1'>
            <th>N</th>
            <th>Id</th>
            <th>Name</th>
            <th>login</th>
            <th>e-mail</th>
            <th>action</th>

            <% int counter = 1; %>
            <% for (User user: ValidateService.getInstance().getAll()) { %>

                <tr>
                    <td> <%= counter++ %>.</td>
                    <td> <%= user.getId() %> </td>
                    <td> <%= user.getName() %> </td>
                    <td> <%= user.getLogin() %> </td>
                    <td> <%= user.getEmail() %> </td>
                    <td>
                        <form action ='<%= request.getContextPath() %>/list' name ='form' method='post'>
                            <input type = 'submit' name ='action' value = 'delete id=<%= user.getId() %>'/>
                            <a href = '<%= request.getContextPath() %>/create.jsp?name=<%= user.getName() %>&login=<%=
                            user.getLogin() %>&email=<%= user.getEmail() %>&createDate=<%= user.getCreateDate() %>&id=<%=
                            user.getId() %>&action=update'>
                                <input type = 'button' name ='action' value='edit'/>
                            </a>
                        </form>
                    </td>
                </tr>
        <% } %>
        </table>
        <br>
        <a href='<%= request.getContextPath() %>/create.jsp?name=&login=&email=&createDate=&action=add'/>Add new user</a>
    </body>
</html>
