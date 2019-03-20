<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Games</title>
</head>
<body>
    <jsp:include page="Views/menu.jsp"/>
    <jsp:include page="Views/gamesView.jsp"/>
    <div class="pagination">
        <c:choose>
            <c:when test='${param.get("offset") / param.get("limit") == 0}'>
                <a href="" >&laquo;</a>
            </c:when>
            <c:otherwise>
                <a href="${urlPattern}?offset=${param.get("offset") - param.get("limit")}&limit=${param.get("limit")}">&laquo;</a>
            </c:otherwise>
        </c:choose>
        <a href="${urlPattern}?offset=${param.get("offset") + param.get("limit")}&limit=${param.get("limit")}">&raquo;</a>
    </div>
</body>
</html>
