<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-size: 20px;
        }
    </style>
</head>
<body>
<div>
    <form action="/registration" method="post">
        <label for="name">
            Name:<input type="text" name="name" id="name">
        </label><br/>
        <label for="birthday">
            Birthday:<input type="date" name="birthday" id="birthday">
        </label><br/>
        <label for="email">
            Email:<input type="email" name="email" id="email">
        </label><br/>
        <label for="pwd">
            Password:<input type="password" name="pwd" id="pwd">
        </label><br/>
        <%--При помощи JSTL выводим все роли, которые у нас есть--%>
        <select name="role" id="role">
            <c:forEach var="role" items="${requestScope.roles}">
                <option label="${role}">${role}</option>
            </c:forEach>
        </select><br/>
        <%--При помощи JSTL выводим все гендеры, которые у нас есть (два)--%>
        <c:forEach var="gender" items="${requestScope.genders}">
            <input type="radio" name="gender" value="${gender}"> ${gender}
        </c:forEach>
        <br/>
        <input type="submit" value="Send">
    </form>
</div>
</body>
</html>
