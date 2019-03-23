<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${game.title} - edit</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<jsp:include page="Views/menu.jsp"/>
<form action="editGame" method="post" enctype="multipart/form-data">
    <div class="crop">
        <c:choose>
            <c:when test="${!empty game.img.trim()}">
                <img src="/FileDownload?filePath=gamesAvatars/${game.img}&fileType=image/png">
            </c:when>
            <c:otherwise>
                <img src="/resources/images/defaultGame.png">
            </c:otherwise>
        </c:choose>
        <input type="file" name="image">
    </div>
    Title <input type="text" name="title" value="${game.title}" required>
    Release Year <input type="number" name="releaseYear" value="${game.releaseYear}" min="1958"
                        max=<%=Calendar.getInstance().get(Calendar.YEAR)%> required>
    Description <textarea name="description">${game.description}</textarea>
    <button type="submit">Confirm</button>
    <a href="${previous}">cancel</a>
</form>
<form action="deleteGame" method="post">
    <input type="hidden" name="previous" value="${previous}">
    <input type="hidden" name="gameId" value="${game.id}">
    <button type="submit">Delete Game</button>
</form>
</body>
</html>
