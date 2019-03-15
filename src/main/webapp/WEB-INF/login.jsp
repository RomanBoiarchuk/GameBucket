<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form name="login" action="login" method="post">
        <h2>Login</h2>
        email <input type="email" name="email" required><br>
        password <input type="password" name="password" required><br>
        <button type="submit" value="Log in">Log in</button>
        <a href="/registration">Sign up</a>
    </form>
</body>
</html>
