<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Append Game</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
</head>
<body>
<div class="background-body">
    <div class="flex-box">
        <jsp:include page="Views/menu.jsp"/>
        <div class="content-container">
            <form action="appendGame" method="post" enctype="multipart/form-data">
                Title <input type="text" name="title" required>
                Release Year <input type="number" name="releaseYear" min="1958"
                                    max=<%=Calendar.getInstance().get(Calendar.YEAR)%> required>
                Description <input type="text" name="description">
                Avatar <input type="file" name="image">
                <button type="submit">Add Game</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
