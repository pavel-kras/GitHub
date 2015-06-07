<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            background: #eedfcc url(pics/4444.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }
    </style>
    <body>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap1.css" />
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <div class="navbar navbar-inverse">
            <nav class="navbar-inner navbar-static-top">
                <a class="brand">Курсовая работа</a>
                <ul class="nav">
                    <li class="divider-vertical"></li>
                    <li><a href="?command=gotomain">Главная</a></li>
                    <li><a href="?command=gotoworker">Работники</a></li>
                    <li><a href="?command=gotowork">Заказы</a></li>
                    <li><a href="?command=gotoorder">Выполнение</a></li>
                    <li class="divider-vertical"></li>
                    <li><a href="?command=logout">Выйти</a></li>
                </ul>
            </nav>
        </div>
    <center>
        <form class="form-style" name="updatework" method="POST"
              action="servlet">
            <input type="hidden" name="command" value="updatework" />
            <input type="hidden" name="idwork" value="${idwork}"/>
            <h1><font color="#ffffff" face="TrixiePro">Название работы</font></h1>
            <input type="text" name="title" value="${title}" required/><br>
            <h1><font color="#ffffff" face="TrixiePro">Время выполнения</font></h1>
            <input type="text" name="time" value="${time}" required pattern="^[0-9]+$"><br />
            <h1><font color="#ffffff" face="TrixiePro">Стоимость работ</font></h1>
            <input type="text" name="price" value="${price}" required pattern="^[0-9]+$"><br /> 
            <button class="btn btn-primary" type="submit">Обновить базу</button>
        </form>
    </center>
</body>
</html>
