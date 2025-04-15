<%--
  Created by IntelliJ IDEA.
  User: SPEC-IT
  Date: 15.04.2025
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сервлет с параметрами</title>
    <style>
        p {
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div>
        <span>Content. Чекаем кодировку.</span>
        <p>Size: ${requestScope.exampleData.size()}</p>
        <%--Вызов массивов и списков через [index] является null-safety
        практикой.--%>
        <p>First element: ${requestScope.exampleData[0]}</p>
        <p>JSESSIONID: ${cookie.get("JSESSIONID")}</p>
        <p>PARAM id: ${param.id}</p>
        <p>HEADER id: ${header["cookie"]}</p>
        <p>NOT EMPTY: ${not empty exampleData}</p>
    </div>
</body>
</html>
