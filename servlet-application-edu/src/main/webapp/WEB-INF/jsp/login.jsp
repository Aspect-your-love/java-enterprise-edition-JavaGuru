<%--
  Created by IntelliJ IDEA.
  User: Aspect
  Date: 18.04.2025
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="email">
            Email: <input type="email" name="email" id="email" value="${param.email}" required>
        </label><br><br>
        <label for="pwd">
            Password: <input type="password" name="pwd" id="pwd" required>
        </label><br><br>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Registration</button>
        </a>
        <c:if test="${param.error != null}">
            <div style="color: red">
                <span>Email or password is not correct</span>
            </div>
        </c:if>
    </form>

</body>
</html>
