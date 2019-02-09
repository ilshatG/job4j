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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Create another new motherfucker</title>

    <script>
        function validate() {
            var elements = document.getElementById("addUser").elements;
            var errorText = "";
            var result = true;
            for (var i = 0, element; element = elements[i++];) {
                if ((element.type === "text" || element.type=="textarea") && element.value === "")
                    errorText = errorText + "\t" + element.title + "\n\r"
            }
            if (errorText!="") {
                alert("Заполните:\n\r" + errorText);
                result = false;
            }
            return result;
        }

        function fillTowns(country) {
            var jsonString = ${townsCountries};

            var pickedTowns = [];
            for(var i=0;i<jsonString.length;i++) {

                if(jsonString[i].country.localeCompare(country) == 0) {
                    pickedTowns.push(jsonString[i].town);
                }
            }

            $('#townSelect')
                .find('option')
                .remove()
                .end()
            ;

            $.each(pickedTowns, function (i, town) {
                $('#townSelect').append($('<option>', {
                    value: town,
                    text: town
                }))
            });

        }
    </script>
</head>
<body>

    <div class="container-fluid">
        <h2>Fill this form to add another person to users list</h2>
        <form action ='${pageContext.request.contextPath}/' name='addUser' id='addUser'  method='post'>
            <div class="form-group">
                <input type = "hidden" name = "id" title="id" class="form-control" value = '<c:out value="${param.id}"/>' />
                <label>Name:</label>
                <input type='text' name='name' title="Name" class="form-control" value='<c:out value="${param.name}"/>'/>
                <label>Login:</label>
                <input type='text' name='login' title="login" class="form-control" value='<c:out value="${param.login}"/>'/>
                <label>email:</label>
                <input type='text' name='email' title="email" class="form-control" value='<c:out value="${param.email}"/>'/>
                <label>date:</label>
                <input type='text' name='createDate' title="Date" class="form-control" value='<c:out value="${param.createDate}"/>'/>
                <label> role:</label>
                <c:if test="${user.role == 'admin' || user.id == item.id}">
                    <select name="role" title="роль" class="form-control">
                        <option selected>${param.role}</option>
                        <option value="admin">admin</option>
                        <option value="guest">guest</option>
                    </select>
                </c:if>
                <label> Выберите страну:</label>
                <select name="country" class="form-control" title="countries" onchange="fillTowns(this.value)">
                    <option selected>${param.country}</option>
                    <c:forEach var="item" items="${countries}">
                        <c:if test="${param.country!=item}">
                            <option value="${item}">${item}</option>
                        </c:if>
                    </c:forEach>
                </select>

                <label>Выберите город:</label>
                <select name="town" class="form-control" title="town" id="townSelect">
                    <option selected>${param.town}</option>
                    <c:forEach items="${townContriesList}" var='item'>
                        <c:if test="${item.country == param.country and item.town!=param.town}">
                            <option value="${item.town}">${item.town}</option>
                        </c:if>
                    </c:forEach>

                </select>
                <label>password:</label>
                <input type='password' name='password' title="парьль" class="form-control" value='<c:out value="${param.password}"/>'/>

                <c:set var = "action" scope = "session" value = "add"/>
                <c:if test = "${param.action == 'edit'}">
                    <c:set var = "action" scope = "session" value = "update"/>
                </c:if>
                <input type='submit' name='action' class="btn btn-default"  onclick="return validate();" value='<c:out value="${action}"/>'/>
                &nbsp
                <input type='submit' name='action' class="btn btn-default" value='cancel'/>
            </div>
        </form>

    </div>
</body>
</html>