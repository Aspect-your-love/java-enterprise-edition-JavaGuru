<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello!</title>
</head>
<body>
    <div style="text-align: center">
        <p>This test application use WEB MVC and SPRING BOOT 3</p>
        <br>
        <p>Test application!</p>
        <br>
        <p>Test application!</p>
        <br>
        <p>Test application!</p>
        <br>
        <p>Test application!</p>
    </div>

    <div>
        <p> Hello, user ${requestScope.user.username}</p>
    </div>

    <div>
        <p>List all Roles:</p>
        <p>${requestScope.roles}</p>
    </div>
</body>
</html>