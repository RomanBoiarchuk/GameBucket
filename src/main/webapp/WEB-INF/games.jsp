<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Games</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>

<div class="background-body">
    <div class="flex-box">
        <jsp:include page="Views/menu.jsp"/>
        <div class="content-container games-container">

            <form class="search-box" action="${urlPattern}" method="get" align="center">
                <input type="hidden" name="limit" value="${param.get("limit")}">
                <input type="hidden" name="offset" value="0">
                <input type="text" name="seek" value="${param.get("seek")}" placeholder="search">
                <input class="year-input" type="number" name="fromYear" value="${param.get("fromYear")}" min="1958"
                                 max=<%=Calendar.getInstance().get(Calendar.YEAR)%>> -
                <input class="year-input" type="number" name="toYear" value="${param.get("toYear")}"
                               min="1958" max=<%=Calendar.getInstance().get(Calendar.YEAR)%>>
                <button type="submit">Search</button>
            </form>

            <jsp:include page="Views/gamesView.jsp"/>

            <div class="pagination">

                <c:choose>
                    <c:when test='${param.get("offset") / param.get("limit") == 0}'>
                        <a href="">&laquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${urlPattern}?offset=${param.get("offset") - param.get("limit")}&limit=${param.get("limit")}
&seek=${param.get("seek")}&fromYear=${param.get("fromYear")}&toYear=${param.get("toYear")}">&laquo;</a>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${empty gameDtos}">
                        <a class="forward" href="">&raquo;</a>
                    </c:when>
                    <c:otherwise>
                        <a class="forward" href="${urlPattern}?offset=${param.get("offset") + param.get("limit")}&limit=${param.get("limit")}
&seek=${param.get("seek")}&fromYear=${param.get("fromYear")}&toYear=${param.get("toYear")}">&raquo;</a>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
    </div>
</div>

</body>
</html>
