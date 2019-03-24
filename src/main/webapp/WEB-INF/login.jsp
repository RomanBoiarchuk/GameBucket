<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="Views/menu.jsp"/>
    <form name="login" action="login" method="post" onsubmit="return validateEntry();">
        <h2>Login</h2>
        email <input type="email" name="email" required><br>
        password <input type="password" name="password" required><br>
        <p id="loginError"></p>
        <button type="submit" value="Log in">Log in</button>
        <a href="/registration">Sign up</a>
    </form>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="/resources/js/validation.js"></script>
</body>
</html>
