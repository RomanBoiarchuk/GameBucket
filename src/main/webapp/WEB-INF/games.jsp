<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>GameBucket</title>
</head>
<body>
    <jsp:include page="Views/menu.jsp"/>
    <ul>
        <c:forEach items="${gameDtos}" var="gameDto">
            <li>
                <h2>${gameDto.title} - ${gameDto.releaseYear}</h2>
                <h1>${gameDto.avgMark}</h1>
                <p>${gameDto.description}</p>
            </li>
        </c:forEach>
    </ul>
    <div class="pagination">
        <c:choose>
            <c:when test='${param.get("offset") / param.get("limit") == 0}'>
                <a href="" >&laquo;</a>
            </c:when>
            <c:otherwise>
                <a href="/games?offset=${param.get("offset") - param.get("limit")}&limit=${param.get("limit")}">&laquo;</a>
            </c:otherwise>
        </c:choose>
        <a href="/games?offset=${param.get("offset") + param.get("limit")}&limit=${param.get("limit")}">&raquo;</a>
    </div>
</body>
</html>
