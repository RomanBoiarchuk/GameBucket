<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Games</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<ul class="game-list">
    <c:forEach items="${gameDtos}" var="gameDto">
        <li>
            <div class="crop">
                <c:choose>
                    <c:when test="${!empty gameDto.img.trim()}">
                        <img src="/FileDownload?filePath=gamesAvatars/${gameDto.img}&fileType=image/png">
                    </c:when>
                    <c:otherwise>
                        <img src="/resources/images/defaultGame.png">
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="game-info">
                <h2>${gameDto.title} - ${gameDto.releaseYear}</h2>
                <h1>${gameDto.avgMark}</h1>
                <p>${gameDto.description}</p>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
