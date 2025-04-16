<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <style>
        div {
            font-size: 20px;
        }
    </style>
</head>
<body>
<div>
    <form action="/registration" method="post">
        <label for="name">
            Name: <input type="text" name="name" id="name">
        </label><br>
        <label for="birthday">
            Birthday: <input type="date" name="birthday" id="birthday">
        </label><br>
        <label for="email">
            <%--Уточнить, что будет, если в поле email вставить не 'text', а 'email' --%>
            Email: <input type="text" name="email" id="email">
        </label><br>
        <label for="pwd">
            Password: <input type="password" name="pwd" id="pwd">
        </label><br>
        <select name="role" id="role">
            <option label="USER">USER</option>
            <optional label="ADMIN">ADMIN</optional>
        </select><br>
        <input type="radio" name="gender" VALUE="MALE"> MALE
        <br>
        <input type="radio" name="gender" VALUE="FEMALE"> FEMALE
        <br>
        <input type="submit" value="Send">
    </form>
</div>
</body>
</html>
