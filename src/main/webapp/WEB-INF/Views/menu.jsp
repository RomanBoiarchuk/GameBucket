<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.softserve.models.UserRole" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <div class="menu">
        <ul>
            <c:if test="${empty user}">
                <li>
                    <a href="/login">Log In</a>
                </li>
            </c:if>
            <li>
                <a href="/profile">Profile</a>
            </li>
            <li>
                <a href="/games">Games</a>
            </li>
            <li>
                <a href="/playLater">Play Later</a>
            </li>
            <li>
                <a href="/marks">Your Marks</a>
            </li>
            <c:if test="${!empty user && user.role == UserRole.ADMIN}">
                <li>
                    <a href="/appendGame">Add New Game</a>
                </li>
            </c:if>
        </ul>
    </div>
</body>
</html>
