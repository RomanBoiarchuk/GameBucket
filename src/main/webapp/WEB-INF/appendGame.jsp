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
            <form action="appendGame" name="appendGame" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>
                            <label>Title</label>
                        </td>
                        <td>
                            <input type="text" name="title" required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Release Year</label>
                        </td>
                        <td>
                            <input type="number" class="year-input" name="releaseYear" min="1958"
                                   max=<%=Calendar.getInstance().get(Calendar.YEAR)%> required>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Description</label>
                        </td>
                        <td>
                            <textarea wrap="hard" type="text" name="description"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Avatar</label>
                        </td>
                        <td>
                            <input type="file" name="image">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">Add Game</button>
                        </td>
                    </tr>
                </table>

            </form>
        </div>
    </div>
</div>

</body>
</html>
