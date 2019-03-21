<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Append Game</title>
</head>
<body>
    <jsp:include page="Views/menu.jsp"/>
    <form action="appendGame" method="post" enctype="multipart/form-data">
        Title <input type="text" name="title" required>
        Release Year <input type="number" name="releaseYear" min="1958"
                            max=<%=Calendar.getInstance().get(Calendar.YEAR)%> required>
        Description <input type="text" name="description">
        Avatar <input type="file" name="image">
        <button type="submit">Add Game</button>
    </form>
</body>
</html>
