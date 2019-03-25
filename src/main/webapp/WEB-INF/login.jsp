<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="background-body">
        <div class="flex-box">
            <jsp:include page="Views/menu.jsp"/>
            <div class="content-container">
                <form name="login" action="login" method="post" onsubmit="return validateEntry();">
                    <h2>Login</h2>
                    email <input type="email" name="email" required><br>
                    password <input type="password" name="password" required><br>
                    <p id="loginError"></p>
                    <button type="submit" value="Log in">Log in</button>
                    <a href="/registration">Sign up</a>
                </form>
            </div>
        </div>
    </div>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="/resources/js/validation.js"></script>
</body>
</html>
