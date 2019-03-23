<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Games</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script src="/resources/js/script.js"></script>
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
                <h1>${gameDto.avgMark}/10</h1>
                <c:if test="${!empty sessionScope.user && sessionScope.user.role == 'ADMIN'}">
                    <div class="editBox">
                        <a href="/editGame?gameId=${gameDto.id}"><i class="fas fa-edit"></i></a>
                    </div>
                </c:if>
                <div id="marks-${gameDto.id}">
                    <c:forEach var="i" begin="1" end="${gamesMarks.get(gameDto)}">
                        <span class="fa fa-star" onclick="setMark(${gameDto.id}, ${i});"></span>
                    </c:forEach>
                    <c:forEach var="i" begin="${gamesMarks.get(gameDto) + 1}" end="10">
                        <span class="far fa-star"
                              onclick="setMark(${gameDto.id}, ${i});"></span>
                    </c:forEach>
                    <button id="delete-mark-${gameDto.id}" class="far fa-window-close"
                            <c:if test="${gamesMarks.get(gameDto) == 0}"> disabled="disabled" </c:if>
                          onclick="deleteMark(${gameDto.id});"></button>
                </div>
                <pre>${gameDto.description}</pre>
            </div>
            <c:choose>
                <c:when test="${playLaterNotesExist.get(gameDto) == true}">
                    <i id="play-later-${gameDto.id}" class="fas fa-bookmark"
                       onclick="playLaterToggle(${gameDto.id});"></i>
                </c:when>
                <c:otherwise>
                    <i id="play-later-${gameDto.id}" class="far fa-bookmark"
                       onclick="playLaterToggle(${gameDto.id});"></i>
                </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</ul>
</body>
</html>
