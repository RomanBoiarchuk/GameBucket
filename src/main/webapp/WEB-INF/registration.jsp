<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <jsp:include page="Views/menu.jsp"/>
    <form name="registration" action="registration" method="post">
        <h2>Registration</h2>
        email <input type="email" name="email" required><br>
        nickname <input name="nickname" required><br>
        password <input type="password" name="password" required><br>
        repeat password <input type="password" name="repeatedPassword" required><br>
        <button type="submit" value="Sign up">Sign up</button>
        <a href="/login">Log in</a>
    </form>
</body>
</html>
