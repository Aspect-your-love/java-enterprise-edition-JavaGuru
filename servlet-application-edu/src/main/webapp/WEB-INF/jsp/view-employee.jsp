<%--
  Created by IntelliJ IDEA.
  User: Aspect
  Date: 15.04.2025
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<h1>Сотрудники</h1>
    <ul>
        <c:forEach var="employees" items="${requestScope.employees}">
            <li>${employees.toString()}</li>
        </c:forEach>

    </ul>
</body>
</html>
