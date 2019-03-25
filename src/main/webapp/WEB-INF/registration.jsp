<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="background-body">
        <div class="flex-box">
            <jsp:include page="Views/menu.jsp"/>
            <div class="content-container">
                <form name="registration" action="registration" method="post">
                    <h2>Registration</h2>
                    email <input type="email" name="email" required onchange="validateEmail(this);"><br>
                    nickname <input name="nickname" required onchange="validateNickname(this);"><br>
                    password <input id="password" type="password" name="password" minlength="6" onchange="validatePassword();" required><br>
                    confirm password <input id="confirmedPassword" type="password" name="confirmedPassword" onchange="validatePassword();" required><br>
                    <button type="submit" value="Sign up">Sign up</button>
                    <a href="/login">Log in</a>
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
