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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap1.css" />
    <body>
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
        <form class="form-style" name="updateworker" method="POST"
              action="servlet">
            <input type="hidden" name="command" value="updateworker" />
            <input type="hidden" name="idworker" value="${idworker}" \/>
            <h1><font color="#fffff" face="TrixiePro">Имя</font></h1>
            <input type="text" name="name" value="${list_worker.name}" required pattern="^[А-Яа-яЁё\s]+$"/><br>
            <h1><font color="#ffffff" face="TrixiePro">Фамилия</font></h1>
            <input type="text" name="surname" value="${list_worker.surname}" required pattern="^[А-Яа-яЁё\s]+$"><br />
            <h1><font color="#ffffff" face="TrixiePro">Телефон</font></h1>
            <input type="text" name="tel" value="${list_worker.tel}" required pattern="^[0-9+-]+$"><br /> 
            <button class="btn btn-primary" type="submit">Обновить базу</button>
        </form>
    </center>
</body>
</html>
