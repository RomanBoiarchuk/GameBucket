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
<div class="background-body">
    <div class="flex-box">
        <jsp:include page="Views/menu.jsp"/>
        <div class="content-container">
            <form action="editGame" name="editGame" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td rowspan="3">
                            <div class="crop">
                                <c:choose>
                                    <c:when test="${!empty game.img.trim()}">
                                        <img src="/FileDownload?filePath=gamesAvatars/${game.img}&fileType=image/png">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="/resources/images/defaultGame.png">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </td>
                        <td>
                            <label>Title</label>
                        </td>
                        <td>
                            <input type="text" value="${game.title}" name="title" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Release Year</label>
                        </td>
                        <td>
                            <input type="number" value="${game.releaseYear}" class="year-input" name="releaseYear" min="1958"
                                   max=<%=Calendar.getInstance().get(Calendar.YEAR)%> required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Description</label>
                        </td>
                        <td>
                            <textarea type="text" name="description">${game.description}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="file" name="image">
                        </td>
                        <td colspan="2">
                            <div class="flex-buttons">
                                <button type="submit">Confirm</button>
                                <form action="deleteGame" align="center" method="post">
                                    <input type="hidden" name="previous" value="${previous}">
                                    <input type="hidden" name="gameId" value="${game.id}">
                                    <button type="submit">Delete Game</button>
                                </form>
                                <a href="${previous}">Cancel</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>


</body>
</html>
