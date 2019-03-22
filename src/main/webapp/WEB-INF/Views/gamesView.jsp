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
            <c:choose>
                <c:when test="${playLaterNotesExist.get(gameDto) == true}">
                    <h2>True</h2>
                </c:when>
                <c:otherwise>
                    <h2>False</h2>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${gamesMarks.get(gameDto) == 0}">
                    <h2>Not graded</h2>
                </c:when>
                <c:otherwise>
                    <h2>${gamesMarks.get(gameDto)}</h2>
                </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</ul>
</body>
</html>
