<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Games</title>
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
</body>
</html>
