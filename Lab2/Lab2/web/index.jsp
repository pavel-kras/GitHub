<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="MyServlet" method="post">
            <p><b>Ваше имя:</b><br>
                <input type="text" size="40" name="Name">
            </p>
            <p><b>Ваш браузер:</b><Br>
                <input type="radio" name="browser" value="ie">Internet Explorer<Br>
                <input type="radio" name="browser" value="opera">Opera<Br>
                <input type="radio" name="browser" value="firefox">Firefox<Br>
            </p>
            <p>Комментарий<Br>
                <textarea name="comment" cols="40" rows="3"></textarea></p>
            <p><input type="submit" value="Отправить" name="OutInfo">
                <input type="reset" value="Очистить"></p>
        </form>
    </body>
</html>
