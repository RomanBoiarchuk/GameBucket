<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.softserve.models.UserRole" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

    <div class="background-body">
        <jsp:include page="Views/menu.jsp"/>
        <div class="content-container">
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
        </div>
    </div>

</body>
</html>
