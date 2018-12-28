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
    <h2>Fill this form to add another new motherfucker to users list</h2>
    <form action ='<%= request.getContextPath() %>/list' name='addUser' method='post'>
        <label>Name:</label><input type='text' name='user' value='<%= Objects.toString(request.getParameter("name"),"") %>'/><br><br>
        <label>Login:</label>
        <input type='text' name='login' value='<%= Objects.toString(request.getParameter("login"),"") %>'/><br><br>
        <label>email:</label>
        <input type='text' name='email' value='<%= Objects.toString(request.getParameter("email"),"") %>'/><br><br>
        <label>date:</label>
        <input type='text' name='createDate' value='<%= Objects.toString(request.getParameter("createDate"),"") %>'/><br><br>

        <%
            String action = Objects.toString(request.getParameter("action"), "");
            if (action.equals("")) {
                action = "add";
            }
            if (action.equals("update")) {
                action = action + " id=" + request.getParameter("id");
            }
        %>

        <input type='submit' name='action' value='<%= action %>'/>
        &nbsp
        <input type='submit' name='action' value='cancel'/>
    </form>
    <p> id: <%= Objects.toString(request.getParameter("id"),"") %></p>
</body>
</html>
