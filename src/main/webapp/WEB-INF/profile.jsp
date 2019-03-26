<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.softserve.models.UserRole" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
    <div class="background-body">
        <div class="flex-box">
            <jsp:include page="Views/menu.jsp"/>
            <div class="content-container">
                <div class="profile">
                    <form>
                        <h3>Nickname: ${userDto.nickname}</h3>
                        <h3>Email: ${userDto.email}</h3>
                        <h3>Games to play later: ${userDto.playLaterGames}</h3>
                        <h3>Marked games: ${userDto.gamesMarked}</h3>
                        <h3>Average mark: ${userDto.avgMark}</h3>
                        <h3>Role:
                            <c:choose>
                                <c:when test="${userDto.role == UserRole.ADMIN}">
                                    admin
                                </c:when>
                                <c:otherwise>
                                    user
                                </c:otherwise>
                            </c:choose>
                        </h3>
                        <a href="/signout">Sign out</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
